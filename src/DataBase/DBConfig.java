package DataBase;

/**
 * Created by Titan on 10/12/2016.
 */

public class DBConfig
{
    public static final String url ="jdbc:mysql://localhost:3306/";
    public static final String user = "root";
    public static final String password = "";

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }
}
