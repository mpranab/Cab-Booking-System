package com.userService.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.userService.entity.User;
import com.userService.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        user1 = new User();
        user1.setUserId(1L);
        user1.setFirstName("Akash");
        user1.setLastName("M");
        user1.setPhoneNumber(1234567890L);
        user1.setEmail("akash@gmail.com");

        user2 = new User();
        user2.setUserId(2L);
        user2.setFirstName("Sumit");
        user2.setLastName("S");
        user2.setPhoneNumber(9876543210L);
        user2.setEmail("sumit@gmail.com");
    }

    @Test
    void testCreateUser() {
        when(userRepository.save(user1)).thenReturn(user1);

        User createdUser = userService.createUser(user1);

        assertNotNull(createdUser);
        assertEquals(user1.getUserId(), createdUser.getUserId());
        assertEquals(user1.getFirstName(), createdUser.getFirstName());
        verify(userRepository, times(1)).save(user1);
    }

    @Test
    void testGetUserById_UserExists() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));

        User foundUser = userService.getUserById(1L);

        assertNotNull(foundUser);
        assertEquals(user1.getUserId(), foundUser.getUserId());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testGetUserById_UserDoesNotExist() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        User foundUser = userService.getUserById(1L);

        assertNull(foundUser);
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = userService.getAllUsers();

        assertNotNull(users);
        assertEquals(2, users.size());
        assertEquals(user1.getEmail(), users.get(0).getEmail());
        assertEquals(user2.getEmail(), users.get(1).getEmail());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testUpdateUser() {
        user1.setLastName("UpdatedLastName");
        when(userRepository.save(user1)).thenReturn(user1);

        User updatedUser = userService.updateUser(user1.getUserId(), user1);

        assertNotNull(updatedUser);
        assertEquals(user1.getUserId(), updatedUser.getUserId());
        assertEquals("UpdatedLastName", updatedUser.getLastName());
        verify(userRepository, times(1)).save(user1);
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userRepository).deleteById(1L);

        userService.deleteUser(1L);

        verify(userRepository, times(1)).deleteById(1L);
    }
}