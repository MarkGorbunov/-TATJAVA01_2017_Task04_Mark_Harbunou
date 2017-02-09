package DAO.connectingPool.exception;

/**
 * Created by Mark_Harbunou on 2/9/2017.
 */
public class ConnectingPoolException extends Exception {

    public ConnectingPoolException() {
        super();
    }

    public ConnectingPoolException(String message) {
        super(message);
    }


    public ConnectingPoolException(String message, Exception e) {
        super(message, e);
    }


    public ConnectingPoolException(Exception e) {
        super(e);
    }

}
