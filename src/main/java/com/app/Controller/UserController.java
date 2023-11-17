package com.app.Controller;

import java.util.List;

import com.app.Dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.Dto.UserUpdateDto;
import com.app.Exception.UserException;
import com.app.Model.User;
import com.app.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<String> createNewUserHandler(@Validated @RequestBody User user) throws UserException{
		return new ResponseEntity<String>(userService.createNewUser(user),HttpStatus.CREATED);
	}

	@PostMapping("/verifyotp")
	public ResponseEntity<String> verifyOtpHandler(@Validated @RequestBody UserUpdateDto userUpdateDto) throws UserException{
		return new ResponseEntity<String>(userService.verifyOtp(userUpdateDto),HttpStatus.CREATED);
	}


	@PostMapping("/login")
	public ResponseEntity<User> loginHandler(@Validated @RequestBody LoginDto loginDto) throws UserException{
		return new ResponseEntity<User>(userService.login(loginDto),HttpStatus.CREATED);
	}

	
}
