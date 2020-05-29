package iae.s20;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
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
                
               
            	   HttpSession session = request.getSession();
            	   
            	   	 String name = (String) session.getAttribute("name");
            	   	 String thumbnail = (String) session.getAttribute("thumbnail");
            	   
                     int id = Integer.parseInt((String) session.getAttribute("id")); 
                     int quantity = Integer.parseInt((String)session.getAttribute("quantity")); 
                     //float totalPrice = Float.parseFloat((String)session.getAttribute("priceFloat"));
                     
                     String firstname = request.getParameter("firstname");
                     String lastname = request.getParameter("lastname");
                     String email = request.getParameter("email");
          	         String phone = request.getParameter("phone");
          	       
            	     String address = request.getParameter("address");
            	     String city = request.getParameter("city");
            	     String state = request.getParameter("state");
           	     
                     int zip = Integer.parseInt(request.getParameter("zip"));            	     
            	     
            	     String billaddr;
            	     String billcity;
            	     String billstate;
            	     int billzip;
            	     
            	     boolean sameaddr = request.getParameter("sameaddr") != null;
            	     
            	     if (sameaddr == false) {
            	    	 
                	      billaddr = request.getParameter("billaddr");  
                 	      billcity = request.getParameter("billcity");
                 	      billstate = request.getParameter("billstate");
                          billzip = Integer.parseInt(request.getParameter("billzip"));
            	     }
            	     else
            	     {            	     
            	    	 billaddr = address;           	    
            	    	 billcity = city;            	    
            	    	 billstate = state;            	    
                    	 billzip = zip;
            	     }

            	     String cardname = request.getParameter("cardname");
            	     String cardnumber = request.getParameter("cardnumber");
                     int expmonth = Integer.parseInt(request.getParameter("expmonth"));
                     int expyear = Integer.parseInt(request.getParameter("expyear"));
                     int cvv = Integer.parseInt(request.getParameter("cvv"));  
            	     String method = request.getParameter("method");
                     int productid = Integer.parseInt(request.getParameter("productid"));

                     			java.sql.Connection connection = DatabaseConnection.connect();
                     			PreparedStatement pst =(PreparedStatement) connection.prepareStatement("INSERT INTO orders (firstname, lastname, email, phone, address, city, state, zip, billaddr, billcity, billstate, billzip, method, productid, quantity, cardname, cardnumber, expmonth, expyear, cvv) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
	    				    			
	    			pst.setString(1,firstname);
	                pst.setString(2,lastname);  
	                pst.setString(3,email);        
	                pst.setString(4,phone);
	                pst.setString(5,address);
	                pst.setString(6,city);
	                pst.setString(7,state);
	                pst.setInt(8, zip);	                
	                pst.setString(9,billaddr);
	                pst.setString(10,billcity);
	                pst.setString(11,billstate);
	                pst.setInt(12,billzip);	                
	                pst.setString(13,method);
	                pst.setInt(14,productid);
	                pst.setInt(15,quantity);
	                pst.setString(16,cardname);
	                pst.setString(17,cardnumber);
	                pst.setInt(18,expmonth);
	                pst.setInt(19,expyear);
	                pst.setInt(20,cvv);
	                
	                int x = pst.executeUpdate();    
	                
	                if(x == 1)    
	                {    
	                	   out.println("<div class=\"content confirmation\">\n" + 
	           	         		"                <h1>Thank you for your order "+firstname +"</h1>\n" + 
	           	         		"                <div style=\"display: flex;\">\n" + 
	           	         		"                    <div class=\"detail\">\n" + 
	           	         		"                        <h2>Order Information</h2>\n" + 
	           	         		"                        <p>Order ID:"+ id +"</p>\n" + 
	           	         		"                        <p>Email: "+ email +"</p>\n" + 
	           	         		"                        <p>Phone Number: "+ phone +"</p>\n" + 
	           	         		"\n" + 
	           	         		"                        <h2>Product Information</h2>\n" + 
	           	         		"                        <p>Product:"+ name +" </p>\n" + 
	           	         		"                        <p>Quantity: "+ quantity +"</p>\n" + 
	           	         		"                        <p>Total Price: "+"</p>\n" + 
	           	         		"\n" + 
	           	         		"                        <h2>Shipping Information</h2>\n" + 
	           	         		"                        <p>Method: "+ method +"</p>\n" + 
	           	         		"                        <p>Address:"+ address +" </p>\n" + 
	           	         		"                        <p>City: "+ city +"</p>\n" + 
	           	         		"                        <p>State: "+ state +"</p>\n" + 
	           	         		"                        <p>Zip Code: "+ zip +" </p>\n" + 
	           	         		"                    </div>\n" + 
	           	         		"                    <div>\n" + 
	           	         		"                        <img src=\""+thumbnail+"\" width=\"175\"\n" + 
	           	         		"                                alt=\"\" style=\"margin-left:100px;margin-top: 100px;\"/>\n" + 
	           	         		"                    </div>\n" + 
	           	         		"                </div>");         
	                } 
	                else 
	                	{
	                			out.println("Error! Please contact customer service");
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
		service(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
