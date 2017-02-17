package controller.impl;


import bean.News;
import controller.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import service.NewsService;
import service.exeption.ServiceException;
import service.factory.ServiceFactory;


/**
 * Class that transfer request(find news) to service and return result of finding
 * <p>
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class FindNews implements Command {
    private static Logger logger = LogManager.getLogger(FindNews.class.getName());

    /**
     * method that transfer request(find news)to service and return result of adding
     *
     * @param news from View
     * @return result of request
     */
    @Override
    public String execute(News news) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();
        try {
            if (logger.isDebugEnabled()) {
                logger.debug("FindNewsLogger in debug");
            }
            return newsService.findNews(news);

        } catch (ServiceException e) {
            logger.error("error message: " + e);
            return "error during findNews procedure";
        }
    }

}
