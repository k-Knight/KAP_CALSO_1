package com.kknight.example.ass1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        IntList intList = new IntList();
        Scanner scanner = new Scanner(System. in);
        while (true) {
            System.out.print("> ");
            String inputString = scanner. nextLine();
            if (inputString.equals("exit"))
                break;
            Command cmd = new Command(inputString);
            if (cmd.type == CommandType.undefined) {
                System.out.println(cmd.error);
            }
            switch (cmd.type) {
                case print: System.out.println("List: " + intList.toString()); break;
                case add: {
                    if (intList.add(cmd.argument))
                        System.out.println("Added: " + cmd.argument);
                    else
                        System.out.println("Failed to add: " + cmd.argument);
                } break;
                case remove: {
                    if (intList.remove(cmd.argument))
                        System.out.println("Removed: " + cmd.argument);
                    else
                        System.out.println("Failed to remove: " + cmd.argument);
                } break;
                case clear: {
                    if (intList.clear())
                        System.out.println("Cleared the list");
                    else
                        System.out.println("Failed to clear the list");
                } break;
            }
        }
    }
}
