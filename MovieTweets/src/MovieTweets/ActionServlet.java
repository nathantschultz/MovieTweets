package MovieTweets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import twitter4j.*;


/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
       
	
	public static Map<String, String> search(String string) {
        
		Twitter twitter = new TwitterFactory().getInstance();
       
        Map<String, String> movieTweets = new LinkedHashMap<String, String>();
        try {
            Query query = new Query(string);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                String num = "0";
                for (Status tweet : tweets) {
                	movieTweets.put(num, "@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                	num += 1;
                }
            } while ((query = result.nextQuery()) != null);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
        }
        return movieTweets;
    }
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,   HttpServletResponse response) throws ServletException, IOException {
        

        
    	String movieName=request.getParameter("moviename");
    	Map<String, String> tweets = search(movieName);
    	
    	File outputFile = new File(getServletContext().getRealPath("/")
                + "savedTweets.txt");
        FileWriter fout = new FileWriter(outputFile);
        
    	for (Map.Entry<String, String> entry : tweets.entrySet()) {
    		fout.write(entry.getValue());
    		fout.write("\r\n");
    	}
        
        fout.close();
        
    	Date now = new Date(); //the date
		System.out.println(now);
		
    	     String json = null;
    	     json = new Gson().toJson(tweets);

    	     response.setContentType("application/json");
    	     response.setCharacterEncoding("UTF-8");
    	     response.getWriter().write(json);       
    	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
