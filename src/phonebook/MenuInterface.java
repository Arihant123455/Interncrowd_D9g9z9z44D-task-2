package phonebook;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuInterface implements BuildInterface,ActionListener {
	private JFrame frame;
	private JPanel panel;
	private JButton show_btn,insert_btn,update_btn,delete_btn;
	
	public MenuInterface(){
		//Initialization of components 
		frame 		 = new JFrame("PhoneBook");
		panel 		 = new JPanel(new GridLayout(0,4));	
		show_btn     = new JButton(new ImageIcon("img/show.png"));
		insert_btn   = new JButton(new ImageIcon("img/insert.png"));
		update_btn   = new JButton(new ImageIcon("img/update.png"));
		delete_btn   = new JButton(new ImageIcon("img/delete.png"));

		//Adding ToolTip to all JButtons
		show_btn.setToolTipText("Show all contacts");
		insert_btn.setToolTipText("Add new contact");
		update_btn.setToolTipText("Update contact");
		delete_btn.setToolTipText("Delete contact");

		
		//Adding JButton listeners 
		show_btn.addActionListener(this);
		insert_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		
	}

	@Override
	public void build() {
		panel.add(show_btn);
		panel.add(insert_btn);
		panel.add(update_btn);
		panel.add(delete_btn);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,200);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton o = (JButton)e.getSource();
		String iconName = o.getIcon().toString();
		
		if(iconName.equals("img/show.png")){
			System.out.println("show");
		}
		else if(iconName.equals("img/insert.png")){
			InsertInterface insertI = new InsertInterface();
			insertI.build();
		}
		else if(iconName.equals("img/update.png")){
			System.out.println("update");
		}
		else{
			System.out.println("delete");
		}
	}
	
}
