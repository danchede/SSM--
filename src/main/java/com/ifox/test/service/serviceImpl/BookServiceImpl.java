package com.ifox.test.service.serviceImpl;

import com.ifox.test.dao.AppointmentDao;
import com.ifox.test.dao.BookDao;
import com.ifox.test.dto.AppointExecution;
import com.ifox.test.entity.Appointment;
import com.ifox.test.entity.Book;
import com.ifox.test.enums.AppointStateEnum;
import com.ifox.test.exception.AppointException;
import com.ifox.test.exception.NoNumberException;
import com.ifox.test.exception.RepeatAppointException;
import com.ifox.test.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //注入Service依赖
    @Autowired
    private BookDao bookDao;
    @Autowired
    private AppointmentDao appointmentDao;

    public Book getById(long bookId) {
        return bookDao.queryById(bookId);
    }

    public List<Book> getList() {
        return bookDao.queryAll(0,1000);
    }

    @Transactional
    public AppointExecution appoint(long bookId, long studentId) {
        try {
            // 减库存
            int update = bookDao.reduceNumber(bookId);
            if (update <= 0) {// 库存不足
                throw new NoNumberException("库存不足！");
            } else {
                // 执行预约操作
                int insert = appointmentDao.insertAppointment(bookId, studentId);
                if (insert <= 0) {// 重复预约
                    throw new RepeatAppointException("重复预约！");
                } else {// 预约成功
                    Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
                    return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
                }
            }
            // 要先于catch Exception异常前先catch住再抛出，
            // 不然自定义的异常也会被转换为AppointException，
            // 导致控制层无法具体识别是哪个异常
        } catch (NoNumberException e1) {
            throw e1;
        } catch (RepeatAppointException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            // 所有编译期异常转换为运行期异常
            throw new AppointException("appoint inner error:" + e.getMessage());
        }
    }
}
