package com.app.Service;

import java.util.List;

import com.app.Dto.LoginDto;
import com.app.Dto.UserUpdateDto;
import com.app.Exception.UserException;
import com.app.Model.User;

public interface UserService {
	
	public String createNewUser(User user) throws UserException;
	
	public String verifyOtp(UserUpdateDto userUpdateDto) throws UserException;


	public User login(LoginDto loginDto) throws UserException;

}
