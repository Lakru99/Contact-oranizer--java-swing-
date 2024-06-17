import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ViewContactList extends JFrame{
	private JButton btnListByName;
	//private JButton btnReload;
	private JButton btnCancel;
	private JButton btnListBySalary;
	private JButton btnListByBirthday;
	private ListByBirthday listByBirthday;
	private ListByName listByName;
	private ListBySalary listBySalary;
	
	ViewContactList(){
		setSize(700,400);
		setTitle("Contact List");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		JLabel titleLabel=new JLabel("Contact List");
		titleLabel.setFont(new Font("",1,35)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBackground(Color.decode("#00b894"));
		titleLabel.setOpaque(true);
		titleLabel.setForeground(Color.WHITE);
		add("North",titleLabel);
		
		
		JPanel mainPanel=new JPanel(new GridLayout(3,1,1,1));
		
		JPanel topPanel=new JPanel(new GridLayout(1,1,1,1));
		JPanel topButtonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		btnListByName=new JButton("List by Name");
		btnListByName.setFont(new Font("",1,15)); 
		btnListByName.setPreferredSize(new Dimension(300, 50));
		btnListByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				if (listByName==null) {
					listByName=new ListByName();
				}
				listByName.setVisible(true);
			}
		});

		topButtonPanel.add(btnListByName);
		
		topPanel.add(topButtonPanel);
		
		mainPanel.add(topPanel);
		
		
		JPanel centerPanel=new JPanel(new GridLayout(1,1,1,1));
		JPanel centerButtonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		btnListBySalary=new JButton("List by Salary");
		btnListBySalary.setFont(new Font("",1,15)); 
		btnListBySalary.setPreferredSize(new Dimension(300, 50));
		btnListBySalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				if (listBySalary==null) {
					listBySalary=new ListBySalary();
				}
				listBySalary.setVisible(true);
			}
		});
		centerButtonPanel.add(btnListBySalary);
		
		centerPanel.add(centerButtonPanel);
		
		mainPanel.add(centerPanel);
		
		
		JPanel bottomPanel=new JPanel(new GridLayout(1,1,1,1));
		JPanel bottomButtonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		btnListByBirthday=new JButton("List by Birthday");
		btnListByBirthday.setFont(new Font("",1,15)); 
		btnListByBirthday.setPreferredSize(new Dimension(300, 50));
		btnListByBirthday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				if (listByBirthday==null) {
					listByBirthday=new ListByBirthday();
				}
				listByBirthday.setVisible(true);
			}
		});
		bottomButtonPanel.add(btnListByBirthday);
		
		bottomPanel.add(bottomButtonPanel);
		
		mainPanel.add(bottomPanel);
		
		add(mainPanel);
				//---------------------footer buttons------------------------
		
		JPanel footerMain=new JPanel(new GridLayout(1,1,1,1));
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
	
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,20)); 
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ViewContactList.this.dispose();
			}
		}); 
		buttonPanel.add(btnCancel);


		
		
		footerMain.add(buttonPanel);
		
		add("South",footerMain);
		
	}
	
	public static void main (String args[]){
			new ViewContactList().setVisible(true);
	}
}

