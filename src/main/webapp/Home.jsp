<%@page import="java.util.Base64"%>
<%@page import="java.util.List"%>
<%@page import="shophouse.dto.*"%>
<%@page import="shophouse.dao.Dao" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%HttpSession hs = request.getSession();
Admin admin = (Admin)hs.getAttribute("admin");
	hs.setAttribute("admin", admin);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin-<%=admin.getAdminName() %></title>
<link rel="stylesheet" href="./css/Home.css">
</head>
<body>
    <nav>
        <h1 id="home" >Home</h1>
        <a href="AddProduct.jsp" id="add_product">add product</a>
        <h1 id="shop">SHOP HOUSE</h1>
        <div id="admin_details">
            <h2 id="admin">Admin ID <%=admin.getAdminId() %></h2> 
            <h1 id="name"><%=admin.getAdminName() %></h1>   
            <a href="logout"><button >Log out</button> </a>
        </div>
    </nav>
    
    <%List<Product> products = (List)hs.getAttribute("products"); 
    	hs.setAttribute("products", products);%>
    
    <div id="main_content">
        <%for(Product p : products){ %>
        <div id="elements">
            <div id="img"> 
                <%String base64image = new String(Base64.getEncoder().encode(p.getProductImage())); %>
                <img src="data:image/jpeg;base64,<%= base64image %>" alt="">
            </div>
            <div id="content">
                <h1>ID : <%=p.getProductId() %></h1>
                <h1>Name : <%=p.getProductName() %></h1>
                <h4>Brand : <%=p.getProductBrand() %></h4>
                <h3>price : <%=p.getProductPrice() %></h3>
                <h3>discount : <%=p.getProductDiscount() %></h3>
                <h3>Final Price : <%=p.getProductPrice()-p.getProductDiscount() %></h3>
            </div>
            
            <div id="buttons">
                <a href="delete?id=<%=p.getProductId() %>"><button id="delete_button">Delete</button></a>
                <a href="EditProduct.jsp?id=<%=p.getProductId() %>" ><button id="edit_button">Edit</button></a>
            </div>
            
        </div>
        <div id="line"></div> 
        <%} %>
    </div> 
    
    

</body>
</html>