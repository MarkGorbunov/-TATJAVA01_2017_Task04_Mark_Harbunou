package DAO.impl;

import DAO.connectingPool.ConnectingPool;
import DAO.connectingPool.exception.ConnectingPoolException;
import DAO.exception.DAOException;
import bean.Category;
import bean.News;

import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.*;


/**
 * Created by Mark_Harbunou on 2/2/2017.
 */
public class ReadNewsDAOTest {
    ConnectingPool connectingPool = ConnectingPool.getInstance();
    ReadNewsDAO fileRead;
    Connection connection;

    @BeforeTest
    public void connectionCreate() throws SQLException, ConnectingPoolException {
        connectingPool.initPoolData();
        fileRead = new ReadNewsDAO();
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
    public void positiveTestForAddNews(News news) throws Exception {
        fileRead.addNews(news);
    }

    @Test(dataProvider = "legalArg")
    public void positiveTestForFindNews(News news) throws DAOException {
        Assert.assertEquals("|Category=" + news.getCategory().toString() + "|Title=" +
                news.getTitle() + "|Author=" + news.getAuthor() + "|",fileRead.findNews(news));
    }

    @Test(dataProvider = "illegalArg", expectedExceptions = NullPointerException.class)
    public void negativeTestForAddNews(News news) throws DAOException {
        fileRead.addNews(news);
    }

    @Test(dataProvider = "illegalArg", expectedExceptions = NullPointerException.class)
    public void negativeTestForFindNews(News news) throws DAOException {
        fileRead.findNews(news);
    }


    @AfterTest
    public void destroyConnection() throws Exception {
       connectingPool.dispose();
    }

}