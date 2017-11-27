package com.ifox.test.dto;

import com.ifox.test.entity.Appointment;
import com.ifox.test.enums.AppointStateEnum;

/**
 * 封装预约执行后结果
 */

public class AppointExecution {
    private long bookId;
    private  int state;
    private  String stateInfo;
    private Appointment  appointment;
    public AppointExecution(){};

    //预约失败的构造器
    public AppointExecution (long bookId , AppointStateEnum stateEnum) {
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    //预约成功的构造器
    public AppointExecution(long bookId ,AppointStateEnum stateEnum ,Appointment appointment){
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "AppointExecution{" +
                "bookId=" + bookId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", appointment=" + appointment +
                '}';
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
