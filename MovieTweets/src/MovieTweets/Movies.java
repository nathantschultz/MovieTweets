package MovieTweets;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Movies
 */
@WebServlet("/Movies")
public class Movies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Movies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String apikey = "regehcgurp4f3uhzrtej3f3b";
        String baseUrl = "http://data.tmsapi.com/v1/movies/showings/?";
        String zipCode = "83440";
        
        URL url = new URL(baseUrl + "startDate=" + "2014-3-24" + "&radius=10" + "&zip=" + zipCode + "&api_key=" + apikey);       
        
        System.out.println(url);
        
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = mapper.readValue(url, Map.class);
		
		request.setAttribute("mList", map.get("Search"));
		request.getRequestDispatcher("/someStuff.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
