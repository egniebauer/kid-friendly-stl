<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css"  rel="stylesheet" href="css/bootstrap-theme.min.css" /><link type="text/css"  rel="stylesheet" href="css/bootstrap-theme.min.css.map" /><link type="text/css"  rel="stylesheet" href="css/bootstrap.min.css" /><link type="text/css"  rel="stylesheet" href="css/bootstrap.min.css.map" />
	<script src="js/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<title>Kid Friendly STL</title>
</head>
<body>
	<div class="container">
	<!-- PAGE HEADING -->
		<div class="row">
			<div class="col-sm-12">
				<h1>Kid Friendly STL</h1>
			</div>
		</div>
	<br />
	<!-- BUTTONS -->
		<div class="row">
			<div class="col-sm-12">
				<a class="btn btn-default" href="form.jsp" role="button">Add New Listing</a>
				<button type="button" class="btn btn-default">Search Listings</button>
			</div>
		</div>
	<br />
	<!-- RESULTS TABLE -->
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-hover table-striped">
					<tbody>
						<c:forEach var="currentBusiness" items="${BUSINESS_LIST}" >
							<c:url var="viewLink" value="FriendlyControllerServlet">
								<c:param name="command" value="VIEW" />
								<c:param name="businessID" value="${currentBusiness.id}" />
							</c:url>
							<tr>
								<td>
									<h4>${currentBusiness.name}</h4>
									<p>${empty currentBusiness.address ? '': currentBusiness.address}${!empty currentBusiness.address && !empty currentBusiness.phone ? ' | ': ''}${!empty currentBusiness.phone ? String.valueOf(currentBusiness.phone).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3") : ''}</p>
								</td>
								<td>
								<c:choose>
									<c:when test="${currentBusiness.rating == 0 }">
										<p>NOT RATED</p>
									</c:when>
									<c:otherwise>
										<c:forEach begin="1" end="${currentBusiness.rating}">
					   						<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
										</c:forEach>
										<c:forEach begin="1" end="${5 - currentBusiness.rating}">
					   						<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
										</c:forEach>
									</c:otherwise>
								</c:choose>
								</td>
								<td>
									<a class="btn btn-default" href="${viewLink}" role="button">View more</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>	
				</table>
			</div>
		</div>
	</div>	
</body>
</html>