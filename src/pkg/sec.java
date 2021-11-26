package pkg;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;
import org.hupo.psi.mi.psicquic.wsclient.PsicquicSimpleClient;

import jade.core.AID;
import jade.core.Agent;
import jade.core.PlatformID;
import jade.core.behaviours.TickerBehaviour;

@SuppressWarnings("serial")
public class sec extends Agent{
	private JFrame frame;
	private JTextField textField;
	private JTable table;
	Database db;
	String query=null;
	Agent agent;
	boolean abc=false;
	List<String> list = new ArrayList<String>();
	List<String> colname = new ArrayList<String>();
	private String Protid="Q12345";
	public long startTime;
	public long endTime; 
	public long result;

/*protected void setup() 
	 { 
	        super.setup(); 
	        System.out.println("Hello World. I am an agent!"); 
	        System.out.println("My LocalName: " + agent.getAID().getLocalName()); 
	        System.out.println("My Name: " + agent.getAID().getName()); 
	        System.out.println("My Address: " + agent.getAID().getAddressesArray()[0]); 
	        ticker(agent);
	 
	 }
*/
	public sec (String a) throws IOException
{
	System.out.println("hello");
	query=a;
	initi();
	}
protected void initi() throws IOException
{
	
	int count=Database.getDatabasecount();
	String[][] obj=	Database.getdatabaseinfo(count);
	frame = new JFrame();
	frame.setVisible(true);
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
	gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	frame.getContentPane().setLayout(gridBagLayout);
	
	JLabel lblNewLabel = new JLabel("Fetch Protien to Protien Interaction ");
	lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 17));
	GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
	gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
	gbc_lblNewLabel.gridx = 3;
	gbc_lblNewLabel.gridy = 0;
	frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
	
	JLabel lblFromDatabses = new JLabel("From Databses");
	lblFromDatabses.setFont(new Font("Tahoma", Font.ITALIC, 17));
	GridBagConstraints gbc_lblFromDatabses = new GridBagConstraints();
	gbc_lblFromDatabses.insets = new Insets(0, 0, 5, 5);
	gbc_lblFromDatabses.gridx = 3;
	gbc_lblFromDatabses.gridy = 1;
	frame.getContentPane().add(lblFromDatabses, gbc_lblFromDatabses);
	
	JButton btnNewButton = new JButton("Back");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			new fir();
			frame.setVisible(false);
			frame.dispose();
		}
	});
	
	JLabel lblEnterProtid = new JLabel("Enter Protid");
	GridBagConstraints gbc_lblEnterProtid = new GridBagConstraints();
	gbc_lblEnterProtid.insets = new Insets(0, 0, 5, 5);
	gbc_lblEnterProtid.gridx = 1;
	gbc_lblEnterProtid.gridy = 2;
	frame.getContentPane().add(lblEnterProtid, gbc_lblEnterProtid);
	
	textField = new JTextField();
	textField.setText(Protid);
	textField.setEditable(false);
	GridBagConstraints gbc_textField = new GridBagConstraints();
	gbc_textField.insets = new Insets(0, 0, 5, 5);
	gbc_textField.fill = GridBagConstraints.HORIZONTAL;
	gbc_textField.gridx = 3;
	gbc_textField.gridy = 2;
	frame.getContentPane().add(textField, gbc_textField);
	textField.setColumns(10);
	
	JScrollPane scrollPane = new JScrollPane();
	GridBagConstraints gbc_scrollPane = new GridBagConstraints();
	gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
	gbc_scrollPane.fill = GridBagConstraints.BOTH;
	gbc_scrollPane.gridx = 3;
	gbc_scrollPane.gridy = 3;
	frame.getContentPane().add(scrollPane, gbc_scrollPane);
	
	table = new JTable();
	scrollPane.setViewportView(table);
	DefaultTableModel model=new DefaultTableModel(){
		public Class<?> getColumnClass(int column){
			if(column==0){
				return String.class;
			}
			else if(column==1){
				return String.class;
			}
			else if(column==2){
				return String.class;
			}
			else if(column==3){
				return Boolean.class;
			}
			else{
				return String.class;

			}
		}
	};
	
	table.setModel(model);
	table.setEnabled(true);
	table.setModel(model);
	model.addColumn("Sr #");
	model.addColumn("Name");
	model.addColumn("Interactions");
	model.addColumn(" ");
	model.addColumn("# of Inter");
	scrollPane.setViewportView(table);
	
	for(int i=0;i<count;i++)
    {
Object[] row={i+1,obj[0][i],obj[1][i],false,0};
//DefaultTableModel model1 =(DefaultTableModel)table.getModel();
model.addRow(row);
table.setRowHeight(40);
    }
	table.addMouseListener(new java.awt.event.MouseAdapter() {
	    @Override
	   
	    public void mouseClicked(java.awt.event.MouseEvent evt) {
	        int row = table.rowAtPoint(evt.getPoint());
	     //   int col = table_1.columnAtPoint(evt.getPoint());
			    String url1= obj[2][row].toString();
	        		
	    try {
	    	table.getModel().setValueAt(getInteractions(query,url1),row,4)	;
		} catch (IOException e) {
						// TODO Auto-generated catch block
		e.printStackTrace();
			}
	       }
	       
	    });
	
	
	GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
	gbc_btnNewButton.anchor = GridBagConstraints.EAST;
	gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
	gbc_btnNewButton.gridx = 3;
	gbc_btnNewButton.gridy = 6;
	frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
	
	JButton btnNext = new JButton("Next");
	btnNext.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
		
			for (int i = 0; i < table.getRowCount(); i++) {
			     boolean isChecked = (Boolean) table.getValueAt(i, 3);

			     if (isChecked) {
		        		String url= obj[2][i].toString();
		           		//String name=obj[0][row].toString();
		        		System.out.println("url="+url);
		           		list.add(url);
			     }
			}
			agent=beh.getagent();
				
			//behavio.addBehaviour(new MyTickerBehaviour(this, 1000));
			//agent.doMove(destination);
			addBehaviour(new MyTickerBehaviour(agent, 1000));  	
          
	/*	for(int i=0;i<colname.size();i++)
			{
				System.out.println(colname.get(i));					
			}*/
		//	endTime=System.currentTimeMillis();
		//	result=endTime-startTime;
		//	System.out.println(result)			
            	
		//new thr(query);
		//	frame.setVisible(false);
			
		}
		
	});
	GridBagConstraints gbc_btnNext = new GridBagConstraints();
	gbc_btnNext.gridx = 4;
	gbc_btnNext.gridy = 6;
	frame.getContentPane().add(btnNext, gbc_btnNext);
	}
