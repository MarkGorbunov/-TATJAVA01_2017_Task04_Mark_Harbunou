package controller;

import DAO.exception.DAOException;
import bean.News;

/**
 * Created by Mark_Harbunou on 2/1/2017.
 */
public interface Command {
    /**
     * method that receives request from View
     *
     * @param news from View
     * @return result of request
     */
    String execute(News news);

}
