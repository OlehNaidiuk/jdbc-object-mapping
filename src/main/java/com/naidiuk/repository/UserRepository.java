package com.naidiuk.repository;

import com.naidiuk.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAllYoungerEighteen();
    List<User> findAllWhoseNameEndsWithO();
    List<User> findAllWhoseAgeBetweenEighteenAndSixty();
    List<User> findAllWhoseNameContainsA();
    List<User> findAllAdult();
}
