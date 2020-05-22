package jdbc.mysql;

class Config {

    protected static String username = "root";
    protected static String password = "";
    protected static String url = "jdbc:mysql://localhost:3306/ssdb";

    public static void setUsername(String username) {
        Config.username = username;
    }

    public static void setPassword(String password) {
        Config.password = password;
    }
    
    public static void setUrl(String url) {
        Config.url = url;
    }
    
}
