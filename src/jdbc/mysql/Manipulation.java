package jdbc.mysql;

import java.sql.SQLException;

public class Manipulation {

    public void display() throws SQLException {
        DB.query("SELECT * FROM products");

        while (DB.data.next()) {
        	
            String id = DB.data.getString("id");
            String name = DB.data.getString("name");

            System.out.println("id: " + id + ", name: " + name);
        }
    }
    
    public String productExample(int id) throws SQLException {
        DB.query("SELECT * FROM products WHERE id = " + id);
        
        String name = "";
        if (DB.data.next()) {
             name = DB.data.getString("name");

            System.out.println("id: " + id + ", name: " + name);
        }
            return name;
  
    }

    void insert(String name) throws SQLException {
        DB.execute("INSERT INTO products (name) VALUES('" + name + "')");
    }

    void update(String name, int id) throws SQLException {
        DB.execute("UPDATE products SET name = '" + name + "' WHERE id = " + id);
    }

    void delete(int id) throws SQLException {
        DB.execute("DELETE FROM products WHERE id = " + id);
    }
}
