<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<title></title>
<%@ include file="headlink.jsp"%>
<script src="js/basic.js"></script>
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>

<style>
.navbar {
	-webkit-box-shadow: 0 8px 6px -6px #999;
	-moz-box-shadow: 0 8px 6px -6px #999;
	box-shadow: 0 8px 6px -3px rgb(220, 220, 220);
}

.item-text {
	font-size: 27px;
	margin-left: 40px;
}

.subtext {
	font-size: 18px;
	margin-left: 40px;
	margin-top: 3px;
	margin-bottom: 2px;
}

.roundedc {
	border-radius: 15px;
}

.btn-success {
	margin-left: 40px;
	margin-top: 12px;
	padding: 12px 30px;
}
.nav-item{
	padding:10px;
}


</style>

</head>
<body>
	<nav class="navbar py-2 navbar-expand-sm navbar-light bg-white mb-3">
		<div class="container">
			<a class="navbar-brand" href="/admindashboard"> <img
				src="https://i.ibb.co/zfMbw3Y/insurance.png" alt=""
				style="height: 50px;">
			</a> <a class="navbar-brand display-4" href="/admindashboard">Patient
				Management</a>
			<button class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarNav">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a
						class="nav-link btn btn-outline-success text-success"
						href="/admindashboard">Home</a></li>
					<li class="nav-item"><a
						class="nav-link btn btn-outline-success text-success"
						href="/logout">Log Out</a></li>

				</ul>
			</div>
		</div>
	</nav>







	<div class="container text-center pt-5 pb-3">
		<div class="row align-items-center">
			<div class="col-md-4 ">
				<hr style="border: 1px solid rgb(80, 80, 80);">
			</div>
			<div class="col-12 col-md-4">
				<p class="display-4" style="font-size: 50px;">Claim Insurance</p>
			</div>
			<div class="col-md-4">
				<hr style="border: 1px solid rgb(80, 80, 80);">
			</div>
		</div>

	</div>


	<div class="container-fluid">
		<div class="col">
			<div class="row">

				<c:forEach items="${insurers}" var="i">
					<div class="col-md-6 my-3">
						<div class="container bg-white shadow-lg roundedc">

							<div class="d-flex align-items-center py-3 px-2">
								<img class="img-fluid "
									src="https://i.ibb.co/6FrDHb5/bg-insurance.png" alt=""
									style="height: 210px;">
								<div>
									<div class="item-text">Insurer name : ${i.insurerName}</div>
									<div class="subtext">Package Name :
										${i.insurerPackageName}</div>
									<div class="subtext">Insurance Amount Limit :
										${i.insuranceAmountLimit}</div>
									<div class="subtext">Disbursement Duration :
										${i.disbursementDuration}</div>
									<form method="post" action="/initiateClaim">
										<input type="hidden" id="pckgName" name="pckgName"
											value="${i.insurerPackageName}"> <input type="hidden"
											id="ptId" name="ptId" value="<%=request.getParameter("id")%>">
										<button class="btn btn-success" name="submit" type="submit"
											id="submit">Initiate Claim</button>
									</form>

								</div>
							</div>

						</div>
					</div>
				</c:forEach>

			</div>

		</div>
	</div>




	<div style="margin-top: 200px;"></div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>


</body>
</html>