

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * View implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		
		printWriter.print("<head>");
		printWriter.print("<link href='css/bootstrap.min.css' rel='stylesheet>'");
		printWriter.print("</head>");
		printWriter.print("<body>");
		
		printWriter.println("<a href='index.html' class=btn='btn btn-info' role'button'> Add Student </a>");
		printWriter.println("<h1>Student Table</h1>");
		
		List<Student> list = StudentSQL.getStudents();
	
		printWriter.print("<table border='1' width='100%'>");
		printWriter.print("<tr><th>ID</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th>");
		
		for(Student student:list) {
				
		printWriter.print("<tr><td>"+student.getId()+"</td><td>"+student.getName()
				+"</td><td>"+student.getPassword()+"</td><td>"+student.getEmail()
				+"</td><td>"+student.getCountry()+"</td><td><a href='UpdateServlet?id="+student.getId()
				+"'>edit</a></td> <td><a href='DeleteServlet?id="+student.getId()+ "'> delete</a></td/</tr>");
		
		}

		printWriter.print("</table>");
		printWriter.print("</body>");
	}


}
