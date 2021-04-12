 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!doctype html>
<html lang="en">
	<head>
		<title></title>
		<%@ include file="headlink.jsp"%>
		
		<script src="js/basic.js"></script>
		<style>
        body {
           
            background-image: url('https://image.freepik.com/free-photo/overhead-view-doctor-s-desk-with-pills-office-supplies_23-2148213958.jpg');
            height: 100vh;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }

        .thumbnail {
            background-image: url('https://i.ibb.co/Krn9ZWy/doctor.png');
            height: 500px;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }



        label {
            font-size: 24px;
        }

        .form-control {
            background-color: rgb(244, 244, 244);
        }
    </style>
	</head>
	<body>
	<div class="container-fluid d-flex justify-content-center align-items-center"
        style="background-color: rgba(0, 0, 0, 0.3); height: 100vh;">

        <div class="container">
            <div class="row shadow">
                <div class="col-md-4 d-flex align-items-center bg-success thumbnail">

                </div>
                <div class="col-md-8 bg-white" style="height: 500px;">
                    <p class="display-4 pl-5 pt-5">Log In</p>
                    <form action="/login" model="user" method="post">
                        <div class="form-group pt-3 px-5">
                            <label for="name">Name</label>
                            <input class="form-control" style="height: 50px;" name="userid" type="text" id="name"
                                placeholder="Enter name" required>
                        </div>
                        <div class="form-group pt-2 px-5">
                            <label for="password">Password</label>
                            <input class="form-control" style="height: 50px;" name="upassword" type="password"
                                id="password" placeholder="Password" required>
                        </div>

                        <button class="btn btn-success btn-lg px-5 ml-5 mt-3" type="submit"
                            id="contact-submit">Submit</button>
                    </form>
                </div>
            </div>

        </div>

    </div>
		
	</body>
</html>


<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>IPTMS</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />

<link rel="stylesheet" type="text/css" href="css/basic.css">

</head>
<body>

	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('https://image.shutterstock.com/image-vector/male-patient-lying-on-bed-260nw-1767929627.jpg');">
			<div class="wrap-login100 p-t-190 p-b-30">
				<form   action="/login" model="user"  method="post" class="login100-form validate-form" >
					<div class="login100-form-avatar">
						<img src="images/logo.webp" alt="AVATAR">
					</div>

					<span class="login100-form-title p-t-30 p-b-55"> <strong>International
							Patient Management System</strong>
					</span>

					<div class="wrap-input100 validate-input m-b-10"
						style="margin: 4; padding: 4" data-validate="Username is required">
						<input class="input100" type="text" name="userid"
							placeholder="Username"> <span class="focus-input100"></span>
						<span class="symbol-input100"> <i class="fa fa-user"></i>
						</span>
					</div>
					

					<div class="wrap-input100 validate-input m-b-10"
						style="margin: 4; padding: 4" data-validate="Password is required">
						<input class="input100" type="password" name="upassword"
							placeholder="Password"> <span class="focus-input100"></span>
						<span class="symbol-input100"> <i class="fa fa-lock"></i>
						</span>
					</div>
					

					<div class="container-login100-form-btn p-t-10" id="contact-submit">
						<button class="login100-form-btn">
							<strong>Login</strong>
						</button>
					</div>

				</form>
			</div>
		</div>
	</div>

	<!--===============================================================================================-->
	<script src="js/basic.js"></script>

</body>
</html>


 --%>

x
