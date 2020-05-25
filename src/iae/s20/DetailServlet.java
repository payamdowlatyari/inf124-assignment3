package iae.s20;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();
		 
		 String id = request.getParameter("id");		
		  response.setContentType("text/html;charset=UTF-8");
	        
	        response.setContentType("text/html");
	        response.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
	        
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>MainServlet</title>");  
	            out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">");
	            out.println(" <link href=\"style.css\" rel=\"stylesheet\">");

	            out.println("</head>");
	            out.println("<body>");
	            
	            out.println("<div class=container>");
	            out.println("<div class=\"header\">");
	            
	            out.println("<div class=\"content\"> ");
	            out.println("<div class=\"logo\"> ");
	            out.println("<a href=\"#\"> ");
	            out.println("<h1>Sports Store</h1>");
	            out.println("</a></div></div>");
	            out.println("<div class=\"navbar\"> ");
	            out.println("<ul class=\"content\"> ");
	            out.println("<li><a href=\"HomeServlet\">Home</a></li> ");
	            out.println("<li><a href=\"ProductServlet\"class=\"active\">Products</a></li> ");
	            out.println("<li><a href=\"AboutServlet\">About Us</a></li> ");
	            out.println("<li><a href=\"ContactServlet\">Contact Us</a></li>");
	            out.println("</ul></div></div>");
	              

	             out.println(" <div class=\"main\">");
	             out.println(" <div class=\"content\">");

	            out.println("<br><br> <h1> Product Details </h1>");

	    		String name = "";
	    		String summary= "";
	    		String thumbnail = "";
	    		String category = "";
	    		String detail = "";
	    		String price = "";
	    		
	    		
	    		try {   		
	    			
	    			java.sql.Connection connection = DatabaseConnection.connect();
	                Statement st = connection.createStatement();    	 
	                ResultSet rs = st.executeQuery("SELECT * FROM products where id= " + id);

	    	      
	    	      if (rs.next())
	    	      {
	    	    	 id = rs.getString("id");
	    	    	 
	    	         name = rs.getString("name"); 
	    	         summary = rs.getString("summary");
	    	         thumbnail = rs.getString("thumbnail");
	    	         category = rs.getString("category");
	    	         detail = rs.getString("detail");
	    	         price = rs.getString("price");
	    	         thumbnail = "assets/" + thumbnail; 

	    	        // print the results
	    	         out.println("<table width=\"100%\" cellspacing=\"20\">");
	    	         out.println("<tbody>");
	    	         out.println("<tr>");
	        		 out.println("<td>");
	    	         out.println("<img src=\""+thumbnail+"\"class=\"thumbnail\" id=\"img-detail\" width=\"250\"/>");
	    	         out.println("</td>");
	    	         out.println("<td>");
	        		 //out.print("<img src='" + request.getContextPath() + "/assets/'" + thumbnail + "/>");
	                 out.println("<h4>Name: </h4>");
	        		 out.println("<p>" +  name + " </p>");

//	                 out.println("<h4>"+ summary +"</h4>");
	                 out.println("<h4>Category: </h4>");
	        		 out.println("<p>" +  category + " </p>");

	                 out.println("<h4>Price: </h4>");
	        		 out.println("<p>" +  price + " </p>");

	               

	        		 out.println("</td>");
	        		 out.println("</tr>");
	        		 out.println("</tbody>");
	        		 out.println("</table>");
	        		 
	        		 out.println("<h1>Details</h1>");
	                 out.println("<div class=\"detail\">"+ detail +"</div>");

	    	      }
	    	      
	    	      out.println("</div>");	    
		    		 out.println("</div>");	  
		    		 
		    		  out.println("<div class=\"footer\">\n" + 
		              		"    <div class=\"content\">\n" + 
		              		"        <table width=\"100%\" cellspacing=\"20\">\n" + 
		              		"            <tbody>\n" + 
		              		"                <tr>\n" + 
		              		"                    <td>\n" + 
		              		"                        <h3>WHO WE ARE</h3>\n" + 
		              		"                        <p> Welcome to Sports Store!</p>\n" + 
		              		"                        <p>\n" + 
		              		"                            We are an online business currently based in\n" + 
		              		"                            Irvine, California.\n" + 
		              		"                        </p>\n" + 
		              		"                        <a href=\"/about.php\">Learn more... </a>\n" + 
		              		"                    </td>\n" + 
		              		"                    <td>\n" + 
		              		"                        <h3>MAIN OFFICE</h3>\n" + 
		              		"                        <p>\n" + 
		              		"                            <address>\n" + 
		              		"                                40234 Sunrise Blvd,\n" + 
		              		"                                Irvine, California, 92811\n" + 
		              		"                            </address>\n" + 
		              		"                        </p>\n" + 
		              		"                        <p> Tel: (949) 800 2221</p>\n" + 
		              		"                        <p> Email: info@sportstore.com</p>\n" + 
		              		"                        <a href=\"/contact.php\">Learn More...</a>\n" + 
		              		"                    </td>\n" + 
		              		"                    <td>\n" + 
		              		"                        <h3>QUICK LINKS</h3>\n" + 
		              		"                        <a href=\"/index.php\">First Page</a>\n" + 
		              		"                        <a href=\"/products.php\">What We Offer</a>\n" + 
		              		"                        <a href=\"/order.php\">Order Now</a>\n" + 
		              		"                        <a href=\"/about.php\">Who We Are</a>\n" + 
		              		"                        <a href=\"/contact.php\">Get In Touch</a>\n" + 
		              		"                    </td>\n" + 
		              		"                    <td>\n" + 
		              		"                        <h3>FOLLOW US</h3>\n" + 
		              		"                        <a href=\"#\">Facebook</a>\n" + 
		              		"                        <a href=\"#\">Instagram</a>\n" + 
		              		"                        <a href=\"#\">Twitter</a>\n" + 
		              		"                        <a href=\"#\">LinkedIn</a>\n" + 
		              		"                        <a href=\"#\">Pinterest</a>\n" + 
		              		"                    </td>\n" + 
		              		"                </tr>\n" + 
		              		"            </tbody>\n" + 
		              		"        </table>\n" + 
		              		"    </div>\n" + 
		              		"    <p class=\"copyright\">\n" + 
		              		"        Copyright &copy; 2020 Sports Store - All Rights Reserved\n" + 
		              		"    </p>\n" + 
		              		"</div>");

		             

		            out.println("</div>");	
		            out.println(" <script type=\"text/javascript\" src=\"main.js\"></script>");

		            out.println("</body>");
		            out.println("</html>");

	    	      
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
	    		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}