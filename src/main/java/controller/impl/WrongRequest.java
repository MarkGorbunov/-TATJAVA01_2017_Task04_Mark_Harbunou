package controller.impl;

import controller.Command;

/**
 * Created by Mark_Harbunou on 2/2/2017.
 */
public class WrongRequest implements Command {
    @Override
    public String execute(String request) {
        String responce = "Wrong request";
        return responce;
    }
}

