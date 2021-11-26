package pkg;

import jade.core.AID;
import jade.core.Agent;
import jade.core.PlatformID;
import jade.core.behaviours.TickerBehaviour;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;



@SuppressWarnings("serial")
public class behavio extends Agent{
	void ticker(Agent agent)
	{
		addBehaviour(new MyTickerBehaviour(agent, 1000)); 
	}
	
	public class MyTickerBehaviour extends TickerBehaviour { 
        Agent agent; 
        // long interval; 
        int counter; 
        String a;
        String content;
   
        public MyTickerBehaviour(Agent agent, long interval) { 
            super(agent, interval); 
            this.agent = agent; 
            // this.interval = interval; 
        } 
   
        @Override
        protected void onTick() {
      //  	Path FROM = Paths.get("C:\\Temp\\from.txt");
        	    if(counter ==0)
        	    {
      
        	    }
        	 if (counter == 1) { 
                // move out 
                AID remoteAMS = new AID("ams@192.168.8.101:1099/JADE", AID.ISGUID); 
                remoteAMS.addAddresses("http://rahilasyed:7778/acc"); 
                PlatformID destination = new PlatformID(remoteAMS); 
                agent.doMove(destination);
               
        }
        	 if(counter==2 )
	            {
	      System.out.print("Arrived");
	         /*   try {
					xmlformatting.xml();
				} catch (XPathExpressionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            try {
					content = new Scanner(new File("F:/Database/tabformat/ooo1.txt")).useDelimiter("\\Z").next();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	           */ 
	            }
            if (counter == 3) { 
                // move back 
            
                AID remoteAMS = new AID("ams@192.168.8.100:1099/JADE", AID.ISGUID); 
                remoteAMS.addAddresses("http://Database1:7778/acc"); 
                PlatformID destination = new PlatformID(remoteAMS);         																
                System.out.println("Leaving... "); 
                agent.doMove(destination);     
            } 
            
            if(counter==4)
            {
            	System.out.println(a);
            try {

		     //Whatever the file path is.
		     File statText = new File("file.txt");
		     FileOutputStream is = new FileOutputStream(statText);
		     OutputStreamWriter osw = new OutputStreamWriter(is);    
		     //    System.out.println(content);
		     osw.write(content);
		     osw.close();
		     } catch (IOException e) {
		     System.err.println("Problem writing to the file");
		     }
            }
            if (counter < 5) 
            {
            	counter++;
            //    System.out.println(counter++); 
            }
        }
   } 
}
