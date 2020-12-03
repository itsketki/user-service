package com.demo.user.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.user.model.User;

@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        User john = new User();
        john.setId(11L);

        Mockito.when(userRepository.findById(john.getId())).thenReturn(Optional.of(john));
        Mockito.when(userRepository.findById(99L)).thenReturn(Optional.empty());
    }

    @Test
    public void when_UserExists_Expect_Record() throws Exception{
        assertNotNull(userRepository.findById(11L));
    }

    @Test
    public void when_UserDoesNotExist_Expect_NoRecord() throws Exception{
        assertEquals(userRepository.findById(99L),Optional.empty());
    }


}
