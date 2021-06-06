package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db_init.database_config;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import dashboard.Dashboard;

import javax.swing.border.EtchedBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tf_username;
	private JButton btnNewButton;
	private Connection con=null;
	private JLabel lblNewLabel;
	private JPasswordField tf_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Login frame = new Login();
				      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					frame.setVisible(true);
					//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("College Project");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 421);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf_username = new JTextField();
		tf_username.setFont(new Font("Cambria", Font.PLAIN, 20));
		tf_username.setBounds(114, 114, 291, 50);
		contentPane.add(tf_username);
		tf_username.setColumns(10);
		
		btnNewButton = new JButton("LOGIN");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			
			PreparedStatement stmt_login;
			if(tf_username.getText().isEmpty() || tf_password.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "PROPERLY FILL ALL FIELDS", "WARNING",
						JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				try
				{
					con = database_config.get_connection();
					String sql_login="SELECT *FROM Users WHERE user_username = ? AND user_password = ?";
					stmt_login = con.prepareStatement(sql_login);
					stmt_login.setString(1, tf_username.getText().toString());
					stmt_login.setString(2, tf_password.getText().toString());
		            ResultSet rs = stmt_login.executeQuery();
		            if(rs.next())
		            {
		            	
		            System.out.println("ok");
						Dashboard window = new Dashboard();
						dispose();
		            }
		            else
		            {
		            	JOptionPane.showMessageDialog(null,

		                        "INCORRECT USERNAME OR PASSWORD.TRY AGAIN WITH CORRECT DETAILS");
		            }
		            

					
				}
				catch(Exception E)
				{
					E.getMessage();
				}
				finally
				{
					try
					{
						con.close();
					}
					catch(Exception f)
					{
						f.getMessage();
					}
				}
			}

			}
		});
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 20));
		btnNewButton.setBounds(111, 259, 294, 50);
		contentPane.add(btnNewButton);
		
		JCheckBox chkbox_show = new JCheckBox("Show Password");
		chkbox_show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				 if (chkbox_show.isSelected()) {
				      tf_password.setEchoChar((char)0); //password = JPasswordField
				   } else {
					   tf_password.setEchoChar('*');
				   }
			}
		});
		chkbox_show.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkbox_show.setHorizontalAlignment(SwingConstants.CENTER);
		chkbox_show.setBounds(263, 232, 141, 23);
		contentPane.add(chkbox_show);
		
		lblNewLabel = new JLabel("PLEASE LOGIN");
		lblNewLabel.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 26));
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(114, 65, 209, 50);
		contentPane.add(lblNewLabel);
		
		tf_password = new JPasswordField();
		tf_password.setFont(new Font("Cambria", Font.PLAIN, 20));
		tf_password.setBounds(114, 175, 291, 50);
		contentPane.add(tf_password);
		tf_password.setColumns(10);
	}
}
