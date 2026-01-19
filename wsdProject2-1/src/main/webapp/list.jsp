<%@ page import="com.example.Repository" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>지원자 현황</title>
  <link href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&display=swap" rel="stylesheet">
  <style>
    @font-face { font-family: 'RoundedFixedsys'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/DungGeunMo.woff') format('woff'); font-weight: normal; font-display: swap; }
    body { font-family: 'RoundedFixedsys', monospace; background-color: #0a0a0a; color: #d4d4d4; margin: 0; padding: 20px; display: flex; flex-direction: column; align-items: center; min-height: 100vh; }
    body::before { content: " "; display: block; position: absolute; top: 0; left: 0; width: 100%; height: 100%; background: linear-gradient(rgba(18, 16, 16, 0) 50%, rgba(0, 0, 0, 0.25) 50%), linear-gradient(90deg, rgba(255, 0, 0, 0.06), rgba(0, 255, 0, 0.02), rgba(0, 0, 255, 0.06)); background-size: 100% 3px, 3px 100%; z-index: 2; pointer-events: none; animation: scanline 8s linear infinite; }
    @keyframes scanline { 0% { background-position: 0 0;} 100% { background-position: 0 100vh; } }
    h1 { font-size: 2.5em; color: #e0e0e0; text-align: center; margin-bottom: 30px; letter-spacing: 2px; text-shadow: 0 0 5px rgba(255,255,255,0.3); }
    table { width: 100%; max-width: 800px; border-collapse: collapse; border: 2px solid #555; background-color: #1c1c1c; z-index: 1; }
    th, td { border: 1px solid #444; padding: 12px; text-align: center; }
    th { background-color: #2a2a2a; color: #ea3635; font-size: 1.2em; }
    td { color: #b0b0b0; }
    a { color: #75fa69; text-decoration: none; }
    .btn { padding: 5px 10px; border: 1px solid #777; background: #0f0f0f; color: #d4d4d4; cursor: pointer; font-family: inherit; }
    .btn:hover { background: #333; }
    .add-btn { margin-top: 20px; font-size: 1.5em; border: 2px outset #e0e0e0; background: #b0b0b0; color: #0a0a0a; padding: 10px 30px; z-index: 5; position: relative;}
  </style>
</head>
<body>
<h1>지원자 명단</h1>
<table>
  <thead>
  <tr>
    <th>NO</th><th>이름</th><th>장기</th><th>혈액형</th><th>관리</th>
  </tr>
  </thead>
  <tbody>
  <% for(Map<String, String> item : Repository.getAll()) { %>
  <tr>
    <td><%= item.get("id") %></td>
    <td><a href="view.jsp?id=<%= item.get("id") %>"><%= item.get("name") %></a></td>
    <td><%= item.get("organ") %></td>
    <td><%= item.get("blood_type") %></td>
    <td>
      <button class="btn" onclick="location.href='edit.jsp?id=<%= item.get("id") %>'">수정</button>
      <button class="btn" onclick="location.href='delete_ok.jsp?id=<%= item.get("id") %>'">삭제</button>
    </td>
  </tr>
  <% } %>
  </tbody>
</table>
<a href="form.html" class="add-btn">지원하기</a>
</body>
</html>