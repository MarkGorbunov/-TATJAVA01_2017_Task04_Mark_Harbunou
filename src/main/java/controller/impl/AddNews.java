package controller.impl;

import beans.Category;
import beans.News;
import controller.Command;
import controller.Converter;
import service.NewsService;
import service.exeption.ServiceException;
import service.factory.ServiceFactory;

/**
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class AddNews implements Command {
    @Override
    public String execute(String request) {
        Converter converter = new Converter();
        String responce = "";
        String[] splittedRequest = request.split(" ");
        Category category = converter.findCategory(request);
        String title = splittedRequest[2];
        String author = splittedRequest[3];

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        try {
            newsService.addNews(new News(category, title, author));
            responce = "book added";
        } catch (ServiceException e) {
            responce = "error during addBook procedure";
        }
        return responce;
    }
}
