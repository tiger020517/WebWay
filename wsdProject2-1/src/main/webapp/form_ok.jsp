<%@ page import="com.example.Repository" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");

    Map<String, String> data = new HashMap<>();
    data.put("name", request.getParameter("name"));
    data.put("age", request.getParameter("age"));
    data.put("contact", request.getParameter("contact"));
    data.put("height", request.getParameter("height"));
    data.put("weight", request.getParameter("weight"));
    data.put("blood_type", request.getParameter("blood_type"));
    data.put("smoker", request.getParameter("smoker"));
    data.put("organ", request.getParameter("organ"));
    data.put("health", request.getParameter("health"));
    data.put("date", request.getParameter("date"));

    Repository.add(data);

    response.sendRedirect("list.jsp");
%>