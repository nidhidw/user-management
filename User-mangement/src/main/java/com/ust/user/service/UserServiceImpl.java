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

	@Override
	public User getUserById(int id) {
		User user = null;
		user = userRepo.findById(id).get();
		return user;

	}

	@Override
	public User saveUser(User user) {
		User savedUser = userRepo.save(user);
		return savedUser;
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
	public User updateByUserId(int id) {

		User userr = null;
		User updatedUser = null;
		Optional optional = userRepo.findById(id);
		if (optional.isPresent()) {
			userr = userRepo.findById(id).get();
			updatedUser = userRepo.findById(id).get();
			userr.setRole_id(userr.getRole_id());
			userr.setCreated_date(userr.getCreated_date());
			userr.setUpdate_date(userr.getUpdate_date());
			updatedUser=userr;
			updatedUser = saveUser(updatedUser);
		}
		return updatedUser;
	}

//	public Blog updateBlog(Blog blog) {
//        Blog updatedBlog = null;
//        Optional optional = blogRepository.findById(blog.getBlogId());
//        if (optional.isPresent()) {
//            Blog getBlog = blogRepository.findById(blog.getBlogId()).get();
//            getBlog.setBlogContent(blog.getBlogContent());
//            updatedBlog = saveBlog(getBlog);
//        }
//        return updatedBlog;

}
