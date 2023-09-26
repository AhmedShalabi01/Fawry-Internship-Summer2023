<%@ page import="com.productapp.productapptask2.repo.ProductRepository" %>
<%@ page import="com.productapp.productapptask2.entity.Product" %>
<%@ page import="com.productapp.productapptask2.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        h1 {
            background-color: #191970;
            color: white;
            padding: 10px;
            margin: 0;
            text-align: center;
        }

        form {
            max-width: 400px;
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 5px 0 #ccc;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="number"],
        select{
            font-family: Arial, sans-serif;
            font-size: 17px;
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #191970;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #191970;
        }


        button[type="text"],
        button[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button[type="button"] {
            background-color: #191970;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 100px;
            cursor: pointer;
        }
        button[type="button"]:hover {
            background-color: #191970;
        }

        a {
            display: block;
            text-align: center;
            text-decoration: none;
            color: #191970;
            margin-top: 20px;
        }

        .required::after{
            content: " *";
            color: red;
            font-size: 20px;
        }

        .centered-form {
            text-align: center;
            margin: 0 auto;
            width: 50%;
            padding: 20px;
            background-color: #f2f2f2;
            border: 1px solid #ccc;
            border-radius: 10px;
        }

        .form-container {
            text-align: center;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 70%;
        }




    </style>
</head>
<body>
    <h1>Add Product</h1>

    <div class="form-container">
        <form method="post" action="${pageContext.request.contextPath}/home/products/saveNewProduct" class="centered-form" >
            <label class="required" for="productName">Product Name:</label>
            <input type="text" id="productName" name="productName" required><br>

            <label class="required" for="productPrice">Product Price:</label>
            <input type="number" id="productPrice" name="productPrice" required><br>

            <label class="required" for="productQuantity">Product Quantity:</label>
            <input type="number" id="productQuantity" name="productQuantity" required><br>

            <label class="required" for="productCategory">Product Category:</label>
            <select id="productCategory" name="productCategory" required>
                <option value="" disabled selected hidden>Select a category</option>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.categoryId}">${category.name}</option>
                </c:forEach>
            </select><br>



            <button type="button" onclick="doneAlert(this);">Add Product</button>
        </form>
        <a href="${pageContext.request.contextPath}/home/products" class="add-button">Back to Product List</a>
    </div>



<script>
    function doneAlert(button){
        var productName = document.getElementById("productName").value;
        var productPrice = document.getElementById("productPrice").value;
        var productCategory = document.getElementById("productCategory").value;
        if(productName===""||productPrice===""){
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Something went wrong!',
            })
        }
        else if (isNaN(productPrice) || parseFloat(productPrice) <= 0) {
            Swal.fire({
                icon: 'info',
                title: "Price must be more than zero !",
            });
        }else if(productCategory === ""){
            Swal.fire({
                icon: 'info',
                title: "Please select a category !",
            });

        }else {

            Swal.fire({
                position: 'center',
                icon: 'success',
                title: 'Product ( ' +  productName +' ) has been saved',
                showConfirmButton: true,
                confirmButtonText: 'OK',
                timer: 3000

            }).then((result)=>{
                if (result.isConfirmed) {
                    button.closest('form').submit();
                }
            })
        }



    }
</script>
</body>
</html>