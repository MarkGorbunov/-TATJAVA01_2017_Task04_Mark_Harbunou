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
public class FindNews implements Command {
    public String execute(String request) {
        Converter converter = new Converter();
        String[] splittedRequest = request.split(" ");
        Category category = converter.findCategory(request);
        String title = splittedRequest[2];
        String author = splittedRequest[3];

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        try {
            return newsService.findNews(new News(category, title, author));
        } catch (ServiceException e) {
            return "News not found";
        }
    }
}
