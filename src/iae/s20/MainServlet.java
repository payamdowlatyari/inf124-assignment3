package iae.s20;
import java.sql.*;
import jdbc.mysql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MainServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
           
    public MainServlet() {
        super();
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//    	 int i = Integer.parseInt(request.getParameter("num1"));
//         int j = Integer.parseInt(request.getParameter("num2"));
//         int k = i + j;
    	PrintWriter out = response.getWriter();
         String name = "";
         
//         PrintWriter out = response.getWriter();
//         
//         
//         request.setAttribute("k", k);
//         
//         RequestDispatcher rd = request.getRequestDispatcher("SqrServlet");
//         rd.forward(request, response);
         
//         HttpSession session = request.getSession();
//         session.setAttribute("k", k);
//         
//         response.sendRedirect("SqrServlet");
         
         
         Manipulation manipulate = new Manipulation();
	        
	        try {
	 	        name = manipulate.productExample(1);

			} catch (SQLException e) {
				e.printStackTrace();
			}
	        
	        out.println("Hey");
	        out.println(name.toString());
         

    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
