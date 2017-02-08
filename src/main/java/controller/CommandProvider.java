package controller;

import controller.impl.AddNews;
import controller.impl.FindNews;
import controller.impl.WrongRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();
    CommandProvider(){
        repository.put(CommandName.ADD_NEWS,new AddNews());
        repository.put(CommandName.FIND_NEWS,new FindNews());
        repository.put(CommandName.WRONG_REQUEST,new WrongRequest());
    }
    Command getCommand(String name){
        CommandName commandName =null;
        Command command = null;
        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        }catch(IllegalArgumentException | NullPointerException e){

            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
