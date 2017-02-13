package DAO.impl;

import DAO.NewsDAO;
import DAO.connectingPool.ConnectingPool;
import DAO.connectingPool.exception.ConnectingPoolException;
import DAO.exception.DAOException;
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
            connectingPool.closeConection(conn, ps);
        }
    }

    /**
     * @param news news for find
     * @return information about news if if was found return strings with information
     * about news else news not found
     * @throws DAOException
     */
    @Override
    public String findNews(News news) throws DAOException {
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
            connectingPool.closeConection(conn, ps, rs);
        }
    }

    /**
     * method that return information about news if it exist else return news not found
     *
     * @param rs
     * @return
     */
    private String newsChecker(ResultSet rs) {
        String Category = null;
        String Title = null;
        String Author = null;
        try {
            while (rs.next()) {
                Category = rs.getString(1);
                Title = rs.getString(2);
                Author = rs.getString(3);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (Category == null || Title == null || Author == null) {
            return "news not found";
        }
        return "|Category=" + Category + "|Title=" + Title + "|Author=" + Author + "|";
    }
}
