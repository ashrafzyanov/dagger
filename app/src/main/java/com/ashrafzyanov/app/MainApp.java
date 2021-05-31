package com.ashrafzyanov.app;

import com.ashrafzyanov.app.command.Command;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MainApp {

    private final List<Command> commands;

    public void startApp(String[] args) {
        Map<String, Command> mapCommand = initCommand();
        String userAnswer = null;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            printPromt();
            userAnswer = scanner.next().trim();
            System.out.println(userAnswer);
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
        return commands.stream().collect(Collectors.toMap(e -> e.getActive(), Function.identity()));

    }

    private void printPromt() {
        for(Command command : commands) {
            System.out.printf("%20s to %20s\n", command.getActive(), command.getCommandName());
        }
    }

}
