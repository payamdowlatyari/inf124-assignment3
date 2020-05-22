package iae.s20;

import java.sql.*;
import jdbc.mysql.*;


public class JDBC {

	public static void main(String[] args) {
		
		 Manipulation manipulate = new Manipulation();
	        
	        try {
	       System.out.println(manipulate.productExample(1));
//				manipulate.display();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

}
