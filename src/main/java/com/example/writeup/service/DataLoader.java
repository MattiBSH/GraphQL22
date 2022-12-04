package com.example.writeup.service;

import com.example.writeup.model.Post;
import com.example.writeup.model.Courier;
import com.example.writeup.repository.PostRepository;
import com.example.writeup.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DataLoader {

    @Autowired
    private CourierRepository userRepository;

    @Autowired
    private PostRepository postRepository;
    AtomicInteger id = new AtomicInteger(0);

    @PostConstruct
    public void loadData(){

        Courier courier1 = new Courier(id.incrementAndGet(),"Kenneth" ,"wefwe","kenneth@kenneth.dk","password123",true);
        Courier courier2 = new Courier(id.incrementAndGet(),"Jens" ,"sdfw","jens@kenneth.dk","password123",false);
        Courier courier3 = new Courier(id.incrementAndGet(),"Birger" ,"gsg","birger@kenneth.dk","password123",true);

        Post post1 = new Post("Graphql with SpringBoot",DataLoader.getRandomDate());
        Post post2 = new Post("Flutter with Firebase",DataLoader.getRandomDate());
        Post post3 = new Post("Nodejs Authentication with JWT",DataLoader.getRandomDate());

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);

        userRepository.save(courier1);
        userRepository.save(courier2);
        userRepository.save(courier3);




    }


    public static Date getRandomDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1990);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DATE, 2);
        Date date1 = calendar.getTime();
        calendar.set(Calendar.YEAR, 1996);
        Date date2 = calendar.getTime();
        long startMillis = date1.getTime();
        long endMillis = date2.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);

        return new Date(randomMillisSinceEpoch);
    }


}
