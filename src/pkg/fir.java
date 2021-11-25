package pkg;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;







import jade.core.Agent;

@SuppressWarnings("serial")
public class fir extends Agent{
	private JFrame frame;
	private JTextField textField;
	private JTable table;
	List<String> colname = new ArrayList<String>();
	public long startTime;
	public long endTime; 
	public long result;
	
	protected void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 17));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Fetch Protien to Protien Interaction ");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 17));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("from Databases");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 17));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 1;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel label = new JLabel("Enter Protid");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 2;
		frame.getContentPane().add(label, gbc_label);
		
		textField = new JTextField("Q12345");
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
					return int.class;
				}
				else if(column==1){
					return String.class;
				}
				else{
					return Boolean.class;

				}
			}
		};
		
		table.setModel(model);
		table.setEnabled(true);
		table.setModel(model);
		model.addColumn("Sr #");
		model.addColumn("Name");
		model.addColumn(" ");
		scrollPane.setViewportView(table);
		String[] col =new String[10];
		col[0]="Interactor A&B";
		col[1]="Interaction Dtection Method";
		col[2]="Auhtor name";
		col[3]="Publication";
		col[4]="NCBI Taxnomy interator A";
		col[5]="NCBI Taxnomy interator B";
		col[6]="Interaction Type";
		col[7]="Interactor Type A";
		col[8]="Interactor Type B";
		col[9]="Source Database";
		
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		for(int i=0;i<col.length;i++)
	    {
	    	
	Object[] row={i+1,col[i],true};
	DefaultTableModel model1 =(DefaultTableModel)table.getModel();
	model1.addRow(row);
//	boolean[] tr=new boolean[10];
	
	table.setRowHeight(40);
	    }
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 3;
		gbc_btnCancel.gridy = 4;
		frame.getContentPane().add(btnCancel, gbc_btnCancel);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/*	if(text1.getText().isEmpty())
	               {
	            	  /*JLabel abc = new JLabel("Wrong ProtID");
	                   abc.setBounds(100, 156, 101, 14);
	                   frame.getContentPane().add(abc); 
	            		id_info.setEnabled(true);
	            		} 
	               else

	               {*/
	               //table.getSelectedRow();
				for (int i = 0; i < table.getRowCount(); i++) {
				     boolean isChecked = (Boolean) table.getValueAt(i, 2);

				     if (isChecked) {
				    	 colname.add(table.getModel().getValueAt(i,1).toString());	
				        //get the values of the columns you need.
				    
				     }
				}
			//	System.out.print(table.getRowCount());
				for(int i=0;i<colname.size();i++)
				{
			       		
	        		System.out.println(colname.get(i));
			}
				
				columlist.colname(colname);
	                try {
	                	endTime=System.currentTimeMillis();
	                	result=endTime-startTime;
	                	System.out.println("Result Time = "+result);
	                	 frame.setVisible(false);
	                	 frame.dispose();
	                	
	                	 new sec(textField.getText());
					
	
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	               	               }	
			
		});
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 0, 5, 0);
		gbc_btnNext.gridx = 4;
		gbc_btnNext.gridy = 4;
		frame.getContentPane().add(btnNewButton, gbc_btnNext);
	}


	 protected void setup() {
	//	 JFrame frame=new JFrame("hello");
	 initialize();
		
		// sec.setup();
	 	beh.setagent(this);
		 System.out.println("Hello World. I am an agent!");
		 System.out.println("My LocalName: " + getAID().getLocalName());
		 System.out.println("My Name: " + getAID().getName());
		 System.out.println("My Address: " + getAID().getAddressesArray()[0]);
		 frame.addWindowListener(new WindowAdapter() { 
		        public void windowClosing(WindowEvent we) {
		            //unsubscribe(); 
		            doDelete(); 
		            System.exit(0);  
		            // kill all the container because there is also 
		            // 1 client running. 
		           // doDelete(); 
		        } 
		        }); 
	
	 }

}
