package com.ifox.test.test;

import com.ifox.test.dao.BookDao;
import com.ifox.test.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class BookDaoTest extends BaseTest {

    @Autowired
    private BookDao bookDao;
    @Test
    public void testQueryById() throws Exception{
        long bookId = 1000;
        Book book = bookDao.queryById(bookId);
        System.out.println(book);
    }
    @Test
    public  void testQueryAll() throws Exception{
        List<Book> books = bookDao.queryAll(0,4);
        for (Book book :books){
            System.out.println(book);
        }
    }
    @Test
    public void testReduceNumber() throws  Exception{
        long bookId = 1000;
        int update = bookDao.reduceNumber(bookId);
        System.out.println("update="+update);
    }

}
