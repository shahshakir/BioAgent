package pkg;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class Database {
       
	static  int count;
	public static void main(String[] args) throws IOException {

}   
public static int getDatabasecount() throws IOException
{
	    
        
  //To get total number of active database:
         URL url = null;
		try {
			url = new URL("http://www.ebi.ac.uk/Tools/webservices/psicquic/registry/registry?action=ACTIVE");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	    URLConnection yc = url.openConnection();
 	  //  int count1=0;
 	    BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
 	    String line = null;
        //to count active DB
         while ((line = in.readLine()) != null) {
	            int start = line.indexOf("<strong>");
	     //       int end = line.indexOf("</strong>");

	            if (start != -1) {
	            	//System.out.print(" diaplay :");
	        //    System.out.println( line.substring(start + "<strong>".length(), end));   
	            count++;    
	            }
	        }
	        
	        int db=count-2;
	        System.out.println("Total available Databses: "+(db));
	return db;
	
}
public static String[][] getdatabaseinfo(int count)
{
	
	String []dbname= new String[count];
 	String []interation= new String[count];
 	String []Rest=new String[count];         
 
 
 //Get database name interaction and rest
 Document doc = null;
try {
	doc = Jsoup.connect("http://www.ebi.ac.uk/Tools/webservices/psicquic/registry/registry?action=ACTIVE").get();
} catch (IOException e) {
	// TODO Auto-generated catch block
	
	e.printStackTrace();
}
Elements paragraphs = doc.select("td");
     
  int i=0;
  int j=0;
  int k=0;
  int l=0;
  
for(Element p : paragraphs)
  { 
 	 if(i%8==0)	 
 	 {
 		 dbname[j]=p.text();
 		 j++;
//        	 System.out.println(p.text());
 	 }

 	 if(i%8==2)
 	 {
 		 interation[k]=p.text();
 		 k++;
// 		 System.out.println(p.text());
 	 }
 	
 	 if(i%8==4)
 	 {
 		 Rest[l]=p.text();
 		 l++;
//           		 System.out.println(p.text());
 	 }
 	
 	 
// System.out.println("Database: " +dbname[i]);
// System.out.println("Interactions: " +interation[i]);
// System.out.println("Rest: " +Rest[i]);
//	   int i=0;
// System.out.println(i%7+ " " +p.text());
//System.out.print("Completed");
 	i++;
  }
 
  //Counter tak
 for(int m=0; m<count ; m++)
  { 
 	 System.out.println(m+1);
 	 System.out.println("Database: " +dbname[m]);
 	 System.out.println("Interactions: " +interation[m]);
//     System.out.println("Rest: " +Rest[m]);
 	 int sub=Rest[m].indexOf("REST: ");
 	 int subend=Rest[m].indexOf(" REST example");
 	 Rest[m]=(Rest[m].substring(sub,subend));
 	 int sub1=Rest[m].indexOf("h");
 	 Rest[m]=(Rest[m].substring(sub1));
 	 System.out.println("Rest: "+Rest[m]);
 	 System.out.println();
  }
 return new String[][]{dbname,interation,Rest};
  
		}
	}


