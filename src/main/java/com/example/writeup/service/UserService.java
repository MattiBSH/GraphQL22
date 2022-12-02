package com.example.writeup.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.writeup.model.Courier;
import com.example.writeup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private UserRepository userRepository;

    public List<Courier> getAllUsers() {
        return userRepository.findAll();
    }

    public Courier updateUserAddress(Integer userId, String address) throws Exception {
        try {
            userRepository.updateUserAddress(address, userId);
            Courier user = userRepository.findById(userId).get();
            return user;
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

}
