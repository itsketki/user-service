package com.demo.user.controller;

import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.demo.user.exception.RecordNotFoundException;
import com.demo.user.model.Address;
import com.demo.user.model.User;
import com.demo.user.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @InjectMocks
    private UserController controller;

    @Mock
    private UserService service;

    @Mock
    private User user;

   @Before
    public void setUp() throws RecordNotFoundException {
       User john = new User();
       john.setId(11L);
       Mockito.when(service.getUserById(john.getId())).thenReturn(john);

    }

    @Test
    public void when_UserExists_Expect_Response200() throws RecordNotFoundException{

        ResponseEntity<User> responseEntity = controller.getEmployeeById(11L);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test(expected = RecordNotFoundException.class)
    public void when_UserDoesNotExist_Expect_Response404() throws RecordNotFoundException{
        when(service.getUserById(any())).thenThrow(new RecordNotFoundException("Employee id 99 does not exist"));
        ResponseEntity<User> responseEntity = controller.getEmployeeById(any());
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(404);
    }

    @Test
    public void when_UserToUpdateExists_Expect_Response200() throws RecordNotFoundException{
        Address address = new Address(5L,"street","city","state",2020);
        User saveDetails = new User(11L,"fname","lname","Mr","Male",address);
        //when(service.getUserById(any())).thenReturn(saveDetails);
        ResponseEntity<User> responseEntity = controller.updateUserDetails(saveDetails, 11L);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test(expected = RecordNotFoundException.class)
    public void when_InvalidInputId_Expect_Response400() throws RecordNotFoundException{
        when(service.getUserById(any())).thenThrow
        (new RecordNotFoundException("Invalid input, expected numeric value."));
        ResponseEntity<User> responseEntity = controller.getEmployeeById(any());
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(400);
    }
}
