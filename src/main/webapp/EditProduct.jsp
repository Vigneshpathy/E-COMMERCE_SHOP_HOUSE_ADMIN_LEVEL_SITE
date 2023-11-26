<%@page import="java.util.Base64"%>
<%@page import="java.sql.SQLException"%>
<%@page import="shophouse.dto.Product"%>
<%@page import="shophouse.dao.Dao"%>
<%@page import="shophouse.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%	HttpSession hs = request.getSession();
	Admin admin = (Admin)hs.getAttribute("admin"); 
	hs.setAttribute("admin", admin);
	hs.setAttribute("products", hs.getAttribute("products"));
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop House-Edit Product</title>
<link rel="stylesheet" href="./css/EditProduct.css">
</head>
<body>
	<nav>
        <h1 id="home" >
           <a href="Home.jsp">Home</a></h1>
        <a href="AddProduct.jsp" id="add_product">add product</a>
        <h1 id="shop">SHOP HOUSE</h1>
        <div id="admin_details">
            <h2 id="admin">Admin ID <%=admin.getAdminId() %></h2> 
            <h1 id="name"><%=admin.getAdminName() %></h1>    
        </div>
    </nav>
    <div id="bg_box"></div>
    <div id="main_content">
        <div id="form">
        <%Dao dao = new Dao();
        
         Product product = dao.findProductById(Integer.parseInt(request.getParameter("id")));
        
        %>
            <form id="form_box" action="EditProduct" method="post" enctype="multipart/form-data">
                <div id="heading">
                    <h1>Edit Product</h1>
                </div>
                <div id="id_div" class="inputs">
                    <label for="id">ID : </label><input type="number" name="id" id="id" class="input_box" value="<%=product.getProductId()%>" readonly>
                </div>
                <div id="name_div" class="inputs">
                    <label for="name">name : </label><input type="text" name="name" id="name" class="input_box" value="<%=product.getProductName()%>">
                </div>
                <div id="brand_div" class="inputs">
                    <label for="brand">Brand : </label><input type="text" name="brand" id="brand" class="input_box" value="<%=product.getProductBrand()%>">
                </div>
                <div id="price_div" class="inputs">
                    <label for="price">Price : </label><input type="number" name="price" id="price" class="input_box" value="<%=product.getProductPrice()%>"> 
                </div>
                <div id="discount_div" class="inputs">
                    <label for="discount">Discount : </label><input type="number" name="discount" id="discount" class="input_box" value="<%=product.getProductDiscount()%>">
                </div>
                <%
                String base64image = Base64.getEncoder().encodeToString(product.getProductImage());
                request.setAttribute("base64image", base64image);%>
                <div id="img_div" class="inputs" >
               		<img src="data:image/jpeg;base64,<%= base64image %>" alt="" width="300px">
                    <label for="image">Add image : </label><input type="file" name="image" id="image" class="input_box" >
                </div>
                
                <input type="submit"  id="submit" value="Update product">
         
            </form>
        </div>
    </div>
</body>
</html>