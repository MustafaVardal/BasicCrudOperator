package com.mustafavardal.user.service;

import com.mustafavardal.user.entity.User;
import com.mustafavardal.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    private UserRepository userRepository;
    private UserServiceImpl userService;


    private User alice;
    private User bob;
    private User charlie;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);

        alice = new User(UUID.randomUUID(), "Alice", "adadsadasdasdad");
        bob = new User(UUID.randomUUID(), "Bob", "sdaadas");
        charlie = new User(UUID.randomUUID(), "Charlie", "1231232sadsa");
    }

    @Test
    void shouldAddUser() {


        userService.addUser(alice);

        verify(userRepository, times(1)).save(alice);
    }

    @Test
    void shouldReturnAllUsers() {
        when(userRepository.findAll()).thenReturn(List.of(bob, alice));

        List<User> users = userService.getAll();

        assertEquals(2, users.size());
    }

    @Test
    void shouldReturnUserByName() {


        when(userRepository.findByName("Bob")).thenReturn(Optional.of(bob));

        User result = userService.getUserByName("Bob");

        assertNotNull(result);
        assertEquals("Bob", result.getName());
    }

    @Test
    void shouldDeleteUserByName() {
        doNothing().when(userRepository).deleteByName("Charlie");

        userService.deleteUserByName("Charlie");

        verify(userRepository, times(1)).deleteByName("Charlie");
    }

}