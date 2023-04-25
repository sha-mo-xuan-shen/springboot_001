package com.mp.controller;

import com.mp.exception.BussinessException;
import com.mp.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e){

        return new Result(e.getCode(), (Object) null,e.getMessage());
    }

    @ExceptionHandler(BussinessException.class)
    public Result doBussinessException(BussinessException e){

        return new Result(e.getCode(), (Object) null,e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        return new Result(Code.SYSTEM_UNKNOW_ERR, (Object) null,"我不会修");
    }
}
