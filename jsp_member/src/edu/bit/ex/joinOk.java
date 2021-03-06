package edu.bit.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/joinOk")
public class joinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Connection connection;
	private Statement stmt;
	
	private String name, id, pw, phone1,phone2,phone3, gender;
	

    public joinOk() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 실행");
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		name = request.getParameter("name");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");
		
		String query ="Insert into member values('"+ name +"','" + id + "','" + pw + "','" + phone1 + "','" + phone2 + "','" + phone3 + "','" + gender + "')";
		System.out.println(query);
		try {
			//암기하기
			Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클 드라이버 객체생성
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott", "tiger");
			stmt = connection.createStatement();
			int i = stmt.executeUpdate(query); // insert부분이기 때문에 
			//stmt.executeQuery(sql); <- select 할때 사용
			if(i == 1) { // 정상적으로 넘겨줄때는 무조건 1, 1이외의 값은 정상적인 것이 아님 
				System.out.println("insert success");
				response.sendRedirect("joinResult.jsp");
			}else {
				System.out.println("insert fail");
				response.sendRedirect("join.html");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				// 객체생성 한 것 반대 순으로 닫아준다. 객체생성 순서 : connection - statement 
				if(stmt!= null) stmt.close();
				if(connection != null) connection.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}	
		}
	}
}
