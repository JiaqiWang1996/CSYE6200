package SwingUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;

import SubjectClass.DayCareRule;

import SubjectClass.Teacher;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Font;

public class TeacherUI extends JFrame {
	private JFrame frame;

	private JTextField teaID;
	private JTextField teaLastName;
	private JTextField teaFirstName;
	private JTextField teaAge;

	private JComboBox teacherType;
	private JComboBox classroomCbb;

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { TeacherUI frame = new TeacherUI();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public TeacherUI(DayCareRule dcr) throws IOException {

		frame = new JFrame();
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 725, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//  setIconifiable(true);
		setTitle("Create a new teacher");
		//  setClosable(true);
		setBounds(100, 100, 725, 500);
		setResizable(false);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 725, 500);
		getContentPane().add(panel);
		panel.setLayout(null);

		//set labels
		JLabel lblTeacher = new JLabel("Teacher");
		lblTeacher.setForeground(Color.DARK_GRAY);
		lblTeacher.setFont(new Font("Sitka Banner", Font.BOLD, 24));
		lblTeacher.setBounds(273, 22, 201, 31);
		panel.add(lblTeacher);

		JLabel FirstName = new JLabel("FirstName :");
		FirstName.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		FirstName.setBounds(273, 91, 120, 30);
		panel.add(FirstName);

		JLabel lblLastName = new JLabel("LastName :");
		lblLastName.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		lblLastName.setBounds(273, 132, 120, 30);
		panel.add(lblLastName);

		JLabel lblAge = new JLabel("Age :");
		lblAge.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		lblAge.setBounds(273, 173, 120, 30);
		panel.add(lblAge);  


		teaFirstName = new JTextField();
		teaFirstName.setColumns(10);
		teaFirstName.setBounds(415, 91, 120, 30);
		panel.add(teaFirstName);

		teaLastName = new JTextField();
		teaLastName.setColumns(10);
		teaLastName.setBounds(415, 132, 120, 30);
		panel.add(teaLastName);

		teaAge = new JTextField();
		teaAge.setColumns(10);
		teaAge.setBounds(415, 173, 120, 30);
		panel.add(teaAge);


		//teacher type label
		JLabel lbltype = new JLabel("Classroom :");
		lbltype.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		lbltype.setBounds(273, 223, 120, 30);
		panel.add(lbltype); 
		//teacher type comboBox
		teacherType = new JComboBox<String>();
		teacherType.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		teacherType.setBounds(415, 223, 120, 30);
		panel.add(teacherType);
		teacherType.setEditable(false);

		teacherType.addItem("6-12");
		teacherType.addItem("13-24");
		teacherType.addItem("25-35");
		teacherType.addItem("36-47");
		teacherType.addItem("48-59");
		teacherType.addItem("60 on up");
		panel.add(teacherType, BorderLayout.SOUTH);

		teacherType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String tType = teacherType.getSelectedItem().toString();
				try {
					dcr.showClassroomWith(tType, classroomCbb);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});

		//classroom choose comboBox
		JLabel lblchoose = new JLabel("Classroom :");
		lblchoose.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		lblchoose.setBounds(273, 273, 120, 30);
		panel.add(lblchoose); 
		classroomCbb = new JComboBox<String>();
		classroomCbb.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		classroomCbb.setBounds(415, 273, 120, 30);
		panel.add(classroomCbb);
		classroomCbb.setEditable(false);

		panel.add(classroomCbb, BorderLayout.SOUTH);

		JButton addBtn = new JButton("Add Teacher");
		addBtn.setBounds(263, 350, 130, 30);

		//addbutton setIcon
		addBtn.setIcon(
				new ImageIcon(TeacherUI.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		panel.add(addBtn);

		//addbutton addActionListener
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addValueActionPerformed(e, dcr);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		//background
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TeacherUI.class.getResource("/images/background.jpg")));
		lblNewLabel.setBounds(0, 0, 725, 500);
		panel.add(lblNewLabel);

	}

	private void addValueActionPerformed(ActionEvent e, DayCareRule dcr) throws IOException {
		//add teacher button
		if (teaFirstName.getText().isEmpty() || teaLastName.getText().isEmpty() || teaAge.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill out all the text fields!");
		} else {
			String tfn = teaFirstName.getText();
			String tln = teaLastName.getText();
			int tage = Integer.parseInt(teaAge.getText());
			String tType = teacherType.getSelectedItem().toString();
			String classroomid = classroomCbb.getSelectedItem().toString();
			int cid = classroomid.charAt(classroomid.length() - 1) - '0';
			Teacher teacher = new Teacher(tfn, tln, tage, cid, tType);
			
			dcr.addTeacherToTeacherFile(teacher);
			dcr.addTeacherToClassroom(teacher);
		}
		dispose();
	}
}