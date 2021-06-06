package Empolyees;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class empolyee_main extends JFrame {

	private JPanel contentPane;
	private final JPanel panel_5 = new JPanel();
	private JTextField emp_pay_txt;
	private JTextField emp_cnic_txt;
	private JTextField name_txt;
	private JTextField emp_contact;
	private JTextField emp_descp;
	private JTextField update_pay_emp;
	private JTextField update_cnic_emp;
	private JTextField update_name_emp;
	private JTextField update_contact_emp;
	private JTextField update_descp_emp;
	private JTextField delete_emp_id;
	private Connection con=database_config.get_connection();
	private JTextField emp_id_update;
	private JTable delete_user_table;
	private JTable emp_search_table;
	private JTextField emp_search_id;
	private JTable emp_detain_info_table;
	private String path="";//For Holding Image of Empolyee//
	private byte[] emp_image;
	private JLabel set_image_emp;
	private JComboBox combo_emp_post;//For Insertion Data
	JComboBox update_combo_post_emp;//For Updation Data

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					empolyee_main frame = new empolyee_main();
					//UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel"); 
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
	public empolyee_main() {
		setResizable(false);
	   setTitle("College Project|Faculty");
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

		FontIcon image=FontIcon.of(MaterialDesign.MDI_IMAGE);
		image.setIconSize(100);
		image.setIconColor(Color.BLACK);
		FontIcon rfresh_icon=FontIcon.of(MaterialDesign.MDI_REFRESH);
		rfresh_icon.setIconSize(30);
		rfresh_icon.setIconColor(Color.white);

		
		
		
		
		
		//---------------------------------------End of Defination--------------------//
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1234, 661);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("ADD EMPOLYEE", new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\plus.png"), panel, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		panel.setLayout(null);
		panel_5.setBackground(new Color(100, 149, 237));
		panel_5.setBounds(10, 11, 1209, 98);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD EMPOLYEE");
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
			
			emp_pay_txt = new JTextField();
			emp_pay_txt.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
			emp_pay_txt.setBounds(44, 300, 193, 39);
			panel.add(emp_pay_txt);
			emp_pay_txt.setColumns(10);
			
			emp_cnic_txt = new JTextField();
			emp_cnic_txt.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
			emp_cnic_txt.setColumns(10);
			emp_cnic_txt.setBounds(44, 236, 435, 39);
			panel.add(emp_cnic_txt);
			
			name_txt = new JTextField();
			name_txt.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
			name_txt.setColumns(10);
			name_txt.setBounds(44, 164, 435, 39);
			panel.add(name_txt);
			
			emp_contact = new JTextField();
			emp_contact.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
			emp_contact.setColumns(10);
			emp_contact.setBounds(44, 366, 217, 39);
			panel.add(emp_contact);
			
			JComboBox combo_emp_type = new JComboBox();
			combo_emp_type.setModel(new DefaultComboBoxModel(new String[] {"Select Empolyee Status", "Working", "Not Working"}));
			combo_emp_type.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
			combo_emp_type.setBounds(271, 366, 208, 39);
			panel.add(combo_emp_type);
			
			JButton add_btn = new JButton("Add");
			add_btn.setForeground(Color.WHITE);
			add_btn.setBackground(Color.DARK_GRAY);
			add_btn.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
			add_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					PreparedStatement insert_stmt=null;
					String name=name_txt.getText();
					String emp_cnic=emp_cnic_txt.getText();
					String emp_pay=emp_pay_txt.getText();
					String contact_no=emp_contact.getText();
					String emp_status=combo_emp_type.getSelectedItem().toString();
					String emp_decp=emp_descp.getText();
					String emp_post=combo_emp_post.getSelectedItem().toString();
					System.out.print(name+"\n"+emp_cnic+"\n"+emp_pay+"\n"+contact_no+"\n"+emp_status+"\n"+emp_decp);
					if(name.isEmpty() || emp_cnic.isEmpty() || emp_pay.isEmpty() || contact_no.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "SOME FIELDS ARE EMPTY");
						return;
					}
					else if(Integer.parseInt(emp_cnic)!=13)
					{
						JOptionPane.showMessageDialog(null, "EMPOLYEE CNIC SHOULD BE 13 DIGIT");
						return;
					}
					else if(emp_post.equals("Select Empolyee Post"))
					{
						JOptionPane.showMessageDialog(null, "SELECT EMPOLYEE STATUS");
						return;

					}
					else if( emp_status.equals("Select Empolyee Statsus"))
					{
						JOptionPane.showMessageDialog(null, "SELECT EMPOLYEE STATUS");
						return;
					}
					else if(path.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "PROVIDE EMPOLYEE IMAGE");
						return;

					}
					else
					{
						//=======================================Image Processing to Byte========================//
						try
						{
							File emp_image_file=new File(path);
							FileInputStream img_file=new FileInputStream(emp_image_file);
							ByteArrayOutputStream bos=new ByteArrayOutputStream();
							byte[] buf=new byte[1024];
							 for (int len; (len = img_file.read(buf)) != -1;)
							 {
					                bos.write(buf, 0, len);
					         }
							 emp_image=bos.toByteArray();
							
						}
						catch(Exception e)
						{
							e.getMessage();
						}
						//=======================================End of Image Processing Block================================================//
						//
					//	JOptionPane.showMessageDialog(null, "YOU ARE GOOD TO GO","INFO",JOptionPane.ERROR_MESSAGE);
						con=database_config.get_connection();
						String sql_insert="INSERT INTO Empolyees(emp_name,emp_contact,emp_cnic,emp_status,emp_image,emp_pay,emp_description,emp_post)  VALUES(?,?,?,?,?,?,?,?)";
						try 
						{
							con=database_config.get_connection();
							InputStream input_emp_img=new FileInputStream(new File(path));
							insert_stmt=con.prepareStatement(sql_insert);
							insert_stmt.setString(1,name);
							insert_stmt.setString(2,contact_no);
							insert_stmt.setString(3,emp_cnic);
							insert_stmt.setString(4, emp_status);
							insert_stmt.setBytes(5, emp_image);
							insert_stmt.setString(6,emp_pay);
							insert_stmt.setString(7, emp_decp);
							insert_stmt.setString(8, emp_post);
							int i=insert_stmt.executeUpdate();
							if(i > 0 )
							{
								System.out.println("Insert Successfully  "+i);
								JOptionPane.showMessageDialog(null, "RECORED SUCCESSFULLY INSERTED","SUCCESS MESSAGE",JOptionPane.INFORMATION_MESSAGE);
								name_txt.setText("");
								emp_pay_txt.setText("");
								emp_cnic_txt.setText("");
								emp_contact.setText("");
								set_image_emp.setIcon(image);
								combo_emp_type.setSelectedIndex(0);
								combo_emp_post.setSelectedIndex(0);
								emp_descp.setText("");
								get_user_data(delete_user_table);
								//get_user_data(insert_panel_table);
								//get_user_data(table_user_update);
								get_user_data(emp_search_table);
								get_user_data(emp_detain_info_table);


							}
							else 
							{
								System.out.println("Failed "+i);
								JOptionPane.showMessageDialog(null, "RECORED NOT SUCCESSFULLY INSERTED");
							}	
							
						
						} 
						catch (Exception e) 
						{
							e.printStackTrace();
							System.out.print(e.getMessage());
						}
						finally
						{
							try {
								con.close();
								insert_stmt.close();

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}

					}
					
					
				}
			});
			add_btn.setBounds(44, 513, 435, 54);
			panel.add(add_btn);
			
			emp_descp = new JTextField();
			emp_descp.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
			emp_descp.setColumns(10);
			emp_descp.setBounds(44, 440, 435, 39);
			panel.add(emp_descp);
			
			JLabel lblNewLabel_2 = new JLabel("Description");
			lblNewLabel_2.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(44, 405, 167, 35);
			panel.add(lblNewLabel_2);
			
			JLabel lblContactNo = new JLabel("Contact No");
			lblContactNo.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
			lblContactNo.setBounds(44, 338, 167, 28);
			panel.add(lblContactNo);
			
			JLabel lblUserType = new JLabel("Empolyee Status");
			lblUserType.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
			lblUserType.setBounds(271, 338, 167, 28);
			panel.add(lblUserType);
			
			JLabel lblUsername = new JLabel("Empolyee Cnic");
			lblUsername.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
			lblUsername.setBounds(44, 202, 167, 39);
			panel.add(lblUsername);
			
			JLabel lblPassword = new JLabel("Empolyee Pay");
			lblPassword.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
			lblPassword.setBounds(44, 267, 167, 35);
			panel.add(lblPassword);
			
			JLabel lblFullName = new JLabel("Full Name");
			lblFullName.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
			lblFullName.setBounds(44, 131, 167, 35);
			panel.add(lblFullName);
			
			set_image_emp = new JLabel();
			set_image_emp.setBorder(new LineBorder(new Color(0, 0, 0)));
			set_image_emp.setHorizontalAlignment(SwingConstants.CENTER);
			set_image_emp.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
			set_image_emp.setBounds(613, 236, 174, 194);
			set_image_emp.setIcon(image);
			panel.add(set_image_emp);
			
			JButton btn_select_image = new JButton("SELECT IMAGE");
			btn_select_image.setForeground(Color.WHITE);
			btn_select_image.setBackground(Color.BLACK);
			btn_select_image.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0)
				{

				JFileChooser choose_image=new JFileChooser();
				 FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
				choose_image.setDialogTitle("Choose Empolyee Image");
				int result=choose_image.showSaveDialog(null);
				choose_image.setCurrentDirectory(null);
				choose_image.addChoosableFileFilter(filter);
				
				if(result == JFileChooser.APPROVE_OPTION)
				{
					File Select_img=choose_image.getSelectedFile();
					path=Select_img.getAbsolutePath();
					set_image_emp.setIcon(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(174, 194, Image.SCALE_DEFAULT)));
					
				}
				
				
				}
			});
			btn_select_image.setBounds(613, 441, 174, 39);
			panel.add(btn_select_image);
			
			JLabel lblEmpolyeePost = new JLabel("Empolyee Post");
			lblEmpolyeePost.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
			lblEmpolyeePost.setBounds(247, 270, 169, 35);
			panel.add(lblEmpolyeePost);
			
			combo_emp_post = new JComboBox();
			combo_emp_post.setModel(new DefaultComboBoxModel(new String[] {"Select Empolyee Post", "Teaching", "Non Teaching", "Others"}));
			combo_emp_post.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
			combo_emp_post.setBounds(247, 300, 232, 39);
			panel.add(combo_emp_post);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("UPDATE EMPOLYEE", new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\pen.png"), panel_1, null);
		tabbedPane.setBackgroundAt(1, Color.WHITE);
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
		
		JLabel lblUpdateUser = new JLabel("UPDATE EMPOLYEE");
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
		
		update_pay_emp = new JTextField();
		update_pay_emp.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		update_pay_emp.setColumns(10);
		update_pay_emp.setBounds(44, 325, 205, 39);
		panel_6.add(update_pay_emp);
		
		update_cnic_emp = new JTextField();
		update_cnic_emp.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		update_cnic_emp.setColumns(10);
		update_cnic_emp.setBounds(44, 248, 435, 39);
		panel_6.add(update_cnic_emp);
		
		update_name_emp = new JTextField();
		update_name_emp.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		update_name_emp.setColumns(10);
		update_name_emp.setBounds(165, 183, 314, 39);
		panel_6.add(update_name_emp);
		
		update_contact_emp = new JTextField();
		update_contact_emp.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		update_contact_emp.setColumns(10);
		update_contact_emp.setBounds(44, 392, 229, 39);
		panel_6.add(update_contact_emp);
		
		JComboBox update_combo_emp_status = new JComboBox();
		update_combo_emp_status.setModel(new DefaultComboBoxModel(new String[] {"Select Empolyee Status", "Working", "Not Working"}));
		update_combo_emp_status.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		update_combo_emp_status.setBounds(283, 392, 196, 39);
		panel_6.add(update_combo_emp_status);
		
		JButton btn_update = new JButton("Update");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				PreparedStatement stmt_update = null;
				String name_update_txt=update_name_emp.getText();
				String emp_update_cnic=update_cnic_emp.getText();
				String emp_update_pay=update_pay_emp.getText();
				String contact_update_txt=update_contact_emp.getText();
				String emp_update_status=update_combo_emp_status.getSelectedItem().toString();
				String emp_update_post=update_combo_post_emp.getSelectedItem().toString();
				String descp_update_txt=update_descp_emp.getText();
				//u);
				if(name_update_txt.isEmpty() || emp_update_pay.isEmpty() || contact_update_txt.isEmpty() || descp_update_txt.isEmpty() || emp_id_update.getText().isEmpty()||emp_update_cnic.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "FILL ALL FIELDS FOR UPDATION OPREATION");
				}
				else if(emp_update_status.equals("Select Empolyee Status"))
				{
					JOptionPane.showMessageDialog(null, "SELECT EMPOLYEE STATUS");
				}
				else if(emp_update_post.equals("Select Empolyee Post"))
				{
					JOptionPane.showMessageDialog(null, "SELECT EMPOLYEE POST");

				}
				else
					{
						try
						{   int emp_id=Integer.parseInt(emp_id_update.getText());
							String sql_update="UPDATE Empolyees SET emp_name=?,emp_contact=?,emp_cnic=?,emp_status=? ,emp_pay=?,emp_description=?,emp_post=? WHERE emp_id = ?";
							con=database_config.get_connection();
							stmt_update=con.prepareStatement(sql_update);
							stmt_update.setString(1, name_update_txt);
							stmt_update.setString(2, contact_update_txt);
							stmt_update.setString(3, emp_update_cnic);
							stmt_update.setString(4, emp_update_status);
							stmt_update.setString(5, emp_update_pay);
							stmt_update.setString(6,descp_update_txt);
							stmt_update.setString(7, emp_update_post);
							stmt_update.setInt(8, emp_id);
							int i=stmt_update.executeUpdate();
							if(i > 0)
							{
								//System.out.println("Insert Successfully  "+i);
								JOptionPane.showMessageDialog(null, "RECORED SUCCESSFULLY UPDATED");
								get_user_data(delete_user_table);
								//get_user_data(insert_panel_table);
							//	get_user_data(table_user_update);
								get_user_data(emp_search_table);
								get_user_data(emp_detain_info_table);
								update_name_emp.setText("");
								update_cnic_emp.setText("");
								update_pay_emp.setText("");
								update_contact_emp.setText("");
								update_combo_emp_status.setSelectedIndex(0);
								update_descp_emp.setText("");
								emp_id_update.setText("");
								update_combo_post_emp.setSelectedIndex(0);
								
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
						finally
						{
						try {
							con.close();
							stmt_update.close();

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
						
					}
			}
			
		});
		btn_update.setForeground(Color.WHITE);
		btn_update.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
		btn_update.setBackground(Color.DARK_GRAY);
		btn_update.setBounds(44, 529, 435, 54);
		panel_6.add(btn_update);
		
		update_descp_emp = new JTextField();
		update_descp_emp.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		update_descp_emp.setColumns(10);
		update_descp_emp.setBounds(44, 463, 435, 39);
		panel_6.add(update_descp_emp);
		
		JLabel label_2 = new JLabel("Description");
		label_2.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		label_2.setBounds(44, 428, 167, 35);
		panel_6.add(label_2);
		
		JLabel label_3 = new JLabel("Contact No");
		label_3.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		label_3.setBounds(44, 359, 167, 35);
		panel_6.add(label_3);
		
		JLabel lblEmpolyeeStatus = new JLabel("Empolyee Status");
		lblEmpolyeeStatus.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblEmpolyeeStatus.setBounds(283, 359, 167, 35);
		panel_6.add(lblEmpolyeeStatus);
		
		JLabel lblEmpolyeeCnic = new JLabel("Empolyee Cnic");
		lblEmpolyeeCnic.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblEmpolyeeCnic.setBounds(44, 219, 167, 35);
		panel_6.add(lblEmpolyeeCnic);
		
		JLabel lblEmpolyeePay = new JLabel("Empolyee Pay");
		lblEmpolyeePay.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblEmpolyeePay.setBounds(44, 290, 167, 35);
		panel_6.add(lblEmpolyeePay);
		
		JLabel label_7 = new JLabel("Full Name");
		label_7.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		label_7.setBounds(168, 148, 167, 35);
		panel_6.add(label_7);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Delete User", new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\paper-bucket.png"), panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 194, 1229, 386);
		panel_2.add(scrollPane_2);
		
		delete_user_table = new JTable();
		delete_user_table.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		scrollPane_2.setViewportView(delete_user_table);
		
		JLabel lblNewLabel_3 = new JLabel("ENTER EMPOLYEE ID");
		lblNewLabel_3.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 129, 194, 50);
		panel_2.add(lblNewLabel_3);
		
		delete_emp_id = new JTextField();
		delete_emp_id.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		delete_emp_id.setBounds(200, 130, 206, 48);
		panel_2.add(delete_emp_id);
		delete_emp_id.setColumns(10);
		
		JButton btn_delete_emp = new JButton("Delete");
		btn_delete_emp.setBackground(Color.BLACK);
		btn_delete_emp.setForeground(Color.WHITE);
		btn_delete_emp.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		btn_delete_emp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				PreparedStatement stmt_delete=null;
			//-----------------------------Delete User---------------------//
			if(delete_emp_id.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "PROVIDE EMPOLYEE ID FOR THIS OPERATION");

			}
			else
			{

				try
				{
				int user_id=Integer.parseInt(delete_emp_id.getText());
				con=database_config.get_connection();
				String sql_delete="DELETE FROM  Empolyees WHERE emp_id =?";
				 stmt_delete=con.prepareStatement(sql_delete);
				stmt_delete.setInt(1, user_id);
				int query_result=stmt_delete.executeUpdate();
				if(query_result > 0)
				{
					JOptionPane.showMessageDialog(null, "RECORED DELETE SUCCESSFULLY");
					get_user_data(delete_user_table);
					//get_user_data(insert_panel_table);
					//get_user_data(table_user_update);
					get_user_data(emp_search_table);
					get_user_data(emp_detain_info_table);
					delete_emp_id.setText("");

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
				finally
				{
					try {
						con.close();
						stmt_delete.close();

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				//-------------------------------------------------------------------//

			}			}
		});
		btn_delete_emp.setBounds(416, 129, 89, 49);
		panel_2.add(btn_delete_emp);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(100, 149, 237));
		panel_8.setBounds(10, 11, 1209, 98);
		panel_2.add(panel_8);
		
		JLabel lblDeleteUser = new JLabel("DELETE EMPOLYEE");
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
		tabbedPane.addTab("Search User", new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\loupe.png"), panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 195, 1229, 438);
		panel_3.add(scrollPane_3);
		
		emp_search_table = new JTable();
		emp_search_table.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		scrollPane_3.setViewportView(emp_search_table);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(100, 149, 237));
		panel_9.setBounds(10, 11, 1209, 98);
		panel_3.add(panel_9);
		
		JLabel lblSearchUser = new JLabel("SEARCH EMPOLYEE");
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
		tabbedPane.addTab("View User", new ImageIcon("C:\\Users\\Sardar Mubashir Ali\\Downloads\\archives.png"), panel_4, null);	
		panel_4.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(100, 149, 237));
		panel_10.setBounds(10, 11, 1209, 98);
		panel_4.add(panel_10);
		
		JLabel lblUserDetails = new JLabel("EMPOLYEE DETAILS");
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
		
		emp_detain_info_table = new JTable();
		emp_detain_info_table.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		scrollPane_4.setViewportView(emp_detain_info_table);
	JLabel lblUserId = new JLabel("Empolyee Id");
	lblUserId.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
	lblUserId.setBounds(44, 148, 101, 35);
	panel_6.add(lblUserId);
	
	emp_id_update = new JTextField();
	emp_id_update.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent arg0)
		{
		PreparedStatement stmt_update=null;
		if(!emp_id_update.getText().isEmpty())
		{
			System.out.println("Working");
			try
			{
				con=database_config.get_connection();
				int emp_id=Integer.parseInt(emp_id_update.getText());
				String sql_update="SELECT *FROM Empolyees WHERE emp_id= ?";
				 stmt_update=con.prepareStatement(sql_update);
				stmt_update.setInt(1, emp_id);
				ResultSet result_update=stmt_update.executeQuery();
				if(result_update.next())
				{
					update_name_emp.setText(result_update.getString("emp_name"));
					update_cnic_emp.setText(result_update.getString("emp_cnic"));
					update_pay_emp.setText(result_update.getString("emp_pay"));
					update_combo_post_emp.setSelectedItem(result_update.getString("emp_post"));
					update_contact_emp.setText(result_update.getString("emp_contact"));
					update_combo_emp_status.setSelectedItem(result_update.getString("emp_status"));
					update_descp_emp.setText(result_update.getString("emp_description"));
					
					
					
				}
				
				
				
				

			}
			catch(Exception e)
			{
				e.getMessage();
				e.printStackTrace();
			}
			finally
			{
			try 
			{
				con.close();
				stmt_update.close();

			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			}
			
		}
		else
		{
			update_name_emp.setText("");
			update_pay_emp.setText("");
			update_cnic_emp.setText("");
			update_combo_post_emp.setSelectedIndex(0);
			update_contact_emp.setText("");
			update_combo_emp_status.setSelectedIndex(0);
			update_descp_emp.setText("");
			
		}
		
		}
	});
	emp_id_update.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
	emp_id_update.setColumns(10);
	emp_id_update.setBounds(44, 183, 111, 39);
	panel_6.add(emp_id_update);
	
	JLabel lblEmpolyeePost_1 = new JLabel("Empolyee Post");
	lblEmpolyeePost_1.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
	lblEmpolyeePost_1.setBounds(259, 290, 182, 35);
	panel_6.add(lblEmpolyeePost_1);
	
	update_combo_post_emp = new JComboBox();
	update_combo_post_emp.setModel(new DefaultComboBoxModel(new String[] {"Select Empolyee Post", "Teaching", "Non Teaching", "Others"}));
	update_combo_post_emp.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
	update_combo_post_emp.setBounds(259, 325, 220, 39);
	panel_6.add(update_combo_post_emp);
	
	JLabel show_img_update_emp = new JLabel();
	show_img_update_emp.setHorizontalAlignment(SwingConstants.CENTER);
	show_img_update_emp.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
	show_img_update_emp.setBorder(new LineBorder(new Color(0, 0, 0)));
	show_img_update_emp.setIcon(image);
	show_img_update_emp.setBounds(671, 213, 174, 194);
	panel_6.add(show_img_update_emp);
	
	JButton button_6 = new JButton("SELECT IMAGE");
	button_6.setForeground(Color.WHITE);
	button_6.setBackground(Color.BLACK);
	button_6.setBounds(671, 418, 174, 39);
	panel_6.add(button_6);
	//===========================Populate Table With Data==========================//

	get_user_data(delete_user_table);
	get_user_data(emp_search_table);
	get_user_data(emp_detain_info_table);
	//=============================End of Call===================================//
	//======================Table Header Font And Background Color Method Call====================//
	set_header_font(delete_user_table);
	set_header_font(emp_search_table);
	set_header_font(emp_detain_info_table);
	//===========================================================================================//
	
	JLabel lblEnterEmpolyeeId = new JLabel("ENTER EMPOLYEE ID");
	lblEnterEmpolyeeId.setFont(new Font("Yu Gothic", Font.BOLD, 16));
	lblEnterEmpolyeeId.setBounds(10, 133, 171, 50);
	panel_3.add(lblEnterEmpolyeeId);
	
	emp_search_id = new JTextField();
	emp_search_id.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
	emp_search_id.setColumns(10);
	emp_search_id.setBounds(191, 134, 231, 48);
	panel_3.add(emp_search_id);
	
	JButton btn_search_emp = new JButton("Search");
	btn_search_emp.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0)
		{
			emp_search_id.getText();
			
			//user_search_table
			if(emp_search_id.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "PROVIDE USER ID FOR SEARCHING");
			}
			else
			{
				search_emp_data(Integer.parseInt(emp_search_id.getText()),emp_search_table);
			}
			
		}
	});
	btn_search_emp.setForeground(Color.WHITE);
	btn_search_emp.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
	btn_search_emp.setBackground(Color.BLACK);
	btn_search_emp.setBounds(432, 133, 89, 49);
	panel_3.add(btn_search_emp);
	
	JButton button_9 = new JButton();
	button_9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0)
		{
		get_user_data(emp_search_table);
		}
	});
	button_9.setForeground(Color.WHITE);
	button_9.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
	button_9.setIcon(rfresh_icon);
	button_9.setBackground(Color.BLACK);
	button_9.setBounds(1145, 133, 55, 49);
	panel_3.add(button_9);
	//==================================End of Call===============================//
	
	
	}
	
	//=========================Method for Showing User Data===================================//

	public void get_user_data(JTable table_name)
	{
		PreparedStatement stmt_read=null;
		con=database_config.get_connection();
		String sql_read="SELECT emp_id as EMPOLYEE_ID,emp_name as NAME,emp_post as POST, emp_status as STATUS, emp_cnic  as NIC, emp_pay as PAY,emp_contact as CONTACT FROM Empolyees";
		try {
			 stmt_read=con.prepareStatement(sql_read);
			ResultSet result_read=stmt_read.executeQuery();
			table_name.setModel(DbUtils.resultSetToTableModel(result_read));
			//table_user_update.setModel(DbUtils.resultSetToTableModel(result_read));
			
		} catch (SQLException e) {
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
				e.getStackTrace();
			}
		}
		
	}
	//================================================End of User Data Method===========================//
	
	
	//=====================================Method For Search User Data=================================//
	public void search_emp_data(int emp_id,JTable table_search)
	{
		PreparedStatement stmt_read=null;
		con=database_config.get_connection();
		int result_flag=0;
		String sql_read="SELECT emp_id as Empolyee_ID,emp_name as Name,emp_post as Post, emp_status as Status, emp_cnic  as NIC, emp_pay as PAY,emp_contact as CONTACT FROM Empolyees WHERE emp_id = ?";
		try {
			 stmt_read=con.prepareStatement(sql_read);
			stmt_read.setInt(1, emp_id);
			ResultSet result_read=stmt_read.executeQuery();
			result_flag++;
			
			if(result_flag > 0)
			{
				table_search.setModel(DbUtils.resultSetToTableModel(result_read));
	
			}
			else
			{
				JOptionPane.showMessageDialog(null, "EMPOLYEE DATA NOT FOUND IN RECORED");
				emp_search_id.setText("");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally
		{
		
			try {
				stmt_read.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
