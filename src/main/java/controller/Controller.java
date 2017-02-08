package controller;

/**
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class Controller {
    private final CommandProvider provider = new CommandProvider();
    private final char paramDelimeter = ' ';
    public String executeTask(String request) {
        String commandName;
        Command executionCommand;
        String[] splittedRequest = request.split(" ");
        if(splittedRequest.length <= 3) {
            return "incorrect amounts of parameters";
        }
        commandName = splittedRequest[0];
        executionCommand = provider.getCommand(commandName);
        String response;
        response = executionCommand.execute(request);
        return response;
    }
}
