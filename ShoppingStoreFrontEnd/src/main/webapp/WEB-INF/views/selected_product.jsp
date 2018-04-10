<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<img alt="" src="${selectedProductImage}"> <br>
${selectedProduct.id}
<img alt="" src="resources/images/${selectedProduct.id}.PNG">
product name: ${selectedProduct.name} <br>
price : ${selectedProduct.price} <br>
Description : ${selectedProduct.description} <br>

<a href="cart/add/${selectedProduct.id}">Add to Cart</a>


<c:forEach items="${products}" var="product">

${product.name}

${product.description}


${product.price}

<img alt="" src="resources/images/${product.id}.PNG">



</c:forEach>






<%-- <form action="cart/add" method = "post">
 <img alt="" src="${selectedProductImage }"> <br>
<img alt =""src="resources/images/ShoppingCartImages/${selectedproduct.id}">
Product id: <input type = "text" disabled = "disabled"  name = "id" values =${selectedproduct.id}>
Product Name : <input type = "text" disabled = "disabled" name = "productName" values =${selectedproduct.name}>
Product price: <input type = "text"  disabled = "disabled" name = "price" values =${selectedproduct.price}>
<input type = "text" name = "quantity"> <br>

Product Name: ${selectedproduct.name} <br>
<input type = "submit" name = "Add to Cart"> --%>

<%-- Price: ${selectedproduct.price} <br>
Description: ${selectedproduct.description}<br>
<a href ="/cart/add?productName=${selectedproduct.name} &price=${selectedprouct.price}&quantity=1">Add to Cart</a> --%>

<%-- <img alt="" src="${imageFolder}/${selectdproduct}.PNG"> --%>
</form>
</body>
</html>