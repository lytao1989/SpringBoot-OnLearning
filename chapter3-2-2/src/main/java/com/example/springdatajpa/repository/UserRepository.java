package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,String>
{

    User findByUserName(String userName);

 //   User findByNameAndAge(String name, Integer age);

    //它也提供通过使用@Query 注解来创建查询，您只需要编写JPQL语句，并通过类似“:name”来映射@Param指定的参数
//    @Query("from User u where u.name=:name")
//    User findUser(@Param("name") String name);

}
