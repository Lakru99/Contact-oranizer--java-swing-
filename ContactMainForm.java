import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ContactMainForm extends JFrame{
	
	//public static final ContactList ;
	private JButton btnAddContact;
	private JButton btnSearchContact;
	private JButton btnDeleteContact; 
	private JButton btnUpdateContact;
	private JButton btnViewContact;
	private JButton btnExit;

	private ViewContactList viewContactList;
	private  AddContact addContact;
	private  SearchContact searchContact;
	private  UpdateContact updateContact;
	private DeleteContact deleteContactList;

	
	ContactMainForm(){
		setSize(600,400);
		setTitle("Main Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1,2));
		
		
//--------------------LEFT SIDE---------------------------------------------------------------//

		
		JPanel leftSide=new JPanel(new GridLayout(4,1,1,1));
		leftSide.setBackground(Color.decode("#2ecc71"));
		JPanel leftTitle=new JPanel(new GridLayout(2,1));
		
		JLabel leftTitleFirstRow=new JLabel("iFRIEND" , SwingConstants.CENTER);
		leftTitleFirstRow.setFont(new Font("",1,40));
		leftTitleFirstRow.setBackground(Color.decode("#2ecc71"));
		leftTitleFirstRow.setOpaque(true);
		leftTitleFirstRow.setForeground(Color.WHITE);
		leftTitle.add("North" , leftTitleFirstRow);
		
		JLabel leftTitleSecondRow=new JLabel("Contact Manager" , SwingConstants.CENTER);
		leftTitleSecondRow.setFont(new Font("",1,30));
		leftTitleSecondRow.setBackground(Color.decode("#2ecc71"));
		leftTitleSecondRow.setOpaque(true);
		leftTitleSecondRow.setForeground(Color.WHITE);
		leftTitle.add("South" , leftTitleSecondRow);
		
		leftSide.add("North" , leftTitle);
		add("West" , leftSide);
		
		
//---------------END LEFT SIDE---------------------------------------------------------------//	

	
//----------------RIGHT SIDE-----------------------------------------------------------------//

        JPanel rightSide = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		rightSide.setLayout(new GridLayout(7,0,2,2));
		rightSide.setBackground(Color.decode("#1abc9c"));
		
		JLabel rightTitle=new JLabel("Home Page",SwingConstants.CENTER);
		rightTitle.setFont(new Font("",1,30));
		rightTitle.setHorizontalAlignment(JLabel.CENTER);
		rightTitle.setBackground(Color.decode("#1abc9c"));
		rightTitle.setOpaque(true);
		rightTitle.setForeground(Color.WHITE);
		
		rightSide.add("North",rightTitle);
        
        
        
        btnAddContact=new JButton("Add Contact");
		btnAddContact.setFont(new Font("",1,20));
		btnAddContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(addContact==null){
					addContact=new AddContact();
				}
				addContact.setVisible(true);
			}
		});

		rightSide.add(btnAddContact);
		
		btnUpdateContact=new JButton("Update Contact");
		btnUpdateContact.setFont(new Font("",1,20));
		btnUpdateContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if (updateContact==null) {
					updateContact=new UpdateContact();
				}
				updateContact.setVisible(true);
			}
		});
		rightSide.add(btnUpdateContact);
		
		btnSearchContact=new JButton("Search Contact");
		btnSearchContact.setFont(new Font("",1,20));
		btnSearchContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if (searchContact==null) {
					searchContact=new SearchContact();
				}
				searchContact.setVisible(true);
			}
		});
		rightSide.add(btnSearchContact);
		
		btnDeleteContact=new JButton("Delete Contact");
		btnDeleteContact.setFont(new Font("",1,20));
		btnDeleteContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				if (deleteContactList==null) {
					deleteContactList=new DeleteContact();
				}
				deleteContactList.setVisible(true);
			}
		});

		rightSide.add(btnDeleteContact);
		
		btnViewContact=new JButton("View contact");
		btnViewContact.setFont(new Font("",1,20));
		btnViewContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if (viewContactList==null) {
					viewContactList=new ViewContactList();
				}
				viewContactList.setVisible(true);
			}
		});
		rightSide.add(btnViewContact);
		
		
		JPanel buttonFooterPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnExit=new JButton("Exit");
		btnExit.setFont(new Font("",1,20)); 
		buttonFooterPanel.add(btnExit);

		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
		});
		
		
		rightSide.add("South",buttonFooterPanel);
		
		
		add("East" , rightSide);

//---------------END RIGHT SIDE--------------------------------------------------------------//
		
	}
}
