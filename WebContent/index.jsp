<%@page import="walexFab.DatabaseConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>Walexfabrics</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrap.css"/>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/bootstrap.min.js"></script>
 
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
	box-sizing: border-box;
}

.background{
    width:100%;        
    display: flex;
	margin-top: -10px;
}

.walexImage{

	display: inline-block;
	background-image: url("Images/best1.png");
	background-repeat: no-repeat;
	background-size: contain;
	width: 50%;
	height: 500px;
	margin-left: 100px;
    opacity: 1;
}

.Walextext{
	display: inline-block;
	 width : 50%;
	font-family: Sitka small;
	justify-content: space-between;
	padding: 10px;
	padding-top: 150px;
	width: 50%;
}

.Walextext h2 {
	font-size: 20px;
}

.submit {
	background: orange;
	width: 80%;
	color: #ffffff;
	height: 45px;
	font-size: 16px;
	margin-top: 10px;
	margin-left: 30px; font-family : Sitka Small;
	border: none;
	border-radius: 10px;
	font-family: Sitka Small;
}

.vid {
	display: inline-block;
	height: 300px;
	width: 100%;
	align-content: center;
	align-items: center;
	text-align: center;
	justify-content: space-between;
	margin-top: 100px;
}

.new_arrival {
	margin-right: auto;
	margin-left: auto;
	height: auto;
	width: 90%;
}

.product-top {
	width: 200px;
	height: 100px;
	float: left;
}

.middle {
	transition: .5s ease;
	opacity: 0;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	-ms-transform: translate(-50%, -50%)
}

.text {
	background-color: #4CAF50;
	color: white;
	font-size: 16px;
	padding: 16px 32px;
}

.product-top img {
	width: 100%;
	position: relative;
	height: 350px;
	opacity: 1;
}

.overlay-div {
	display: block;
	opacity: 100;
	position: absolute;
	top: 0%;
	margin-left: 0;
	width: 80px;
	background-color: orange;
}

.overlay-div h4 {
	color: white;
	font-size: 20px;
	margin-left: 10px;
	font-family: Lucida fax;
	text-align: center;
}

.dd {
	display: flex;
	width: 100%;
}

.bb {
	width: 300px;
	margin: 10px;
	display: block;
	text-align: center;
	height: 75px;
	font-size: 30px;
}

 @media(max-width:980px) {
	.background {
		display: block;
	}
	.walexImage {
		background-image: url("Images/best1.png");
		width: 100%;
		background-size: cover;
		margin-left: 0px;
	}
	.Walextext {
	margin-top:-100px;
	width: 100%;
	}
}
</style>
</head>
<body>
<jsp:include page="header_ui.jsp"></jsp:include>
<div class="background">
<div class= "walexImage"></div>
<div class="Walextext">
<h2>Walexfabrics give's you a nice material lace and designs. We make sure to delivery every good's and items you bought to your 
door steps. Place your Order's  and choose home delivery with your phone number. OR   You can visit
 our shopping center at 1st floor 34 tejuosho st,surulere Opp access bank.</h2>
<a href="shopall.jsp"><input type="submit" value="Shop" class="submit" ></input></a>
</div>
</div>

<div   class="vid">			
<video    autoplay loop="loop"   muted  class="sizing"    width="400"  height="350"    >    
<SOURCE src="videos/c1.mp4"    type="video/mp4"   />
</video>
            		           
<video      autoplay   loop="loop" muted  class="sizing"  width="400"  height="350">    
<SOURCE src="videos/c2.mp4"    type="video/mp4"/>
</video>
            
<video      autoplay  loop="loop"  muted  class="sizing"  width="400"  height="350">    
<SOURCE src="videos/c3.mp4"    type="video/mp4"/>
</video>
</div>



<jsp:include page="in.jsp"></jsp:include>
<jsp:include page="Footer.jsp"></jsp:include>



   
                    
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>




