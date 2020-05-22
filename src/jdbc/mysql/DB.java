
package jdbc.mysql;

public class DB extends Connection {

    private static final java.sql.Connection conn = Connection.DB();

    public static java.sql.ResultSet data;

    public static void query(String query) throws java.sql.SQLException {
    	
        java.sql.Statement stm = conn.createStatement();
        DB.data = stm.executeQuery(query);
    }

   
    public static void execute(String query) throws java.sql.SQLException {
    	
        java.sql.PreparedStatement pst = conn.prepareStatement(query);
        pst.execute();
    }
}
