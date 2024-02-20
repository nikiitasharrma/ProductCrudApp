<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="./base.jsp"%>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Update product details</h1>
				<form action="${pageContext.request.contextPath}/handle-form" method="post">
					<div class="form-group">
						<label for="name">Product id</label> <input type="text"
							class="form-control" id="productId" name="id"
							placeholder="Enter product id" value="${product.id}">
					</div>
					<div class="form-group">
						<label for="name">Product Name</label> <input type="text"
							class="form-control" id="productName" name="name"
							placeholder="Enter product name" value="${product.name}">
					</div>
					<div class="form-group">
						<label for="desc">Product Description</label>
						<textarea class="form-control" id="productDesc" rows="5"
							name="desc" placeholder="Enter product description">${product.desc}</textarea>
					</div>
					<div class="form-group">
						<label for="name">Product Price</label> <input type="text"
							class="form-control" id="productPrice" name="price"
							placeholder="Enter product price" value="${product.price}">
					</div>
					<div class="container text-center">
						<a href="${pageContext.request.contextPath}/"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-primary">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>