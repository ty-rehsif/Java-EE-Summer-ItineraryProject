<%-- 
    Document   : search
    Created on : Apr 20, 2021, 8:51:00 AM
    Author     : Tyrese Fisher
--%>

<%@include file = "/include/header.jsp" %>
<form action="search" method="POST">
    <select name="searchcategory">
        <option>All</option>
        <c:forEach var="i" items ="${categories}" >
    <option>${i}</option>    
        </c:forEach>
    </select>  
    <input type="submit" value="Search Plan" />
</form>

<p> ${searchMessage}</p>
<p> ${resultlist}</p>
<hr>
<a href="index.jsp"> Go Add</a>
<%@include file = "/include/footer.jsp" %>
