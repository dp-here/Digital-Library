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
import java.sql.ResultSet;

/**
 * Servlet implementation class User_login
 */
public class User_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elibrary","root","Root@66");
			
			String em = request.getParameter("user");
			String pass = request.getParameter("pass");
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user_login where username='"+em+"' and password = '"+pass+"'");
			
			if(rs.next()) {
				response.sendRedirect("home1.html");
				
			}
			else {
				response.sendRedirect("user_login.html");
			}
			
			
			out.close();
			
		

		}
		catch(Exception e) {
		out.println(" I M sorry");
		}
	}

}
