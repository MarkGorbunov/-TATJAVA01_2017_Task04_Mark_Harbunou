package service.impl;

import beans.Category;
import beans.News;
import service.exeption.ServiceException;

/**
 * Class that find category
 *
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class Converter {
    /**
     * method that find category and return if it exist
     *
     * @param request request from controller
     * @return category if it exist
     * @throws ServiceException
     */
     public Category findCategory(String request) throws ServiceException {
        String[] splittedRequest =  request.split(" ");
        for(Category category : Category.values()) {
            if(splittedRequest[1].toUpperCase().equals(category.toString())) {
                return category;
            }
        }
         throw new ServiceException();
    }

}
