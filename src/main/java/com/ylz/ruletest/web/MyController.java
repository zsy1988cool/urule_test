package com.ylz.ruletest.web;

import com.ylz.ruletest.invoke.Invokor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "test")
@Controller
public class MyController {

    @RequestMapping(value = "sayHello")
    String sayHello() throws Exception {
        Invokor invokor = new Invokor();
        invokor.doTest();
        return "Hello";
    }
}
