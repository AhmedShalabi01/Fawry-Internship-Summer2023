<%@ page import="com.productapp.productapptask2.entity.Product" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
    <link rel="icon" href="Productpng.png" type="image/png">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        h1 {
            background-color: 		#722F37;
            color: white;
            padding: 10px;
            margin: 0;
            text-align: center;
        }
        table {
            width: 70%;
            border-collapse: collapse;
            margin: 20px auto;
            border: 1px solid #ccc;
        }
        th, td {
            padding: 8px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: 		#722F37;
            color: white;
        }
        .delete-button, .update-button {
            background-color: 	#DC143C	;
            color: white;
            padding: 5px 10px;
            cursor: pointer;
            border: 1px solid #ccc;
            border-radius: 200px;
        }
        .update-button {
            background-color: 		#722F37;
        }
        .add-button {
            background-color: 		#722F37;
            color: white;
            border: 1px solid #ccc;
            border-radius: 100px;
            padding: 5px 10px;
            cursor: pointer;
            text-decoration: none;
            display: block;
            width: 120px;
            margin: 20px auto;
            text-align: center;
        }
        .search-bar {
            text-align: center;
            margin: 20px auto;
        }

        .search-bar form {
            display: inline ;
        }

        .search-bar input[type="text"] {
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-right: 5px;
            width: 15%;
        }

        .search-bar button {
            background-color: 	#722F37;
            color: white;
            border: 1px solid #ccc;
            border-radius: 100px;
            padding: 5px 10px;
            cursor: pointer;
        }

    </style>
</head>
<body>
<h1>Product Stock</h1>

<div class="search-bar">
    <form action="${pageContext.request.contextPath}/home/products/searchProduct" method="get" onsubmit="return validateSearchForm()">
        <label class="required" for="productName"></label>
        <input type="text" id="productName" name="productName" placeholder="Search by ID or Product Name...">
        <button type="submit">Search</button>
    </form>
    <a href="${pageContext.request.contextPath}/home/products/addProduct" class="add-button">Add Product</a>
</div>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Category</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Options</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.category.name}</td>
            <td>${product.quantity}</td>
            <td>${product.price}</td>
            <td>
                <form action="${pageContext.request.contextPath}/home/products/deleteProduct" method="post" style="display: inline;">
                    <input  type="hidden" name="productId" value="${product.id}">
                    <button class="delete-button" type="button" onclick="callAlert(this);">Delete</button>
                </form>

                <form action="${pageContext.request.contextPath}/home/products/updateProduct" method="get" style="display: inline;">
                    <input type="hidden" name="productId" value="${product.id}">
                    <input type="hidden" name="productName" value="${product.name}">
                    <input type="hidden" name="productPrice" value="${product.price}">
                    <input type="hidden" name="productQuantity" value="${product.quantity}">
                    <button class="update-button" type="submit">Update</button>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>
<script>
    function callAlert(button) {
        Swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            dangerMode: true,
            confirmButtonColor: '#722F37',
            cancelButtonColor: '#DC143C',
            confirmButtonText: 'Yes, delete it'
        }).then((result) => {
            if (result.isConfirmed) {
                Swal.fire(
                    'Deleted!',
                    'Your product has been deleted.',
                    'success'
                ).then(() => {
                    // Once the user confirms, submit the form
                    button.closest('form').submit();
                });
            }
        });
    }

    function validateSearchForm() {
        const searchInput = document.querySelector('input[name="productName"]');
        if (searchInput.value.trim() === '') {

            Swal.fire({
                confirmButtonColor: '#722F37',
                icon: 'info',
                title: 'Need Input to search for !',
                iconColor:'#722F37',
            })
            return false;
        }

        return true;
    }

</script>


</body>
</html>