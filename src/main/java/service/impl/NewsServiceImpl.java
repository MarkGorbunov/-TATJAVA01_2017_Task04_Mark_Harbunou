package service.impl;

import DAO.NewsDAO;
import DAO.exception.DAOException;
import DAO.factory.DAOFactory;
import beans.Category;
import beans.News;
import service.NewsService;
import service.exeption.ServiceException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Class that process request from controller
 *
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class NewsServiceImpl implements NewsService {
    /**
     * method that transfer request transformed in news(add news) to dao and check request from controller for correct
     *
     * @param request from controller
     * @throws ServiceException
     */
    @Override
    public void addNews(String request) throws ServiceException {
        try {
            Converter converter = new Converter();
            String[] splittedRequest = request.split(" ");
            Category category = converter.findCategory(request);
            String title = splittedRequest[2];
            String author = splittedRequest[3];
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            NewsDAO newsDAO = daoObjectFactory.getFileReadNewsImpl();
            newsDAO.addNews(new News(category,title,author));
        } catch (DAOException | NullPointerException | IllegalArgumentException e) {
            throw new ServiceException();
        }

    }

    /**
     * method that transfer transformed in news request(find news) to dao and check request from controller for correct
     *
     * @param request from controller
     * @throws ServiceException
     */
    @Override
    public String findNews(String request) throws ServiceException {
        try {
            Converter converter = new Converter();
            String[] splittedRequest = request.split(" ");
            Category category = converter.findCategory(request);
            String title = splittedRequest[2];
            String author = splittedRequest[3];
            DAOFactory daoObjectFactory = DAOFactory.getInstance();
            NewsDAO newsDAO = daoObjectFactory.getFileReadNewsImpl();
            return newsDAO.findNews(new News(category,title,author));
        } catch (DAOException | NullPointerException | IllegalArgumentException e) {
            throw new ServiceException();
        }
    }




}
