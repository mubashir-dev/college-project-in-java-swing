package dashboard;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Empolyees.empolyee_main;
import Users.user_main;
import courses.Course;
import student.Student;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	public JFrame frmCollegeProject;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		setTitle("College Project|Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1114, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Students");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Student dialog = new Student();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);

			}
		});
		btnNewButton.setBounds(237, 145, 305, 100);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Faculty");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				empolyee_main dialog = new empolyee_main();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);

			}
		});
		button.setBounds(611, 145, 305, 100);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Courses");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Course dialog = new Course();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
			}
		});
		button_1.setBounds(237, 288, 305, 100);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Users");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				user_main dialog = new user_main();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
			}
		});
		button_2.setBounds(611, 288, 305, 100);
		contentPane.add(button_2);
		setLocationRelativeTo(null);

	}
}
