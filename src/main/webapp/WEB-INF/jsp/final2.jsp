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

        .navbar {
            -webkit-box-shadow: 0 8px 6px -6px #999;
            -moz-box-shadow: 0 8px 6px -6px #999;
            box-shadow: 0 8px 6px -3px rgb(220, 220, 220);
        }

        .item-text {
            font-size: 30px;
            margin-left: 30px;
            margin-bottom: 21px;
        }

        .subtext {
            font-size: 21px;
            margin-left: 30px;
            margin-top: 7px;
            margin-bottom: 7px;
        }

        span {
            font-size: 21px;
            font-weight: 600;
            margin-right: 100px;
        }

        .roundedc {
            border-radius: 15px;
        }

        hr {

            border: 1px solid rgb(167, 167, 167);
            margin-left: 20px;
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
                    <li class="nav-item">
                        <a class="nav-link btn btn-outline-success text-success" href="/logout">Log Out</a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>





    <div class="container pt-5">

        <div class="col-12 my-5">
            <div class="container bg-white shadow-lg roundedc">
               
                <div class=" row d-flex align-items-center py-5 px-2">
                    <img class="col-md-4" src="https://i.ibb.co/CJXb8Jy/savings.png" alt="">
                    <div class="col-md-8 container">
                        <div class="item-text">Order Summary : </div>
                        <div class="subtext"><span> Total Cost :</span> ₹ ${total} </div>
                        <div class="subtext"><span> Insurance :</span> ₹ ${InsurAmt} </div>
                        <hr />
                        <div class="subtext"><span> To be Paid :</span> ₹ ${Outstanding} </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="text-center">
            <a class="btn btn-success btn-lg text-white" href="/admindashboard"> Go To Home</a>
        </div>

    </div>




    <div style="margin-top:500px;"></div>
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