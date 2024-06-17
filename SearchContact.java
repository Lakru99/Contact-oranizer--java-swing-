import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class SearchContact extends JFrame{
	private JButton btnSearchContact;
	private JButton btnHome;
	
	private JTextField searchTextPanel;
	private JLabel txtId;
	private JLabel txtName;
	private JLabel txtNumber;
	private JLabel txtCompany;
	private JLabel txtSalary;
	private JLabel txtBirthday;
	
	
	SearchContact(){
		setSize(700,400);
		setTitle("Search Contact");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		JLabel titleLabel=new JLabel("Search Contact");
		titleLabel.setFont(new Font("",1,35)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBackground(Color.decode("#00b894"));
		titleLabel.setOpaque(true);
		titleLabel.setForeground(Color.WHITE);
		add("North",titleLabel);
		
		
		
		
		
		JPanel searchButtonPanel=new JPanel(new GridLayout(1,2,2,2));
		
		searchTextPanel=new JTextField(20);
		searchTextPanel.setFont(new Font("",1,20)); 
		JPanel searchPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		searchPanel.add(searchTextPanel);
		searchButtonPanel.add(searchPanel);
		
		btnSearchContact=new JButton("Search");
		btnSearchContact.setFont(new Font("",1,15)); 
		JPanel btnSearchPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnSearchPanel.add(btnSearchContact);
		btnSearchContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				ContactList contactList = DBConnection.getInstance().getContactList();
				String nameOrPhone = searchTextPanel.getText();
				int index=ContactsController.searchContacts(nameOrPhone);
				if (searchTextPanel.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Text Field is Empty... Search Contact again");
					searchTextPanel.requestFocus();
				}else if(index!=-1){
					txtId.setText(contactList.get(index).getId());
					txtName.setText(contactList.get(index).getName());
					txtNumber.setText(contactList.get(index).getPhoneNumber());
					txtCompany.setText(contactList.get(index).getCompanyName());
					txtSalary.setText(""+contactList.get(index).getSalary());
					txtBirthday.setText(contactList.get(index).getBirthday());

				}else{
					JOptionPane.showMessageDialog(null, "No contact fount for "+ nameOrPhone);
				}
			}
		});
		searchButtonPanel.add(btnSearchPanel);
		add(searchButtonPanel);
		
		
		//------------------------left label ------------------------------------------
		
		JPanel labelPanel=new JPanel(new GridLayout(6,0,2,2));
		labelPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
		JLabel idLabel=new JLabel("ID - ");
		idLabel.setFont(new Font("",1,20)); 
		idLabel.setHorizontalAlignment(JLabel.LEFT);
		labelPanel.add(idLabel);
		
		JLabel lblName=new JLabel("Name");
		lblName.setFont(new Font("",1,20)); 
		lblName.setHorizontalAlignment(JLabel.LEFT);
		labelPanel.add(lblName);
		
		JLabel lblNumber=new JLabel("Contact Number");
		lblNumber.setFont(new Font("",1,20)); 
		lblNumber.setHorizontalAlignment(JLabel.LEFT);
		labelPanel.add(lblNumber);
		
		JLabel lblCompany=new JLabel("Company");
		lblCompany.setFont(new Font("",1,20));
		lblCompany.setHorizontalAlignment(JLabel.LEFT); 
		labelPanel.add(lblCompany);
		
		JLabel lblSalary=new JLabel("Salary");
		lblSalary.setFont(new Font("",1,20)); 
		idLabel.setHorizontalAlignment(JLabel.LEFT);
		labelPanel.add(lblSalary);
		
		JLabel lblBirthday=new JLabel("Birthday");
		lblBirthday.setFont(new Font("",1,20)); 
		lblBirthday.setHorizontalAlignment(JLabel.LEFT);
		labelPanel.add(lblBirthday);
		
		add("West",labelPanel);
		
		
		// --------------------  text panel---------------
		JPanel textPanel=new JPanel(new GridLayout(6,0,2,2));
		textPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
		
		txtId=new JLabel();
		txtId.setFont(new Font("",1,20)); 
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		idTextPanel.add(txtId);
		textPanel.add(idTextPanel);
		
		txtName=new JLabel();
		txtName.setFont(new Font("",1,20)); 
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameTextPanel.add(txtName);
		textPanel.add(nameTextPanel);
		
		txtNumber=new JLabel();
		txtNumber.setFont(new Font("",1,20)); 
		JPanel numberTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		numberTextPanel.add(txtNumber);
		textPanel.add(numberTextPanel);
		
		
		txtCompany=new JLabel();
		txtCompany.setFont(new Font("",1,20)); 
		JPanel companyTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		companyTextPanel.add(txtCompany);
		textPanel.add(companyTextPanel);
		
		txtSalary=new JLabel();
		txtSalary.setFont(new Font("",1,20)); 
		JPanel salaryTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		salaryTextPanel.add(txtSalary);
		textPanel.add(salaryTextPanel);
		
		txtBirthday=new JLabel();
		txtBirthday.setFont(new Font("",1,20)); 
		JPanel birthdayTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		birthdayTextPanel.add(txtBirthday);
		textPanel.add(birthdayTextPanel);
		
		
		add("East", textPanel);
		
				//---------------------footer buttons------------------------
		
		JPanel footerMain=new JPanel(new GridLayout(1,1,1,1));
		
		JPanel buttonPanelBottom=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnHome=new JButton("Back to Home Page");
		btnHome.setFont(new Font("",1,20)); 
		btnHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				SearchContact.this.dispose();
			}
		});
		buttonPanelBottom.add(btnHome);
		footerMain.add(buttonPanelBottom);
		
		add("South",footerMain);
		
		
	}
	
}


