<%@ page import="hello.servelet.domain.member.Member" %>
<%@ page import="hello.servelet.domain.member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: yubin
  Date: 2022/12/22
  Time: 2:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // request, response는 import없이 사용 가능
  // jsp 도 서블릿으로 변환됨 그래서 원래 문법상 지원
  MemberRepository memberRepository = MemberRepository.getInstance();
  System.out.println("MemberSaveServlet.service");
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));

  Member member = new Member(username, age);
  memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  성공
<ul>
  <li>id=<%=member.getId()%></li>
  <li>username=<%=member.getUsername()%></li>
  <li>age<%=member.getAge()%></li>
</ul>
</body>
</html>
