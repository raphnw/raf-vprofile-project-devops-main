<<<<<<< HEAD
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
=======
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
<<<<<<< HEAD
    <title>Sign Up</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="${contextPath}/resources/images/icons/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/fonts/iconic/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/vendor/animate/animate.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/vendor/css-hamburgers/hamburgers.min.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/vendor/animsition/css/animsition.min.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/vendor/select2/select2.min.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/vendor/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/util.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/main.css">
    <style>
        .navbar-custom {
            background: rgba(0, 0, 0, 0); /* Fully transparent */
            border: none;
            box-shadow: none; /* Remove any box shadow if present */
        }
        .navbar-custom .navbar-brand, .navbar-custom .navbar-nav > li > a {
            color: #fff;
        }
        .navbar-custom .navbar-nav > li > a:hover {
            color: #007bff;
        }
        .navbar-wrapper {
            position: absolute;
            width: 100%;
            top: 0;
            left: 0;
            z-index: 1000;
        }
        body {
            background-image: url('${contextPath}/resources/Images/bg-01.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        * {
            margin: 0px;
            padding: 0px;
            box-sizing: border-box;
            color:red;
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-custom navbar-expand-lg navbar-light">
        <a class="navbar-brand" href="${contextPath}/">HKH Infotech</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">

        </div>
    </nav>

    <div class="limiter">
        <div class="container-login100">
            <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
                <form:form modelAttribute="userForm" method="post" class="login100-form validate-form">
                    <span class="login100-form-title p-b-30">Sign Up</span>

                    <!-- Email field -->
                    <div class="wrap-input100 validate-input m-b-23" data-validate="Email is required">
                        <span class="label-input100">Email ID</span>
                        <form:input path="userEmail" class="input100" placeholder="Type your email id"/>
                        <form:errors path="userEmail" cssClass="error"/>
                        <span class="focus-input100" data-symbol="&#xf206;"></span>
                    </div>

                    <!-- Username field -->
                    <div class="wrap-input100 validate-input m-b-23" data-validate="Username is required">
                        <span class="label-input100">Username</span>
                        <form:input path="username" class="input100" placeholder="Type your username"/>
                        <form:errors path="username" cssClass="error"/>
                        <span class="focus-input100" data-symbol="&#xf206;"></span>
                    </div>

                    <!-- Password field -->
                    <div class="wrap-input100 validate-input m-b-23" data-validate="Password is required">
                        <span class="label-input100">Password</span>
                        <form:password path="password" class="input100" placeholder="Type your password"/>
                        <form:errors path="password" cssClass="error"/>
                        <span class="focus-input100" data-symbol="&#xf190;"></span>
                    </div>

                    <!-- Confirm Password field -->
                    <div class="wrap-input100 validate-input m-b-23" data-validate="Confirm password is required">
                        <span class="label-input100">Confirm Password</span>
                        <br>
                        <form:password path="passwordConfirm" class="input100" placeholder="Confirm your password"/>
                        <form:errors path="passwordConfirm" cssClass="error"/>
                        <span class="focus-input100" data-symbol="&#xf190;"></span>
                    </div>

                    <!-- Sign Up button -->
                    <div class="container-login100-form-btn">
                        <div class="wrap-login100-form-btn">
                            <div class="login100-form-bgbtn"></div>
                            <button class="login100-form-btn">Sign Up</button>
                        </div>
                    </div>

                    <!-- Login link -->
                    <div class="flex-col-c p-t-155">
                        <span class="txt1 p-b-17">Already have an account?</span>
                        <a href="${contextPath}" class="txt2">Login</a>
                    </div>
                </form:form>
            </div>
        </div>
    </div>

    <div id="dropDownSelect1"></div>

    <script src="${contextPath}/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
    <script src="${contextPath}/resources/vendor/animsition/js/animsition.min.js"></script>
    <script src="${contextPath}/resources/vendor/bootstrap/js/popper.js"></script>
    <script src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="${contextPath}/resources/vendor/select2/select2.min.js"></script>
    <script src="${contextPath}/resources/vendor/daterangepicker/moment.min.js"></script>
    <script src="${contextPath}/resources/vendor/daterangepicker/daterangepicker.js"></script>
    <script src="${contextPath}/resources/vendor/countdowntime/countdowntime.js"></script>
    <script src="${contextPath}/resources/js/main.js"></script>
=======
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SIGNUP</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/profile.css" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://bootswatch.com/cosmo/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
   </head>

<body>
<div class="mainbody container-fluid">
    <div class="row">
        <div class="navbar-wrapper">
            <div class="container-fluid">
                <div class="navbar navbar-custom navbar-static-top" role="navigation">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span><span
                                    class="icon-bar"></span><span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="${contextPath}/index" >VISUAL PATH</a>
                            <i class="brand_network"><small><small>VProfile</small></small></i>
                        </div>
                        <div class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                                <li><a href="#">TECHNOLOGIES</a></li>
                                <li><a href="#">ABOUT</a></li>
                                <li><a href="#">BLOG</a></li>
                            </ul>
                            <div class="navbar-collapse navbar-right collapse">
	                            <ul class="nav navbar-nav">
	                        	 <li><a href="${contextPath}/login">LOGIN</a></li>
	                        	 <li><a href="${contextPath}/registration">SIGN UP</a></li>
	                       	 	</ul>
                            </div>
                            
                         </div>
                         
                    </div>
                </div>
            </div>
 		</div>
	</div>
</div>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading" align="center">SIGN UP</h2>
        <img  class="logo" src="${contextPath}/resources/Images/visualpathlogo3.png" />
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="username" class="form-control" placeholder="Username"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="userEmail">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="userEmail" class="form-control" placeholder="Email Id"
                            autofocus="true"></form:input>
                <form:errors path="userEmail"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passwordConfirm" class="form-control"
                            placeholder="Confirm password"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-custom btn-lg  btn-block" type="submit">SIGN UP</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
</body>
</html>
