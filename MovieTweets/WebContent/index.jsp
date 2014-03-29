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
         var url     = "http://data.tmsapi.com/v1/movies/showings";
         var apikey  = "regehcgurp4f3uhzrtej3f3b";
         var d       = new Date();
         var today   = d.getFullYear() + '-' + (d.getMonth()+1) + '-' + d.getDate();         
         var zipCode = "83440";
         var radius  = "10";

         $(document).ready(function() {
          
           // send off the query
           $.ajax({
            url: url,
                data: { 
                	api_key:   apikey,
                	startDate: today,
                    zip:       zipCode,
                	radius:    radius,
                    jsonp:     "dataHandler"
                   },          
            dataType: "jsonp",
           });
         });
             
       
         // callback to handle the results
         function dataHandler(data) {
          var movies = data.hits;
          var movieData = '<select class="movies" name="mydropdown">';
          
          //goes through each movie in the list
          $.each(data, function(index, movie) {
        	  
        	//this is the title of the movie
            movieData += '<option value="' + movie.title + '">' + movie.title;
            
            //this gets the rating and puts it into the movieData
            if (movie.ratings) { movieData += ' (' + movie.ratings[0].code + ') </option>'};
          });
          movieData += '</select>';
          
          //movieData is the thing that is going in, and it goes to the class "this"
          $(movieData).appendTo(".styled-select");
         }    

      </script>
      
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
            <form name="myform" action="MovieInfo" method="GET">
                <div class="styled-select">
					<!-- This is where the movies from the above script will go-->
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