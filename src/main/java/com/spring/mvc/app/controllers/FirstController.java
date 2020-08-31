package com.spring.mvc.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a",required = false) double a,
                                 @RequestParam(value = "b", required = false) double b,
                                 @RequestParam(value = "action", required = false) String action,
                                 Model model){

        double result;
        switch (action){
            case "mul":
                result = a*b;
                break;
            case "add":
                result = a+b;
                break;
            case "sub":
                result = a-b;
                break;
            case "div":
                result = a/b;
                break;
            default:
                result = 0;
                break;
        }

        model.addAttribute("math", "Result: " + result);

        return "first/calculator";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }
}
