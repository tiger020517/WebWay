<%@ page import="com.example.Repository" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String id = request.getParameter("id");
  Map<String, String> d = Repository.getById(id);
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>지원자 정보 수정</title>
  <style>
    @font-face { font-family: 'RoundedFixedsys'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/DungGeunMo.woff') format('woff'); font-weight: normal; font-display: swap; }
    body { font-family: 'RoundedFixedsys', monospace; background-color: #0a0a0a; color: #d4d4d4; margin: 0; padding: 20px; display: flex; flex-direction: column; align-items: center; min-height: 100vh; animation: textFlicker 0.05s infinite; }
    body::before { content: " "; display: block; position: absolute; top: 0; left: 0; width: 100%; height: 100%; background: linear-gradient(rgba(18, 16, 16, 0) 50%, rgba(0, 0, 0, 0.25) 50%), linear-gradient(90deg, rgba(255, 0, 0, 0.06), rgba(0, 255, 0, 0.02), rgba(0, 0, 255, 0.06)); background-size: 100% 3px, 3px 100%; z-index: 2; pointer-events: none; animation: scanline 8s linear infinite; }
    @keyframes scanline { 0% { background-position: 0 0;} 100% { background-position: 0 100vh; } }
    @keyframes textFlicker { from { text-shadow: 1px 0 0 #ea3635, -1px 0 0 #75fa69; } to { text-shadow: -1px 0 0 #ea3635, 1px 0 0 #75fa69; } }
    h1 { font-size: 3em; color: #e0e0e0; text-align: center; text-shadow: 0 0 3px rgba(255, 255, 255, 0.4); margin-bottom: 30px; letter-spacing: 2px; animation: titleGlich 2s infinite steps(4, end); }
    form { background-color: #1c1c1c; padding: 30px; border: 2px solid #555; border-style: inset; width: 100%; max-width: 550px; box-sizing: border-box; z-index: 1; }
    label { display: block; margin-bottom: 5px; color: #b0b0b0; font-size: 1.2em; }
    input[type="text"], input[type="number"], input[type="date"], textarea, select { width: 100%; padding: 8px; margin-bottom: 15px; background-color: #0f0f0f; border: 2px inset #444; color: #d4d4d4; font-family: 'RoundedFixedsys', monospace; font-size: 1.2em; box-sizing: border-box; }
    input:focus, textarea:focus, select:focus { outline: none; background-color: #2a2a2a; border-color: #666; }
    #age { width: 100px; } #name { width: 100%; } #contact { width: 60%; }
    input[type="range"] { -webkit-appearance: none; width: 100%; height: 6px; background: #444; outline: none; border: 1px solid #222; }
    input[type="range"]::-webkit-slider-thumb { -webkit-appearance: none; appearance: none; width: 18px; height: 18px; background: #999; border: 2px outset #777; cursor: grab; }
    input[type="radio"], input[type="checkbox"] { -webkit-appearance: none; -moz-appearance: none; display: inline-block; width: 20px; height: 20px; border: 2px inset #555; background-color: #0f0f0f; border-radius: 3px; vertical-align: middle; margin-right: 8px; position: relative; cursor: pointer; outline: none; transition: background-color 0.1s linear; box-shadow: 0 0 3px rgba(0,0,0,0.5); }
    input[type="radio"]:checked, input[type="checkbox"]:checked { background-color: #d4d4d4; border-color: #888; box-shadow: 0 0 5px rgba(255, 255, 255, 0.3); animation: checkedPulse 0.8s infinite alternate steps(2); }
    input[type="radio"]:checked::after, input[type="checkbox"]:checked::after { content: ''; display: block; width: 10px; height: 10px; background-color: #0a0a0a; position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); border-radius: 1px; animation: innerGlow 0.8s infinite alternate steps(2); }
    input[type="radio"] + label, input[type="checkbox"] + label { display: inline-block; margin-right: 15px; vertical-align: middle; color: #d4d4d4; font-weight: normal; text-transform: none; letter-spacing: 0; font-size: 1.2em; }
    input[type="submit"] { background-color: #b0b0b0; color: #0a0a0a; border: 2px outset #e0e0e0; padding: 10px 20px; font-size: 1.2em; font-family: 'RoundedFixedsys', monospace; cursor: pointer; display: block; margin: 20px auto 0 auto; }
    input[type="submit"]:active { border-style: inset; }
  </style>
</head>
<body>
<h1>정보 수정</h1>
<form id="myForm" action="edit_ok.jsp" method="post">
  <input type="hidden" name="id" value="<%= id %>">
  <label for="name">이름:</label>
  <input type="text" id="name" name="name" value="<%= d.get("name") %>" required><br><br>

  <label for="age">나이:</label>
  <input type="number" id="age" name="age" value="<%= d.get("age") %>" required><br><br>

  <label for="contact">연락처:</label>
  <input type="text" id="contact" name="contact" value="<%= d.get("contact") %>" required><br><br>

  <label for="height">키: <span id="height-value"><%= d.get("height") %></span> cm</label>
  <input type="range" id="height" name="height" min="0" max="200" value="<%= d.get("height") %>" required><br><br>

  <label for="weight">몸무게: <span id="weight-value"><%= d.get("weight") %></span> kg</label>
  <input type="range" id="weight" name="weight" min="0" max="150" value="<%= d.get("weight") %>" required><br><br>

  <label for="blood_type">혈액형:</label>
  <input type="radio" id="A" name="blood_type" value="A" <%= "A".equals(d.get("blood_type")) ? "checked" : "" %>><label for="A">A</label>
  <input type="radio" id="B" name="blood_type" value="B" <%= "B".equals(d.get("blood_type")) ? "checked" : "" %>><label for="B">B</label>
  <input type="radio" id="AB" name="blood_type" value="AB" <%= "AB".equals(d.get("blood_type")) ? "checked" : "" %>><label for="AB">AB</label>
  <input type="radio" id="O" name="blood_type" value="O" <%= "O".equals(d.get("blood_type")) ? "checked" : "" %>><label for="O">O</label><br><br>

  <label for="smoker">흡연 여부:</label>
  <input type="checkbox" id="smoker" name="smoker" value="yes" <%= "yes".equals(d.get("smoker")) ? "checked" : "" %>><label for="smoker">예</label><br><br>

  <label for="organ">기증할 장기:</label>
  <select id="organ" name="organ" required>
    <option value="kidney" <%= "kidney".equals(d.get("organ")) ? "selected" : "" %>>신장</option>
    <option value="liver" <%= "liver".equals(d.get("organ")) ? "selected" : "" %>>간</option>
    <option value="heart" <%= "heart".equals(d.get("organ")) ? "selected" : "" %>>심장</option>
    <option value="lung" <%= "lung".equals(d.get("organ")) ? "selected" : "" %>>폐</option>
    <option value="pancreas" <%= "pancreas".equals(d.get("organ")) ? "selected" : "" %>>췌장</option>
    <option value="intestine" <%= "intestine".equals(d.get("organ")) ? "selected" : "" %>>장</option>
    <option value="cornea" <%= "cornea".equals(d.get("organ")) ? "selected" : "" %>>각막</option>
  </select><br><br>

  <label for="health">건강 상태:</label><br>
  <textarea id="health" name="health" rows="4" cols="50" required><%= d.get("health") %></textarea><br><br>

  <label for="date">희망 기증 날짜:</label>
  <input type="date" id="date" name="date" value="<%= d.get("date") %>" required><br><br>
  <input type="submit" value="수정 완료">
</form>
<script>
  const heightSlider = document.getElementById('height');
  const heightValue = document.getElementById('height-value');
  const weightSlider = document.getElementById('weight');
  const weightValue = document.getElementById('weight-value');
  heightSlider.addEventListener('input', function () { heightValue.textContent = this.value; });
  weightSlider.addEventListener('input', function() { weightValue.textContent = this.value; });
</script>
</body>
</html>