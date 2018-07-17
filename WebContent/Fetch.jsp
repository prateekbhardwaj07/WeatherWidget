<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fetch Page</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="weather.js"></script>
</head>
<body>
<div class="container-fluid">
<center>
<h3>This page uses Javascript to fetch weather Information.<br>Server Code is done using Java.</h3>
</center>
</div>
<div class="row">
<div class="col-sm-3 col-md-4 col-lg-6"><p>This is first block</p></div>
<div class="col-sm-9 col-md-8 col-lg-6">
<div id="responseData"></div>
</div>
</div>
<div class="row"></div>
<div class="row"></div>
</body>
</html>