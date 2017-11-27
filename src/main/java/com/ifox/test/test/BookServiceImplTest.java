package com.ifox.test.test;

import com.ifox.test.dto.AppointExecution;
import com.ifox.test.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImplTest  extends BaseTest{
    @Autowired
    private BookService bookService;
    @Test
    public void testAppoint() throws Exception{
        long bookId = 1001;
        long studentId = 2015070662;
        AppointExecution execution = bookService.appoint(bookId,studentId);
        System.out.println(execution);
    }
}
