package com.naidiuk;

import com.naidiuk.service.UserService;
import com.naidiuk.service.UserServiceImpl;

public class Test {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.printAllYoungerEighteen();
        userService.printAllWhoseNameEndsWithO();
        userService.printAllWhoseAgeBetweenEighteenAndSixty();
        userService.printNumberOfUsersWhoseNameContainsA();
        userService.printNumberOfAdultUsers();
    }
}
