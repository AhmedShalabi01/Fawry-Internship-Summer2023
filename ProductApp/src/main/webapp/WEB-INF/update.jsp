<%@ page import="com.productapp.productapptask2.entity.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Product</title>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
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
            margin: 30px auto;
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
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        input[type="submit"] {
            background-color: #191970;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 3px;
        }
        input[type="submit"]:hover {
            background-color: #191970;
        }




        button[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button[type="button"] {
            background-color: #191970;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 100px;
        }
        button[type="button"]:hover {
            background-color: #191970;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: #333;
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
<h1>Update Product</h1>

<div class="form-container">
    <form method="post" action="${pageContext.request.contextPath}/home/products/updateProduct"  class="centered-form">
        <input type="hidden" name="productId" value="${param.productId}">

        <label class="required" for="productName">Product Name:</label>
        <input type="text" id="productName" name="productName"  value="${param.productName}" required>

        <label class="required" for="productPrice">Product Price:</label>
        <input type="number" id="productPrice" name="productPrice"  value="${param.productPrice}" required>

        <button class="update-button" type="button" onclick="callAlert(this);" >Update Product</button>
    </form>

    <a href="${pageContext.request.contextPath}/home/products">Back to Product List</a>
</div>
<script>

        function callAlert(button) {
            let productName =  document.getElementById("productName").value;
            let productPrice = document.getElementById("productPrice").value;
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
                    title: "Price must be more than zero!",
                });

            } else {
                Swal.fire({
                    title: 'Do you want to save the changes?',
                    showDenyButton: true,
                    confirmButtonText: 'Save',
                    denyButtonText: `Don't save`,
                }).then((result) => {
                    if (result.isConfirmed) {
                        Swal.fire('Saved!', '', 'success').then(() => {
                            button.closest('form').submit();
                        });
                    } else if (result.isDenied) {
                        Swal.fire('Changes are not saved', '', 'info' ).then(() => {
                        });
                    }
                });
            }

    }
</script>

</body>
</html>