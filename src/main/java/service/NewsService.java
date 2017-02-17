package service;

import DAO.exception.DAOException;
import bean.News;
import service.exeption.ServiceException;

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
    void addNews(News news) throws ServiceException;

    /**
     * method that find news
     *
     * @param news that we found
     * @return found news
     * @throws ServiceException
     */
    String findNews(News news) throws ServiceException;

    /**
     * method that call connection create in dao
     *
     * @throws ServiceException
     */
    void initResources() throws ServiceException;

    /**
     * method that call connection destroy in dao
     *
     * @throws ServiceException
     */
    void clearResources() throws ServiceException;
}
