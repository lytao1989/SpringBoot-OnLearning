package com.example.web;

import com.example.domain.User;
import com.example.exception.MyException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController
{
    @RequestMapping("/t")
    public String index(ModelMap map)
    {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }
    @RequestMapping("/hellot")
    public String hello() throws  Exception
    {
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

    @PostMapping(value = "/test",consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public User getUser()
    {
        return new User();
    }


    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/home")
    public String test2() {
        return "hello";
    }

    @RequestMapping("/login")
    public String login()
    {

        return "login";
    }
}
