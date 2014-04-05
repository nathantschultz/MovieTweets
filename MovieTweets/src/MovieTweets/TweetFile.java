package MovieTweets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
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

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * Servlet implementation class TweetFile
 */
@WebServlet("/TweetFile")
public class TweetFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TweetFile() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @see HttpServlet#HttpServlet()
     */
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		String movieName = request.getParameter("moviename");
    	
		if (movieName.contains(":")) {
        	String[] movieSplit = movieName.split(":");
    		movieName = movieSplit[0];
    	}
		
		Date now = new Date();
	
    	Map<String, String> tweets = search(movieName);
    	
    	File outputFile = new File(getServletContext().getRealPath("/") + movieName + " Tweets.txt");
        FileWriter fout = new FileWriter(outputFile);
    	
        
        if (tweets.size() > 0) {
    		fout.write(now + "\r\n");
        	
    		for (Map.Entry<String, String> entry : tweets.entrySet()) {
        		fout.write(entry.getValue() + "\r\n");
        	}
        }
        
        fout.close();
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
