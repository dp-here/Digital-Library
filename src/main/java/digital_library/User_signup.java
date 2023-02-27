package digital_library;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class User_signup
 */
public class User_signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();  
		try{  
			 				
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/elibrary","root","Root@66");  
		     PreparedStatement ps=con.prepareStatement(  
                     "insert into user_login(username,password) values (?,?)");  
        
        ps.setString(1,request.getParameter("user"));  
        ps.setString(2,request.getParameter("pass"));  
   
          
      int  status=ps.executeUpdate();  
          
        con.close();  
			  
			}catch(Exception e){out.println(e);} // TODO Auto-generated method stub
	}

}
