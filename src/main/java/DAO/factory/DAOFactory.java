package DAO.factory;

import DAO.impl.FileReadNewsDAO;
import DAO.NewsDAO;

/**
 * Created by Mark_Harbunou on 2/1/2017.
 */
public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final NewsDAO fileReadNewsImpl = new FileReadNewsDAO();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return  instance;
    }

    public NewsDAO getFileReadNewsImpl() {
        return  fileReadNewsImpl;
    }
}
