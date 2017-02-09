package service;

import beans.News;
import service.exeption.ServiceException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Mark_Harbunou on 2/1/2017.
 */
public interface NewsService {
    /**
     * method that add news
     *
     * @param news
     * @throws ServiceException
     */
    void addNews(String news) throws ServiceException;

    /**
     * method that find news
     *
     * @param news that we found
     * @return found news
     * @throws ServiceException
     */
    String findNews(String news) throws ServiceException;
}
