//package com.wsl.advice;
//
//
//import org.springframework.dao.DuplicateKeyException;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import java.io.FileNotFoundException;
//
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//    @ExceptionHandler(value = FileNotFoundException.class)
//    public void duplicateKeyException(FileNotFoundException e) {
//        System.out.println("程序被占用了,报错内容为"+e.getMessage());
//    }
//
//
//}
