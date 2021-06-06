package student;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;
import db_init.database_config;
import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class Student extends JFrame {

	private JPanel contentPane;
	private final JPanel panel_5 = new JPanel();
	private JTextField name_txt;
	private JTextField contct_txt;
	private JTable insert_panel_table;
	private JTextField cust_descp;
	private JTextField update_name;
	private JTextField update_contact;
	private JTextField update_address;
	private JTextField delete_supp_id;
	private Connection con;
	private JTable table_user_update;
	private JTextField cust_id_update;
	private JTable delete_user_table;
	private JTextField supp_search_id;
	private JTable user_detain_info_table;
	private JTextField supp_cnic;
	private JTextField update_cnic;
	//=======================Date Object===================================//
	java.util.Date date=new java.util.Date();
	java.sql.Date curr_date=new java.sql.Date(date.getDate());
	//===================================Lables For Display Search Data In Below Lables=====================//
	private JLabel lb_cust_name;
	private JLabel lb_contact_cust;
	private JLabel lb_cust_nic;
	private JLabel lb_cust_adder;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
				      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

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
	public Student() {
		setResizable(false);
		setTitle("College Project|Student");
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
		FontIcon print_icon=FontIcon.of(MaterialDesign.MDI_PRINTER);
		print_icon.setIconSize(35);
		print_icon.setIconColor(Color.WHITE);

		
		
		
		
		
		//---------------------------------------End of Defination--------------------//
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1234, 661);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("ADD STUDENT", new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\plus.png"), panel, null);
		panel.setLayout(null);
		panel_5.setBackground(new Color(100, 149, 237));
		panel_5.setBounds(10, 11, 1209, 98);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD STUDENT");
		lblNewLabel.setFont(new Font("MS Gothic", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(79, 27, 369, 60);
		panel_5.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\cart.png"));
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
		
		name_txt = new JTextField();
		name_txt.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		name_txt.setColumns(10);
		name_txt.setBounds(44, 230, 435, 39);
		panel.add(name_txt);
		
		contct_txt = new JTextField();
		contct_txt.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		contct_txt.setColumns(10);
		contct_txt.setBounds(44, 366, 435, 39);
		panel.add(contct_txt);
		
		JButton add_btn = new JButton("Add");
		add_btn.setForeground(Color.WHITE);
		add_btn.setBackground(Color.DARK_GRAY);
		add_btn.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
		add_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String name=name_txt.getText();
				String contact_no=contct_txt.getText();
				String cust_descpn=cust_descp.getText();
				String cnic=supp_cnic.getText();
			//	System.out.print(name+"\n"+contact_no+"\n"++"\n"+cust_descpn);
				if(name.isEmpty() || cnic.isEmpty() || contact_no.isEmpty() || cust_descpn.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "SOME FIELDS ARE EMPTY");
					return;
				}
				else
				{
					
					con=database_config.get_connection();
					String sql_insert="INSERT INTO Suppliers(supp_name,supp_contact,supp_cnic,supp_address)  VALUES(?,?,?,?)";
					try 
					{
						PreparedStatement insert_stmt=con.prepareStatement(sql_insert);
						insert_stmt.setString(1,name);
						insert_stmt.setString(2,contact_no);
						insert_stmt.setString(3,cnic);
						insert_stmt.setString(4,cust_descpn);
						int i=insert_stmt.executeUpdate();
						if(i > 0 )
						{
							System.out.println("Insert Successfully  "+i);
							JOptionPane.showMessageDialog(null, "RECORED SUCCESSFULLY INSERTED");
							name_txt.setText("");
							contct_txt.setText("");
							cust_descp.setText("");
							supp_cnic.setText("");
							get_user_data(delete_user_table);
							get_user_data(insert_panel_table);
							get_user_data(table_user_update);
						//	get_user_data(user_search_table);
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
		
		cust_descp = new JTextField();
		cust_descp.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		cust_descp.setColumns(10);
		cust_descp.setBounds(44, 435, 435, 39);
		panel.add(cust_descp);
		
		JLabel lblNewLabel_2 = new JLabel("ADDRESS");
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(44, 404, 167, 25);
		panel.add(lblNewLabel_2);
		
		JLabel lblContactNo = new JLabel("CONTACT NO");
		lblContactNo.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblContactNo.setBounds(44, 344, 167, 25);
		panel.add(lblContactNo);
		
		JLabel lblFullName = new JLabel("NAME");
		lblFullName.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblFullName.setBounds(44, 201, 167, 25);
		panel.add(lblFullName);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("UPDATE STUDENT", new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\pen.png"), panel_1, null);
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
		
		JLabel lblUpdateUser = new JLabel("UPDATE STUDENT");
		lblUpdateUser.setForeground(Color.DARK_GRAY);
		lblUpdateUser.setFont(new Font("MS Gothic", Font.BOLD, 25));
		lblUpdateUser.setBounds(78, 27, 369, 60);
		panel_7.add(lblUpdateUser);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\cart.png"));
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
		
		update_name = new JTextField();
		update_name.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		update_name.setColumns(10);
		update_name.setBounds(44, 219, 314, 39);
		panel_6.add(update_name);
		
		update_contact = new JTextField();
		update_contact.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		update_contact.setColumns(10);
		update_contact.setBounds(44, 281, 435, 39);
		panel_6.add(update_contact);
		
		JButton btn_update = new JButton("Update");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String name_update_txt=update_name.getText();
				String contact_update_txt=update_contact.getText();
				String address_update=update_address.getText();
				String nic=update_cnic.getText();
				//u);
				if(name_update_txt.isEmpty() ||contact_update_txt.isEmpty()  || cust_id_update.getText().isEmpty() || nic.isEmpty())
				{
					
					JOptionPane.showMessageDialog(null, "FILL ALL FIELDS FOR UPDATION OPREATION","MESSAGE",JOptionPane.CANCEL_OPTION);
				}
				else
				{
					try
					{   int cust_id=Integer.parseInt(cust_id_update.getText());
						String sql_update="UPDATE Suppliers SET supp_name=?,supp_contact=?,supp_cnic=?,supp_address=? WHERE supp_id = ?";
						con=database_config.get_connection();
						PreparedStatement stmt_update=con.prepareStatement(sql_update);
						stmt_update.setString(1, name_update_txt);
						stmt_update.setString(2, contact_update_txt);
						stmt_update.setString(3, nic);
						stmt_update.setString(4, address_update);
						stmt_update.setInt(5, cust_id);
						int i=stmt_update.executeUpdate();
						if(i > 0)
						{
							//System.out.println("Insert Successfully  "+i);
							JOptionPane.showMessageDialog(null, "SUPPLIER RECORED SUCCESSFULLY UPDATED");
							get_user_data(delete_user_table);
							get_user_data(insert_panel_table);
							get_user_data(table_user_update);
							//get_user_data(user_search_table);
							get_user_data(user_detain_info_table);
							update_name.setText("");
							update_contact.setText("");
							update_address.setText("");
							cust_id_update.setText("");
							update_cnic.setText("");
							
						}
						else
						{
							
						//	System.out.println("Insert Successfully  "+i);
							JOptionPane.showMessageDialog(null, "SUPPLIER RECORED NOT SUCCESSFULLY UPDATED");
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
			String contact_no=model.getValueAt(selected_row, 2).toString();
			String nic=model.getValueAt(selected_row, 3).toString();
			String address=model.getValueAt(selected_row, 4).toString();
			
			//==============Fetch User Values And Filled In Fields====================//
			update_name.setText(name);
			update_contact.setText(contact_no);
			update_address.setText(address);
			cust_id_update.setText(""+user_id);
			update_cnic.setText(nic);
			//===========================================================================//
			System.out.print("User ID : "+user_id	);
			
			}
		});
		
				scrollPane_1.setViewportView(table_user_update);
				
				update_address = new JTextField();
				update_address.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
				update_address.setColumns(10);
				update_address.setBounds(44, 417, 435, 39);
				panel_6.add(update_address);
				
				JLabel lblAddress = new JLabel("ADDRESS");
				lblAddress.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
				lblAddress.setBounds(44, 384, 167, 39);
				panel_6.add(lblAddress);
				
				JLabel lblContactNo_1 = new JLabel("CONTACT NO");
				lblContactNo_1.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
				lblContactNo_1.setBounds(44, 253, 435, 35);
				panel_6.add(lblContactNo_1);
				
				JLabel lblName = new JLabel("NAME");
				lblName.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
				lblName.setBounds(44, 184, 167, 35);
				panel_6.add(lblName);
				JLabel lblUserId = new JLabel("ID");
				lblUserId.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
				lblUserId.setBounds(368, 184, 101, 35);
				panel_6.add(lblUserId);
				
				cust_id_update = new JTextField();
				cust_id_update.setEditable(false);
				cust_id_update.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
				cust_id_update.setColumns(10);
				cust_id_update.setBounds(368, 219, 111, 39);
				panel_6.add(cust_id_update);
				get_user_data(table_user_update);
				set_header_font(table_user_update);
				
				JLabel lblCnic_1 = new JLabel("CNIC");
				lblCnic_1.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
				lblCnic_1.setBounds(44, 316, 435, 35);
				panel_6.add(lblCnic_1);
				
				update_cnic = new JTextField();
				update_cnic.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
				update_cnic.setColumns(10);
				update_cnic.setBounds(44, 349, 435, 39);
				panel_6.add(update_cnic);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("DELETE STUDENT", new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\paper-bucket.png"), panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 194, 1229, 386);
		panel_2.add(scrollPane_2);
		
		delete_user_table = new JTable();
		delete_user_table.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		scrollPane_2.setViewportView(delete_user_table);
		
		JLabel lblNewLabel_3 = new JLabel("ENTER STUDENT ID");
		lblNewLabel_3.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 129, 189, 50);
		panel_2.add(lblNewLabel_3);
		
		delete_supp_id = new JTextField();
		delete_supp_id.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		delete_supp_id.setBounds(197, 132, 218, 48);
		panel_2.add(delete_supp_id);
		delete_supp_id.setColumns(10);
		
		JButton btn_delete_user = new JButton("Delete");
		btn_delete_user.setBackground(Color.BLACK);
		btn_delete_user.setForeground(Color.WHITE);
		btn_delete_user.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		btn_delete_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			//-----------------------------Delete User---------------------//
			if(delete_supp_id.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "PROVIDE CUSTOMER ID FOR THIS OPERATION");

			}
			else
			{

				try
				{
				int supp_id=Integer.parseInt(delete_supp_id.getText());
				con=database_config.get_connection();
				String sql_delete="DELETE FROM  Suppliers WHERE supp_id =?";
				PreparedStatement stmt_delete=con.prepareStatement(sql_delete);
				stmt_delete.setInt(1, supp_id);
				int query_result=stmt_delete.executeUpdate();
				if(query_result > 0)
				{
					JOptionPane.showMessageDialog(null, "SUPPLIER RECORED DELETE SUCCESSFULLY");
					get_user_data(delete_user_table);
					get_user_data(insert_panel_table);
					get_user_data(table_user_update);
					//get_user_data(user_search_table);
					get_user_data(user_detain_info_table);
					delete_supp_id.setText("");

				}
				else
				{
					JOptionPane.showMessageDialog(null, "SUPPLIER RECORED NOT SUCCESSFULLY DELETE");
					delete_supp_id.setText("");


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
		btn_delete_user.setBounds(425, 131, 89, 49);
		panel_2.add(btn_delete_user);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(100, 149, 237));
		panel_8.setBounds(10, 11, 1209, 98);
		panel_2.add(panel_8);
		
		JLabel lblDeleteUser = new JLabel("DELETE STUDENT");
		lblDeleteUser.setForeground(Color.DARK_GRAY);
		lblDeleteUser.setFont(new Font("MS Gothic", Font.BOLD, 25));
		lblDeleteUser.setBounds(79, 27, 369, 60);
		panel_8.add(lblDeleteUser);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\cart.png"));
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
		tabbedPane.addTab("SEARCH STUDENT", new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\loupe.png"), panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(100, 149, 237));
		panel_9.setBounds(10, 11, 1209, 98);
		panel_3.add(panel_9);
		
		JLabel lblSearchUser = new JLabel("SEARCH STUDENT");
		lblSearchUser.setForeground(Color.DARK_GRAY);
		lblSearchUser.setFont(new Font("MS Gothic", Font.BOLD, 25));
		lblSearchUser.setBounds(79, 27, 369, 60);
		panel_9.add(lblSearchUser);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\cart.png"));
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
		tabbedPane.addTab("VIEW STUDENT", new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\archives.png"), panel_4, null);	
		panel_4.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(100, 149, 237));
		panel_10.setBounds(10, 11, 1209, 98);
		panel_4.add(panel_10);
		
		JLabel lblUserDetails = new JLabel("STUDENT DETAILS");
		lblUserDetails.setForeground(Color.DARK_GRAY);
		lblUserDetails.setFont(new Font("MS Gothic", Font.BOLD, 25));
		lblUserDetails.setBounds(79, 27, 369, 60);
		panel_10.add(lblUserDetails);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\cart.png"));
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
		scrollPane_4.setBounds(0, 177, 1229, 456);
		panel_4.add(scrollPane_4);
		
		user_detain_info_table = new JTable();
		user_detain_info_table.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		scrollPane_4.setViewportView(user_detain_info_table);
	//===========================Populate Table With Data==========================//

	get_user_data(delete_user_table);
	get_user_data(insert_panel_table);
	get_user_data(user_detain_info_table);
	//=============================End of Call===================================//
	//======================Table Header Font And Background Color Method Call====================//
	set_header_font(delete_user_table);
	set_header_font(insert_panel_table);
	
	JLabel lblCnic = new JLabel("CNIC");
	lblCnic.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
	lblCnic.setBounds(44, 269, 167, 25);
	panel.add(lblCnic);
	
	supp_cnic = new JTextField();
	supp_cnic.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
	supp_cnic.setColumns(10);
	supp_cnic.setBounds(44, 294, 435, 39);
	panel.add(supp_cnic);
	set_header_font(user_detain_info_table);
	
	JButton btnNewButton = new JButton();
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0)
		{
		JOptionPane.showMessageDialog(null, "CURRENTLY NOT AVAILABLE","MESSAGE",JOptionPane.WARNING_MESSAGE);
		}
	});
	btnNewButton.setBackground(Color.BLACK);
	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
	btnNewButton.setBounds(1124, 120, 77, 46);
	btnNewButton.setIcon(print_icon);
	panel_4.add(btnNewButton);
	//===========================================================================================//
	
	JLabel lblEnterCustomerId = new JLabel("ENTER STUDENT ID\r\n");
	lblEnterCustomerId.setFont(new Font("Yu Gothic", Font.BOLD, 16));
	lblEnterCustomerId.setBounds(160, 134, 187, 50);
	panel_3.add(lblEnterCustomerId);
	
	supp_search_id = new JTextField();
	supp_search_id.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
	supp_search_id.setColumns(10);
	supp_search_id.setBounds(346, 136, 206, 48);
	panel_3.add(supp_search_id);
	
	JButton btn_search = new JButton("Search");
	btn_search.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0)
		{
			supp_search_id.getText();
			PreparedStatement stmt_read=null;
			//user_search_table
			if(supp_search_id.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "PROVIDE SUPPLIER ID FOR SEARCHING");
				supp_search_id.setText("");
				lb_cust_name.setText("");
				lb_contact_cust.setText("");
				lb_cust_nic.setText("");
				lb_cust_adder.setText("");
			}
			else
			{
				
				con=database_config.get_connection();
				String sql_read="SELECT *FROM Suppliers WHERE supp_id =?";
				try {
					
					int cust_id=Integer.parseInt(supp_search_id.getText());
					stmt_read=con.prepareStatement(sql_read);
					stmt_read.setInt(1, cust_id);
					ResultSet result_read=stmt_read.executeQuery();
					if(result_read.next())
					{
						lb_cust_name.setText(result_read.getString("supp_name"));
						lb_contact_cust.setText(result_read.getString("supp_contact"));
						lb_cust_nic.setText(result_read.getString("supp_cnic"));
						lb_cust_adder.setText(result_read.getString("supp_address"));
					}
					else
					{
						JOptionPane.showMessageDialog(null, "SUPPLIER DATA NOT FOUND IN RECORED");
						supp_search_id.setText("");
						lb_cust_name.setText("");
						lb_contact_cust.setText("");
						lb_cust_nic.setText("");
						lb_cust_adder.setText("");
					}
					
				} catch (SQLException e) 
				{
					e.printStackTrace();
					System.out.println(e.getMessage());
				}	
				finally
				{
					try
					{
						con.close();
						stmt_read.close();
					}
					catch(Exception e)
					{
						e.getMessage();
					}
				}
				
		}
			
		}
	});
	btn_search.setForeground(Color.WHITE);
	btn_search.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
	btn_search.setBackground(Color.BLACK);
	btn_search.setBounds(562, 135, 89, 49);
	panel_3.add(btn_search);
	
	JPanel panel_11 = new JPanel();
	panel_11.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(0, 0, 0)));
	panel_11.setBounds(10, 195, 1209, 409);
	panel_3.add(panel_11);
	panel_11.setLayout(null);
	
	JLabel lblNewLabel_4 = new JLabel("NAME");
	lblNewLabel_4.setFont(new Font("Yu Gothic", Font.BOLD, 15));
	lblNewLabel_4.setBounds(45, 32, 194, 42);
	panel_11.add(lblNewLabel_4);
	
	JLabel lblNic = new JLabel("NIC");
	lblNic.setFont(new Font("Yu Gothic", Font.BOLD, 15));
	lblNic.setBounds(45, 85, 194, 42);
	panel_11.add(lblNic);
	
	JLabel lblContactNo_2 = new JLabel("CONTACT NO");
	lblContactNo_2.setFont(new Font("Yu Gothic", Font.BOLD, 15));
	lblContactNo_2.setBounds(45, 127, 194, 42);
	panel_11.add(lblContactNo_2);
	
	JLabel lblAddress_1 = new JLabel("ADDRESS");
	lblAddress_1.setFont(new Font("Yu Gothic", Font.BOLD, 15));
	lblAddress_1.setBounds(45, 176, 194, 42);
	panel_11.add(lblAddress_1);
	
	lb_cust_name = new JLabel("");
	lb_cust_name.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
	lb_cust_name.setBorder(new LineBorder(new Color(0, 0, 0)));
	lb_cust_name.setBounds(246, 32, 537, 42);
	panel_11.add(lb_cust_name);
	
	lb_cust_nic = new JLabel("");
	lb_cust_nic.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
	lb_cust_nic.setBorder(new LineBorder(new Color(0, 0, 0)));
	lb_cust_nic.setBounds(246, 81, 537, 42);
	panel_11.add(lb_cust_nic);
	
	lb_contact_cust = new JLabel("");
	lb_contact_cust.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
	lb_contact_cust.setBorder(new LineBorder(new Color(0, 0, 0)));
	lb_contact_cust.setBounds(246, 127, 537, 42);
	panel_11.add(lb_contact_cust);
	
	lb_cust_adder = new JLabel("");
	lb_cust_adder.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
	lb_cust_adder.setBorder(new LineBorder(new Color(0, 0, 0)));
	lb_cust_adder.setBounds(246, 176, 537, 42);
	panel_11.add(lb_cust_adder);
	//==================================End of Call===============================//
	
	
	}
	
	//=========================Method for Showing User Data===================================//

	public void get_user_data(JTable table_name)
	{
		con=database_config.get_connection();
		String sql_read="SELECT  supp_id as ID,supp_name as NAME,supp_contact as CONTACT,supp_cnic as NIC,supp_address as ADDRESS FROM Suppliers";
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
				supp_search_id.setText("");
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
