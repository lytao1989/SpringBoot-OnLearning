package com.example.springdatajpa.web;

import com.example.springdatajpa.entity.User;
import com.example.springdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController
{
   @Autowired
    private UserRepository userRepository;

   @PostMapping("")
   public User saveUser(@RequestBody User user)
   {
      return userRepository.save(user);
   }

   @GetMapping("/{id}")
   public User getUser(@PathVariable("id") String id )
   {
       Optional<User> optional =userRepository.findById(id);
       return optional.orElseGet(User::new);
   }

   @DeleteMapping("/{id}")
   public void deleteUser(@PathVariable("id") String id)
   {
       userRepository.deleteById(id);
   }

   @PutMapping("/{id}")
   public User updateUser(@PathVariable("id") String id,@RequestBody User user)
   {
       user.setId(id);
       return userRepository.saveAndFlush(user);


   }

   @GetMapping("/list")
    public Page<User> pageQuery(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize)
   {
       return  userRepository.findAll(PageRequest.of(pageNum,pageSize));
   }

   @GetMapping("/{name}")
   public User getUserByName(@PathVariable("userName") String userName)
   {
       return  userRepository.findByUserName(userName);
   }
}
