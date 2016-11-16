package by.vasilevich.navigation;

import by.vasilevich.navigation.commands.ICommand;

public class CommandFactory {
	
    public static ICommand getCommand(String page) {
        Commands command = Commands.valueOf(page.toUpperCase());
        return command.getCommand();
    }

}
