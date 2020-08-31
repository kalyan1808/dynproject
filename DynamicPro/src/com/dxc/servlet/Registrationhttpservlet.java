package com.dxc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Registrationhttpservlet
 */
@WebServlet("/Registrationhttpservlet")
public class Registrationhttpservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrationhttpservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		showRegistrationform(response, false);
	}

	private void showRegistrationform(HttpServletResponse response, boolean error) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		if(error) {
			response.sendRedirect("Unsuccessful.html");
		}
		else {
			out.println("<form method=\"post\">");
			out.println("UserName:<input type=\"text\" name=\"Username\"><br>");
			out.println("Password:<input type=\"Password\" name=\"password\"><br>");
			out.println("<input type=\"submit\" value=\"login\">");	
			out.println("<input type=\"reset\" value=\"cancel\">");	
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("Username");
		String password=request.getParameter("password");
		
		if(validate(username,password)) {
			HttpSession session=request.getSession(true);
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			RequestDispatcher rd=request.getRequestDispatcher("Successful");
			rd.forward(request, response);
		}
		else {
			showRegistrationform(response, true);
		}
	out.close();
	}

	private boolean validate(String username, String password) {
		// TODO Auto-generated method stub
		if(username.equals("Venkat") && password.equals("kumar")) {
			return true;
		}
		else {
			return false;
		}
	}

}
