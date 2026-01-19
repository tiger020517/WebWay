<%--
  Created by IntelliJ IDEA.
  User: kimjunhyoung
  Date: 25. 12. 7.
  Time: 오후 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="top.jsp" />

<div class="row mb-3">
  <div class="col-md-6">
    <h2>Donor List</h2>
  </div>
  <div class="col-md-6 text-end">
    <form action="list" method="get" class="d-flex justify-content-end">
      <select name="sort" class="form-select me-2" style="width: auto;" onchange="this.form.submit()">
        <option value="new" ${param.sort == 'new' ? 'selected' : ''}>최신순</option>
        <option value="old" ${param.sort == 'old' ? 'selected' : ''}>오래된순</option>
        <option value="name" ${param.sort == 'name' ? 'selected' : ''}>이름순</option>
      </select>
      <input type="text" name="search" class="form-control me-2" placeholder="이름 검색" value="${param.search}" style="width: 200px;">
      <button type="submit" class="btn btn-outline-primary">검색</button>
    </form>
  </div>
</div>

<table class="table table-hover table-bordered">
  <thead class="table-light">
  <tr>
    <th>ID</th>
    <th>Photo</th>
    <th>Name</th>
    <th>Age</th>
    <th>Blood Type</th>
    <th>Contact</th>
    <th>Health</th>
    <th>Reg Date</th>
    <th>Manage</th> </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="u">
    <tr>
      <td>${u.sid}</td>
      <td>
        <c:if test="${not empty u.photo}">
          <img src="${pageContext.request.contextPath}/resources/upload/${u.photo}" width="50" height="50" class="rounded-circle">
        </c:if>
        <c:if test="${empty u.photo}">No Img</c:if>
      </td>
      <td>${u.name}</td>
      <td>${u.age}</td>
      <td>${u.blood_type}</td>
      <td>${u.contact}</td>
      <td>${u.health}</td>
      <td>
        <fmt:formatDate value="${u.regdate}" pattern="yyyy-MM-dd HH:mm"/>
      </td>
      <td>
        <a href="edit/${u.sid}" class="btn btn-sm btn-success">Edit</a>
        <a href="javascript:delete_ok('${u.sid}')" class="btn btn-sm btn-danger">Delete</a>
      </td>
    </tr>
  </c:forEach>

  <c:if test="${empty list}">
    <tr>
      <td colspan="9" class="text-center py-4">등록된 데이터가 없습니다.</td>
    </tr>
  </c:if>
  </tbody>
</table>

<div class="text-end">
  <a href="add" class="btn btn-primary">Add New Donor</a>
</div>

<script>
  function delete_ok(id) {
    if(confirm("정말로 삭제하시겠습니까?")) {
      location.href = 'delete/' + id;
    }
  }
</script>

<jsp:include page="bottom.jsp" />
