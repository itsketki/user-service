package com.demo.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.demo.user.exception.RecordNotFoundException;
import com.demo.user.model.User;
import com.demo.user.repository.UserRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


/**
* <h1>User Details Service</h1>
* The class is the service layer for UserDetails operations.
* <p>
*
* @author  Ketki Gupta
* @version 1.0
* @since   2020-12-03
*/
@Transactional
@Service
public class UserService {

    @Autowired
    public UserRepository repository;

    /**
     * This method is used to retrieve user details using user Id.
     *
     * @param  Id   This is the user id.
     * @return User This is the retrieved user details.
     */
    @HystrixCommand(fallbackMethod = "userDetails_Fallback")
    public User getUserById(Long id) throws RecordNotFoundException
    {
        Optional<User> userRecord = repository.findById(id);
        if(userRecord.isPresent()) {
            return userRecord.get();
        } else {
            throw new RecordNotFoundException("User id '" + id + "' does not exist");
        }
    }

    /**
     * This method is the fallback method for retrieving user details.
     *
     * @param  Id   This is the user id.
     * @return User This is the default user details.
     */
    @SuppressWarnings("unused")
    private User userDetails_Fallback(Long id) {
        System.out.println("User Service is down! fallback route enabled...");
        User defaultUser = new User();
        defaultUser.setId(10000L);
        defaultUser.setFirstName("FirstName");
        defaultUser.setLastName("LastName");
        defaultUser.setTitle("title");
        defaultUser.setGender("Gender");

        return defaultUser;
    }

    /**
     * This method is used to update user details. It queries database for existing user.
     * If the user exists, it updates the details otherwise throws exception.
     *
     * @param  User   This is the user details to be updated.
     * @return User   This is the updated user details.
     */
    @HystrixCommand(fallbackMethod = "userDetails_Fallback")
    public User updateUserDetails(User user) throws RecordNotFoundException
    {
        Optional<User> userRecord = repository.findById(user.getId());
        if(userRecord.isPresent()) {
            user = repository.save(user);
            return user;
        } else {
            throw new RecordNotFoundException("User id '" + user.getId() + "' does not exist");
        }
    }

}
