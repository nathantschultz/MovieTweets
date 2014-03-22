<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="author" content="Nathan Schultz & Damon White">

    <title>Mo Movie Tweets</title>
    <link href="style.css" rel="stylesheet">
    
 
 
 
 
 <script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    $(document).ready(function() {
        $('#country').change(function(event) {  
        var $country=$("select#country").val();
           $.get('ActionServlet',{countryname:$country},function(responseJson) {   
            var $select = $('#states');                           
               $select.find('option').remove();                          
               $.each(responseJson, function(key, value) {               
                   $('<option>').val(key).text(value).appendTo($select);      
                    });
            });
        });
    });          
</script>
 
 
 
    
    
</head>
<body>
    <div class="header">
        <div class="left">
            <form name="myform" action="http://www.mydomain.com/myformhandler.cgi" method="POST">
                <div id="movie" class="styled-select">
                    <select name="mydropdown">
                        <option selected="selected" disabled="disabled">Select a Movie</option>
                        <option value="robocop">Robocop</option>
                        <option value="the secret life of walter mitty">The Secret Life of Walter Mitty</option>
                        <option value="gravity">Gravity</option>
                    </select>
                </div>
            </form>
        </div>
        <div class="title">
          <h1>Mo Movie</h1>
          <h1>Tweets</h1>
          <h2>REVIEWS BY MORMONS FOR MORMONS</h2>
        </div>
    </div>
    <div class="content">
        <h1 id="welcome">Welcome!</h1>

    
    
    
    
    
    
Select Country:
<select id="country">
<option>Select Country</option>
<option value="India">India</option>
<option value="US">US</option>
</select>
<br/>
<br/>
Select State:
<select id="states">
<option>Select State</option>
</select>
    
    
    
    
    
    
    
    
    
    
    
    
    </div>
</body>
</html>