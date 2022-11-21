package com.deqode.backend2.springpractice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.deqode.backend2.Model.Users;
import com.deqode.backend2.Repository.UserRepository;
import com.deqode.backend2.Service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ExtendWith(MockitoExtension.class)
class SpringpracticeApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

//	@Test
//	public void getAllUsersTest() {
//		when(userRepository.findAll()).thenReturn(Stream.of(new Users("Danile@gmail.com", "Danile101", "Danile101"),
//				new Users("Danile@gmail.com", "Danile102", "Danile102")).collect(Collectors.toList()));
//		assertEquals(2, userService.getAllUsers().size());
//	}
//
//	@Test
//	public void saveUserTest() {
//		Users user = new Users("Danile@gmail.com", "Danile102", "Danile102");
//		when(userRepository.save(user)).thenReturn(user);
//		assertEquals(user, userService.createUser(user));
//	}
}
