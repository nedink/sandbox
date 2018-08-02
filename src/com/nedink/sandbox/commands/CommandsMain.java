package com.nedink.sandbox.commands;

import java.util.Scanner;

public class CommandsMain {

    public static boolean running;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("type a command.");


        running = true;
        while (running) {
//            CommandType commandType = CommandsMap.commandTypeMap.get(scanner.next());
//            if (commandType == null) {
//                System.out.println("null");
//                continue;
//            }
//            System.out.println(scanner.next());
//            System.out.println(scanner.nextLine().trim());
//            for (String s : scanner.nextLine().trim().split())
//                System.out.println(s);
//            switch (commandType) {
//                case QUIT:
//                    System.exit(0);
//            }
        }
    }
}
