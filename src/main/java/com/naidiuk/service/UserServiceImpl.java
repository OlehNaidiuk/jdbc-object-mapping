package com.naidiuk.service;

import com.naidiuk.entity.User;
import com.naidiuk.repository.UserRepository;
import com.naidiuk.repository.UserRepositoryImpl;
import com.naidiuk.util.SqlQueries;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void printAllYoungerEighteen() {
        List<User> users = userRepository.findAllYoungerEighteen();
        System.out.println("Users younger eighteen:");
        printAll(users);
        System.out.println("===============================================================================");
    }

    @Override
    public void printAllWhoseNameEndsWithO() {
        List<User> users = userRepository.findAllWhoseNameEndsWithO();
        System.out.println("Users whose name ends with 'o':");
        printAll(users);
        System.out.println("===============================================================================");
    }

    @Override
    public void printAllWhoseAgeBetweenEighteenAndSixty() {
        List<User> users = userRepository.findAllWhoseAgeBetweenEighteenAndSixty();
        System.out.println("Users whose age between 18 and 60:");
        printAll(users);
        System.out.println("===============================================================================");
    }

    @Override
    public void printNumberOfUsersWhoseNameContainsA() {
        List<User> users = userRepository.findAllWhoseNameContainsA();
        System.out.println("Number of users whose name contains 'a':");
        System.out.println(users.size());
        System.out.println("===============================================================================");
    }

    @Override
    public void printNumberOfAdultUsers() {
        List<User> users = userRepository.findAllAdult();
        System.out.println("Number of adult users:");
        System.out.println(users.size());
        System.out.println("===============================================================================");
    }

    private void printAll(List<User> users) {
        for (User user : users) {
            System.out.println(user);
        }
    }
}
