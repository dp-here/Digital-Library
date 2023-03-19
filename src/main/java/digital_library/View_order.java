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
import java.sql.Statement;
import java.util.Date;

/**
 * Servlet implementation class View_order
 */
public class View_order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_order() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   PrintWriter out = res.getWriter();  
	        res.setContentType("text/html");  
	        out.println("<html><body>");  
	        try 
	        {  
	            Class.forName("com.mysql.jdbc.Driver");  
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/elibrary","root","Root@66");  
	            String  id  = request.getParameter("id");
	            String  book_id  = request.getParameter("book_id");
	            String  title  = request.getParameter("title");
	            Statement stmt = con.createStatement();  
	            ResultSet rs = stmt.executeQuery("select * from orders where User_ID='"+id+"' or \r\n"
	            		+ "   Book_ID='"+book_id+"' or Book_Title='"+title+"'");  
	            
	           
	            if(!rs.next()) {
	            	out.println("<h1>The order you searched does not exist. Please check the details and try again.</h1>");
	            }
	            
	            else 
	            {  
	            	 out.println("<table border=1 width=50% height=20%>");  
	                 out.println("<tr><th>UserId</th><th>Book_ID</th><th>Book_Title</th><th>issue_date</th><th>return_date</th><th>User_name</th><tr>"); 
	                 
	                String n = rs.getString("User_ID");  
	                String nm = rs.getString("Book_ID");  
	                String s = rs.getString("Book_Title");
	                Date m = rs.getDate("issue_date"); 
	                Date mn = rs.getDate("return_date");
	                String ss=rs.getString("user_name");
	                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td><td>" + m +"</td><td>" + mn + "</td><td>" +ss +"</td></tr>");   
	            }  
	            out.println("</table>");  
	            out.println("</html></body>");  
	            con.close();  
	           }  
	            catch (Exception e) 
	           {  
	            out.println("error");  
	        }
	}

}
