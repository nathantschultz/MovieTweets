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
 * Servlet implementation class MovieLocation
 */
@WebServlet("/MovieLocation")
public class MovieLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieLocation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
//		String movie = request.getParameter("movie").replaceAll(" ", "%20");
		String location = "83440";
		
//		URL url = new URL("http://www.omdbapi.com/?s=" + movie);
		URL url = new URL("http://www.fandango.com/rss/moviesnearme_" + location + ".rss");
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = mapper.readValue(url, Map.class);
		
		for (String key : map.keySet())
		{
		System.out.println(key + ": " + map.get(key));
		}
			
//		request.setAttribute("mList", map.get("Search"));
//		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
