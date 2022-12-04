package cn.tedu.spring.controller;

import cn.tedu.spring.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Component
public class ExceptionAdvice {

    Logger logger= LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void handleUserNotFoundException(UserNotFoundException e){
        logger.debug("用户信息找到",e);
    }
}
