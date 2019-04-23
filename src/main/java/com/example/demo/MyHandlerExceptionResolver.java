package com.example.demo;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 2019-04-23
 */
@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver, Ordered {

    @Override
    public int getOrder() {
        return -1;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            PrintWriter printWriter =  httpServletResponse.getWriter();
            printWriter.write(this.getClass().getSimpleName()+":"+e.getMessage());
            printWriter.flush();
            printWriter.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }


}
