import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.*;

class ListByBirthday extends JFrame{
	private JTable tblContactBirthday;
	private DefaultTableModel dtm;

	
	private JButton btnHome;
	private JButton btnReload;
	
	ListByBirthday(){
		setSize(700,400);
		setTitle("List by Birthday");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		JLabel titleLabel=new JLabel("List Contacts by Birthday");
		titleLabel.setFont(new Font("",1,35)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBackground(Color.decode("#00b894"));
		titleLabel.setOpaque(true);
		titleLabel.setForeground(Color.WHITE);
		add("North",titleLabel);
		
		
		String[] columnName={"Contact ID", "Name","Contact Number",  "Company","Salary", "Birthday"};
		dtm=new DefaultTableModel(columnName,100);
		tblContactBirthday=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(tblContactBirthday);
		add("Center",tablePane);

		
		
		
				//---------------------footer buttons------------------------
		
		JPanel footerMain=new JPanel(new GridLayout(1,1,1,1));
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));

		btnReload=new JButton("Reload");
		btnReload.setFont(new Font("",1,20)); 
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				Contact[] contactArray=ContactsController.ListByBirthday();

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
				ListByBirthday.this.dispose();
			}
		}); 
		buttonPanel.add(btnHome);
		
		footerMain.add(buttonPanel);
		
		add("South",footerMain);
		
	}
	
	public static void main (String args[]){
			new ListByBirthday().setVisible(true);
	}
}




