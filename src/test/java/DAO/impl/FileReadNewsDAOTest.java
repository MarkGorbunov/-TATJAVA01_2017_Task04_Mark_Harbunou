package DAO.impl;

import DAO.exception.DAOException;
import beans.Category;
import beans.News;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;




/**
 * Created by Mark_Harbunou on 2/2/2017.
 */
public class FileReadNewsDAOTest {
    FileReadNewsDAO fileRead;


    @BeforeMethod
    public void setUp() {
        fileRead = new FileReadNewsDAO();

    }

    @DataProvider(name = "legalArg")
    public Object[][] getNews() {
        return new Object[][]{
                {new News(Category.BOOKS, "redbook", "Mark")},
                {new News(Category.MOOVIES, "redbook", "Mark")},
                {new News(Category.DISKS, "reddisk", "Mark")}
        };
    }

    @DataProvider(name = "illegalArg")
    public Object[][] geTillegalArg() {
        return new Object[][]{
                {null}
        };
    }

    @Test(dataProvider = "legalArg")
    public void positiveTestForAddNews(News news) throws DAOException {
        fileRead.addNews(news);
    }

    @Test(dataProvider = "legalArg")
    public void positiveTestForFindNews(News news) throws DAOException {
        fileRead.findNews(news);
    }

    @Test(dataProvider = "illegalArg", expectedExceptions = DAOException.class)
    public void negativeTestForAddNews(News news) throws DAOException {
        fileRead.addNews(news);
    }

    @Test(dataProvider = "illegalArg" ,expectedExceptions = DAOException.class)
    public void negativeTestForFindNews(News news) throws DAOException {
        fileRead.findNews(news);
    }

}