public int getInteractions(String query,String url) throws IOException {
	
	//	String db="http://www.ebi.ac.uk/Tools/webservices/psicquic/intact/webservices/current/search/";
		PsicquicSimpleClient client = new PsicquicSimpleClient(url);
		final long count = client.countByQuery(query);
		System.out.println("Interactors from : "+url+" Count: "+count);
		return (int) count;
}	
void ticker(Agent agent)
{
	System.out.println("Ticker function");
	addBehaviour(new MyTickerBehaviour(agent, 1000)); 
}

private class MyTickerBehaviour extends TickerBehaviour {  
    Agent agent; 
    // long interval; 
    int counter; 
    String a;
    String content;

    public MyTickerBehaviour(Agent agent, long interval) { 
        super(agent, interval); 
        this.agent = agent; 
    	System.out.println("Ticker constructor");
        //this.interval = interval; 
    	onTick() ;
    } 

    @Override
    protected void onTick() {
    //Path FROM = Paths.get("C:\\Temp\\from.txt");
    	if(abc==false)
		{ 
    		for(int i=0;i<colname.size();i++)
    		{
    			System.out.println(colname.get(i));
    			
    		}
    
    	/*	
		AID remoteAMS = new AID("ams@192.168.8.100:1099/JADE", AID.ISGUID); 
        remoteAMS.addAddresses("http://Databasen:7778/acc"); 
        PlatformID destination = new PlatformID(remoteAMS); 
        agent.doMove(destination);
		
		System.out.println("Hello World. I am an agent!"); 
        System.out.println("My LocalName: " + agent.getAID().getLocalName()); 
        System.out.println("My Name: " + agent.getAID().getName()); 
        System.out.println("My Address: " + agent.getAID().getAddressesArray()[0]); 
        
        //setup();
		//ticker(agent);
		*/
    	//System.out.println("list="+list);
        DownloadFile.download(list,Protid);
		colname=columlist.getlist();
		try {
			xmlformatting.xml(colname);
		} catch (XPathExpressionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	merging.concentenation();
		abc=true;
		}
		if(abc==true)
		{
			  AID remoteAMS = new AID("ams@192.168.8.102:1099/JADE", AID.ISGUID); 
	            remoteAMS.addAddresses("http://DESKTOP-UN39FCA:7778/acc"); 
	            PlatformID destination = new PlatformID(remoteAMS); 
	            
		}
    }
       
    }
} 


