<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<code>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
      <style type="text/css">
         .tile {display: inline-block; border: 1px solid grey; background: silver; padding: 4px; text-align: center; font-size: 15px;width:250px; }
      </style>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
      <script>
         var apikey = "regehcgurp4f3uhzrtej3f3b";
         var baseUrl = "http://data.tmsapi.com/v1";
         var showtimesUrl = baseUrl + '/movies/showings';
         var zipCode = "83440";
         var d = new Date();
         var today = d.getFullYear() + '-' + (d.getMonth()+1) + '-' + d.getDate();

         $(document).ready(function() {
          
           // send off the query
           $.ajax({
            url: showtimesUrl,
                data: { startDate: today,
                	radius: 10,
                    zip: zipCode,
                    jsonp: "dataHandler",
                    api_key: apikey
                   },          
            dataType: "jsonp",
           });
         });
          
         // callback to handle the results
         function dataHandler(data) {
          $(document.body).append('<p>Found ' + data.length + ' movies showing within 10 miles of ' + zipCode+':</p>');
          var movies = data.hits;
          $.each(data, function(index, movie) {
            var movieData = '<div class="tile"><img src="http://tmsimg.com/' + movie.preferredImage.uri + '?api_key='+apikey+'"><br/>';
            movieData += movie.title;
            if (movie.ratings) { movieData += ' (' + movie.ratings[0].code + ') </div>' };
            $(document.body).append(movieData);
          });
         }
            
      </script>
   </head>
   <body>
   	
   	<div class="searchBox">
    <h2>Search!</h2>
    <form action="Movies" method="GET">
        <input type="submit" value="search">
    </form>
	</div>
	
	<div>
		<h3>Results</h3>
		<c:forEach items="${mList}" var="movie">
			<a href="MovieInfo?movie=${movie.Title}" >${movie.Title}</a><br />
		</c:forEach>
	</div>
	
   </body>
</html>
</code>