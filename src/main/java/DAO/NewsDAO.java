package DAO;


import DAO.exception.DAOException;
import beans.Category;
import beans.News;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Mark_Harbunou on 1/30/2017.
 */
public interface NewsDAO {
    void addNews(News news) throws DAOException;
    String findNews(News news) throws DAOException;
    /*
    ArrayList<String> findNewsCategory(Category categoryo);
    void findNewsTitle(String title);
    void findNewsAuthor(String Author);
    */
}
