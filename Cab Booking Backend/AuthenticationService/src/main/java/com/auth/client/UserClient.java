package com.auth.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.auth.entity.User;

@FeignClient(name = "userSevice", url = "http://localhost:8084/")
public interface UserClient {
	
	    @PostMapping("/users/addUser")
	    public User createUser(@RequestBody User user); 

	    @GetMapping("/users/{userId}")
	    public User getUserById(@PathVariable Long userId);

	    @GetMapping("/users")
	    public List<User> getAllUsers();

	    @PutMapping("/users/{userId}")
	    public User updateUser(@PathVariable Long userId, @RequestBody User user);

	    @DeleteMapping("/users/{userId}")
	    public ResponseEntity<Void> deleteUser(@PathVariable Long userId);


}
