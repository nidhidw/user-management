package com.ust.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.user.entity.User;
import com.ust.user.exception.IncompleteDetailsException;
import com.ust.user.exception.InvalidDateException;
import com.ust.user.exception.InvalidRoleException;
import com.ust.user.exception.UserExistsException;
import com.ust.user.exception.UserNotFoundException;
import com.ust.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;

	@Autowired
	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

//	@Override
//	public boolean addUser(User user) throws UserExistsException {
//		if (!((userRepo.findById(user.getId()) == null))) {
//			throw new UserExistsException("USer Already Exists!!!!!!!!!!");
//		}
//		userRepo.save(user);
//		return true;
//	}
//
//	@Override
//	public boolean deleteUser(User user)
//			throws IncompleteDetailsException, InvalidRoleException, InvalidDateException, UserNotFoundException {
//		if (!(userRepo.findById(user.getId()).isPresent())) {
//			throw new UserNotFoundException("User Doesn't Exists!!!!!!!!!!");
//		}
//		if (!(userRepo.findById(user.getRole_id()).isPresent())) {
//			throw new InvalidRoleException("User Role Invalid!!!!!!!");
//		}
//
//		if (user.getCreated_date().equals(null) || user.getUpdate_date().equals(null)) {
//			throw new InvalidDateException("Please enter a date");
//		}
//
//		userRepo.delete(user);
//		return true;
//	}
//
//	@Override
//	public boolean updateUser(User user) throws UserNotFoundException {
//
//		if (!(userRepo.findById(user.getId()).isPresent())) {
//			throw new UserNotFoundException("User Doesn't Exists!!!!!!!!!!");
//		}
//		User temp = userRepo.findById(user.getId()).get();
//		temp.setCreated_date(user.getCreated_date());
//		temp.setUpdate_date(user.getUpdate_date());
//		temp.setRole_id(user.getRole_id());
//		userRepo.save(temp);
//		return true;
//	}
//
//	@Override
//	public List<User> getallUser() throws UserNotFoundException {
//
//		return userRepo.findAll();
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<User> getById(User user) throws UserNotFoundException {
//		if (!(userRepo.findById(user.getId()).isPresent())) {
//			throw new UserNotFoundException("User Doesn't Exists!!!!!!!!!!");
//		}
//
//		return (List<User>) userRepo.findById(user.getId()).get();
//	}

//	@Override
//	public List<User> getAllUser() {
//
//		return userRepo.findAll();
//
//	}

	@Override
	public User getUserById(int id) {
		User user = null;
		user = userRepo.findById(id).get();
		return user;

	}

	@Override
	public User deleteByUserId(int id) {
		User user = null;
		Optional optional = userRepo.findById(id);
		if (optional.isPresent()) {
			user = userRepo.findById(id).get();
			userRepo.deleteById(id);
		}
		return user;

	}

	@Override
	public User saveUser(User user) {
		User savedUser = userRepo.save(user);
		return savedUser;
	}

	@Override
	public User updateByUserId(int id) {

		User updatedUser = null;
		Optional optional = userRepo.findById(id);
		if (optional.isPresent()) {
			updatedUser = saveUser(updatedUser);
		}
		return updatedUser;
	}

//	public User updateByUserId(User user) throws UserNotFoundException {
//		if (!(userRepo.findById(user.getId()).isPresent())) {
//			throw new UserNotFoundException("User Doesn't Exists!!!!!!!!!!");
//		}
//		User temp = userRepo.findById(user.getId()).get();
//		temp.setCreated_date(user.getCreated_date());
//		temp.setUpdate_date(user.getUpdate_date());
//		temp.setRole_id(user.getRole_id());
//		userRepo.save(temp);
//		return temp;
//
//		
//	    }
}