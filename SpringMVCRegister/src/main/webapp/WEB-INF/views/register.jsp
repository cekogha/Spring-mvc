<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Sign Up</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Zeta Template Project">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/styles/bootstrap4/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/styles/main_styles_custom.css">
</head>

<body>

<div class="super_container">

	<c:choose>
		<c:when test="${not empty signupSucceed}">
			<div class="sign_up_text">${signupSucceed}<a href="home">Sign in now</a></div>
		</c:when>
		<c:otherwise>
		
		<!-- Sign up form -->
		<div class="div_sign_up container">
		<!-- LOGO -->
			<div class="sign_up_logo">
				<img src="resources/images/logo_lets_riddle.png" alt="" />
			</div>
			
			<div class="sign_up_text">Already a member? <a href="home">Sign in now</a></div>
			<c:if test="${not empty signupError}">
				<div class="alert alert-warning">${signupError}</div>
			</c:if>
			
			<form class="form-horizontal" action="signup" method="post">
				<div class="form-group">
					<label class="control-label col-sm-3">Username : </label>
					<div class="col-sm-6">
						<input class="form-control form-control-sm" type="text" name="username" placeholder="USERNAME" required/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">Email : </label>
					<div class="col-sm-6">
						<input class="form-control form-control-sm" type="email" name="email" placeholder="EMAIL" required/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">Password : </label>
					<div class="col-sm-6">
						<input class="form-control form-control-sm" type="password" name="password1" placeholder="PASSWORD" required/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">Confirm password : </label>
					<div class="col-sm-6">
						<input class="form-control form-control-sm" type="password" name="password2" placeholder="CONFIRM PASSWORD"
	                 	required/>
	                 </div>
				</div>
				<div class="form-group ">
					<div class="col-sm-offset-3 col-sm-6 grid_button">					
						<input class="form-control btn btn-primary" type="submit" />
						<input class="form-control btn btn-secondary" type="reset"  />
					</div>
				</div>
			</form>
		</div>
		
		</c:otherwise>
	</c:choose>	

</div>
		<!-- FOOTER -->
		<%@ include file="footer.jsp" %>

</body>
</html>

