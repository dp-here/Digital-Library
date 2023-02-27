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
 * Servlet implementation class Add_book
 * @param <PrintWriter>
 */
public class Add_book<PrintWriter> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_book() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		java.io.PrintWriter out=response.getWriter();  
		try{  
			 				
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/elibrary","root","Root@66");  

		     PreparedStatement ps=con.prepareStatement(  
                     "insert into books(Book_ID,Title,Author_Name,Cost,Quantity) values (?,?,?,?,?)");  
        ps.setString(1,req.getParameter("id"));  
        ps.setString(2,req.getParameter("title"));  
        ps.setString(3,req.getParameter("author")); 
        ps.setString(4,req.getParameter("cost")); 
        ps.setString(5,req.getParameter("quantity")); 
   
          
      int  status=ps.executeUpdate();  
         out.print("Books added successfully!");//script tag m alert 
         //redirect tag ka use krke Home page p chale jayega...
        con.close(); 
        
			  //AB HOME PAGE P JANA H TO KAISE JAYE.?
        
			}catch(Exception e){out.println(e);}  
	}

}
