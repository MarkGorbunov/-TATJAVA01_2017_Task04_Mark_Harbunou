package DAO.impl;

import DAO.NewsDAO;
import DAO.connectingPool.ConnectingPool;
import DAO.connectingPool.exception.ConnectingPoolException;
import DAO.exception.DAOException;
import bean.Category;
import bean.News;

import java.sql.*;


/**
 * Class that work with file
 * <p>
 * Created by Mark_Harbunou on 1/30/2017.
 */
public class ReadNewsDAO implements NewsDAO {
    private ConnectingPool connectingPool = ConnectingPool.getInstance();

    /**
     * method that initialize connection pool in which our connection in suspended condition
     *
     * @throws DAOException
     */
    @Override
    public void connectionCreate() throws DAOException {
        try {
            connectingPool.initPoolData();

        } catch (ConnectingPoolException e) {
            throw new DAOException(e);
        }
    }

    /**
     * method that close all connection
     */
    @Override
    public void connectionDestroy() throws DAOException {
        try {
            connectingPool.dispose();
        } catch (ConnectingPoolException e) {
            throw new DAOException(e);
        }
    }

    /**
     * method  that add news in database
     *
     * @param news news for adding
     * @throws DAOException
     */
    @Override
    public void addNews(News news) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = connectingPool.takeConnection();
            String query = "INSERT INTO NEWS VALUES (?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, news.getCategory().toString());
            ps.setString(2, news.getTitle());
            ps.setString(3, news.getAuthor());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        } catch (ConnectingPoolException e) {
            throw new DAOException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(e);
            }
            try {
                ps.close();
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }
    }

    /**
     * @param news news for find
     * @return information about news if if was found return strings with information
     * about news else news not found
     * @throws DAOException
     */
    @Override
    public News findNews(News news) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connectingPool.takeConnection();
            String query = "SELECT * FROM news WHERE Category = ? AND Title = ? AND Author = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, news.getCategory().toString());
            ps.setString(2, news.getTitle());
            ps.setString(3, news.getAuthor());
            ps.executeQuery();
            rs = ps.executeQuery();
            return newsChecker(rs);
        } catch (SQLException e) {
            throw new DAOException(e);
        } catch (ConnectingPoolException e) {
            throw new DAOException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(e);
            }
            try {
                ps.close();
            } catch (SQLException e) {
                throw new DAOException(e);
            }
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }
    }

    /**
     * method that return information about news if it exist else return news not found
     *
     * @param rs
     * @return
     */
    private News newsChecker(ResultSet rs) throws DAOException {
        String category = null;
        String title = null;
        String author = null;
        try {
            while (rs.next()) {
                category = rs.getString(1);
                title = rs.getString(2);
                author = rs.getString(3);
                return (new News(Category.valueOf(category.toUpperCase()), title, author));
            }
        } catch (SQLException e) {
            throw new DAOException("something wrong with sql", e);
        }
        return (new News(null, null, null));
    }
}
