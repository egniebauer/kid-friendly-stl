<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css"  rel="stylesheet" href="css/bootstrap-theme.min.css" /><link type="text/css"  rel="stylesheet" href="css/bootstrap-theme.min.css.map" /><link type="text/css"  rel="stylesheet" href="css/bootstrap.min.css" /><link type="text/css"  rel="stylesheet" href="css/bootstrap.min.css.map" />	<link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css" />
	<script src="js/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script>
		$(document).ready(function(){
		    $('#resultsTable').DataTable();
		});
	</script>
	<title>Kid Friendly STL</title>
</head>
<body>
	<div class="container">
<!-- PAGE HEADING -->
		<div class="row">
			<div class="col-sm-6">
				<h1>Kid Friendly STL</h1>
			</div>
			<div class="col-sm-6 text-right">
				<h1><a class="btn btn-primary btn-lg" href="form.jsp" role="button">Add New Listing</a></h1>
			</div>
		</div>
	<br /><br /><br />
<!-- RESULTS TABLE -->
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-hover table-striped" id="resultsTable">
					<thead>
						<tr>
							<th></th>
							<th>Business</th>
							<th>Categories</th>
							<th>Age Ranges</th>
							<th>Rating</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="currentBusiness" items="${BUSINESS_LIST}" >
							<c:url var="viewLink" value="FriendlyControllerServlet">
								<c:param name="command" value="VIEW" />
								<c:param name="businessID" value="${currentBusiness.id}" />
							</c:url>
							<tr>
								<td>
									<a class="btn btn-default" href="${viewLink}" role="button">View more</a>
								</td>
								<td>
									<address>
										<strong>${currentBusiness.name}</strong><br />
										${empty currentBusiness.address ? '': currentBusiness.address}${!empty currentBusiness.address && !empty currentBusiness.phone ? ' | ': ''}${!empty currentBusiness.phone ? String.valueOf(currentBusiness.phone).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3") : ''}
									</address>
								</td>
								<td>
									<c:forEach var="currentCategory" items="${CATEGORY_LIST}">
										<c:if test="${currentCategory.businessID == currentBusiness.id}">
											<ul class="list-unstyled">
												<li>${currentCategory.activeLife == true ? 'Active Life' : ''}</li>
												<li>${currentCategory.artsEntertainment == true ? 'Arts & Entertainment' : ''}</li>
												<li>${currentCategory.education == true ? 'Education' : ''}</li>
												<li>${currentCategory.foodRestaurant == true ? 'Food & Restaurants' : ''}</li>
												<li>${currentCategory.healthMedical == true ? 'Health/ Medical' : ''}</li>
												<li>${currentCategory.hotelTravel == true ? 'Hotels & Travel' : ''}</li>
												<li>${currentCategory.publicServiceGovernment == true ? 'Public Services/ Government' : ''}</li>
												<li>${currentCategory.religious == true ? 'Religious' : ''}</li>
												<li>${currentCategory.shopping == true ? 'Shopping' : ''}</li>
											</ul>
										</c:if>
									</c:forEach>
								</td>
								<td>
									<c:forEach var="currentAgeRange" items="${AGE_RANGE_LIST}">
										<c:if test="${currentAgeRange.businessID == currentBusiness.id}">
											<ul class="list-unstyled">
												<li>${currentAgeRange.baby == true ? 'Baby' : ''}</li>
												<li>${currentAgeRange.toddler == true ? 'Toddler' : ''}</li>
												<li>${currentAgeRange.preschooler == true ? 'Preschooler' : ''}</li>
												<li>${currentAgeRange.gradeSchooler == true ? 'Grade Schooler' : ''}</li>
												<li>${currentAgeRange.teen == true ? 'Teen' : ''}</li>
											</ul>
										</c:if>
									</c:forEach>
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
							</tr>
						</c:forEach>
					</tbody>	
				</table>
				<br /><br /><br />
			</div>
		</div>
	</div>	
</body>
</html>