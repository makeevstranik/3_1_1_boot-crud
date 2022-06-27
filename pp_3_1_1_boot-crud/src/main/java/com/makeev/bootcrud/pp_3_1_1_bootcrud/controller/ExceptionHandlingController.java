package com.makeev.bootcrud.pp_3_1_1_bootcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ExceptionHandlingController {
    @ExceptionHandler(Exception.class)
    public void handleError(HttpServletRequest req, Exception ex) {
        ex.printStackTrace();
    }
}

