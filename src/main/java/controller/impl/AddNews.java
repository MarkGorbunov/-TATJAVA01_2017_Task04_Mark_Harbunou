package controller.impl;

import bean.News;
import controller.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.NewsService;
import service.exeption.ServiceException;
import service.factory.ServiceFactory;


/**
 * Class that transfer request(add news) to service and return result of adding
 * <p>
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class AddNews implements Command {

    private static Logger logger = LogManager.getLogger(AddNews.class.getName());

    /**
     * method that transfer request(add news) to service and return result of adding
     *
     * @param news from View
     * @return result of request
     */
    @Override
    public String execute(News news) {
        String responce = "";
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();
        try {
            if (logger.isDebugEnabled()) {
                logger.debug("AddNewsLogger in debug");
            }
            newsService.addNews(news);
            responce = "book added";
        } catch (ServiceException e) {
            logger.error("error message: " + e);
            responce = "error during addNews procedure";
        }
        return responce;
    }
}
