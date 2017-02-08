package service.factory;

import service.NewsService;
import service.impl.NewsServiceImpl;

/**
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class ServiceFactory {
    private static ServiceFactory instance = new ServiceFactory();
    private final NewsService newsService = new NewsServiceImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public NewsService getNewsService() {
        return newsService;
    }
}
