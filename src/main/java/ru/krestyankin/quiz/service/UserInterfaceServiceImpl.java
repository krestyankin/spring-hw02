package ru.krestyankin.quiz.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class UserInterfaceServiceImpl implements UserInterfaceService {
    private final Scanner in;

    public UserInterfaceServiceImpl() {
        in = new Scanner(System.in);
    }

    public String getString() {
        String input="";
        while (input.length()==0)
          input=in.nextLine();
        return input;
    }

    public void writeString(String msg) {
        System.out.println(msg);
    }
}
