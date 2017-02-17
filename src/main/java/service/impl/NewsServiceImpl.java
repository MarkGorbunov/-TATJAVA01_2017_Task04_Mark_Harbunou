package service.impl;

import DAO.NewsDAO;
import DAO.exception.DAOException;
import DAO.factory.DAOFactory;
import bean.Category;
import bean.News;
import service.NewsService;
import service.exeption.ServiceException;

/**
 * Class that process request from controller
 * <p>
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class NewsServiceImpl implements NewsService {
    /**
     * method that transfer news to dao
     *
     * @param news from controller
     * @throws ServiceException
     */
    @Override
    public void addNews(News news) throws ServiceException {
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            NewsDAO newsDAO = daoObjectFactory.getReadNewsImpl();
            newsDAO.addNews(news);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    /**
     * method that transfer news to dao
     *
     * @param news from controller
     * @throws ServiceException
     */
    @Override
    public String findNews(News news) throws ServiceException {
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            NewsDAO newsDAO = daoObjectFactory.getReadNewsImpl();
            News newsForCheck = newsDAO.findNews(news);
            if (newsValidation(newsForCheck)) {
                return "|Category: " + news.getCategory().toString() +
                        " |Title: " + news.getTitle() +
                        "|Author: " + news.getAuthor();
            }
            return "news not found";
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * method that call connection create in dao
     *
     * @throws ServiceException
     */
    @Override
    public void initResources() throws ServiceException {
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            NewsDAO newsDAO = daoObjectFactory.getReadNewsImpl();
            newsDAO.connectionCreate();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * method that call connection destroy in dao
     *
     * @throws ServiceException
     */
    @Override
    public void clearResources() throws ServiceException {
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            NewsDAO newsDAO = daoObjectFactory.getReadNewsImpl();
            newsDAO.connectionDestroy();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    private boolean newsValidation(News news) throws DAOException {
        if (news.getCategory() == null || news.getCategory() == null || news.getAuthor() == null) {
            return false;
        }
        return true;
    }


}
