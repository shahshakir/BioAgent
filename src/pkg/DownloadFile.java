package pkg;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import org.hupo.psi.mi.psicquic.wsclient.PsicquicSimpleClient;

public class DownloadFile{
	
	public static void main(String[] args) throws IOException {

	   }
	public static void download(List<String> list ,String query)
	{
	for(int i=0;i<list.size();i++)
	{
		try {
	
		  PsicquicSimpleClient client = new PsicquicSimpleClient(list.get(i).toString());
		  File statText = new File("test/"+i+".xml");
		  FileOutputStream is = new FileOutputStream(statText);
		  OutputStreamWriter osw = new OutputStreamWriter(is);    
		  //String Line=null;
		 //System.out.println("qq="+query);
		  final InputStream result = client.getByQuery(query, PsicquicSimpleClient.XML25);
		  
		  BufferedReader in = new BufferedReader(new InputStreamReader(result));
		  String line;
		  
		  while ((line = in.readLine()) != null) {
			  System.out.println("Line="+line);
		 
		  osw.write(line);
		  	}
		  osw.close();

		  } catch (IOException e) {
		  	e.printStackTrace();
		  System.err.println("Problem writing to the file xml");
		  	}
	}
	}
	}
	