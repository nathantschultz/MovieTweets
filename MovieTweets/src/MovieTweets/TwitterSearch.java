package MovieTweets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import twitter4j.*;
import java.util.List;

/**
 * Servlet implementation class TwitterSearch
 */
@WebServlet("/TwitterSearch")
public class TwitterSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwitterSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    

    
	
	
	
	public class SearchTweets {
	    /**
	     * Usage: java twitter4j.examples.search.SearchTweets [query]
	     *
	     * @param args search query
	     */
	    public static void main(String[] args) {
	        if (args.length < 1) {
	            System.out.println("java twitter4j.examples.search.SearchTweets [query]");
	            System.exit(-1);
	        }
	        Twitter twitter = new TwitterFactory().getInstance();
	        try {
	            Query query = new Query(args[0]);
	            QueryResult result;
	            do {
	                result = twitter.search(query);
	                List<Status> tweets = result.getTweets();
	                for (Status tweet : tweets) {
	                    System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
	                }
	            } while ((query = result.nextQuery()) != null);
	            System.exit(0);
	        } catch (TwitterException te) {
	            te.printStackTrace();
	            System.out.println("Failed to search tweets: " + te.getMessage());
	            System.exit(-1);
	        }
	    }
	}
	
	
    
    
    
    
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
