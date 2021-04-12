<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!doctype html>
<html lang="en">
	<head>
		<title></title>
		<%@ include file="headlink.jsp"%>
		<script src="js/basic.js"></script>
		
		<style>
        .grabg {
            background-image: url('https://i.ibb.co/qxypVrG/grabg.png');
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }

        .navbar {
            -webkit-box-shadow: 0 8px 6px -6px #999;
            -moz-box-shadow: 0 8px 6px -6px #999;
            box-shadow: 0 8px 6px -3px rgb(220, 220, 220);
        }

        .subtext {
            font-size: 19px;
            margin-left: 0px;
        }

        span {
            font-size: 19px;
            font-weight: 600;
            margin-right: 6px;
        }

        .roundedc {
            border-radius: 15px;
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



    <div class="container text-center pt-5">
        <div class="row align-items-center">
            <div class="col-md-4 ">
                <hr style="border: 1px solid rgb(80, 80, 80);">
            </div>
            <div class="col-12 col-md-4">
                <p class="display-4"> Treatment Plan </p>
            </div>
            <div class="col-md-4">
                <hr style="border: 1px solid rgb(80, 80, 80);">
            </div>
        </div>

    </div>

    <div class="container-fluid  my-5">
        <div class="col">
        
        <c:forEach items="${patient}" var="plan">
				  <c:set var="count" value="${count + 1}" scope="page" />				
				  
				    <div class="row">
                <div class="col-12 pr-4 my-3">
                    <div class="container-fluid bg-white shadow-lg roundedc">
                            <div class="d-flex align-items-center py-3 px-2">
                                <div class="grabg" style="height: 120px; width: 120px;">
                                    <p class="display-4 d-flex align-items-center justify-content-center text-white"
                                        style="height: 120px;"> <strong>${count}</strong> </p>
                                </div>
                                <div class="col pt-1 pl-5 ">

                                    <div class="row my-3">
                                        <div class="col-md-3">
                                            <div class="subtext"><span> Name :</span> ${plan.ptDetail.name} </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="subtext"><span> Test Details :</span> ${plan.testDetails} </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="subtext"><span> Package :</span> ${plan.packageName} </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="subtext"><span> Specialist :</span> ${plan.specialist} </div>
                                        </div>
                                    </div>
                                    <div class="row my-3">
                                        <div class="col-md-3">
                                            <div class="subtext"><span> Cost :</span> ${plan.cost} </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="subtext"><span> Start date :</span>
                                                ${plan.treatmentCommencementDate} </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="subtext"><span> End date :</span> ${plan.treatmentEndDate}
                                            </div>
                                        </div>
                                         <div class="col-md-3">
                                            <div class="subtext"><span> Status :</span> <a href='/claimInsurance?id=<c:out value="${plan.ptDetail.id}"></c:out>'> ${plan.status} </a> </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                      
                    </div>
                </div>

            </div>
		</c:forEach>

           



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