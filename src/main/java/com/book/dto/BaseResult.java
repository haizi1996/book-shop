package com.book.dto;

public class BaseResult<T> extends AbstractResult {

    private T data;



    public BaseResult(boolean state, String errorMess) {
        this.state = state;
        this.errorMess = errorMess;
    }

    public BaseResult(boolean state, T data) {
        this.state = state;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }



    @Override
    public String toString() {
        return "BaseResult{" +
                "data=" + data +
                ", state=" + state +
                ", errorMess='" + errorMess + '\'' +
                '}';
    }

    public static<T> AbstractResult<T> success(T t){
        return new BaseResult<T>(true , t);
    }

    public static AbstractResult error(String errorMess){
        return new BaseResult(false, errorMess);
    }
}
