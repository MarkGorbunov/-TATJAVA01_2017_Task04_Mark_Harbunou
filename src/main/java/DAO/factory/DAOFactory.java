package DAO.factory;

import DAO.impl.FileReadNewsDAO;
import DAO.NewsDAO;

/**
 * Class that process access to DAO
 *
 * Created by Mark_Harbunou on 2/1/2017.
 */
public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final NewsDAO fileReadNewsImpl = new FileReadNewsDAO();

    private DAOFactory() {}
    /**
     * method that process access for getFileReadNewsImpl
     *
     * @return instance of ServiceFactory
     */
    public static DAOFactory getInstance() {
        return  instance;
    }

    /**
     * method that process access for addNews and findNews
     *
     * @return filereadnewsDAO
     */
    public NewsDAO getFileReadNewsImpl() {
        return  fileReadNewsImpl;
    }
}
