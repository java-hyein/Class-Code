package edu.bit.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestObj
 */
//유저가 리퀘스트오비제이로 치고 들어오게되면 실행된다
@WebServlet("/RequestObj")
public class RequestObj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestObj() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		actionDo(request,response);
	
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		
		String id =(String)request.getAttribute("id");
		String pw =(String)request.getAttribute("pw");
		
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter writer = response.getWriter();
		
		writer.print("<html><head></head><body>");
		writer.print("RequestObj" +"<hr>");
		writer.println("id : "+ id +"<br>");
		writer.println("pw : "+ pw);
		writer.print("</body></html>");
		//RequestDispather
//		request.setAttribute("id", "abcde");
//		request.setAttribute("pw", "12345");
//		//두개의 값이 포워딩이 된다. (
////		RequestDispatcher dispatcher = request.getRequestDispatcher("/dispatcher.jsp");
////		dispatcher.forward(request,response);
		
		
		
		
		
	}

}
