<%@ page import="hello.servelet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="hello.servelet.domain.member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: yubin
  Date: 2022/12/22
  Time: 2:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table>
    <a href="/index.html">메인</a>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <%
        for (Member member : members) {
            out.write("    <tr>");
            out.write("    <td>" + member.getId() + "</td>");
            out.write("    <td>" + member.getUsername() + "</td>");
            out.write("    <td>" + member.getAge() + "</td>");
            out.write("    </tr>");
        } %>
    </tbody>
</table>

</body>
</html>
