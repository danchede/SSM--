package com.ifox.test.entity;

import java.util.Date;

public class Appointment {
    private long bookId;            //图书ID
    private String studentId;       //学号
    private Date appointTime;       //预约时间
    private Book book;

    @Override
    public String toString() {
        return "Appointment{" +
                "bookId=" + bookId +
                ", studentId='" + studentId + '\'' +
                ", appointTime=" + appointTime +
                ", book=" + book +
                '}';
    }

    public Appointment() {
    }

    public Appointment(long bookId, String studentId, Date appointTime, Book book) {
        this.bookId = bookId;
        this.studentId = studentId;
        this.appointTime = appointTime;
        this.book = book;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
