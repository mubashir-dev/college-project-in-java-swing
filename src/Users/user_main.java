package Users;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;
import db_init.database_config;
import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class user_main extends JFrame {

	private JPanel contentPane;
	private final JPanel panel_5 = new JPanel();
	private JTextField pass_txt;
	private JTextField username_txt;
	private JTextField name_txt;
	private JTextField contct_txt;
	private JTable insert_panel_table;
	private JTextField user_descp;
	private JTextField update_pass_wd;
	private JTextField update_username;
	private JTextField update_name;
	private JTextField update_contact;
	private JTextField update_descp;
	private JTextField delete_user_id;
	private Connection con;
	private JTable table_user_update;
	private JTextField user_id_update;
	private JTable delete_user_table;
	private JTable user_search_table;
	private JTextField user_search_id;
	private JTable user_detain_info_table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_main frame = new user_main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public user_main() {
		setResizable(false);
		setTitle("Mobile Shop Software :: User Panel ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		//-------------------------------ICons Defination----------------------------//
		
		
		
		
		FontIcon homeicon=FontIcon.of(MaterialDesign.MDI_HOME);
		homeicon.setIconSize(45);
		homeicon.setIconColor(Color.WHITE);

		
		
		
		
		
		//---------------------------------------End of Defination--------------------//
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1234, 661);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add User", null, panel, null);
		panel.setLayout(null);
		panel_5.setBackground(new Color(100, 149, 237));
		panel_5.setBounds(10, 11, 1209, 98);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD USER");
		lblNewLabel.setFont(new Font("MS Gothic", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(79, 27, 369, 60);
		panel_5.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\telemarketer.png"));
	//	lblNewLabel_1.setIcon(new ImageIcon(user_main.class.getResource("/icons/user.png")));
		lblNewLabel_1.setBounds(10, 11, 70, 76);
		panel_5.add(lblNewLabel_1);
		
		JButton logout_btn = new JButton("Logout");
		logout_btn.setBackground(Color.BLACK);
		logout_btn.setForeground(Color.WHITE);
		logout_btn.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		logout_btn.setBounds(1092, 29, 107, 50);
		panel_5.add(logout_btn);
		
		JButton home_btn = new JButton();
		home_btn.setForeground(Color.WHITE);
		home_btn.setBackground(Color.BLACK);
		home_btn.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		home_btn.setIcon(homeicon);
		home_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		home_btn.setBounds(1005, 29, 81, 50);
		panel_5.add(home_btn);
		
		pass_txt = new JTextField();
		pass_txt.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		pass_txt.setBounds(250, 288, 229, 39);
		panel.add(pass_txt);
		pass_txt.setColumns(10);
		
		username_txt = new JTextField();
		username_txt.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		username_txt.setColumns(10);
		username_txt.setBounds(44, 288, 196, 39);
		panel.add(username_txt);
		
		name_txt = new JTextField();
		name_txt.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		name_txt.setColumns(10);
		name_txt.setBounds(44, 219, 435, 39);
		panel.add(name_txt);
		
		contct_txt = new JTextField();
		contct_txt.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		contct_txt.setColumns(10);
		contct_txt.setBounds(44, 355, 217, 39);
		panel.add(contct_txt);
		
		JComboBox combo_user_type = new JComboBox();
		combo_user_type.setModel(new DefaultComboBoxModel(new String[] {"Select User Type", "Admin", "Sales Man"}));
		combo_user_type.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		combo_user_type.setBounds(271, 355, 208, 39);
		panel.add(combo_user_type);
		
		JButton add_btn = new JButton("Add");
		add_btn.setForeground(Color.WHITE);
		add_btn.setBackground(Color.DARK_GRAY);
		add_btn.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
		add_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String name=name_txt.getText();
				String username=username_txt.getText();
				String password=pass_txt.getText();
				String contact_no=contct_txt.getText();
				String user_type=combo_user_type.getSelectedItem().toString();
				String user_decp=user_descp.getText();
				System.out.print(name+"\n"+username+"\n"+password+"\n"+contact_no+"\n"+user_type+"\n"+user_decp);
				if(name.isEmpty() || username.isEmpty() || password.isEmpty() || contact_no.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Some Fields Are  Blanks");
					return;
				}
				else if( user_type.equals("Select User Type"))
				{
					JOptionPane.showMessageDialog(null, "Select User Type");
					return;
				}
				else
				{
					
					con=database_config.get_connection();
					String sql_insert="INSERT INTO Users(username,contact_no,name,password,description,user_type)  VALUES(?,?,?,?,?,?)";
					try 
					{
						PreparedStatement insert_stmt=con.prepareStatement(sql_insert);
						insert_stmt.setString(1,username);
						insert_stmt.setString(2,contact_no);
						insert_stmt.setString(3,name);
						insert_stmt.setString(4, password);
						insert_stmt.setString(5,user_decp);
						insert_stmt.setString(6, user_type);
						int i=insert_stmt.executeUpdate();
						if(i > 0 )
						{
							System.out.println("Insert Successfully  "+i);
							JOptionPane.showMessageDialog(null, "RECORED SUCCESSFULLY INSERTED");
							name_txt.setText("");
							pass_txt.setText("");
							username_txt.setText("");
							contct_txt.setText("");
							combo_user_type.setSelectedIndex(0);
							user_descp.setText("");
							get_user_data(delete_user_table);
							get_user_data(insert_panel_table);
							get_user_data(table_user_update);
							get_user_data(user_search_table);
							get_user_data(user_detain_info_table);


						}
						else 
						{
							System.out.println("Failed "+i);
							JOptionPane.showMessageDialog(null, "RECORED NOT SUCCESSFULLY INSERTED");

						}
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
						System.out.print(e.getMessage());
					}

				}
				
				
			}
		});
		add_btn.setBounds(44, 513, 435, 54);
		panel.add(add_btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(502, 219, 717, 379);
		panel.add(scrollPane);
		
		insert_panel_table = new JTable();
				insert_panel_table.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		scrollPane.setViewportView(insert_panel_table);
		
		user_descp = new JTextField();
		user_descp.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		user_descp.setColumns(10);
		user_descp.setBounds(44, 427, 435, 39);
		panel.add(user_descp);
		
		JLabel lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(44, 395, 167, 35);
		panel.add(lblNewLabel_2);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblContactNo.setBounds(44, 327, 167, 35);
		panel.add(lblContactNo);
		
		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblUserType.setBounds(273, 327, 167, 35);
		panel.add(lblUserType);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblUsername.setBounds(44, 259, 167, 35);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblPassword.setBounds(251, 259, 167, 35);
		panel.add(lblPassword);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblFullName.setBounds(44, 184, 167, 35);
		panel.add(lblFullName);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Update User", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(0, 0, 1229, 633);
		panel_1.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(100, 149, 237));
		panel_7.setBounds(10, 11, 1209, 98);
		panel_6.add(panel_7);
		
		JLabel lblUpdateUser = new JLabel("UPDATE USER");
		lblUpdateUser.setForeground(Color.DARK_GRAY);
		lblUpdateUser.setFont(new Font("MS Gothic", Font.BOLD, 25));
		lblUpdateUser.setBounds(78, 27, 369, 60);
		panel_7.add(lblUpdateUser);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\telemarketer.png"));
		label_1.setBounds(10, 11, 70, 76);
		panel_7.add(label_1);
		
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		button.setBackground(Color.BLACK);
		button.setBounds(1005, 27, 81, 50);
		button.setIcon(homeicon);
		panel_7.add(button);
		
		JButton button_1 = new JButton("Logout");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		button_1.setBackground(Color.BLACK);
		button_1.setBounds(1092, 27, 107, 50);
		panel_7.add(button_1);
		
		update_pass_wd = new JTextField();
		update_pass_wd.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		update_pass_wd.setColumns(10);
		update_pass_wd.setBounds(250, 288, 229, 39);
		panel_6.add(update_pass_wd);
		
		update_username = new JTextField();
		update_username.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		update_username.setColumns(10);
		update_username.setBounds(44, 288, 196, 39);
		panel_6.add(update_username);
		
		update_name = new JTextField();
		update_name.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		update_name.setColumns(10);
		update_name.setBounds(44, 219, 314, 39);
		panel_6.add(update_name);
		
		update_contact = new JTextField();
		update_contact.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		update_contact.setColumns(10);
		update_contact.setBounds(44, 355, 258, 39);
		panel_6.add(update_contact);
		
		JComboBox update_combo = new JComboBox();
		update_combo.setModel(new DefaultComboBoxModel(new String[] {"Select User Type", "Admin", "Sales Man"}));
		update_combo.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		update_combo.setBounds(312, 355, 167, 39);
		panel_6.add(update_combo);
		
		JButton btn_update = new JButton("Update");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String name_update_txt=update_name.getText();
				String username_update_txt=update_username.getText();
				String pass_update_txt=update_pass_wd.getText();
				String contact_update_txt=update_contact.getText();
				String usertype_update_txt=update_combo.getSelectedItem().toString();
				String descp_update_txt=update_descp.getText();
				//u);
				if(name_update_txt.isEmpty() || pass_update_txt.isEmpty() || contact_update_txt.isEmpty() || usertype_update_txt.isEmpty() || descp_update_txt.isEmpty() || user_id_update.getText().isEmpty())
				{
					
				
					JOptionPane.showMessageDialog(null, "FILL ALL FIELDS FOR UPDATION OPREATION");
				}
				else if(usertype_update_txt.equals("Select User Type"))
				{
					JOptionPane.showMessageDialog(null, "SELECT USER TYPE");

				}
				else
				{
					try
					{   int user_id=Integer.parseInt(user_id_update.getText());
						String sql_update="UPDATE Users SET username=?,contact_no=?,name=?,password=?,description=? ,user_type=? WHERE Id = ?";
						con=database_config.get_connection();
						PreparedStatement stmt_update=con.prepareStatement(sql_update);
						stmt_update.setString(1, username_update_txt);
						stmt_update.setString(2, contact_update_txt);
						stmt_update.setString(3, name_update_txt);
						stmt_update.setString(4, pass_update_txt);
						stmt_update.setString(5, descp_update_txt);
						stmt_update.setString(6,usertype_update_txt);
						stmt_update.setInt(7, user_id);
						int i=stmt_update.executeUpdate();
						if(i > 0)
						{
							//System.out.println("Insert Successfully  "+i);
							JOptionPane.showMessageDialog(null, "RECORED SUCCESSFULLY UPDATED");
							get_user_data(delete_user_table);
							get_user_data(insert_panel_table);
							get_user_data(table_user_update);
							get_user_data(user_search_table);
							get_user_data(user_detain_info_table);
							update_name.setText("");
							update_username.setText("");
							update_pass_wd.setText("");
							update_contact.setText("");
							update_combo.setSelectedIndex(0);
							update_descp.setText("");
							user_id_update.setText("");
						}
						else
						{
							
						//	System.out.println("Insert Successfully  "+i);
							JOptionPane.showMessageDialog(null, "RECORED NOT SUCCESSFULLY UPDATED");
						}
						
					}
					
					catch(Exception e)
					{
					e.getMessage();
					System.out.print(e.getMessage());
					}
					
				}
				
				
			
			}
		});
		btn_update.setForeground(Color.WHITE);
		btn_update.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
		btn_update.setBackground(Color.DARK_GRAY);
		btn_update.setBounds(44, 513, 435, 54);
		panel_6.add(btn_update);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(502, 217, 717, 381);
		panel_6.add(scrollPane_1);
		
		table_user_update = new JTable();
		table_user_update.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		table_user_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
			TableModel model=table_user_update.getModel();
			int selected_row=table_user_update.getSelectedRow();
			int user_id=Integer.parseInt(model.getValueAt(selected_row, 0).toString());
			String name=model.getValueAt(selected_row, 1).toString();
			String username=model.getValueAt(selected_row, 2).toString();
			String password=model.getValueAt(selected_row, 3).toString();
			String descp=model.getValueAt(selected_row, 4).toString();
			String Type=model.getValueAt(selected_row, 5).toString();
			String contact=model.getValueAt(selected_row, 6).toString();
			
			//==============Fetch User Values And Filled In Fields====================//
			update_name.setText(name);
			update_username.setText(username);
			update_pass_wd.setText(password);
			update_contact.setText(contact);
			update_combo.setSelectedItem(Type);
			update_descp.setText(descp);
			user_id_update.setText(""+user_id);
			//===========================================================================//
			System.out.print("User ID : "+user_id	);
			
			}
		});

		scrollPane_1.setViewportView(table_user_update);
		
		update_descp = new JTextField();
		update_descp.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		update_descp.setColumns(10);
		update_descp.setBounds(44, 427, 435, 39);
		panel_6.add(update_descp);
		
		JLabel label_2 = new JLabel("Description");
		label_2.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		label_2.setBounds(44, 395, 167, 35);
		panel_6.add(label_2);
		
		JLabel label_3 = new JLabel("Contact No");
		label_3.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		label_3.setBounds(44, 327, 167, 35);
		panel_6.add(label_3);
		
		JLabel label_4 = new JLabel("User Type");
		label_4.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		label_4.setBounds(312, 327, 167, 35);
		panel_6.add(label_4);
		
		JLabel label_5 = new JLabel("Username");
		label_5.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		label_5.setBounds(44, 259, 167, 35);
		panel_6.add(label_5);
		
		JLabel label_6 = new JLabel("Password");
		label_6.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		label_6.setBounds(251, 259, 167, 35);
		panel_6.add(label_6);
		
		JLabel label_7 = new JLabel("Full Name");
		label_7.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		label_7.setBounds(44, 184, 167, 35);
		panel_6.add(label_7);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Delete User", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 194, 1229, 386);
		panel_2.add(scrollPane_2);
		
		delete_user_table = new JTable();
		delete_user_table.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		scrollPane_2.setViewportView(delete_user_table);
		
		JLabel lblNewLabel_3 = new JLabel("Enter User ID");
		lblNewLabel_3.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 129, 116, 50);
		panel_2.add(lblNewLabel_3);
		
		delete_user_id = new JTextField();
		delete_user_id.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		delete_user_id.setBounds(125, 131, 206, 48);
		panel_2.add(delete_user_id);
		delete_user_id.setColumns(10);
		
		JButton btn_delete_user = new JButton("Delete");
		btn_delete_user.setBackground(Color.BLACK);
		btn_delete_user.setForeground(Color.WHITE);
		btn_delete_user.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		btn_delete_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			//-----------------------------Delete User---------------------//
			if(delete_user_id.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "PROVIDE USER ID FOR THIS OPERATION");

			}
			else
			{

				try
				{
				int user_id=Integer.parseInt(delete_user_id.getText());
				con=database_config.get_connection();
				String sql_delete="DELETE FROM  Users WHERE Id =?";
				PreparedStatement stmt_delete=con.prepareStatement(sql_delete);
				stmt_delete.setInt(1, user_id);
				int query_result=stmt_delete.executeUpdate();
				if(query_result > 0)
				{
					JOptionPane.showMessageDialog(null, "RECORED DELETE SUCCESSFULLY");
					get_user_data(delete_user_table);
					get_user_data(insert_panel_table);
					get_user_data(table_user_update);
					get_user_data(user_search_table);
					get_user_data(user_detain_info_table);
					delete_user_id.setText("");

				}
				else
				{
					JOptionPane.showMessageDialog(null, "RECORED NOT SUCCESSFULLY DELETE");

				}
				}
				catch(Exception e)
				{
					e.getCause();
					e.printStackTrace();
				}
				//-------------------------------------------------------------------//

			}			}
		});
		btn_delete_user.setBounds(341, 130, 89, 49);
		panel_2.add(btn_delete_user);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(100, 149, 237));
		panel_8.setBounds(10, 11, 1209, 98);
		panel_2.add(panel_8);
		
		JLabel lblDeleteUser = new JLabel("DELETE USER");
		lblDeleteUser.setForeground(Color.DARK_GRAY);
		lblDeleteUser.setFont(new Font("MS Gothic", Font.BOLD, 25));
		lblDeleteUser.setBounds(79, 27, 369, 60);
		panel_8.add(lblDeleteUser);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\user (1).png"));
		label_8.setBounds(10, 11, 70, 76);
		panel_8.add(label_8);
		
		JButton button_2 = new JButton("Logout");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		button_2.setBackground(Color.BLACK);
		button_2.setBounds(1092, 29, 107, 50);
		panel_8.add(button_2);
		
		JButton button_3 = new JButton("Home");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		button_3.setBackground(Color.BLACK);
		button_3.setBounds(978, 29, 104, 50);
		panel_8.add(button_3);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Search User", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 195, 1229, 438);
		panel_3.add(scrollPane_3);
		
		user_search_table = new JTable();
		user_search_table.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		scrollPane_3.setViewportView(user_search_table);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(100, 149, 237));
		panel_9.setBounds(10, 11, 1209, 98);
		panel_3.add(panel_9);
		
		JLabel lblSearchUser = new JLabel("SEARCH USER");
		lblSearchUser.setForeground(Color.DARK_GRAY);
		lblSearchUser.setFont(new Font("MS Gothic", Font.BOLD, 25));
		lblSearchUser.setBounds(79, 27, 369, 60);
		panel_9.add(lblSearchUser);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\telemarketer.png"));
		label_9.setBounds(10, 11, 70, 76);
		panel_9.add(label_9);
		
		JButton button_4 = new JButton("Logout");
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		button_4.setBackground(Color.BLACK);
		button_4.setBounds(1092, 29, 107, 50);
		panel_9.add(button_4);
		
		JButton button_5 = new JButton();
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		button_5.setBackground(Color.BLACK);
		button_5.setIcon(homeicon);
		button_5.setBounds(1005, 29, 81, 50);
		panel_9.add(button_5);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("View User", null, panel_4, null);	
		panel_4.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(100, 149, 237));
		panel_10.setBounds(10, 11, 1209, 98);
		panel_4.add(panel_10);
		
		JLabel lblUserDetails = new JLabel("USER DETAILS");
		lblUserDetails.setForeground(Color.DARK_GRAY);
		lblUserDetails.setFont(new Font("MS Gothic", Font.BOLD, 25));
		lblUserDetails.setBounds(79, 27, 369, 60);
		panel_10.add(lblUserDetails);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\telemarketer.png"));
		label_11.setBounds(10, 11, 70, 76);
		panel_10.add(label_11);
		
		JButton button_7 = new JButton("Logout");
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		button_7.setBackground(Color.BLACK);
		button_7.setBounds(1092, 29, 107, 50);
		panel_10.add(button_7);
		
		JButton button_8 = new JButton();
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		button_8.setBackground(Color.BLACK);
		button_8.setIcon(homeicon);
		button_8.setBounds(1005, 29, 81, 50);
		panel_10.add(button_8);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 160, 1229, 473);
		panel_4.add(scrollPane_4);
		
		user_detain_info_table = new JTable();
		user_detain_info_table.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		scrollPane_4.setViewportView(user_detain_info_table);
	JLabel lblUserId = new JLabel("User Id");
	lblUserId.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
	lblUserId.setBounds(368, 184, 101, 35);
	panel_6.add(lblUserId);
	
	user_id_update = new JTextField();
	user_id_update.setEditable(false);
	user_id_update.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
	user_id_update.setColumns(10);
	user_id_update.setBounds(368, 219, 111, 39);
	panel_6.add(user_id_update);
	//===========================Populate Table With Data==========================//

	get_user_data(delete_user_table);
	get_user_data(insert_panel_table);
	get_user_data(table_user_update);
	get_user_data(user_search_table);
	get_user_data(user_detain_info_table);
	//=============================End of Call===================================//
	//======================Table Header Font And Background Color Method Call====================//
	set_header_font(delete_user_table);
	set_header_font(insert_panel_table);
	set_header_font(table_user_update);
	set_header_font(user_search_table);
	set_header_font(user_detain_info_table);
	//===========================================================================================//
	
	JLabel label = new JLabel("Enter User ID");
	label.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
	label.setBounds(231, 134, 116, 50);
	panel_3.add(label);
	
	user_search_id = new JTextField();
	user_search_id.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
	user_search_id.setColumns(10);
	user_search_id.setBounds(346, 136, 206, 48);
	panel_3.add(user_search_id);
	
	JButton btn_search = new JButton("Search");
	btn_search.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0)
		{
			user_search_id.getText();
			
			//user_search_table
			if(user_search_id.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "PROVIDE USER ID FOR SEARCHING");
			}
			else
			{
				search_user_data(Integer.parseInt(user_search_id.getText()),user_search_table);
			}
			
		}
	});
	btn_search.setForeground(Color.WHITE);
	btn_search.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
	btn_search.setBackground(Color.BLACK);
	btn_search.setBounds(562, 135, 89, 49);
	panel_3.add(btn_search);
	//==================================End of Call===============================//
	
	
	}
	
	//=========================Method for Showing User Data===================================//

	public void get_user_data(JTable table_name)
	{
		con=database_config.get_connection();
		String sql_read="SELECT Id as User_ID,name as Name,username as Username, password as Password, description as Description, user_type as Type,contact_no as Contact FROM Users";
		try {
			PreparedStatement stmt_read=con.prepareStatement(sql_read);
			ResultSet result_read=stmt_read.executeQuery();
			table_name.setModel(DbUtils.resultSetToTableModel(result_read));
			//table_user_update.setModel(DbUtils.resultSetToTableModel(result_read));
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	//================================================End of User Data Method===========================//
	
	
	//=====================================Method For Search User Data=================================//
	public void search_user_data(int user_id,JTable table_search)
	{
		con=database_config.get_connection();
		String sql_read="SELECT Id as User_ID,name as Name,username as Username, password as Password, description as Description, user_type as Type,contact_no as Contact FROM Users WHERE Id = ?";
		try {
			PreparedStatement stmt_read=con.prepareStatement(sql_read);
			stmt_read.setInt(1, user_id);
			ResultSet result_read=stmt_read.executeQuery();
			if(result_read.next())
			{
				table_search.setModel(DbUtils.resultSetToTableModel(result_read));
			}
			else
			{
				JOptionPane.showMessageDialog(null, "USER DATA NOT FOUND IN RECORED");
				user_search_id.setText("");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	//================================================End of Search Method==================================//
	
	//=================================Method for Seting Table Header ======================================//
	public void set_header_font(JTable table_name)
	{
		JTableHeader header = table_name.getTableHeader();
		header.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		header.setBackground(new Color(100, 149, 237));

	}
}
