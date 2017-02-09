package service.exeption;

/**
 * Class that contain Service Exception
 *
 * Created by Mark_Harbunou on 2/1/2017.
 */
public class ServiceException extends  Exception {
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Exception e) {
        super(e);
    }

    public ServiceException(String message, Exception e) {
        super(message, e);
    }
}
