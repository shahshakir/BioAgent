package pkg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class merging {
 
	public static void concentenation()
	{
        File folder = new File("tabformat");
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  {
		    	  System.out.println(listOfFiles[i].getName());
		    	 
		    	  }
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
System.out.println("files no: "+listOfFiles.length);
String sourceFile1Path = "tabformat/";

String mergedFilePath = "tabformat/tab.txt";

File[] files = new File[listOfFiles.length];
for(int i=0;i<listOfFiles.length;i++)
{
files[i] = new File(sourceFile1Path+listOfFiles[i].getName());
}

File mergedFile = new File(mergedFilePath);

mergeFiles(files, mergedFile);
	}
 
	public static void mergeFiles(File[] files, File mergedFile) {
 
		FileWriter fstream = null;
		BufferedWriter out = null;
		try {
			fstream = new FileWriter(mergedFile, true);
			 out = new BufferedWriter(fstream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
 
		for (File f : files) {
			System.out.println("merging: " + f.getName());
			FileInputStream fis;
			try {
				fis = new FileInputStream(f);
				BufferedReader in = new BufferedReader(new InputStreamReader(fis));
 
				String aLine;
				while ((aLine = in.readLine()) != null) {
					out.write(aLine);
					out.newLine();
				}
 
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
}