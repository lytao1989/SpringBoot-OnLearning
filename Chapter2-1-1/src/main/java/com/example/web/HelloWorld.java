package com.example.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld
{
    @RequestMapping("/hello")
   public String index()
   {
       return "Hello World";
   }

}
