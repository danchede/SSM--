package com.ifox.test.service;

import com.ifox.test.dto.AppointExecution;
import com.ifox.test.entity.Book;

import java.util.List;

public interface BookService {
    Book getById(long bookId);
    List<Book> getList();
    AppointExecution appoint(long bookId, long studentId);
}
