<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href = "buy"> BUY </a> <br>
<c:forEach var="cart" items="${cartList}">
<%-- <img alt="" src=" ${ImagesFolder}${cart.productID}.PNG"> --%>
<img alt="" src="resources/images/${cart.productID}.PNG">
Name  : <input type="text" name="price" value="${cart.productName}"> <br>
Price: <input type = "text" name = "price" values =${cart.price}> <br>
Quantity  : <input type="text" name="price" value="${cart.quantity}"> <br>
</c:forEach>

</body>
</html>