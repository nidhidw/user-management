package com.ust.user.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ust.user.entity.User;
import com.ust.user.repository.UserRepository;
import com.ust.user.service.UserServiceImpl;

@SpringBootTest
class ServiceIntegrationTest {

	 @Autowired
	    private UserRepository userRepo;

	    @Autowired
	    private UserServiceImpl userService;
	    private User user1, user2, user3;
	    private List<User> userList;
	    private Optional optional;

	    @BeforeEach
	    public void setUp() {

	        userList = new ArrayList<>();
	        user1 = new User(1, 1, "2020-12-20", "2021-02-15");
	        user2 = new User(2, 1, "2020-11-08", "2021-01-10");
	        user3 = new User(3, 2, "2020-10-18", "2021-01-04");
	        userList.add(user1);
	        userList.add(user2);
	        userList.add(user3);
	    }

	    @AfterEach
	    public void tearDown() {
	        user1 = user2 = user3 = null;
	        userList = null;
	    }

	    @Test
	    public void givenBlogToSaveThenShouldReturnSavedBlog() {
	        User savedUser = userRepo.save(user1);
	        assertNotNull(savedUser);
	        assertEquals(user1.getId(), savedUser.getId());
	    }


}
