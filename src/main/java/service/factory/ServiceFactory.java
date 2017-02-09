package service.factory;

import service.NewsService;
import service.impl.NewsServiceImpl;

/**
 * Class that process access to service
 *
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class ServiceFactory {
    private static ServiceFactory instance = new ServiceFactory();
    private final NewsService newsService = new NewsServiceImpl();

    private ServiceFactory() {}

    /**
     * method that process access for getNewsService
     *
     * @return instance of ServiceFactory
     */
    public static ServiceFactory getInstance() {
        return instance;
    }

    /**
     *
     * @return new service
     */
    public NewsService getNewsService() {
        return newsService;
    }
}
