<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css"  rel="stylesheet" href="css/bootstrap-theme.min.css" /><link type="text/css"  rel="stylesheet" href="css/bootstrap-theme.min.css.map" /><link type="text/css"  rel="stylesheet" href="css/bootstrap.min.css" /><link type="text/css"  rel="stylesheet" href="css/bootstrap.min.css.map" /><link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.13/css/dataTables.bootstrap.min.css"/><link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/autofill/2.1.3/css/autoFill.bootstrap.css"/><link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/responsive/2.1.0/css/responsive.bootstrap.min.css"/>
	<script src="js/jquery-3.1.1.js" type="text/javascript"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/autofill/2.1.3/js/dataTables.autoFill.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/autofill/2.1.3/js/autoFill.bootstrap.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/responsive/2.1.0/js/dataTables.responsive.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/responsive/2.1.0/js/responsive.bootstrap.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.2.4/js/dataTables.buttons.min.js"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<jsp:include page="navbar.jsp" />
			</div>
		</div>
		<br /><br /><br />
		<div class="row">
			<div class="col-sm-6  col-sm-offset-3">
			<!-- Error Message Box Panel -->
				<c:if test="${not empty ERROR_MESSAGE}">
			  		<div class="panel panel-danger">
		  				<div class="panel-heading">
		    				<h3 class="panel-title">Login Error</h3>
		  				</div>
			  			<div class="panel-body">
			  				<p>${ERROR_MESSAGE}</p>
			  			</div>
					</div>
				</c:if>
			<!-- Login Box Panel -->
				<div class="panel panel-default">
	  				<div class="panel-heading">
	    				<h3 class="panel-title">Kid Friendly STL - Login</h3>
	  				</div>
		  			<div class="panel-body">
						<form id="login" action="LoginServlet" method="POST">
							<input type="hidden" name="command" value="VALIDATE" />
							<div class="form-group">
								<label for="userEmail">User Name</label>
								<div class="input-group">
			  						<span class="input-group-addon" id="basic-addon1">@</span>
			  						<input name="userEmail" id="userEmail"  type="email" class="form-control" placeholder="Email Address" aria-describedby="basic-addon1">
								</div>
							</div>
							<div class="form-group">
		    					<label for="userPassword">Password</label>
		    					<input type="password" class="form-control" name="userPassword" id="userPassword" placeholder="Password">
		  					</div>
		  					<div class="center-block">
		  						<input class="btn btn-default" type="submit" value="Submit">
		  					</div>
		  				</form>
		  			</div>
		  		</div>
			</div>
		</div>
	</div>
</body>
</html>