package com.example.writeup.repository;

import com.example.writeup.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE user SET address = ?1 WHERE user_id = ?2 ", nativeQuery = true)
    int updateUserAddress(String address, Integer user_id);

}
