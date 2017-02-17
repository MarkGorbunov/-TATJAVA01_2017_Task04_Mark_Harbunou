package DAO;


import DAO.connectingPool.exception.ConnectingPoolException;
import DAO.exception.DAOException;
import bean.News;

/**
 * Created by Mark_Harbunou on 1/30/2017.
 */
public interface NewsDAO {
    /**
     * method that receive news from service and add it to the database
     *
     * @param news news for adding
     * @throws DAOException
     */
    void addNews(News news) throws DAOException;

    /**
     * method that receive news from service and find it in the database
     *
     * @param news news for adding
     * @return found news
     * @throws DAOException
     */
    News findNews(News news) throws DAOException;

    /**
     * method that create connection
     *
     * @throws DAOException
     */
    void connectionCreate() throws DAOException;

    /**
     * method that destroy connection
     *
     * @throws DAOException
     */
    void connectionDestroy() throws DAOException;
}
