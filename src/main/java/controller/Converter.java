package controller;

import beans.Category;

/**
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class Converter {

     public Category findCategory(String request){
        String[] splittedRequest =  request.split(" ");
        for(Category category : Category.values()) {
            if(splittedRequest[1].toUpperCase().equals(category.toString())) {
                return category;
            }
        }
        throw new IllegalArgumentException();
    }
}
