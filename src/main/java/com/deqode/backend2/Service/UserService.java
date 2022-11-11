package com.deqode.backend2.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.deqode.backend2.Dto.JwtRequest;
import com.deqode.backend2.Model.Users;
import com.deqode.backend2.Repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

//	@Autowired
//	private PasswordEncoder bcryptEncoder;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public Users createUser(Users user) {
		logger.info("Into the UserService");
		Users users = userRepository.save(user);
		return users;
	}

	public List<Users> getAllUsers() {
		logger.info("Into the UserService");
		List<Users> user = userRepository.findAll();
		return user;
	}

	public Optional<Users> getUserById(String id) {
		logger.info("Into the UserService");
		Optional<Users> userById = userRepository.findById(id);
		return userById;
	}

	// Update User
	public ResponseEntity<Users> updateUser(String id, Users user) {
		logger.info("Into the UserService");
		Optional<Users> userData = userRepository.findById(id);

		if (userData.isPresent()) {
			Users _user = userData.get();
			_user.setEmail(user.getEmail());
			_user.setPassword(user.getPassword());

			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Delete User
	public ResponseEntity<Users> deleteUser(String id) {
		logger.info("Into the deleteUser UserService");
		try {
			userRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

//	public Users save(JwtRequest user) {
//		Users newUser = new Users(null, null, null);
//		newUser.setUsername(user.getUsername());
//		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//		return userRepository.save(newUser);
//	}
}
