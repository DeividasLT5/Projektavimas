package main;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        FileManager fileManager = new FileManager();
        Scanner input = new Scanner(System.in);
        System.out.println("Name, Last name, number, email, address, password");
        User user = new User(input.nextLine(), input.nextLine(), input.nextLine(),
                input.nextLine(), input.nextLine(), input.nextLine());

        String password = user.getPassword();
        String number   = user.getNumber();
        String email    = user.getEmail();
        int random = (int) (Math.random() * 99999 + 10000);
        MainModule mm = new MainModule();
        if (!mm.isPasswordInvalid(password) && !mm.isPhoneInvalid(number) && !mm.isEmailInvalid(email)){
            try {
                fileManager.AddUser(user, Integer.toString(random));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
