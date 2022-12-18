package cn.tedu.spring.controller;

import cn.tedu.spring.exception.UserNotFoundException;
import cn.tedu.spring.exception.UsernameExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice //REST控制器通知，用于异常处理
@Component
public class ExceptionAdvice {

    Logger logger= LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handleUserNotFoundException(UserNotFoundException e){
        logger.debug("用户信息找到",e);
        Map<String, Object> result = new HashMap<>();
        result.put("message", e.getMessage());
        return result;
    }

    @ExceptionHandler(UsernameExistsException.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public Map<String, Object> handleUsernameExistsException(UsernameExistsException e){
        logger.debug("用户名已经存在", e);
        Map<String, Object> result = new HashMap<>();
        result.put("message", e.getMessage());
        return result;
    }

}
