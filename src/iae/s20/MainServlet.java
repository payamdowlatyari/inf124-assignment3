package iae.s20;
import java.sql.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;


@WebServlet(name = "MainServlet", urlPatterns = { "/MainServlet" })
public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
           
    public MainServlet() {
        super();
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {	
    	
    	
     response.setContentType("text/html;charset=UTF-8");
        
        response.setContentType("text/html");
        response.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        PrintWriter out = response.getWriter();
        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MainServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1> Products </h1>");
            
            
            // create a connection object
            DatabaseConnection DatabaseConnection = new DatabaseConnection();
    		
            String id = ""; 
    		String name = "";
    		String summary= "";
    		String thumbnail = "";
    		String category = "";
    		String detail = "";
    		String price = "";
    		
    		
    		try {   		
    			
    			java.sql.Connection connection = DatabaseConnection.connect();
                Statement st = connection.createStatement();    	 
                ResultSet rs = st.executeQuery("SELECT * FROM products;");

    	      
    	      // iterate through the java resultset
    	      while (rs.next())
    	      {
    	    	 id = rs.getString("id");
    	         name = rs.getString("name"); 
    	         summary = rs.getString("summary");
    	         thumbnail = rs.getString("thumbnail");
    	         category = rs.getString("category");
    	         detail = rs.getString("detail");
    	         price = rs.getString("price");
    	        
    	        // print the results
    	         out.println("<table>");
    	         out.println("<tbody>");
    	         out.println("<tr>");
        		 out.println("<td>");
        		 
        		 out.print("<img src='" + request.getContextPath() + "/assets/'" + thumbnail + "/>");
                 out.println("<h2>"+ name +"</h2>");
                 out.println("<h4>"+ summary +"</h4>");
                 out.println("<h4>"+ category +"</h4>");
                 out.println("<h4>"+ detail +"</h4>");
                 out.println("<h4>"+ price +"</h4>");

        		 out.println("</td>");
        		 out.println("</tr>");
        		 out.println("</tbody>");
        		 out.println("</table>");
    	      }
    	    }
    	    catch (Exception e)
    	    {
    	        System.err.println ("Cannot connect to database server");
    	        e.printStackTrace();

    	    
    		} 
    		finally 
    	    {    			
    			DatabaseConnection.disconnect();
    		}
    	           
            out.println("</body>");
            out.println("</html>");
    	
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
         

    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
