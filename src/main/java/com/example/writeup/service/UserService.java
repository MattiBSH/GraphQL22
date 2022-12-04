package com.example.writeup.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.writeup.model.Courier;
import com.example.writeup.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CourierRepository courierRepository;

    public List<Courier> findAllCouriers() {
        return courierRepository.findAll();
    }

    public Courier findOneCourier(Integer id) {
        return courierRepository.findById(id).get();
    }

    //Find all courier with active status
    public List<Courier> findAvailableCourier(Boolean available) {
        List<Courier>couriers=courierRepository.findAll();
        List<Courier>availableCouriers=new ArrayList<>();
        for (int i = 0; i < couriers.size(); i++) {
            if(couriers.get(i).getAvailable()==available){
                availableCouriers.add(couriers.get(i));
            }
        }
        return availableCouriers;
    }
}
