package controller.impl;


import controller.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import service.NewsService;
import service.exeption.ServiceException;
import service.factory.ServiceFactory;


/**
 * Class that transfer request(find news) to service and return result of finding
 *
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class FindNews implements Command {
    final Logger logger = LogManager.getLogger(FindNews.class.getName());

    /**
     * method that transfer request(find news)to service and return result of adding
     *
     * @param request from View
     * @return result of request
     */
    @Override
    public String execute(String request) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        try {
            if (logger.isDebugEnabled()) {
                logger.debug("FindNewsLogger in debug");
            }
            return newsService.findNews(request);

        } catch (ServiceException e) {
            logger.error("error message: " + e.getMessage());
            logger.fatal("fatal error message: " + e.getMessage());
            return "News not found";
        }
    }

}
