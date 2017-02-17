package controller;

import DAO.connectingPool.exception.ConnectingPoolException;
import DAO.exception.DAOException;
import bean.Category;
import bean.News;
import controller.impl.AddNews;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.NewsService;
import service.exeption.ServiceException;
import service.factory.ServiceFactory;

import java.sql.SQLException;

/**
 * Class that decide what to do with request from View
 * <p>
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class Controller {
    private static Logger logger = LogManager.getLogger(Controller.class.getName());
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private final NewsService newsService = serviceFactory.getNewsService();
    private final CommandProvider provider = new CommandProvider();

    /**
     * method that execute request from View and check for correct number of parameters also
     * pick out news and transfer it
     *
     * @param request from View
     * @return result of request
     */
    public String executeTask(String request) {
        String commandName;
        Command executionCommand;
        String[] splittedRequest = request.split(" ");
        if (splittedRequest.length <= 3) {
            return "incorrect amounts of parameters in news";
        }
        commandName = splittedRequest[0];
        executionCommand = provider.getCommand(commandName);
        String response;
        if (checkCategory(splittedRequest[1]) == false) {
            return "Category not found";
        }
        Category category = Category.valueOf(splittedRequest[1].toUpperCase());
        String title = splittedRequest[2];
        String author = splittedRequest[3];
        response = executionCommand.execute(new News(category, title, author));
        return response;
    }


    private boolean checkCategory(String request) {
        if (Category.BOOKS.toString().equalsIgnoreCase(request)) {
            return true;
        }
        if (Category.DISKS.toString().equalsIgnoreCase(request)) {
            return true;
        }
        if (Category.MOOVIES.toString().equalsIgnoreCase(request)) {
            return true;
        }
        return false;
    }

    /**
     * method that call connection create in service
     *
     * @throws ServiceException
     */
    public void initResources() {
        try {
            newsService.initResources();
        } catch (ServiceException e) {
            logger.error("error message: " + e);
        }
    }

    /**
     * method that call connection destroy in service
     *
     * @throws ServiceException
     */
    public void clearResources() {
        try {
            newsService.clearResources();
        } catch (ServiceException e) {
            logger.error("error message: " + e);
        }
    }
}
