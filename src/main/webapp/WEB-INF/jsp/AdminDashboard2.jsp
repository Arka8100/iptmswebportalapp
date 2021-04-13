

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<%@ include file="headlink.jsp"%>

<script src="js/basic.js"></script>

<style>
.navbar {
	-webkit-box-shadow: 0 8px 6px -6px #999;
	-moz-box-shadow: 0 8px 6px -6px #999;
	box-shadow: 0 8px 6px -3px rgb(220, 220, 220);
}

.item-text {
	font-size: 30px;
	margin-left: 50px;
}

.subtext {
	font-size: 21px;
	margin-left: 50px;
}

.roundedc {
	border-radius: 15px;
}

a, a:hover {
	text-decoration: none;
	color: rgb(34, 34, 34);
}
.nav-item {
	padding:10px;
}

</style>

</head>
<body>
	<nav class="navbar py-2 navbar-expand-sm navbar-light bg-white mb-3">
		<div class="container">
			<a class="navbar-brand" href="#"> <img
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
						href="/logout">Log Out</a></li>
				</ul>

			</div>
		</div>
	</nav>




	<div class="container-fluid">
		<div class="row">
			<div class="col-12 col-md-6 col-sm-12">
				<img class="img-fluid pl-md-5"
					src="https://i.ibb.co/37QQ6VL/undraw-medicine-b1ol.png" alt="">
			</div>
			<div class="col-12 col-md-6 col-sm-12 pt-5 pr-5">
				<p class="display-2 text-success">Welcome</p>
				<p style="font-size: 30px;">To International Patient Management
					System</p>
				<p>A leading hospital wants to bring up a web application to list and choose the treatment
packages for International patients, register them, track their treatment to closure thru insurance
claim</p>
			</div>
		</div>
	</div>


	<div class="container text-center pt-5">
		<div class="row align-items-center">
			<div class="col-md-4 ">
				<hr style="border: 1px solid rgb(80, 80, 80);">
			</div>
			<div class="col-12 col-md-4">
				<p class="display-4">Menu Items</p>
			</div>
			<div class="col-md-4">
				<hr style="border: 1px solid rgb(80, 80, 80);">
			</div>
		</div>

	</div>

	<div class="container-fluid px-5 my-5">
		<div class="col">

			<div class="row">
				<div class="col-md-6 pr-4 my-3">
					<div class="container bg-white shadow-lg roundedc">
						<a href="/specialist">
							<div class="d-flex align-items-center py-3 px-2">
								<img class="img-fluid "
									src="https://i.ibb.co/xzJpkB6/doctor.png" alt=""
									style="height: 145px;">
								<div>
									<div class="item-text">View Specialists</div>
									<div class="subtext">Click here to view all the Doctors.</div>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-6 pl-4 my-3">
					<div class="container bg-white shadow-lg roundedc">
						<a href="/packages">
							<div class="d-flex align-items-center py-3 px-2">
								<img class="img-fluid "
									src="https://i.ibb.co/Zdn2y7W/treatments.png" alt=""
									style="height: 145px;">
								<div>
									<div class="item-text">View Treatments</div>
									<div class="subtext">Click here to view all the
										treatments available.</div>
								</div>
							</div>
						</a>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-md-6 pr-4 my-3">
					<div class="container bg-white shadow-lg roundedc">
						<a href="/patients">
							<div class="d-flex align-items-center py-3 px-2">
								<img class="img-fluid "
									src="https://i.ibb.co/X22ZSmk/patient.png" alt=""
									style="height: 145px;">
								<div>
									<div class="item-text">View Patients</div>
									<div class="subtext">Click here to view all the patients.</div>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-6 pl-4 my-3">
					<div class="container bg-white shadow-lg roundedc">
						<a href="/insurer">
							<div class="d-flex align-items-center py-3 px-2">
								<img class="img-fluid "
									src="https://i.ibb.co/bJYbM9B/insurance.png" alt=""
									style="height: 145px;">
								<div>
									<div class="item-text">View Insurance Provider</div>
									<div class="subtext">Click here to view all the insurance
										provider.</div>
								</div>
							</div>
						</a>
					</div>
				</div>

			</div>

			<div class="row">
				<div class="col-md-6 pr-4 my-3">
					<div class="container bg-white shadow-lg roundedc">
						<a href="/ongoingTreatments">
							<div class="d-flex align-items-center py-3 px-2">
								<img class="img-fluid " src="https://i.ibb.co/s2LZsyL/edit.png"
									alt="" style="height: 145px;">
								<div>
									<div class="item-text">Edit Treatment Plan</div>
									<div class="subtext">Click here to edit treatment plan.</div>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-6 pl-4 my-3">
					<div class="container bg-white shadow-lg roundedc">
						<a href="/ongoingTreatmentsnew">
							<div class="d-flex align-items-center py-3 px-2">
								<img class="img-fluid "
									src="https://i.ibb.co/bmrcDKV/view-all.png" alt=""
									style="height: 145px;">
								<div>
									<div class="item-text">View All Plans</div>
									<div class="subtext">Click here to view all the Plans.</div>
								</div>
							</div>
						</a>
					</div>
				</div>
			</div>

		</div>


	</div>



	<div style="margin-top: 500px;"></div>
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
