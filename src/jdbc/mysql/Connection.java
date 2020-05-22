package jdbc.mysql;

import javax.swing.JOptionPane;

class Connection extends Config {

    private static java.sql.Connection mysql;

    protected static java.sql.Connection DB() {
    	
        try {
        	
            //java.sql.DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Class.forName ("com.mysql.cj.jdbc.Driver");
            mysql = java.sql.DriverManager.getConnection(Config.url.toString(), Config.username.toString(), Config.password.toString());
            
        } catch (Exception e) {
        	
            JOptionPane.showMessageDialog(null, e, "Connecting Failed", 1);
        }
        
        return mysql;
    }
}
