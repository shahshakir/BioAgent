package pkg;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class xmlformatting {

 public static void xml(List<String> list) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
 {
	  boolean interAB=false;
	  boolean idm=false;
	  boolean aname=false;
	  boolean pub=false;
	  boolean nca=false;
	  boolean ncb=false;
	  boolean intty=false;
	  boolean inA=false;
	  boolean inB=false;
	  boolean db=false; 
	  for(int i=0;i<list.size();i++)
	  {
		  if(list.get(i)=="Interactor A&B")
		  {
			  interAB=true;
		  }
		  if(list.get(i)=="Interaction Dtection Method")
		  {
			  idm=true;
			 }
		  if(list.get(i)=="Auhtor name")
		  {
			  aname=true;
		  }
		  if(list.get(i)=="Publication")
		  {
			  pub=true;
				  
		  }
		if(list.get(i)=="NCBI Taxnomy interator A")
		{
		nca=true;
		}
		if(list.get(i)=="NCBI Taxnomy interator B")
		{
		ncb=true;
		}
		if(list.get(i)=="Interaction Type")
		{
		intty=true;
		  }
		if(list.get(i)=="Interactor Type A")
		{
		inA=true;
		}
		if(list.get(i)=="Interactor Type B")
		{
		inB=true;
		}
		if(list.get(i)=="Source Database")
		{
		db=true;
		}

		  }
	  List<String> filename= new ArrayList<String>();
		 File folder = new File("test");
			File[] listOfFiles = folder.listFiles();

for(int i=0;i<listOfFiles.length;i++)
{
	filename.add(listOfFiles[i].getName());
}
	for(int i=0;i<filename.size();i++)
	{
		System.out.println(filename.get(i));
		format(interAB,idm, aname,  pub, nca, ncb, intty, inA, inB, db,filename.get(i));
	}
	
 
	  }
	  
	  
	  
  
public  static void format(boolean interAB,boolean idm, boolean aname, boolean pub, boolean nca, boolean ncb, boolean intty, boolean inA, boolean inB, boolean db,String filename)throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
	BufferedWriter output = null;
	File file = new File("tabformat/"+filename+".txt");
    output = new BufferedWriter(new FileWriter(file));
    
    InputStream in_s = new FileInputStream("test/"+filename);
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder =  builderFactory.newDocumentBuilder();
    Document xmlDocument = builder.parse(in_s);
    XPath xPath =  XPathFactory.newInstance().newXPath();
    String expression0=null;
    String expression=null;
    String  expression1=null;
    String  expression2=null;
    String  expression3=null;
   // String  expression4=null;
    //String  expression5=null;
    String  expression7=null;
    String  expression8=null;
    String  expression9=null;
    String NCBIA=null;
    String NCBIB=null;
    
    String[] inttype=null;
    String[] srcdb=null;
    String[] expno=null;
    String interactorA=null;
    String interactorB=null;
    String[] interno=null;
    String ncbitaxA = null;
    String interactortypeA =null;
    String ncbitaxB =null;
    String interactortypeB = null;
    String[] autname=null;
    String[] publication=null;
    String[] inter=null;
    String[] intAb=null;
    //String interAB,String idm, String aname, String pub, String nca, String ncb, String intty, String inA, String inB, String db 
    /*----Start Interactor A and B--------*/

    expression0 = "/entrySet/entry/interactionList/interaction/names/shortLabel";
    NodeList nodeList0 = (NodeList) xPath.compile(expression0).evaluate(xmlDocument, XPathConstants.NODESET);
    intAb = new String[nodeList0.getLength()];
    for (int j= 0; j < nodeList0.getLength(); j++) 
    {
  	  intAb[j] =nodeList0.item(j).getFirstChild().getNodeValue(); 
  	 
    } 
    /*----End Interactor A and B--------*/
    
    /*----Start Interactor type--------------*/
    expression8 = "/entrySet/entry/interactionList/interaction/interactionType/names/shortLabel";
     NodeList nodeList9 = (NodeList) xPath.compile(expression8).evaluate(xmlDocument, XPathConstants.NODESET);
     inttype = new String[nodeList9.getLength()];
    
     for (int j= 0; j < nodeList9.getLength(); j++) {
    	 inttype[j]= nodeList9.item(j).getFirstChild().getNodeValue(); 
   //  System.out.println("Interaction Type: "+inttype[j]);
     }
     /*----End interactionDetectionMethod --------------*/
     
     /*-------Start Source Database--------*/
     expression9 = "/entrySet/entry/interactionList/interaction/xref/primaryRef/@db";
     NodeList nodeList10 = (NodeList) xPath.compile(expression9).evaluate(xmlDocument, XPathConstants.NODESET);
     srcdb = new String[nodeList10.getLength()];
            
     for (int j= 0; j < nodeList10.getLength(); j++) {
     srcdb[j]= nodeList10.item(j).getFirstChild().getNodeValue(); 
     
             }          
             /*-------End Source Database--------*/
    
    
    expression = "/entrySet/entry/interactionList/interaction/experimentList/experimentRef";
    NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
    expno = new String[nodeList.getLength()];
  //  String[] expno = new String[nodeList.getLength()];
    
    int i=0,z=0,x=1;

    for ( i = 0; i < nodeList.getLength(); i++) 
  {	  
  	expno[i]= nodeList.item(i).getFirstChild().getNodeValue(); 
  	 // System.out.println("Experiment no.: "+expno[i]);
  	if(interAB!=false){
  	//System.out.println("-------------------info: "+i+"--------------");
  	System.out.print("Interactors : "+intAb[i]+"\t");
  	output.write(intAb[i]+"\t");
  	}
  	if(db!=false)
  	{
  	System.out.print("Source Db : "+srcdb[i]+"\t");
  	output.write(srcdb[i]+"\t");
  	}
        /*-----------start interactorList-----*/
        
  	//loops for getting data from interactor list
       
    String interexp="/entrySet/entry/interactionList/interaction/participantList/participant/interactorRef";
        
    NodeList internode= (NodeList) xPath.compile(interexp).evaluate(xmlDocument, XPathConstants.NODESET);
    interno = new String[internode.getLength()];
      

   	interno[z]= internode.item(z).getFirstChild().getNodeValue();
   	interno[x]= internode.item(x).getFirstChild().getNodeValue();

  	NCBIA = "/entrySet/entry/interactorList/interactor[@id='"+interno[z]+"']/organism/@ncbiTaxId";
  	interactorA="/entrySet/entry/interactorList/interactor[@id='"+interno[z]+"']/interactorType/names/shortLabel";
  	NodeList ncbia = (NodeList) xPath.compile(NCBIA).evaluate(xmlDocument, XPathConstants.NODESET);
  	NodeList interA = (NodeList) xPath.compile(interactorA).evaluate(xmlDocument, XPathConstants.NODESET);
  	 
  	ncbitaxA=ncbia.item(0).getFirstChild().getNodeValue();
  	interactortypeA=interA.item(0).getFirstChild().getNodeValue();
  
  	if(nca !=false){
  	System.out.print("ncbi taxA : "+ncbitaxA+"\t");
  	output.write(ncbitaxA+"\t");
  	}
  	if(inA!=false)
  	{
  	  System.out.print("interactor type A : "+interactortypeA+"\t");
  	output.write(interactortypeA+"\t");
  	}   

  	NCBIB ="/entrySet/entry/interactorList/interactor[@id='"+interno[x]+"']/organism/@ncbiTaxId";
    interactorB="/entrySet/entry/interactorList/interactor[@id='"+interno[x]+"']/interactorType/names/shortLabel";
  	 
  	NodeList interB = (NodeList) xPath.compile(interactorB).evaluate(xmlDocument, XPathConstants.NODESET);
  	NodeList ncbib = (NodeList) xPath.compile(NCBIB).evaluate(xmlDocument, XPathConstants.NODESET);  
  
  	ncbitaxB=ncbib.item(0).getFirstChild().getNodeValue();
  	interactortypeB=interB.item(0).getFirstChild().getNodeValue();
  	if(ncb !=false)
  	{
  	System.out.print("ncbi taxB : "+ncbitaxB+"\t");
  	output.write(ncbitaxB+"\t");
  	}
  	if(inB !=false)
  	{
  	System.out.print("interactor type B : "+interactortypeB+"\t");   
  	output.write(interactortypeB+"\t");
  	}
     z=x+1;
     x=z+1;
        
    /*-end interactorList-------*/
    
    /*----Start Experiment Name--------------*/
 	expression1 = "/entrySet/entry/experimentList/experimentDescription[@id='"+expno[i]+"']/names/shortLabel";
    NodeList nodeList2 = (NodeList) xPath.compile(expression1).evaluate(xmlDocument, XPathConstants.NODESET);
     
    autname = new String[nodeList2.getLength()];
    for (int j = 0; j < nodeList2.getLength(); j++) 
    {
  	autname[j]=nodeList2.item(j).getFirstChild().getNodeValue(); 
  	if(aname!= false)
  	{
    System.out.print("Experiment no.: "+expno[i]+"   Author Name: "+autname[j]+"\t"); 
    output.write(autname[j]+"\t");
  	}
  	  }
    
    
  /*----End Experiment Name--------------*/

  /*----Start publication --------------*/
       expression2 = "/entrySet/entry/experimentList/experimentDescription[@id='"+expno[i]+"']/bibref/xref/primaryRef/@db";
       expression3 = "/entrySet/entry/experimentList/experimentDescription[@id='"+expno[i]+"']/bibref/xref/primaryRef/@id";
    //   expression4 = "/entrySet/entry/experimentList/experimentDescription[@id='"+expno[i]+"']/xref/primaryRef/@db";
      // expression5 = "/entrySet/entry/experimentList/experimentDescription[@id='"+expno[i]+"']/xref/primaryRef/@id";
       
       NodeList nodeList3 = (NodeList) xPath.compile(expression2).evaluate(xmlDocument, XPathConstants.NODESET);
       NodeList nodeList4 = (NodeList) xPath.compile(expression3).evaluate(xmlDocument, XPathConstants.NODESET);
       //NodeList nodeList5 = (NodeList) xPath.compile(expression4).evaluate(xmlDocument, XPathConstants.NODESET);
       //NodeList nodeList6 = (NodeList) xPath.compile(expression5).evaluate(xmlDocument, XPathConstants.NODESET);
       publication = new String[nodeList3.getLength()];
       for (int j = 0; j < nodeList3.getLength(); j++) 
       {
    	   
      publication[j]=nodeList3.item(j).getFirstChild().getNodeValue()+":"+nodeList4.item(j).getFirstChild().getNodeValue();/*+"|"+nodeList5.item(j).getFirstChild().getNodeValue()+":"+nodeList6.item(j).getFirstChild().getNodeValue();*/
      if(pub !=false)
      {
      System.out.print("publication: "+publication[j]+"\t");
      output.write(publication[j]+"\t");
      }

      }
       /*----End publication --------------*/
                    /*----Start interactionDetectionMethod --------------*/
       expression7 = "/entrySet/entry/experimentList/experimentDescription[@id='"+expno[i]+"']/interactionDetectionMethod/names/shortLabel";
       NodeList nodeList8 = (NodeList) xPath.compile(expression7).evaluate(xmlDocument, XPathConstants.NODESET);
       inter = new String[nodeList.getLength()];
      
       for (int j= 0; j < nodeList8.getLength(); j++)
       {
      inter[j]= nodeList8.item(j).getFirstChild().getNodeValue(); 
     if(idm !=false)
     {
      System.out.print("Interaction Detection method : "+inter[j]+"\t");
      output.write(inter[j]+"\t");
     }
     if(intty !=false)
     {
      System.out.print("Interaction Type: "+inttype[j]+"\t");
      output.write(inttype[j]+"\t");
      //  System.out.print("---------------------------------\n");
     } 
     output.write("\n");
     System.out.println();
      }           
       /*----End interactionDetectionMethod --------------*/
  			} 
    output.close();
    }
} 