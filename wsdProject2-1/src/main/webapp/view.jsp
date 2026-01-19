<%@ page import="com.example.Repository" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String id = request.getParameter("id");
  Map<String, String> item = Repository.getById(id);
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>상세 정보</title>
  <style>
    @font-face { font-family: 'RoundedFixedsys'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/DungGeunMo.woff') format('woff'); font-weight: normal; font-display: swap; }
    body { font-family: 'RoundedFixedsys', monospace; background-color: #0a0a0a; color: #d4d4d4; margin: 0; padding: 20px; display: flex; flex-direction: column; align-items: center; min-height: 100vh; }
    body::before { content: " "; display: block; position: absolute; top: 0; left: 0; width: 100%; height: 100%; background: linear-gradient(rgba(18, 16, 16, 0) 50%, rgba(0, 0, 0, 0.25) 50%), linear-gradient(90deg, rgba(255, 0, 0, 0.06), rgba(0, 255, 0, 0.02), rgba(0, 0, 255, 0.06)); background-size: 100% 3px, 3px 100%; z-index: 2; pointer-events: none; animation: scanline 8s linear infinite; }
    @keyframes scanline { 0% { background-position: 0 0;} 100% { background-position: 0 100vh; } }
    .container { background-color: #1c1c1c; padding: 30px; border: 2px solid #555; width: 100%; max-width: 500px; z-index: 1; }
    h1 { color: #ea3635; text-align: center; text-shadow: 0 0 3px red; }
    p { font-size: 1.3em; border-bottom: 1px dashed #444; padding: 10px; margin: 0; }
    span { color: #75fa69; float: right; }
    .actions { margin-top: 30px; text-align: center; }
    .btn { background-color: #b0b0b0; color: #0a0a0a; border: 2px outset #e0e0e0; padding: 10px 20px; font-size: 1.1em; font-family: inherit; cursor: pointer; text-decoration: none; margin: 0 10px; }
  </style>
</head>
<body>
<div class="container">
  <h1>지원자 상세 정보</h1>
  <p>이름 <span><%= item.get("name") %></span></p>
  <p>나이 <span><%= item.get("age") %></span></p>
  <p>연락처 <span><%= item.get("contact") %></span></p>
  <p>키/몸무게 <span><%= item.get("height") %>cm / <%= item.get("weight") %>kg</span></p>
  <p>혈액형 <span><%= item.get("blood_type") %></span></p>
  <p>흡연여부 <span><%= item.get("smoker") == null ? "아니오" : "예" %></span></p>
  <p>장기 <span><%= item.get("organ") %></span></p>
  <p>건강상태 <span><%= item.get("health") %></span></p>
  <p>희망일 <span><%= item.get("date") %></span></p>

  <div class="actions">
    <a href="list.jsp" class="btn">목록</a>
    <a href="edit.jsp?id=<%= id %>" class="btn">수정</a>
  </div>
</div>
</body>
</html>