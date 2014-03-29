package MovieTweets;

import java.io.IOException;
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
       
	
	public static List<String> search(String string) {
        Twitter twitter = new TwitterFactory().getInstance();
        List<String> movieTweets = null;
        try {
            Query query = new Query(string);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                	movieTweets.add("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
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
		List<String> tweets = search(movieName);
    	
    	
    	  String country=request.getParameter("moviename");
    	  	Map<String, String> robo = new LinkedHashMap<String, String>();
    	  	robo.put("1", "@weinerdog4life: Why did robocop have a mouth? Was it so he could kiss other robocops? I bet it was so he could kiss other robocops.");
    	  	robo.put("2", "@JoeyBurns87: Watching Robocop 2. Its chocker with bad hair and pointless handbrake turns. I love it.");
    	  	robo.put("3", "@VicSage2005: Check Out This Hilarious Robocop Baby Food Ad By Giovanni Costa!");
    	  	robo.put("4", "@WiKiWiKira: \"Your move creep\" #robocop");
    	     
    	     Map<String, String> secret = new LinkedHashMap<String, String>();
    	     secret.put("1", "@gaysers: im going to watch the secret life of walter mitty w my sister now");
    	     secret.put("2", "@mikerkay: Secret Life of Walter Mitty is a great movie.");
    	     secret.put("3", "@mangionealex: But really Frozen was alright.  Wouldn't mind watching it again.  But the secret life of Walter Mitty? I'd watch that a hundred more times.");
    	     secret.put("4", "@MacLeicht12: The secret life of walter mitty is one of my new favorite movies #stilleristheman");

    	     Map<String, String> gravity = new LinkedHashMap<String, String>();
    	     gravity.put("1", "‏@jastilley: Child sitting. Nothing great on tv so we are watching Gravity. We are wondering how they filmed weightless scenes. Maybe invisible cables.");
    	     gravity.put("2", "@LoudFlavor: watching gravity made me really woozy and claustrophobic");
    	     gravity.put("3", "@JulienMacdonald: Seeing gravity this evening.... Am i going to be blown away? #Gravity");
    	     gravity.put("4", "@UCDan: Just watched Gravity for the first time. It really grounded me, but I wasn't moved.");

    	     
//    	     String json = null ;
//    	     if(country.equals("robocop")){
//    	      json= new Gson().toJson(robo);   
//    	     }
//    	     else if(country.equals("secret")){
//    	      json=new Gson().toJson(secret);  
//    	     }
//    	     else if(country.equals("gravity")){
//       	      json=new Gson().toJson(gravity);  
//       	     }
		
			String json = null;
			json=new Gson().toJson(robo);  

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
