package com.ifox.test.test;

import com.ifox.test.dao.AppointmentDao;
import com.ifox.test.entity.Appointment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AppointmentDaoTest extends BaseTest{
    @Autowired
    private AppointmentDao appointmentDao;
    @Test
    public void testInsertAppointment() throws Exception{
        long bookId = 1000;
        long studentId = 2015070662;
        int insert = appointmentDao.insertAppointment(bookId,studentId);
        System.out.println("insert="+insert);
    }
    @Test
    public  void  testQueryByKeyWithBook() throws Exception{
        long bookId = 1000;
        long studentId = 2015070662;
        Appointment appointment = appointmentDao.queryByKeyWithBook(bookId,studentId);
        System.out.println(appointment);
        System.out.println(appointment.getBook());
    }

}
