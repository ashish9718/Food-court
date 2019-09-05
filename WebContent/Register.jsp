<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Register V3</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="login register resources/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login register resources/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login register resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login register resources/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login register resources/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="login register resources/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login register resources/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login register resources/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="login register resources/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login register resources/css/util.css">
	<link rel="stylesheet" type="text/css" href="login register resources/css/main.css">
<!--===============================================================================================-->
</head>
<body>

	<div class="limiter">
		<div class="container-login100" style="background-image: url('resources/images/slide_2.jpg');">
			<div class="wrap-login100">
				<form class="login100-form validate-form" action="UserController" method="get">
				<input type="hidden" name="action" value="insert">
					<span class="login100-form-logo">
						<i class="zmdi zmdi-landscape"></i>
					</span>
					${msg }
	

					<span class="login100-form-title p-b-34 p-t-27">
						Register
					</span>
					
					
					<div class="wrap-input100 validate-input" data-validate = "First Name">
						<input class="input100" type="text" name="firstname" placeholder="First Name">
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Last Name">
						<input class="input100" type="text" name="lastname" placeholder="Last Name">
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>
					
					
					<div class="wrap-input100 validate-input" data-validate = "Gender">
						<input class="input100" type="text" name="gender" placeholder="Gender">
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>
					
					
					<div class="wrap-input100 validate-input" data-validate = "D.O.B">
						<input class="input100" type="Date" name="dob" placeholder="D.O.B">
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Address">
						<input class="input100" type="text" name="address" placeholder="Address">
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "User Type">
						<input class="input100" type="text" name="usertype" placeholder="User Type">
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Enter username">
						<input class="input100" type="text" name="username" placeholder="Username">
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<input class="input100" type="password" name="password" placeholder="Password">
						<span class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>

					<div class="contact100-form-checkbox">
						<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
						<label class="label-checkbox100" for="ckb1">
							Remember me
						</label>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Register
						</button>
					</div>

				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="login register resources/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="login register resources/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="login register resources/vendor/bootstrap/js/popper.js"></script>
	<script src="login register resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="login register resources/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="login register resources/vendor/daterangepicker/moment.min.js"></script>
	<script src="login register resources/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="login register resources/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="login register resources/js/main.js"></script>
<a href="index.jsp">go back</a>
</body>
</html>