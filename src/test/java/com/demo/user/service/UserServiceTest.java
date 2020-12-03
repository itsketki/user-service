package com.demo.user.service;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.user.exception.RecordNotFoundException;
import com.demo.user.model.Address;
import com.demo.user.model.User;
import com.demo.user.repository.UserRepository;

@RunWith(SpringRunner.class)
public class UserServiceTest {
    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    @Before
    public void setUp() {
        User john = new User();
        john.setId(11L);

        Mockito.when(repository.findById(john.getId())).thenReturn(Optional.of(john));
        Mockito.when(repository.findById(99L)).thenReturn(Optional.empty());
    }

    @Test
    public void when_UserExists_Expect_SuccessResponse() throws RecordNotFoundException{
        Long id = 11L;
        User found = service.getUserById(id);
        assert(found.getId()).equals(id);
        Mockito.verify(repository).findById(11L);
    }

    @Test(expected = RecordNotFoundException.class)
    public void when_UserDoesNotExist_Expect_ExceptionThrown() throws RecordNotFoundException{
        Long id = 99L;
        service.getUserById(id);
        Mockito.verify(repository).findById(99L);
    }

    @Test
    public void when_UserToBeUpdatedExists_Expect_SuccessResponse() throws RecordNotFoundException{
        Address address = new Address(5L,"street","city","state",2020);
        User saveDetails = new User(11L,"fname","lname","Mr","Male",address);
        Mockito.when(repository.findById(11L)).thenReturn(Optional.of(saveDetails));
        Mockito.when(repository.save(saveDetails)).thenReturn(saveDetails);
        User savedUser = service.updateUserDetails(saveDetails);
        System.out.println(savedUser.getId());
        assert(savedUser.getId()).equals(11L);
        Mockito.verify(repository).findById(11L);
        Mockito.verify(repository).save(saveDetails);
    }

}
