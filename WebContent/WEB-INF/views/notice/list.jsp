<%@page import="dto.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%List<Notice> list = (List) request.getAttribute("noticeList");%>

<%@ include file="/WEB-INF/views/layout/bootAdminHeader.jsp" %>
<%@ include file="/WEB-INF/views/layout/bootAdminNavigation.jsp" %>


<style type="text/css">

.button{
background-color: #143642;
color: white;
border-radius: 4px;
float: right;
}

.container{
width: 900px;

}

.searchform{
float:right; 
margin:0px 3px 5px 3px;
}

#btnSearch{
background-color: #143642;
color: white;
border-radius: 4px;
}

th{
background-color: #A8201A;
}

#move:hover tbody tr:hover td{
background:#143642;
color:#FFFFFF;
}

</style>



<div class="container">
<h1>공지사항 목록</h1>
<hr>

<div class="searchform">
<form action="/admin/notice" method="get">
<select id="select" name="select" class="">
<option>제목</option>
<option>내용</option>
</select>
<input type="text" name="search" id="search"/>
<button id="btnSearch">검색</button>
</form>
</div>

<table class="table table-striped table-hover table-condensed" id="move">
<tr>
	<th>글번호</th>
	<th>제목</th>
	<th>아이디숫자</th>
	<th>조회수</th>
	<th>작성일</th>
</tr>
<%	for(int i=0; i<list.size(); i++) { %>
<tr>

<td><%=list.get(i).getN_no() %></td>
<td>
		<a href="/admin/view?n_no=<%=list.get(i).getN_no() %>">
		<%=list.get(i).getN_title() %>
		</a>
	</td>
	<td><%=list.get(i).getU_no() %></td>
	<td><%=list.get(i).getN_views() %></td>
	<td><%=list.get(i).getN_create_date() %></td>
	
</tr>
<%	} %>
</table>
<hr>
<button type="button" onclick="location.href='/admin/writenot' " class="button">글쓰기</button>


</div>

<%if(request.getParameter("search") == null){ %>
<%@ include file="/WEB-INF/views/layout/paging.jsp" %>
<%}else{ %>
<%@include file="/WEB-INF/views/notice/noticePaing.jsp"%>
<%} %>


<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
