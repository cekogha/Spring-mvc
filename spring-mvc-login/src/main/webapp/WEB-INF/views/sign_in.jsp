<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Sign in form -->
<div class="div_sign_in">
	<div class="div_sign_in_grid_1_2">
	</div>
	<div  class="div_sign_in_grid_2_2">
		<div class="div_sign_in_flex">
		<!-- LOGO -->
			<div class="sign_in_logo">
				<img src="resources/images/logo_lets_riddle.png" alt="" />
			</div>
			
			<c:if test="${not empty loginError}">
				<label class="alert alert-warning"> ${loginError} </label>
			</c:if>
			<form class="form_sign_in group-form" action="login" method="post" >
		
				<input class="form-control form-control-sm" type="text" name="username"
					placeholder="username or email" />
				<input class="form-control form-control-sm" type="password" name="password"
					placeholder="password" />
				<input class="form-control btn btn-primary"	type="submit" value="Sign in" />
				<div class="group-form grid_sign_up">
					<a href="password_forgot">Password forgot?</a> | <a href="signup">Sign up</a>
				</div>
			</form>
		</div>
	</div>
</div>
