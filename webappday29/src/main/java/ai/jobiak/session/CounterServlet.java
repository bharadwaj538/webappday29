package ai.jobiak.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CounterServlet
 */
@WebServlet("/counter")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CounterServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		int counter=1;
		if(session.isNew())
		{
			session.setAttribute("visits", counter+"");
			
		}
		else
		{
			String counterstr=(String) session.getAttribute("visits");
			counter=Integer.parseInt(counterstr);
			counter++;
			session.setAttribute("visits", counter+"");
		}
		response.setContentType("text/html");
		out.println("<h3>You visited# "+counter+"</h3>");
		out.println("<h3>session id# "+session.getId());
		
	}

}
