<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css" /><link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css.map" /><link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" /><link type="text/css" rel="stylesheet" href="css/bootstrap.min.css.map" />
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<title>OOPS...</title>
</head>
<body>
<div class="container">
	<div class="row">
  		<div class="col-sm-12">
			<h1>OOPS...</h1>
		</div>
	</div>
<!-- BUTTONS -->
	<div class ="row">
	  	<div class="col-sm-12">
			<a class="btn btn-default" href="${pageContext.request.contextPath}/" role="button" >home</a> 
			<button class="btn btn-default"  type="button" name="back" onclick="history.back()">back</button>
		</div>
	</div>
	<br /><br />
	<div class ="row">
	  	<div class="col-sm-12">
			<p><b>We encountered a problem:</b></p>
			<br />
			<p>${ERROR_MESSAGE}</p>
		</div>
	</div>
	<br /><br />
<!-- LIST DUPES -->
	<c:if test="${not empty DUPLICATE_LIST }">
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-hover table-striped">
					<tbody>
						<tr>
							<th>Possible Duplicate Listing</th>
							<th>Rating</th>
							<th>View more</th>
						</tr>
						<c:forEach var="dupeListing" items="${DUPLICATE_LIST}">
<!-- Generate viewLink for each business -->
							<c:url var="viewLink" value="FriendlyControllerServlet">
								<c:param name="command" value="VIEW" />
								<c:param name="businessID" value="${dupeListing.id}" />
							</c:url>
<!-- Generate row for each business -->
							<tr>
								<td>
									<h4>${dupeListing.name}</h4>
									<p>${empty dupeListing.address ? '': dupeListing.address}${!empty dupeListing.address && !empty dupeListing.phone ? ' | ': ''}${String.valueOf(dupeListing.phone).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3")}</p>
								</td>
								<td>
								<c:choose>
									<c:when test="${dupeListing.rating == 0 }">
										<p>NOT RATED</p>
									</c:when>
									<c:otherwise>
										<c:forEach begin="1" end="${dupeListing.rating}">
					   						<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
										</c:forEach>
										<c:forEach begin="1" end="${5 - dupeListing.rating}">
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
	</c:if>
</div>
</body>
</html>