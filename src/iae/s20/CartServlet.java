package iae.s20;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
//@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

 public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {	
	   	
        response.setContentType("text/html;charset=UTF-8");
           
           response.setContentType("text/html");
           response.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
           PrintWriter out = response.getWriter();

//           String quantity = request.getParameter("quantity");
           
           HttpSession session = request.getSession(false);
          // @SuppressWarnings("unchecked")
		HashMap<Integer, Integer> idList = (HashMap<Integer, Integer>)session.getAttribute("idList");
           if(idList == null) {
        	   HashMap<Integer, Integer> newIdList = new HashMap<Integer, Integer>();
        	   session.setAttribute("idList", newIdList);
        	   idList = newIdList;
           }
//          
//           HttpSession session = request.getSession(false);
//           String id = (String)session.getAttribute("id"); 
//           String price = (String)session.getAttribute("price");
//           String name = (String)session.getAttribute("name");
//           float pi = Float.valueOf(price.trim()).floatValue();
//           float qi = Float.valueOf(quantity.trim()).floatValue();
//           float priceFloat = pi * qi;
           
           //String totalPrice = "";
   
//	         session.setAttribute("quantity", quantity); 
//	         session.setAttribute("priceFloat", priceFloat);

               out.println("<!DOCTYPE html>");
               out.println("<html>");
               out.println("<head>");
               out.println("<title>Cart</title>");  
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
               out.println("<br><br>  <h1>Shopping Cart</h1>");   
               out.println("<div class=\"shopping-cart\">");
               
               
               out.println("<form method='POST' action='CheckOutServlet'>");
               out.println("<ul>");
               float subtotal = (float) 0.0;
               //String name = "";
    		   //Float price = (float) 0.0;
        	   
        	   //HashMap<Integer, Integer> entry = new HashMap<Integer, Integer>();

               for (Entry<Integer, Integer> en : idList.entrySet()) {
            	   //out.println(entry.getKey());
            	   //out.println(entry.getValue());
            	   int id = en.getKey();
        		   int quantity = en.getValue();

            	   try 
            	   
            	   {
            	   java.sql.Connection connection = DatabaseConnection.connect();
            		  
            		   Statement st = connection.createStatement();
            		   ResultSet rs = st.executeQuery("SELECT * FROM products where id= " + id);
            		   if(rs.next()) {
	            		    String name = rs.getString("name");
	            		    float price = rs.getFloat("price");
	            		   subtotal += (quantity*price);
	            		   out.println("<li>" + name + "\tPrice:" + Float.toString(price) + " Quantity:" + Integer.toString(quantity) + "</li>");
            		   }
                	  // out.println("</li>");

            	   }
            	   
            	   catch(Exception e) {
            		   e.printStackTrace();
            	   }
       			}
               session.setAttribute("subtotal", subtotal);
               
               out.println("</ul>");

               out.println("<input type='submit' id='order-submit' class='checkout-btn' btn' tabindex='0' id='form-submit' name='purchase'>");
               out.println("<p>Subtotal: " + Float.toString(subtotal) + "</p>");

               out.println("</form></div>");

               
//               out.println("<div class=\"shopping-cart\"> <form method=\"GET\" action=\"CheckOutServlet\">\n" + 
//            			"               <span class=\"price-item\">"+ name +"</span>" + 
//                  		"\n" + 
//              		"               <span class=\"price-item\" id=\"price-cart\">&nbsp; &nbsp;$"+ price +"</span>" + 
//              		"<input type=hidden id=\"unitPrice\" name=\"price-cart\" value="+ price +">" +
//
//              		"               <span class=\"price-item\">X "+ quantity + "</span>" + 
//              		" <span class=\"price-item\" id=\"total-price-cart\"> <span>" + priceFloat +"</span></span>" + 
//
//              		"<input type=hidden id=\"quantity-cart\" name=\"quantity\" value="+ quantity +">" +
//              		"                   <input class=\"checkout-btn\" type=\"submit\" value=\"Check Out\">\n" +             		              
//
//              		"               </form> </div>");
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
                 out.println(" <script type=\"text/javascript\" src=\"main.js\"></script>");
                 out.println("</body>");
                 out.println("</html>");	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		service(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer> idList =(HashMap<Integer, Integer>)session.getAttribute("idList");
		if(idList == null) {
			HashMap<Integer, Integer> newIdList = new HashMap<Integer, Integer>();
			session.setAttribute("idList", newIdList);
			idList = newIdList;
		}
		String idStr = request.getParameter("id");
		String quantityStr = request.getParameter("quantity");
		int id = Integer.parseInt(idStr);
		int quantity = Integer.parseInt(quantityStr);
		if(!idList.containsKey(id)) {
			idList.put(id, quantity);
		}
		else {
			int initialQuantity = idList.get(id);
			idList.put(id, (int)(quantity + initialQuantity));
		}
		session.setAttribute("idList", idList);
		doGet(request, response);
	
	}

}