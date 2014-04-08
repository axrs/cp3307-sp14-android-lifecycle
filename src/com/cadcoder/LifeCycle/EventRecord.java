package com.cadcoder.LifeCycle;

import java.util.Date;

public class EventRecord {
    private String _message;
    private Date _time = new Date();

    public EventRecord(String message) {
        _message = message;
    }

    public String getMessage() {
        return _message;
    }

    public Date getTime() {
        return _time;
    }
}
