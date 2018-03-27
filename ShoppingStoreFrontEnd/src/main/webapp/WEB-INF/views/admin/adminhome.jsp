<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2></h2><a href="managecategories"> Manage Categories</a>
<a href="managesuppliers"> Manage Suppliers</a>
<a href="manageproducts"> manage products</a>
</h2>
<c:if test="${isAdminClickedCategories==true }">
<jsp:include page="category.jsp"></jsp:include>
</c:if>
<c:if test="${isAdminClickedSuppliers==true }">
<jsp:include page="supplier.jsp"></jsp:include>
</c:if>
<c:if test="${isAdminClickedProducts==true }">
<jsp:include page="product.jsp"></jsp:include>
</c:if>
</body>
</html>