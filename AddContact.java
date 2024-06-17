import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddContact extends JFrame{
	private JButton btnAddContact;
	private JButton btnCancel;
	private JButton btnHome;
	
	private JLabel txtId;
	private JTextField txtName;
	private JTextField txtNumber;
	private JTextField txtCompany;
	private JTextField txtSalary;
	private JTextField txtBirthday;
	
	
	AddContact(){
		setSize(500,400);
		setTitle("Add Customer Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JLabel titleLabel=new JLabel("Add Contact");
		titleLabel.setFont(new Font("",1,35)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBackground(Color.decode("#00b894"));
		titleLabel.setOpaque(true);
		titleLabel.setForeground(Color.WHITE);
		add("North",titleLabel);
		
		
		//------------------------left label ------------------------------------------
		
		JPanel labelPanel=new JPanel(new GridLayout(6,0,2,2));
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
		
		txtId=new JLabel(ContactsController.generateId());
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
		txtNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				String phoneNumber = txtNumber.getText();
				boolean isValidPhoneNumber=ContactsController.isValidPhoneNumber(phoneNumber);
				
				if (isValidPhoneNumber) {
					int option =JOptionPane.showConfirmDialog(null, "Invalid Phone Number.. Do you want to input number again?", "Confirm",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option==JOptionPane.YES_OPTION) {
						txtNumber.setText("");
						txtNumber.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						ContactsController.count();
						txtId.setText(ContactsController.generateId());
						txtName.setText("");
						txtNumber.setText("");
						txtCompany.setText("");
						txtSalary.setText("");
						txtBirthday.setText("");
						dispose();
					}

				}
			}
		});
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
		btnAddContact=new JButton("Add Contact");
		btnAddContact.setFont(new Font("",1,20)); 
		btnAddContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=txtId.getText();
				String name=txtName.getText();
				String phoneNumber=txtNumber.getText();
				String company=txtCompany.getText();
				double salary=Double.parseDouble(txtSalary.getText());
				String birthday=txtBirthday.getText();
				Contact contact=new Contact(id,name,phoneNumber,company,salary,birthday);
				//ContactMainForm.ContactList.add(contact);

				boolean isValidPhoneNumber=ContactsController.isValidPhoneNumber(phoneNumber);
				boolean isValidSalary=ContactsController.isValidSalary(salary);
				boolean isValidBirthday=ContactsController.isValidBirthday(birthday);

				if (!isValidPhoneNumber) {
					int option =JOptionPane.showConfirmDialog(null, "Invalid Phone Number.. Do you want to input number again?", "Confirm",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option==JOptionPane.YES_OPTION) {
						txtNumber.setText("");
						txtNumber.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						ContactsController.count();
						txtId.setText(ContactsController.generateId());
						txtName.setText("");
						txtNumber.setText("");
						txtCompany.setText("");
						txtSalary.setText("");
						txtBirthday.setText("");
						dispose();
					}
				}else if(!isValidSalary){
					int option =JOptionPane.showConfirmDialog(null, "Invalid Salary.. Do you want to input Salary again?", "Confirm",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option==JOptionPane.YES_OPTION) {
						txtSalary.setText("");
						txtSalary.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						ContactsController.count();
						txtId.setText(ContactsController.generateId());
						txtName.setText("");
						txtNumber.setText("");
						txtCompany.setText("");
						txtSalary.setText("");
						txtBirthday.setText("");
						dispose();
					}
				}else if(!isValidBirthday){
					int option =JOptionPane.showConfirmDialog(null, "Invalid Birthday.. Do you want to input Birthday again?", "Confirm",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option==JOptionPane.YES_OPTION) {
						txtBirthday.setText("");
						txtBirthday.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						ContactsController.count();
						txtId.setText(ContactsController.generateId());
						txtName.setText("");
						txtNumber.setText("");
						txtCompany.setText("");
						txtSalary.setText("");
						txtBirthday.setText("");
						dispose();
					}
				}else{
					ContactsController.addContact(contact);
					int option =JOptionPane.showConfirmDialog(null, "Added Successfull.. Do you want to add another contact?", "Confirm",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
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
			}
		});


		buttonPanel.add(btnAddContact);


		
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
				AddContact.this.dispose();
			}
		});
		buttonPanelBottom.add(btnHome);
		footerMain.add(buttonPanelBottom);
		
		add("South",footerMain);
		
		
	}
	
}
