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
          var movies = data.hits;
          var movieData = '<select name=movies>';
          $.each(data, function(index, movie) {
            movieData += '<option value=' + movie.title + '>' + movie.title + '</option>';
          });
          movieData += '</select>';
          $(document.body).append(movieData);
         }
            
      </script>
   </head>
   <body>
   
	
   </body>
</html>
</code>