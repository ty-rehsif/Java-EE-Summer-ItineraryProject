<%-- 
    Document   : index
    Created on : Apr 20, 2021, 8:09:36 AM
    Author     : Tyrese Fisher
--%>

<%@include file = "/include/header.jsp" %>
<h2>make your summer plan</h2>
<c:if test="${not empty message}">
    ${message}
    <hr>
</c:if>
<form action ="add" method="POST">
<p> id: <input type="text" name="id" value="" /></p>
<p>  activity: <input type="text" name="activity" value="" /></p>

<p> 
    category:
    <select name="category">
       <c:forEach var="i" items =" ${categories}" >
    <option>${i}</option>    
        </c:forEach>
    
</select>  
</p>
<input type="submit" value="Add To Plan" />
</form>

<hr>
<a href="search.jsp"> Go Search</a>




<%@include file = "/include/footer.jsp" %>