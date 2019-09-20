package com.example.web;

import com.example.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserController
{
    static Map<Long,User> users= Collections.synchronizedMap(new HashMap<Long, User>());

    //查询用户列表
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> getUserList()
    {
        List<User> us=new ArrayList<User>(users.values());
        return  us;
    }
    //添加
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user)
    {
        users.put(user.getId(),user);
        return  "success";
    }

    //根据ID查询用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable Long id)
    {
        return  users.get(id);
    }

    //根据ID更新用户
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateUser(@PathVariable Long id,@ModelAttribute User user)
    {
        User u=users.get(id);
        u.setAge(user.getAge());
        u.setName(user.getName());
        users.put(id,u);
        return  "success";
    }

    //根据ID删除用户
    @RequestMapping(value = "/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        users.remove(id);
        return "success";
    }

}
