package controller;

/**
 * Created by Mark_Harbunou on 2/1/2017.
 */
public interface Command {
    /**
     * method that receives request from View
     *
     * @param request from View
     * @return result of request
     */
    public String execute(String request);
}
