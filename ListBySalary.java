import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.*;

class ListBySalary extends JFrame{
	private JTable tblContactSalary;
	private DefaultTableModel dtm;

	
	private JButton btnHome;
	private JButton btnReload;
	
	ListBySalary(){
		setSize(700,400);
		setTitle("List by Salary");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		JLabel titleLabel=new JLabel("List Contacts by Salary");
		titleLabel.setFont(new Font("",1,35)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBackground(Color.decode("#00b894"));
		titleLabel.setOpaque(true);
		titleLabel.setForeground(Color.WHITE);
		add("North",titleLabel);
		
		
		String[] columnName={"Contact ID", "Name","Contact Number", "Company","Salary", "Birthday"};
		dtm=new DefaultTableModel(columnName,100);
		tblContactSalary=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(tblContactSalary);
		add("Center",tablePane);

		
		
		
				//---------------------footer buttons------------------------
		
		JPanel footerMain=new JPanel(new GridLayout(1,1,1,1));
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnReload=new JButton("Reload");
		btnReload.setFont(new Font("",1,20)); 
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				Contact[] contactArray=ContactsController.ListBySalary();

				dtm.setRowCount(0);
				for(int i=0; i<contactArray.length; i++){
					Contact contact=contactArray[i];
					Object[] rowData = {contact.getId(),contact.getName(),contact.getPhoneNumber(),contact.getCompanyName(),contact.getSalary(),contact.getBirthday()};
					dtm.addRow(rowData);
				}
			}
		});
		buttonPanel.add(btnReload);
		
		footerMain.add(buttonPanel);

		btnHome=new JButton("Cancel");
		btnHome.setFont(new Font("",1,20)); 
		btnHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ListBySalary.this.dispose();
			}
		});
		buttonPanel.add(btnHome);
		
		footerMain.add(buttonPanel);
		
		add("South",footerMain);
		
	}
	
	public static void main (String args[]){
			new ListBySalary().setVisible(true);
	}
}



