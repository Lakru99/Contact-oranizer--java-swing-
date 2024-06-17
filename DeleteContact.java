import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DeleteContact extends JFrame{
	private JButton btnDeleteContact;
	private JButton btnCancel;
	private JButton btnSearchContact;
	private JButton btnHome;
	
	private JTextField searchTextPanel;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtNumber;
	private JTextField txtCompany;
	private JTextField txtSalary;
	private JTextField txtBirthday;
	
	
	DeleteContact(){
		setSize(700,400);
		setTitle("Delete Contact Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		JLabel titleLabel=new JLabel("Delete Contact");
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
		btnSearchContact.setFont(new Font("",1,20)); 
		JPanel btnSearchPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
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
					searchTextPanel.setText("");
					searchTextPanel.requestFocus();
				}

			}
		});
		btnSearchPanel.add(btnSearchContact);
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
		
		txtId=new JTextField(5);
		txtId.setFont(new Font("",1,20)); 
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		idTextPanel.add(txtId);
		textPanel.add(idTextPanel);
		
		txtName=new JTextField(15);
		txtName.setFont(new Font("",1,20)); 
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameTextPanel.add(txtName);
		textPanel.add(nameTextPanel);
		
		txtNumber=new JTextField(15);
		txtNumber.setFont(new Font("",1,20)); 
		JPanel numberTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		numberTextPanel.add(txtNumber);
		textPanel.add(numberTextPanel);
		
		
		txtCompany=new JTextField(15);
		txtCompany.setFont(new Font("",1,20)); 
		JPanel companyTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		companyTextPanel.add(txtCompany);
		textPanel.add(companyTextPanel);
		
		txtSalary=new JTextField(10);
		txtSalary.setFont(new Font("",1,20)); 
		JPanel salaryTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		salaryTextPanel.add(txtSalary);
		textPanel.add(salaryTextPanel);
		
		txtBirthday=new JTextField(10);
		txtBirthday.setFont(new Font("",1,20)); 
		JPanel birthdayTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		birthdayTextPanel.add(txtBirthday);
		textPanel.add(birthdayTextPanel);
		
		
		add("East", textPanel);
		
				//---------------------footer buttons------------------------
		
		JPanel footerMain=new JPanel(new GridLayout(2,1,1,1));
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnDeleteContact=new JButton("Delete");
		btnDeleteContact.setFont(new Font("",1,20)); 
		btnDeleteContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				String nameOrPhone = searchTextPanel.getText();
				int index=ContactsController.searchContacts(nameOrPhone);
				ContactsController.remove(index);
				if (searchTextPanel.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Text field is empty");
				}else if(index==-1){
					JOptionPane.showMessageDialog(null, "Deleted fail...");
				}else{
					JOptionPane.showMessageDialog(null, "Deleted successfully...");
				}
				int option =JOptionPane.showConfirmDialog(null, "Do you want to update another contact? ", "Confirm",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option==JOptionPane.YES_OPTION) {
						searchTextPanel.setText("");
						searchTextPanel.requestFocus();
						txtId.setText("");
						txtName.setText("");
						txtNumber.setText("");
						txtCompany.setText("");
						txtSalary.setText("");
						txtBirthday.setText("");
						txtName.requestFocus();

					}else if(option==JOptionPane.NO_OPTION){
						searchTextPanel.setText("");
						txtId.setText("");
						txtName.setText("");
						txtNumber.setText("");
						txtCompany.setText("");
						txtSalary.setText("");
						txtBirthday.setText("");
						dispose();
					}

			}
		});
		buttonPanel.add(btnDeleteContact);
		
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,20)); 
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				//ContactsController.addContact(contact);
					int option =JOptionPane.showConfirmDialog(null, "Are you sure to cansel this?", "Confirm",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option==JOptionPane.YES_OPTION) {
						txtId.setText(ContactsController.generateId());
						txtName.setText("");
						txtNumber.setText("");
						txtCompany.setText("");
						txtSalary.setText("");
						txtBirthday.setText("");
						txtName.requestFocus();

					}else if(option==JOptionPane.NO_OPTION){
						txtId.setText(ContactsController.generateId());
						txtName.setText("");
						txtNumber.setText("");
						txtCompany.setText("");
						txtSalary.setText("");
						txtBirthday.setText("");
						dispose();
					}
			}
		});
		buttonPanel.add(btnCancel);
		
		footerMain.add(buttonPanel);
		
		JPanel buttonPanelBottom=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnHome=new JButton("Back to Home Page");
		btnHome.setFont(new Font("",1,20));
		btnHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				DeleteContact.this.dispose();
			}
		}); 
		buttonPanelBottom.add(btnHome);
		footerMain.add(buttonPanelBottom);
		
		add("South",footerMain);
		
		
	}

	
}

