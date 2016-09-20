package qtech.gramophone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by shiqining on 9/20/16.
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(String username) {
        return username + "hello, welcome to java web world";
    }

    @RequestMapping("/freemarker/hello")
    public String hello(String name) {
        return "hello world";
    }
}