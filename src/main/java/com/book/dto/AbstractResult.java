package com.book.dto;

public abstract class AbstractResult<T> {


    protected boolean state; //200代表成功返回

    protected String errorMess;

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getErrorMess() {
        return errorMess;
    }

    public void setErrorMess(String errorMess) {
        this.errorMess = errorMess;
    }


    public abstract Object getData() ;


    @Override
    public abstract String toString();
}
