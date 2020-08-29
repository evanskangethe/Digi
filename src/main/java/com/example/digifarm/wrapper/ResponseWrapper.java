package com.example.digifarm.wrapper;

import lombok.Data;

@Data
public class ResponseWrapper<T> {
    public int code;
    public String message;
    public T data;
}
