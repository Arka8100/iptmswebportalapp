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

        span {
            font-size: 21px;
            font-weight: 600;
            margin-right: 15px;
        }

        .subtext {
            font-size: 21px;
            margin-left: 50px;
            margin-top: 6px;
        }

        .roundedc {
            border-radius: 15px;
        }

        .imgbg {
            margin-bottom: 120px;
            margin-left: 20px;
            margin-top: 10px;
        }

        .btn-success {
            margin-left: 60px;
            margin-top: 24px;
            padding-left: 90px;
            padding-right: 90px;
        }
        .nav-item{
			padding:10px;
		}
    </style>
     
		
	</head>
	<body>
		 <nav class="navbar py-2 navbar-expand-sm navbar-light bg-white mb-3">
        <div class="container">
            <a class="navbar-brand" href="/admindashboard">
                <img src="https://i.ibb.co/zfMbw3Y/insurance.png" alt="" style="height: 50px;">
            </a>
            <a class="navbar-brand display-4" href="/admindashboard">Patient Management</a>
            <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                	<li class="nav-item"><a
						class="nav-link btn btn-outline-success text-success"
						href="/admindashboard">Home</a></li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-outline-success text-success" href="/logout">Log Out</a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>




    <div class="container-fluid">
        <div class="row ">
            <div class="col-12 col-md-6 col-sm-12">
                <img class="img-fluid imgbg p-5" src="https://i.ibb.co/3YC88Kj/donebg.png" alt="">
            </div>
            <div class="col-12 col-md-6 col-sm-12 mt-5 pr-5">
                <p class="display-4 text-success"> Registration Success :</p>
                <p class="pb-3">Below are The Details of The Registered Patient : </p>
                <div class="container bg-white shadow-lg roundedc ">
                    <div class="d-flex align-items-center pl-4 py-5">
                        <img class="img-fluid " src="https://i.ibb.co/QfMv4XG/round-patient.png" alt=""
                            style="height: 210px;">
                        <div>
                            <div class="subtext"><span> Name :</span> ${plan.ptDetail.name} </div>
                            <div class="subtext"><span>Test Details :</span> ${plan.testDetails} </div>
                            <div class="subtext"><span>Package :</span> ${plan.packageName}</div>
                            <div class="subtext"><span>Specialist :</span> ${plan.specialist}</div>
                            <div class="subtext"><span>Cost :</span> ${plan.cost}</div>
                            <div class="subtext"><span>Start Date :</span> ${plan.treatmentCommencementDate}</div>
                            <div class="subtext"><span>End Date :</span> ${plan.treatmentEndDate}</div>
                            <div class="subtext"><span>Status :</span> Registered Successfully</div>
                             <a class="btn btn-success " href="/patients"> Start Treatment </a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>






    <div style="margin-top:200px;"></div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
        integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>
		
	</body>
</html>