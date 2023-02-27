package digital_library;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;  
 
import java.sql.*;

/**
 * Servlet implementation class Search_book
 */
public class Search_book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search_book() {
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
            String  book_name  = request.getParameter("book");
            String  author_name  = request.getParameter("author");
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from books where Book_ID='"+id+"' or \r\n"
            		+ "   Title='"+book_name+"' or Author_Name='"+author_name+"'");  
            out.println("<table border=1 width=50% height=20%>");  
            out.println("<tr><th>EmpId</th><th>EmpName</th><th>Salary</th><th>Cost</th><th>Quantity</th><tr>");  
            while (rs.next()) 
            {  
                String n = rs.getString("Book_ID");  
                String nm = rs.getString("Title");  
                String s = rs.getString("Author_Name");
                int m = rs.getInt("Cost"); 
                int mn = rs.getInt("Quantity");  
                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td><td>" + m +"</td><td>" + mn +"</td></tr>");   
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
