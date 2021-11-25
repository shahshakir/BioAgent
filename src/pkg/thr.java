package pkg;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jade.core.Agent;


@SuppressWarnings("serial")
public class thr extends Agent{
	private String query=null;
	private JFrame frame;
	Agent agent;
protected void setup()
{
	}
public thr(String a)
{
	query=a;
	init();
	}
protected void init()
{
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
	
	JTextField textField = new JTextField();
	textField.setText(query);
	textField.setEditable(false);
	GridBagConstraints gbc_textField = new GridBagConstraints();
	gbc_textField.insets = new Insets(0, 0, 5, 5);
	gbc_textField.fill = GridBagConstraints.HORIZONTAL;
	gbc_textField.gridx = 3;
	gbc_textField.gridy = 2;
	frame.getContentPane().add(textField, gbc_textField);
	textField.setColumns(10);
	
	JLabel lblInteractionsFromDatabases = new JLabel("Interactions from databases has been Fetched");
	GridBagConstraints gbc_lblInteractionsFromDatabases = new GridBagConstraints();
	gbc_lblInteractionsFromDatabases.insets = new Insets(0, 0, 5, 5);
	gbc_lblInteractionsFromDatabases.gridx = 3;
	gbc_lblInteractionsFromDatabases.gridy = 4;
	frame.getContentPane().add(lblInteractionsFromDatabases, gbc_lblInteractionsFromDatabases);
	
	JLabel lblThankYou = new JLabel("Thank you.");
	GridBagConstraints gbc_lblThankYou = new GridBagConstraints();
	gbc_lblThankYou.insets = new Insets(0, 0, 5, 5);
	gbc_lblThankYou.gridx = 3;
	gbc_lblThankYou.gridy = 5;
	frame.getContentPane().add(lblThankYou, gbc_lblThankYou);
	
	JButton btnNewButton = new JButton("Back");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			frame.setVisible(false);
			frame.dispose();
			try {
				new sec(query);
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
	frame.setVisible(true);
	JButton btnExit = new JButton("Exit");
	btnExit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	GridBagConstraints gbc_btnExit = new GridBagConstraints();
	gbc_btnExit.gridx = 4;
	gbc_btnExit.gridy = 6;
	frame.getContentPane().add(btnExit, gbc_btnExit);	



}
}
