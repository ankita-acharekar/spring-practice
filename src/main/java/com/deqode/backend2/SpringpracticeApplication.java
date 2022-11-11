package com.deqode.backend2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deqode.backend2.Model.Users;
import com.deqode.backend2.Repository.UserRepository;

@SpringBootApplication
public class SpringpracticeApplication {
	
	@Autowired
	UserRepository userRepository;

	@PostConstruct
	public void initUsers() {
		List<Users> users = Stream.of(
				new Users("user1@gmail.com", "ankita", "ankita123"),
				new Users("user2@gmail.com", "naman", "naman123"), 
				new Users("user3@gmail.com", "mahesh", "mahesh123"),
				new Users("user4@gmail.com", "deqode", "deqode123")).collect(Collectors.toList());
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringpracticeApplication.class, args);
	}

}
