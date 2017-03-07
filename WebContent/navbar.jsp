<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="row">
	<div class="col-sm-12">
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container-fluid">
<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
		      		<a class="navbar-brand" href="${pageContext.request.contextPath}/">Kid Friendly STL</a>
		    	</div>
<!-- Nav links, forms, and other content for toggling -->
				<c:choose>
					<c:when test="${!empty USER}">
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<c:choose>
								<c:when test="${USER.administrator == true}">
										<ul class="nav navbar-nav">
											<li><a href="form.jsp">Add New Listing</a></li>
											<c:if test="${!empty THE_BUSINESS}">
												<c:url var="updateLink" value="FriendlyControllerServlet">
													<c:param name="command" value="LOAD" />
													<c:param name="businessID" value="${THE_BUSINESS.id}" />
												</c:url>
												<li><a href="${updateLink}">Update ${THE_BUSINESS.name}</a></li>
												<c:url var="deleteLink" value="FriendlyControllerServlet">
													<c:param name="command" value="DELETE" />
													<c:param name="businessID" value="${THE_BUSINESS.id}" />
												</c:url>
												<li><a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this business?'))) return false">Delete ${THE_BUSINESS.name}</a></li>
											</c:if>
										</ul>
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose>
			        		<div class="navbar-right">
								<p class="navbar-text">Signed in as <a href="profile.jsp" class="navbar-link">${USER.email}</a></p>
								<c:url var="logoutLink" value="LoginServlet">
									<c:param name="command" value="LOGOUT" />
									<c:param name="userEmail" value="${USER.email}" />
								</c:url>
								<a class="btn btn-default navbar-btn" href="${logoutLink}" role="button" onclick="if (!(confirm('Are you sure you want to logout?'))) return false">Logout</a>
							</div>
				    	</div>
					</c:when>
					<c:otherwise>
				    	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			        		<div class="navbar-right">
								<a class="btn btn-default navbar-btn" href="login.jsp" role="button">Sign in</a>
							</div>
				    	</div>
					</c:otherwise>
				</c:choose>
		  	</div>
		</nav>
	</div>
</div>
