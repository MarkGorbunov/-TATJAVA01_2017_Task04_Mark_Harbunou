package service.impl;

import DAO.NewsDAO;
import DAO.exception.DAOException;
import DAO.factory.DAOFactory;
import beans.News;
import service.NewsService;
import service.exeption.ServiceException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class NewsServiceImpl implements NewsService {
    @Override
    public void addNews(News news) throws ServiceException {
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            NewsDAO newsDAO = daoObjectFactory.getFileReadNewsImpl();
            newsDAO.addNews(news);
        } catch (DAOException e) {
            throw new ServiceException();
        }

    }

    @Override
    public  String findNews(News news) throws ServiceException{
        try {
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            NewsDAO newsDAO = daoObjectFactory.getFileReadNewsImpl();
            return newsDAO.findNews(news);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }
}
