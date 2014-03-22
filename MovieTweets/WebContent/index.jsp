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
        $('#movies').change(function(event) {  
        var $movie=$("select#movies").val();
           $.get('ActionServlet',{moviename:$movie},function(responseJson) {   
            var $select = $('#tweets');                           
               $select.find('li').remove();
            var $welcome = $('#welcome2');
            	$welcome.find('h1').remove();
               $.each(responseJson, function(key, value) {               
                   $('<li>').val(key).text(value).appendTo($select);      
                    });
            });
        });
    });          
</script>
 
 
 
    
    
</head>
<body>
    <div class="header">
        <div class="left">
            <form name="myform" action="" method="POST">
                <div class="styled-select">
                    <select id="movies" name="mydropdown">
                        <option selected="selected" disabled="disabled">Select a Movie</option>
                        <option value="robocop">Robocop</option>
                        <option value="secret">The Secret Life of Walter Mitty</option>
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
        <span id="welcome2"><h1 id="welcome">Welcome!</h1></span>

    

<br/>
<ul id="tweets">
</ul>
    
    
    </div>
</body>
</html>