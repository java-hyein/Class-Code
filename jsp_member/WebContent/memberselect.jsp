<%@ page import ="java.util.ArrayList"%>
<%@ page import = "edu.bit.ex.*"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		MemberPoolDAO memberDAO = new MemberPoolDAO();
		//��� ����Ʈ�� dtos �� ���� (�� �κ� �����ϱ�)
		ArrayList<MemberDTO> dtos = memberDAO.memberSelect();
		
		for(int i = 0; i <dtos.size(); i++){
			MemberDTO dto = dtos.get(i); // DTO ���� �޾ƿ���
			String name = dto.getName();
			String id = dto.getId();
			String pw = dto.getPw();
			String phone = dto.getPhone1()+ " - "+ dto.getPhone2()+ " - " + dto.getPhone3();
			String gender = dto.getGender();
			
			out.println("�̸� : " + name +", ���̵� : "+ id + ", ��й�ȣ : " + pw + ", ����ó : "+ phone +", ���� : " + gender +"<br>");
		}
	%>
</body>
</html>