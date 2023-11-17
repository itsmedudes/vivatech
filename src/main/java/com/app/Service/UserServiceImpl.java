package com.app.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.app.Dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dto.UserUpdateDto;
import com.app.Exception.UserException;
import com.app.Model.User;
import com.app.Repository.UserRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	

	
	@Override
	public String createNewUser(User user) throws UserException {
			Random rnd = new Random();
			int number = rnd.nextInt(999999);
			String otp  = String.format("%06d", number);

			User users = userRepository.findByMobile(user.getMobile());
			if(users!=null){
				if(users.is_verified()==false){
					users.setUpdated_at(new Date(System.currentTimeMillis()));
					users.setOtp(otp);
					userRepository.save(users);
					return otp;
				}else{
					throw new UserException("User already exist With this Mobile Number And Verified: "+user.getMobile());

				}

			}
		user.setCreated_at(new Date(System.currentTimeMillis()));
		user.setOtp(otp);
		userRepository.save(user);
		return otp;



	}

	public String verifyOtp(UserUpdateDto userUpdateDto) throws UserException{

		User user = userRepository.findByMobile(userUpdateDto.getMobile());

		if(user!=null){
			if (user.getOtp() != null && user.getOtp().equals(userUpdateDto.getOtp())) {
				user.set_verified(true);
//				user.setOtp("");
				userRepository.save(user);

				return "Successfully Verified";
			} else {
				return "Invalid OTP";
			}
		}else{
			 return "Invalid Mobile Number";
		}

	}

	@Override
	public User login(LoginDto loginDto) throws UserException {
		User user = userRepository.findByMobile(loginDto.getMobile());

		if(user!=null){
			if(user.getPassword().equals(loginDto.getPassword())){
				return user;
			}else{
				throw new UserException("Invalid Crendentials");
			}
		}else{

		throw new UserException("Not Registered with this Mobile Number: "+user.getMobile());
		}

	}


}
