package controller.impl;

import bean.News;
import controller.Command;

/**
 * Class that transfer request(add news) to service and return result of adding
 * <p>
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class WrongRequest implements Command {
    /**
     * method that return responce(wrong request) if request was incorrect
     *
     * @param news from View
     * @return result of request
     */
    @Override
    public String execute(News news) {
        String responce = "Wrong request";
        return responce;
    }
}

