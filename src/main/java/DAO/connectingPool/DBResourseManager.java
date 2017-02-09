package DAO.connectingPool;

import java.util.ResourceBundle;

/**
 * Created by Mark_Harbunou on 2/9/2017.
 */
public class DBResourseManager {
    private final static DBResourseManager instance = new DBResourseManager();
    private ResourceBundle bundle = ResourceBundle.getBundle("_java._se._07._connectionpool.db");

    public static DBResourseManager getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }
}
