package com.ust.user.test;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.ust.user.entity.User;
import com.ust.user.repository.UserRepository;
import com.ust.user.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
class ServiceTest {
	
	 @Autowired
	    private MockMvc mockMvc;


//	@Before(value = "")
//	public void initMocks() {
//		MockitoAnnotations.initMocks(this);
//	}
	
	@Mock
	private UserRepository userRepo;

	@InjectMocks
	private UserServiceImpl userService;
	private User user, user1;
	private List<User> userList;
	private Optional optional;

	
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		user = new User(1, 1, "2020-12-20", "2021-02-15");
		user1 = new User(2, 1, "2020-11-08", "2021-01-10");
		optional = Optional.of(user);
	}

	@AfterEach
	public void tearDown() {
		user = null;
	}

	@Test
	public void givenUserToSaveThenShouldReturnSavedBlog() {
		when(userRepo.save(any())).thenReturn(user);
		assertEquals(user, userService.saveUser(user));
		verify(userRepo, times(1)).save(any());
	}

	@Test
	public void givenBlogToSaveThenShouldNotReturnSavedBlog() {
		when(userRepo.save(any())).thenThrow(new RuntimeException());
		Assertions.assertThrows(RuntimeException.class, () -> {
			userService.saveUser(user);
		});
		verify(userRepo, times(1)).save(any());
	}

	@Test
	public void givenUserIdThenShouldReturnRespectiveUser() {
		when(userRepo.findById(anyInt())).thenReturn(Optional.of(user));
		User retrievedUser = userService.getUserById(user.getId());
		verify(userRepo, times(1)).findById(anyInt());

	}

	@Test
	void givenBlogIdToDeleteThenShouldReturnDeletedBlog() {
		when(userRepo.findById(user.getId())).thenReturn(optional);
		User deletedBlog = userService.deleteByUserId(1);
		assertEquals(1, deletedBlog.getId());

		verify(userRepo, times(2)).findById(user.getId());
		verify(userRepo, times(1)).deleteById(user.getId());
	}

	@Test
	void givenBlogIdToDeleteThenShouldNotReturnDeletedBlog() {
		when(userRepo.findById(user.getId())).thenReturn(Optional.empty());
		User deletedBlog = userService.deleteByUserId(1);
		verify(userRepo, times(1)).findById(user.getId());
	}

}
