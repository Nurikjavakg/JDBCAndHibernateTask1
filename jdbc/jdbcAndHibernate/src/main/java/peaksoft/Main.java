package peaksoft;

import peaksoft.model.User;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Util.getConnection();
        UserServiceImpl userService = new UserServiceImpl();

        while (true){
            System.out.println("Choose your case:");
            int number = new Scanner(System.in).nextInt();
            switch (number){
                case 1->{
                    userService.createUsersTable();
                }
                case 2->{
                    userService.saveUser("Justin","Bieber",(byte) 29);
                }
                case 3->{

                }
                case 4->{
                    System.out.println(userService.getAllUsers());
                }
                case 5->{
                    userService.removeUserById(2L);
                }
                case 6->{
                    userService.cleanUsersTable();
                }
                case 7->{
                    userService.dropUsersTable();
                }

            }
        }



    }
}
