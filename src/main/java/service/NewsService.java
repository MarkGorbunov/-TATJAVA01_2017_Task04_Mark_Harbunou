package service;

import beans.News;
import service.exeption.ServiceException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Mark_Harbunou on 2/1/2017.
 */
public interface NewsService {
    void addNews(News news) throws ServiceException;
    String findNews(News news) throws ServiceException;
}
