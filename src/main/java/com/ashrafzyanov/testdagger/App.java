package com.ashrafzyanov.testdagger;

import com.ashrafzyanov.testdagger.command.Command;
import com.ashrafzyanov.testdagger.service.UserManager;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {

    @Inject
    private List<Command> commands;

    public static void main( String[] args ) {
        new App().startApp(args);
    }

    public void startApp(String[] args) {
        Map<String, Command> mapCommand = initCommand();
        String userAnswer = null;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            printPromt();
            userAnswer = scanner.next();
            if (userAnswer == null || userAnswer.isEmpty() || "exit".equals(userAnswer)) {
                return;
            }
            Command command = mapCommand.get(userAnswer);
            if (command == null) {
                System.out.println("Command does't exist. Try again\n");
                continue;
            }
            command.execute();
        }
    }

    private Map<String, Command> initCommand() {
        Map<String, Command> commandMap = new HashMap<>();
        return commands.stream().collect(Collectors.toMap(e -> e.getCommandName(), Function.identity()));

    }

    private void printPromt() {
        for(Command command : commands) {
            System.out.printf("%20s to $20s\n", command.getActive(), command.getCommandName());
        }
    }

}
