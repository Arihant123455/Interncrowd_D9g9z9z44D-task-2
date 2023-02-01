package phonebook;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertInterface implements BuildInterface,ActionListener{
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel formPanel;
	private JLabel name_lb;
	private JLabel address_lb;
	private JLabel email_lb;
	private JLabel phone_lb;
	private JTextField name_txt;
	private JTextField address_txt;
	private JTextField email_txt;
	private JTextField phone_txt;
	private JButton insert_btn;
	
	public InsertInterface(){
		frame        = new JFrame("INSERT");
		mainPanel    = new JPanel(new BorderLayout());
		formPanel    = new JPanel(new GridLayout(4,2,10,80));
		name_lb      = new JLabel("Name:");
		address_lb   = new JLabel("Address:");
		email_lb     = new JLabel("Email:");
		phone_lb     = new JLabel("Phone:");
		name_txt     = new JTextField(100);
		address_txt  = new JTextField();
		email_txt    = new JTextField();
		phone_txt    = new JTextField();
		insert_btn   = new JButton("Insert Contact");
		
		insert_btn.addActionListener(this);
	}
	@Override
	public void build() {
		formPanel.add(name_lb);
		formPanel.add(name_txt);
		formPanel.add(address_lb);
		formPanel.add(address_txt);
		formPanel.add(email_lb);
		formPanel.add(email_txt);
		formPanel.add(phone_lb);
		formPanel.add(phone_txt);
		mainPanel.add(formPanel, BorderLayout.CENTER);
		mainPanel.add(insert_btn, BorderLayout.SOUTH);
		frame.add(mainPanel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400,700);
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			ContactDAO dao = new ContactDAO();
			Contact contact = new Contact();
			contact.setName(name_txt.getText());
			contact.setAddress(address_txt.getText());
			contact.setEmail(email_txt.getText());
			contact.setPhone(phone_txt.getText());
			dao.insert(contact);
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
			System.exit(1);
		}
		JOptionPane.showMessageDialog(null, "Contact sucessfully added.", "Success", JOptionPane.PLAIN_MESSAGE);
		frame.dispose();
	}

}
