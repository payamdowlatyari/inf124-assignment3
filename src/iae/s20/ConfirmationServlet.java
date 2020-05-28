package iae.s20;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConfirmationServlet
 */
//@WebServlet("/ConfirmationServlet")
public class ConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {	
	   	
        response.setContentType("text/html;charset=UTF-8");
           
           response.setContentType("text/html");
           response.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
           PrintWriter out = response.getWriter();
           
               out.println("<!DOCTYPE html>");
               out.println("<html>");
               out.println("<head>");
               out.println("<title>Confirmation</title>");  
               out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">");
               out.println(" <link href=\"style.css\" rel=\"stylesheet\">");
               out.println(" <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js\"></script>\n" + 
	            		"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>");

               out.println("</head>");
               out.println("<body>");          
               out.println("<div class=\"container\">");         
               out.println("<div class=\"header\">");
               out.println("<div class=\"content\"> ");
               out.println("<div class=\"logo\"> ");
               out.println("<a href=\"HomeServlet\"> ");
               out.println("<h1>Sports Store</h1>");
               out.println("</a></div></div>");
               out.println("<div class=\"navbar\"> ");
               out.println("<ul class=\"content\"> ");
               out.println("<li><a href=\"HomeServlet\">Home</a></li> ");
               out.println("<li><a href=\"ProductServlet\">Products</a></li> ");
               out.println("<li><a href=\"AboutServlet\">About Us</a></li> ");
               out.println("<li><a href=\"ContactServlet\">Contact Us</a></li>");
               out.println("</ul></div></div>");
               out.println(" <div class=\"main\">");
               out.println(" <div class=\"content\">"); 
               out.println(" <h1><br>Confirmation</h1>\n");
               
               
               try {              
 
            	   
            	   int id = 1;
            	   String firstname = "";
                   String lastname = "";
                   String email = "";
                   String phone = "";
                   String address = "";
                   String city = "";
                   String state = "";
                   int zip = 00000;
                   String billaddr = "";
                   String billcity = "";
                   String billstate = "";
                   int billzip = 00000;
                   //boolean sameaddr = true;
                   String cardname = "";
                   String cardnumber = "";
                   int expmonth = 00;
                   int expyear = 0000;
                   int cvv = 000;            	   
                   String method = "";
                   int productid = 0000;
                   int quantity = 1;
                  
                
               
            	     id = Integer.parseInt(request.getParameter("id")); 
            	     firstname = request.getParameter("firstname");
            	     lastname = request.getParameter("lastname");
            	     email = request.getParameter("email");
            	     phone = request.getParameter("phone");
            	     address = request.getParameter("address");
            	     city = request.getParameter("city");
            	     state = request.getParameter("state");
                     zip = Integer.parseInt(request.getParameter("zip"));
                     billaddr = request.getParameter("billaddr");                   
                     billcity = request.getParameter("billcity");
            	     billstate = request.getParameter("billstate");
                     billzip = Integer.parseInt(request.getParameter("billzip"));
                     cardname = request.getParameter("cardname");
                     cardnumber = request.getParameter("cardnumber");
                     expmonth = Integer.parseInt(request.getParameter("expmonth"));
                     expyear = Integer.parseInt(request.getParameter("expyear"));
                     cvv = Integer.parseInt(request.getParameter("cvv"));            	   
                     method = request.getParameter("method");
                     productid = Integer.parseInt(request.getParameter("productid"));
                     quantity = Integer.parseInt(request.getParameter("quantity"));

	    			
	    			java.sql.Connection connection = DatabaseConnection.connect();
	                PreparedStatement pst =(PreparedStatement) connection.prepareStatement("INSERT INTO orders (id, firstname, lastname, email, phone, address, city, state, zip, billaddr, billcity, billstate, billzip, method, productid, quantity, cardname, cardnumber, expmonth, expyear, cvv) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
	    			
	    			
	                pst.setInt(1, id);
	    			pst.setString(2,firstname);
	                pst.setString(3,lastname);  
	                pst.setString(4,email);        
	                pst.setString(5,phone);
	                pst.setString(6,address);
	                pst.setString(7,city);
	                pst.setString(8,state);
	                pst.setInt(9, zip);	                
	                pst.setString(10,address);
	                pst.setString(11,city);
	                pst.setString(12,state);
	                pst.setInt(13,zip);	                
	                pst.setString(14,method);
	                pst.setInt(15,9876);
	                pst.setInt(16,1);
	                pst.setString(17,cardname);
	                pst.setString(18,cardnumber);
	                pst.setInt(19,expmonth);
	                pst.setInt(20,expyear);
	                pst.setInt(21,cvv);
	                
	                int x=pst.executeUpdate();    
	                
	                if(x==1)    
	                {    
	                out.println("Values Inserted Successfully");    
	                } 
	                else 
	                {
	                	out.println("Error");
	                }
	                
	                pst.close();
              
            
       		 out.println("</div>");
       		 out.println("</div>");	
       		 out.println("<br><div class=\"footer\">\n" + 
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
               out.println(" <script type=\"text/javascript\" src=\"\"></script>");
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


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
