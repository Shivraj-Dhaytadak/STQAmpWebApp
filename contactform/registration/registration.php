

<?php 

include('config.php');
>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Registration Form</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
  <link rel="stylesheet" href="styles.css">
</head>
<body>

<div class="wrapper">
  <div class="title">
    Admin Registration
  </div>
  <div class="social_media">
    <div class="item">
      <i class="fab fa-facebook-f"></i>
    </div>
    <div class="item">
      <i class="fab fa-twitter"></i>
    </div>
    <div class="item">
      <i class="fab fa-google-plus-g"></i>
    </div>
  </div>
  
  <div class="form">
    <div class="input_field">
      <input type="text" placeholder="Name" class="input">
      <i class="fas fa-user"></i>
    </div>
    <div class="input_field">
      <input type="text" placeholder="Email" class="input">
      <i class="far fa-envelope"></i>
    </div>
    <div class="input_field">
      <input type="password" placeholder="Password" class="input">
      <i class="fas fa-lock"></i>
    </div>
    <div class="btn">
      <a href="#">Register</a>
    </div>
    
  </div>
</div>	
	
</body>
</html>