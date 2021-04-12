<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

        .form-control {
            background-color: rgb(249, 249, 249);
        }


        .img-fluid {
            margin-bottom: 120px;
            margin-left: 30px;
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
        <div class="row align-items-center">
            <div class="col-12 col-md-6 col-sm-12">
                <img class="img-fluid mr-5" src="https://i.ibb.co/Fsj1Wk3/drbgg.png" alt="">
            </div>
            <div class="col-12 col-md-6 col-sm-12 pt-5 pr-5">
                <p class="display-4 text-success"> Patient Registration :</p>
                <p class="pb-3">To Get Treatment Schedule, You Have to Go Through Registration First : </p>
                <div class="container bg-white shadow-lg roundedc ">
                    <div class="align-items-center py-5 ">
                        <form id="contact" action="/registerSubmit" model="patient"  method="post">
                            <div class="form-group pt-1 px-5">
                                <label for="name">Name</label>
                                <input class="form-control" style="height: 50px;" name="name" type="text" required
                                    placeholder="Enter name" required>
                            </div>
                            <div class="form-group pt-1 px-5">
                                <label for="age">Age</label>
                                <input class="form-control" style="height: 50px;" min="1" max="120" name="age"
                                    placeholder="Age" type="number" required placeholder="Enter Age" required>
                            </div>
                            <div class="form-group pt-1 px-5">
                                <label for="treatmentPackageName">Package Name</label>
                                <input class="form-control" style="height: 50px;" value="${ pack }"
                                    name="treatmentPackageName" type="text" required="true" readonly
                                    placeholder="Enter package" required>
                            </div>
                            <div class="form-group pt-1 px-5">
                                <label for="ailment">Ailment</label>
                                <input class="form-control" style="height: 50px;" value="${ ailment }" name="ailment"
                                    type="text" required="true" readonly placeholder="Ailment" required>
                            </div>
                            <div class="form-group pt-1 px-5">
                                <label for="cost">Cost</label>
                                <input class="form-control" style="height: 50px;" type="text" id="cost" name="cost"
                                    value="${cost}" readonly placeholder="Enter cost" required>
                            </div>

                            <button class="btn btn-success btn-lg px-5 ml-5 mt-3" name="submit" type="submit"
                                id="contact-submit" data-submit="...Sending">Submit</button>
                        </form>
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