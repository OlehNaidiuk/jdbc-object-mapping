package com.naidiuk;

import com.naidiuk.service.UserService;
import com.naidiuk.service.UserServiceImpl;

public class Test {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        System.out.println("Users younger eighteen:");
        userService.printAllYoungerEighteen();
        System.out.println("===============================================================================");
        System.out.println("Users whose name ends with 'o':");
        userService.printAllWhoseNameEndsWithO();
        System.out.println("===============================================================================");
        System.out.println("Users whose age between 18 and 60:");
        userService.printAllWhoseAgeBetweenEighteenAndSixty();
        System.out.println("===============================================================================");
        System.out.println("Number of users whose name contains 'a':");
        userService.printNumberOfUsersWhoseNameContainsA();
        System.out.println("===============================================================================");
        System.out.println("Number of adult users:");
        userService.printNumberOfAdultUsers();
    }
}
