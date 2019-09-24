package com.example;

import com.example.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter311ApplicationTests
{
	private MockMvc mvc;

	@Before
	public void setUp() throws  Exception
	{
		mvc= MockMvcBuilders.standaloneSetup(new UserController()).build();
	}

	@Test
	public void testUserController() throws Exception
	{

		// 1、get查一下user列表，应该为空
		mvc.perform(MockMvcRequestBuilders.get("/users/"))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[]")));

		//2、post一个User
		mvc.perform(MockMvcRequestBuilders.post("/users/")
				.param("id","1")
				.param("name","测试大师")
				.param("age","20")

		).andExpect(content().string(equalTo("success")));

		//3、get User列表
		String response=mvc.perform(MockMvcRequestBuilders.get("/users/")).andReturn().getResponse().getContentAsString();
		System.out.println("User列表："+response);
		//4、put一个user
		mvc.perform(MockMvcRequestBuilders.put("/users/1")
				.param("name","test")
				.param("age","12"))
				.andExpect(content().string(equalTo("success")));
		//5、get一个user id=1

	   String userid1=mvc.perform(MockMvcRequestBuilders.get("/users/1")).andReturn().getResponse().getContentAsString();
	   System.out.println(userid1);

	   //6、del 一个user id=1
		mvc.perform(MockMvcRequestBuilders.delete("/users/1")).andExpect(content().string(equalTo("success")));







	}

}
