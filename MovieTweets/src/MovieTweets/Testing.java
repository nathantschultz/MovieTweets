package MovieTweets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Testing {

    public static void main(String[] args){
    	
        String string="";
        String file ="savedMovies.txt";

        //reading   
        try{
            InputStream ips=new FileInputStream(file); 
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String line;
            while ((line = br.readLine())!=null){
                System.out.println(line);
                string+=line+"\n";
            }
            br.close(); 
        }       
        catch (Exception e){
            System.out.println(e.toString());
        }

        //writing
        try {
            FileWriter fw = new FileWriter (file);
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter fileOut = new PrintWriter (bw); 
                fileOut.println (string+"\n test of read and write !!"); 
            fileOut.close();
            System.out.println("the file " + file + " is created!"); 
        }
        catch (Exception e){
            System.out.println(e.toString());
        }       
    }
}
