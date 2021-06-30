package com.ust.user.service;

import java.util.List;
import java.util.Optional;

import com.ust.user.entity.User;
import com.ust.user.exception.IncompleteDetailsException;
import com.ust.user.exception.InvalidDateException;
import com.ust.user.exception.InvalidRoleException;
import com.ust.user.exception.UserExistsException;
import com.ust.user.exception.UserNotFoundException;

public interface UserService {
	
//	public boolean addUser(User user) throws UserExistsException;
//	public boolean deleteUser(User user) throws IncompleteDetailsException,InvalidRoleException,InvalidDateException,  UserNotFoundException;
//	public boolean updateUser(User user) throws UserNotFoundException;
//	public List<User> getallUser() throws UserNotFoundException;
//	public List<User> getById(User user)throws UserNotFoundException;

	public User saveUser(User user);

	public User getUserById(int id);

	public User updateByUserId(int id) ;

	public User deleteByUserId(int id);

	//List<User> getAllUser();
}
