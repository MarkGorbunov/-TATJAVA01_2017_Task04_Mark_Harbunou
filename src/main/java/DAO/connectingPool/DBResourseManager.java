package DAO.connectingPool;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *  * Class that process access to db
 *
 * Created by Mark_Harbunou on 2/9/2017.
 */
public class DBResourseManager {
    private final static DBResourseManager instance = new DBResourseManager();
    private ResourceBundle bundle = ResourceBundle.getBundle("db", Locale.ENGLISH);

    public static DBResourseManager getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }
}
