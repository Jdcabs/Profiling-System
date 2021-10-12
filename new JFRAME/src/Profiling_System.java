import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

public class Profiling_System extends JDBC_Connector implements ActionListener{

	// Login JFrame Properties and Fields.
	JFrame LoginFrame = new JFrame();
	JButton buttonLogin;
	JLabel labelOutput;
	JTextField usernameTextField;
	JPasswordField userpassword;
	JOptionPane loginPane;

	// Home page Jframe properties and fields
	JFrame jframe = new JFrame();
	JButton logoutButton = new JButton("Logout");
	ImageIcon framelogo = new ImageIcon("img/concepcion uno logo.png");
	JButton addResident = new JButton();
	JButton deleteResident = new JButton();
	ArrayList list;
	
	
	// Frame Properties
			
	// Adding of Resident Properties.
	// Vaccination Information of the Resident.
	JLabel lblVaccinationInfomation;
	JLabel vaccineQuestion;
	JLabel manufacturerNameFirstDose_lbl;
	JLabel batchNumFirstDose_lbl;
	JLabel vaccinationDateFirstDose_lbl;
	JTextField manufacturerNameFirstDose_txtf;
	JTextField batchNumFirstDose_txtf;
	JFormattedTextField vaccinationDateFirstDose_txtf;
	JLabel manufacturerNameSecondDose_lbl;
	JLabel batchNumSecondDose_lbl;
	JLabel vaccinationDateSecondDose_lbl;
	JTextField manufacturerNameSecondDose_txtf;
	JTextField batchNumSecondDose_txtf;
	JFormattedTextField vaccinationDateSecondDose_txtf;	
	JRadioButton yes_rb;
	JRadioButton no_rb;
	ButtonGroup vaccineButtonGroup;
	
	// Information of the Resident.
	JLabel emailAdd_lbl;
	JLabel randomId_lbl;
	JLabel suffix_lbl;
	JLabel address_lbl;
	JLabel lastname_lbl;
	JLabel middleinitial_lbl;
	JLabel firstname_lbl;
	JLabel phoneNum_lbl;
	JLabel status_lbl;
	JLabel gender_lbl;
	JComboBox gender_txtb;
	JTextField emailAdd_txtf;
	JTextField randomId_txtf;
	JTextField suffix_txtf;
	JTextField firstName_txtf;
	JTextField lastName_txtf;
	JTextField middleInitial_txtf;
	JTextField address_txtf;
	JTextField phoneNumber_txtf;
	JComboBox status_txtb;
	
	JButton addButton;
	JButton clearButton;
	JButton generateRandomId;
	JScrollPane addRessidentScroll;
	JPanel jpanelResidentRegistration;
	
	// Deletion of the Resident Properties.
	JScrollPane deleteResidentScroll;
	JPanel jpanelResidentDeletion;
	JTextField searchResidentIDDelete_txtf;
	JButton searchResidentID_btn;
	JLabel firstNameDelete_lbl;
	JLabel lastNameDelete_lbl;
	JLabel middleNameDelete_lbl;
	JLabel suffixDelete_lbl;
	JLabel phoneNumberDelete_lbl;
	JLabel emailAddressDelete_lbl;
	JLabel addressDelete_lbl;
	JLabel statusDelete_lbl;
	JLabel genderDelete_lbl;
	JTextField firstNameDelete_txtf;
	JTextField lastNameDelete_txtf;
	JTextField middleNameDelete_txtf;
	JTextField suffixDelete_txtf;
	JTextField phoneNumberDelete_txtf;
	JTextField emailAddressDelete_txtf;
	JTextField addressDelete_txtf;
	JTextField statusDelete_txtf;
	JTextField genderDelete_txtf;
	
	// Vaccine Information.
	JLabel manufacturerNameFirstDoseDelete_lbl;
	JLabel batchNumFirstDoseDelete_lbl;
	JLabel vaccinationDateFirstDoseDelete_lbl;
	JLabel manufacturerNameSecondDoseDelete_lbl;
	JLabel batchNumSecondDoseDelete_lbl;
	JLabel vaccinationDateSecondDoseDelete_lbl;
	JTextField manufacturerNameFirstDoseDelete_txtf;
	JTextField batchNumFirstDoseDelete_txtf;
	JTextField vaccinationDateFirstDoseDelete_txtf;
	JTextField manufacturerNameSecondDoseDelete_txtf;
	JTextField batchNumSecondDoseDelete_txtf;
	JTextField vaccinationDateSecondDoseDelete_txtf;
	JButton residentDeletion_btn;
	JButton deletedResidentInformation_btn;
	
	// deleted resident information properties.
	JFrame deletedframe; 
	JTextField search_txtf;
	JButton restore_btn;
	JTable jtable;
	DefaultTableModel tableModel;
	JScrollPane addjtableScroll;
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 																													   //
	//			 LOGIN PAGE OF THE PROFILING SYSTTEM.                                                                      //
	// 																													   //
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public Profiling_System() {

		// Login Textfields.
		usernameTextField = new JTextField();
		usernameTextField.setPreferredSize(new Dimension(200, 30));
		usernameTextField.setBounds(130, 240, 200, 30);
		usernameTextField.setFont(new Font("Helvetica", Font.PLAIN, 20));

		userpassword = new JPasswordField();
		userpassword.setPreferredSize(new Dimension(200, 30));
		userpassword.setBounds(130, 320, 200, 30);
		userpassword.setFont(new Font("Helvetica", Font.PLAIN, 20));

		// Labels for username and Password TextField
		JLabel usernameLabel = new JLabel();
		usernameLabel.setText("Username: ");
		usernameLabel.setBounds(130, 215, 120, 20);
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("Helvetica", Font.BOLD, 15));

		JLabel userpasswordLabel = new JLabel();
		userpasswordLabel.setText("Password: ");
		userpasswordLabel.setBounds(130, 295, 120, 20);
		userpasswordLabel.setForeground(Color.WHITE);
		userpasswordLabel.setFont(new Font("Helvetica", Font.BOLD, 15));

		// LabelOutput.
		labelOutput = new JLabel();
		labelOutput.setText("Hello there!");
		labelOutput.setBounds(140, 200, 150, 130);
		labelOutput.setForeground(Color.WHITE);
		labelOutput.setHorizontalTextPosition(SwingConstants.CENTER);
		labelOutput.setVerticalTextPosition(SwingConstants.CENTER);
		labelOutput.setVisible(false);
		labelOutput.setFont(new Font("Helvetica", Font.BOLD, 25));

		// Button for the Loginform.
		buttonLogin = new JButton();
		buttonLogin.setText("Login");
		buttonLogin.setBounds(190, 425, 80, 35);
		buttonLogin.setFocusable(false);
		buttonLogin.addActionListener(this);
		buttonLogin.setFont(new Font("Helvetica", Font.BOLD, 13));
		buttonLogin.setBackground(Color.LIGHT_GRAY);
		buttonLogin.setBorder(BorderFactory.createRaisedSoftBevelBorder());

		// Jpanel for the Login Form
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(Color.gray);
		loginPanel.setBounds(86, 180, 100, 100);

		// label in Login form with an Image
		ImageIcon loginLabelImage = new ImageIcon(
				new ImageIcon("img/concepcion uno logo.png").getImage().getScaledInstance(80, 90, Image.SCALE_SMOOTH));

		JLabel loginlabel = new JLabel("Profiling System");
		loginlabel.setIcon(loginLabelImage);
		loginlabel.setHorizontalTextPosition(SwingConstants.CENTER);
		loginlabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		loginlabel.setForeground(Color.white);
		loginlabel.setFont(new Font("Helvetica", Font.BOLD, 25));
		loginlabel.setVerticalAlignment(SwingConstants.TOP);
		loginlabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginlabel.setIconTextGap(15);
		loginlabel.setBounds(100, 50, 260, 230);

		// JFrame Properties
		LoginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		LoginFrame.setSize(470, 600);
		LoginFrame.setVisible(true);
		LoginFrame.setTitle("Profiling System");
		LoginFrame.getContentPane().setBackground(new Color(2, 53, 130));
		LoginFrame.setLayout(null);
		LoginFrame.setResizable(false);
		LoginFrame.setLocationRelativeTo(null);

		// Added Components to the Frame.
		LoginFrame.add(loginlabel);
		LoginFrame.add(labelOutput);
		LoginFrame.add(usernameTextField);
		LoginFrame.add(buttonLogin);
		LoginFrame.add(userpassword);
		LoginFrame.add(usernameLabel);
		LoginFrame.add(userpasswordLabel);

		// Image for the Frame itself.
		ImageIcon imageiconinframe = new ImageIcon("img/concepcion uno logo.png");
		LoginFrame.setIconImage(imageiconinframe.getImage());
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//                                                                                                                     //
	//                           HOHE PAGE OF RESIDENT REGISTRATION PROFILING SYSTTEM.                                     //
	//                                                                                                                     //
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void residentRegistrationPage() {

		// Jpanel for the body of the frame, here we can see the changing of properties
		// depends on the button clicked in the sidebar menu.
		// Component inside the Body of the frame.
		
		//
		// Properties inside the Adding Resident Information Registration Jpanel.
		// Vaccination Information.
		//
		lblVaccinationInfomation = new JLabel();
		lblVaccinationInfomation.setText("Vaccine Information");
		lblVaccinationInfomation.setForeground(Color.WHITE);
		lblVaccinationInfomation.setFont(new Font("Helvetica", Font.BOLD, 35));
		lblVaccinationInfomation.setBounds(35, 500, 400, 50);
		
		vaccineQuestion = new JLabel();
		vaccineQuestion.setText("Does the Resident is Already Vaccinated ?");
		vaccineQuestion.setForeground(Color.WHITE);
		vaccineQuestion.setFont(new Font("Helvetica", Font.BOLD, 18));
		vaccineQuestion.setBounds(35, 570, 380, 25);
		
		yes_rb = new JRadioButton();
		yes_rb.setText("Yes");
		yes_rb.setFocusable(false);
		yes_rb.setForeground(Color.WHITE);
		yes_rb.setBackground(new Color(2, 53, 130));
		yes_rb.setFont(new Font("Helvetica", Font.BOLD, 15));
		yes_rb.setBounds(35, 600, 70, 25);
		yes_rb.addActionListener(this);
		
		no_rb = new JRadioButton();
		no_rb.setText("No");
		no_rb.setFocusable(false);
		no_rb.setForeground(Color.WHITE);
		no_rb.setBackground(new Color(2, 53, 130));
		no_rb.setFont(new Font("Helvetica", Font.BOLD, 15));
		no_rb.setBounds(110, 600, 50, 25);
		no_rb.addActionListener(this);
		
		vaccineButtonGroup = new ButtonGroup();
		vaccineButtonGroup.add(yes_rb);
		vaccineButtonGroup.add(no_rb);
		
		JLabel firstDose_lbl = new JLabel();
		firstDose_lbl.setText("First Dose of Vaccine");
		firstDose_lbl.setFont(new Font("Helvetica", Font.BOLD, 25));
		firstDose_lbl.setForeground(Color.WHITE);
		firstDose_lbl.setBounds(35, 660, 300, 25);
		
		manufacturerNameFirstDose_lbl = new JLabel();
		manufacturerNameFirstDose_lbl.setText("Manufacturer Name: ");
		manufacturerNameFirstDose_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		manufacturerNameFirstDose_lbl.setForeground(Color.WHITE);
		manufacturerNameFirstDose_lbl.setBounds(35, 700, 200, 25);
		
		manufacturerNameFirstDose_txtf = new JTextField();
		manufacturerNameFirstDose_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		manufacturerNameFirstDose_txtf.setBounds(35, 725, 320, 30);
		manufacturerNameFirstDose_txtf.setEditable(false);
		
		batchNumFirstDose_lbl = new JLabel();
		batchNumFirstDose_lbl.setText("Batch Number: ");
		batchNumFirstDose_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		batchNumFirstDose_lbl.setForeground(Color.WHITE);
		batchNumFirstDose_lbl.setBounds(390, 700, 200, 25);
		
		batchNumFirstDose_txtf = new JTextField();
		batchNumFirstDose_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		batchNumFirstDose_txtf.setBounds(390, 725, 205, 30);
		batchNumFirstDose_txtf.setEditable(false);
		
		vaccinationDateFirstDose_lbl = new JLabel();
		vaccinationDateFirstDose_lbl.setText("Vaccination Date: ");
		vaccinationDateFirstDose_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		vaccinationDateFirstDose_lbl.setForeground(Color.WHITE);
		vaccinationDateFirstDose_lbl.setBounds(630, 700, 200, 25);
	
		vaccinationDateFirstDose_txtf = new JFormattedTextField();
		vaccinationDateFirstDose_txtf.setEditable(false);
		vaccinationDateFirstDose_txtf.setText("YYYY/MM/DD");
		vaccinationDateFirstDose_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		vaccinationDateFirstDose_txtf.setBounds(630, 725, 205, 30);
		
		JLabel secondDose_lbl = new JLabel();
		secondDose_lbl.setText("Second Dose of Vaccine");
		secondDose_lbl.setFont(new Font("Helvetica", Font.BOLD, 25));
		secondDose_lbl.setForeground(Color.WHITE);
		secondDose_lbl.setBounds(35, 800, 300, 25);
		
		manufacturerNameSecondDose_lbl = new JLabel();
		manufacturerNameSecondDose_lbl.setText("Manufacturer Name: ");
		manufacturerNameSecondDose_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		manufacturerNameSecondDose_lbl.setForeground(Color.WHITE);
		manufacturerNameSecondDose_lbl.setBounds(35, 840, 200, 25);
		
		manufacturerNameSecondDose_txtf = new JTextField(); 
		manufacturerNameSecondDose_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		manufacturerNameSecondDose_txtf.setBounds(35, 865, 320, 30);
		manufacturerNameSecondDose_txtf.setEditable(false);
		
		batchNumSecondDose_lbl = new JLabel();
		batchNumSecondDose_lbl.setText("Batch Number: ");
		batchNumSecondDose_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		batchNumSecondDose_lbl.setForeground(Color.WHITE);
		batchNumSecondDose_lbl.setBounds(390, 840, 200, 25);
		
		batchNumSecondDose_txtf = new JTextField();
		batchNumSecondDose_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		batchNumSecondDose_txtf.setBounds(390, 865, 205, 30);
		batchNumSecondDose_txtf.setEditable(false);
		
		vaccinationDateSecondDose_lbl  = new JLabel();
		vaccinationDateSecondDose_lbl.setText("Vaccination Date: ");
		vaccinationDateSecondDose_lbl.setForeground(Color.WHITE);
		vaccinationDateSecondDose_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		vaccinationDateSecondDose_lbl.setBounds(630, 840, 200, 25);
		
		vaccinationDateSecondDose_txtf = new JFormattedTextField();
		vaccinationDateSecondDose_txtf.setEditable(false);
		vaccinationDateSecondDose_txtf.setText("YYYY/MM/DD");
		vaccinationDateSecondDose_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		vaccinationDateSecondDose_txtf.setBounds(630, 865, 205, 30);
		
		//
		// Properties inside the Resident Information Registration Jpanel.
		//
		clearButton = new JButton();
		clearButton.setText("Clear");
		clearButton.setFont(new Font("Helvetica", Font.BOLD, 14));
		clearButton.setBounds(820, 1050, 140, 40);
		clearButton.setFocusable(false);
		clearButton.setForeground(Color.WHITE);
		clearButton.setBackground(Color.RED);
		clearButton.addActionListener(this);
		clearButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());

		addButton = new JButton();
		addButton.setText("Add Resident");
		addButton.setFont(new Font("Helvetica", Font.BOLD, 14));
		addButton.setBounds(660, 1050, 140, 40);
		addButton.setFocusable(false);
		addButton.setForeground(Color.WHITE);
		addButton.setBackground(Color.GREEN);
		addButton.addActionListener(this);
		addButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		gender_lbl = new JLabel();
		gender_lbl.setText("Gender: ");
		gender_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		gender_lbl.setForeground(Color.WHITE);
		gender_lbl.setBounds(750, 350, 200, 25);
		
		String[] genderSelection = { "Male", "Female" };
		gender_txtb = new JComboBox(genderSelection);
		gender_txtb.setBounds(750, 375, 150, 30);
		
		
		generateRandomId = new JButton();
		generateRandomId.setText("Generate ID");
		generateRandomId.setFocusable(false);
		generateRandomId.setFont(new Font("Helvetica", Font.BOLD, 14));
		generateRandomId.setBounds(615, 377, 100, 25);
		generateRandomId.addActionListener(this);
		generateRandomId.setBackground(Color.LIGHT_GRAY);
		generateRandomId.setBorder(BorderFactory.createRaisedSoftBevelBorder());

		emailAdd_lbl = new JLabel("Email Address: ");
		emailAdd_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		emailAdd_lbl.setForeground(Color.WHITE);
		emailAdd_lbl.setBounds(35, 350, 150, 25);

		emailAdd_txtf = new JTextField();
		emailAdd_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		emailAdd_txtf.setBounds(35, 375, 320, 30);

		randomId_lbl = new JLabel("Generate ID: ");
		randomId_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		randomId_lbl.setForeground(Color.WHITE);
		randomId_lbl.setBounds(400, 350, 150, 25);

		randomId_txtf = new JTextField();
		randomId_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		randomId_txtf.setEditable(false);
		randomId_txtf.setBounds(400, 375, 205, 30);

		status_lbl = new JLabel("Status: ");
		status_lbl.setForeground(Color.WHITE);
		status_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		status_lbl.setBounds(640, 250, 150, 40);
		status_lbl.setHorizontalTextPosition(SwingConstants.CENTER);

		String[] statusSelection = { "Single", "Married", "Divorced", "Widowed", "Separated" };
		status_txtb = new JComboBox(statusSelection);
		status_txtb.setBounds(640, 285, 150, 30);

		phoneNum_lbl = new JLabel("Phone Number: ");
		phoneNum_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		phoneNum_lbl.setForeground(Color.WHITE);
		phoneNum_lbl.setBounds(400, 250, 150, 40);
		phoneNum_lbl.setHorizontalTextPosition(SwingConstants.CENTER);

		phoneNumber_txtf = new JTextField();
		phoneNumber_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		phoneNumber_txtf.setBounds(400, 285, 200, 30);

		address_lbl = new JLabel("Adress: ");
		address_lbl.setForeground(Color.WHITE);
		address_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		address_lbl.setBounds(35, 250, 130, 40);
		address_lbl.setHorizontalTextPosition(SwingConstants.CENTER);

		address_txtf = new JTextField();
		address_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		address_txtf.setBounds(35, 285, 320, 30);

		suffix_lbl = new JLabel("Suffix: ");
		suffix_lbl.setForeground(Color.WHITE);
		suffix_lbl.setHorizontalTextPosition(SwingConstants.CENTER);
		suffix_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		suffix_lbl.setBounds(815, 150, 150, 40);

		suffix_txtf = new JTextField();
		suffix_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		suffix_txtf.setBounds(815, 185, 60, 30);

		middleinitial_lbl = new JLabel("Middle Name: ");
		middleinitial_lbl.setForeground(Color.WHITE);
		middleinitial_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		middleinitial_lbl.setBounds(290, 150, 130, 40);
		middleinitial_lbl.setHorizontalTextPosition(SwingConstants.CENTER);

		middleInitial_txtf = new JTextField();
		middleInitial_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		middleInitial_txtf.setBounds(290, 185, 205, 30);

		lastname_lbl = new JLabel("Last Name: ");
		lastname_lbl.setForeground(Color.WHITE);
		lastname_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		lastname_lbl.setHorizontalTextPosition(SwingConstants.CENTER);
		lastname_lbl.setBounds(555, 150, 130, 40);

		lastName_txtf = new JTextField();
		lastName_txtf.setBounds(555, 185, 205, 30);
		lastName_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));

		firstName_txtf = new JTextField();
		firstName_txtf.setBounds(35, 185, 205, 30);
		firstName_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));

		firstname_lbl = new JLabel("First Name: ");
		firstname_lbl.setForeground(Color.WHITE);
		firstname_lbl.setHorizontalTextPosition(SwingConstants.CENTER);
		firstname_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		firstname_lbl.setBounds(35, 150, 130, 40);

		JLabel registerlabel = new JLabel("Add New Resident");
		registerlabel.setForeground(Color.WHITE);
		registerlabel.setFont(new Font("Helvetica", Font.BOLD, 35));
		registerlabel.setBounds(35, 50, 350, 45);
		

		//
		// Properties inside the Deleting Resident Information Registration Jpanel.
		//
		// Basic Resident Information.
		JLabel deletinglabel = new JLabel("Delete Resident Information");
		deletinglabel.setForeground(Color.WHITE);
		deletinglabel.setFont(new Font("Helvetica", Font.BOLD, 35));
		deletinglabel.setBounds(35, 50, 500, 45);
		
		JLabel searchResidentID = new JLabel("Search for Resident ID: ");
		searchResidentID.setForeground(Color.WHITE);
		searchResidentID.setFont(new Font("Helvetica", Font.BOLD, 18));
		searchResidentID.setBounds(220, 130, 250, 25);
		
		searchResidentIDDelete_txtf = new JTextField();
		searchResidentIDDelete_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		searchResidentIDDelete_txtf.setBounds(430, 128, 150, 30);

		searchResidentID_btn = new JButton();
		searchResidentID_btn.setText("SEARCH");
		searchResidentID_btn.setFont(new Font("Helvetica", Font.BOLD, 14));
		searchResidentID_btn.setFocusable(false);
		searchResidentID_btn.setBackground(Color.LIGHT_GRAY);
		searchResidentID_btn.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		searchResidentID_btn.setBounds(600, 128, 110, 30);
		searchResidentID_btn.addActionListener(this);
		
		firstNameDelete_lbl = new JLabel();
		firstNameDelete_lbl.setText("First Name: ");
		firstNameDelete_lbl.setForeground(Color.WHITE);
		firstNameDelete_lbl.setBounds(35, 200, 200, 25);
		firstNameDelete_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		
		firstNameDelete_txtf = new JTextField();
		firstNameDelete_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		firstNameDelete_txtf.setEditable(false);
		firstNameDelete_txtf.setBounds(35, 225, 260, 30);
		
		middleNameDelete_lbl = new JLabel();
		middleNameDelete_lbl.setText("Middle Name: ");
		middleNameDelete_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		middleNameDelete_lbl.setForeground(Color.WHITE);
		middleNameDelete_lbl.setBounds(35, 280, 200, 25);
		
		middleNameDelete_txtf = new JTextField();	
		middleNameDelete_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		middleNameDelete_txtf.setEditable(false);
		middleNameDelete_txtf.setBounds(35, 305, 260, 30);
		
		lastNameDelete_lbl = new JLabel();
		lastNameDelete_lbl.setText("Last Name: ");
		lastNameDelete_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		lastNameDelete_lbl.setForeground(Color.WHITE);
		lastNameDelete_lbl.setBounds(35, 360, 200, 25);
		
		lastNameDelete_txtf = new JTextField();
		lastNameDelete_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		lastNameDelete_txtf.setEditable(false);
		lastNameDelete_txtf.setBounds(35, 385, 260, 30);
		
		suffixDelete_lbl = new JLabel();
		suffixDelete_lbl.setText("Suffix: ");
		suffixDelete_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		suffixDelete_lbl.setForeground(Color.WHITE);
		suffixDelete_lbl.setBounds(35, 440, 200, 25);
		
		suffixDelete_txtf = new JTextField();
		suffixDelete_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		suffixDelete_txtf.setEditable(false);
		suffixDelete_txtf.setBounds(35, 465, 60, 30);
		
		phoneNumberDelete_lbl = new JLabel();
		phoneNumberDelete_lbl.setText("Phone Number: ");
		phoneNumberDelete_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		phoneNumberDelete_lbl.setForeground(Color.WHITE);
		phoneNumberDelete_lbl.setBounds(380, 200, 200, 25);
		
		phoneNumberDelete_txtf = new JTextField();
		phoneNumberDelete_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		phoneNumberDelete_txtf.setEditable(false);
		phoneNumberDelete_txtf.setBounds(380, 225, 320, 30);
		
		emailAddressDelete_lbl = new JLabel();
		emailAddressDelete_lbl.setForeground(Color.WHITE);
		emailAddressDelete_lbl.setText("Email Address: ");
		emailAddressDelete_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		emailAddressDelete_lbl.setBounds(380, 280, 200, 25);
		
		emailAddressDelete_txtf = new JTextField();
		emailAddressDelete_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		emailAddressDelete_txtf.setEditable(false);
		emailAddressDelete_txtf.setBounds(380, 305, 350, 30);
		
		addressDelete_lbl = new JLabel();
		addressDelete_lbl.setText("Address: ");
		addressDelete_lbl.setForeground(Color.WHITE);
		addressDelete_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		addressDelete_lbl.setBounds(380, 355, 200, 25);
		
		addressDelete_txtf = new JTextField();
		addressDelete_txtf.setFont(new Font("Helvetica", Font.BOLD, 17));
		addressDelete_txtf.setEditable(false);
		addressDelete_txtf.setBounds(380, 380, 480, 30);
		
		statusDelete_lbl = new JLabel();
		statusDelete_lbl.setText("Status: ");
		statusDelete_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		statusDelete_lbl.setForeground(Color.WHITE);
		statusDelete_lbl.setBounds(150, 440, 100, 25);
		
		statusDelete_txtf = new JTextField();
		statusDelete_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		statusDelete_txtf.setEditable(false);
		statusDelete_txtf.setBounds(150, 465, 120, 30);
		
		genderDelete_lbl = new JLabel();
		genderDelete_lbl.setText("Gender: ");
		genderDelete_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		genderDelete_lbl.setForeground(Color.WHITE);
		genderDelete_lbl.setBounds(320, 440, 150, 25);
		
		genderDelete_txtf = new JTextField();
		genderDelete_txtf.setFont(new Font("Helvetica", Font.BOLD,20));
		genderDelete_txtf.setEditable(false);
		genderDelete_txtf.setBounds(320, 465, 200, 30);
		
		// Resident Vaccination Information.
		
		JLabel vaccineInformationDelete_lbl = new JLabel();
		vaccineInformationDelete_lbl.setText("Vaccine Information");
		vaccineInformationDelete_lbl.setFont(new Font("Helvetica", Font.BOLD, 35));
		vaccineInformationDelete_lbl.setForeground(Color.WHITE);
		vaccineInformationDelete_lbl.setBounds(35, 560, 400, 35);
		
		JLabel firstDoseDelete_lbl = new JLabel();
		firstDoseDelete_lbl.setText("First Dose of Vaccine");
		firstDoseDelete_lbl.setFont(new Font("Helvetica", Font.BOLD, 25));
		firstDoseDelete_lbl.setForeground(Color.WHITE);
		firstDoseDelete_lbl.setBounds(35, 625, 300, 25);
		
		manufacturerNameFirstDoseDelete_lbl = new JLabel();
		manufacturerNameFirstDoseDelete_lbl.setText("Manufacturer Name: ");
		manufacturerNameFirstDoseDelete_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		manufacturerNameFirstDoseDelete_lbl.setForeground(Color.WHITE);
		manufacturerNameFirstDoseDelete_lbl.setBounds(35, 665, 205, 25);
		
		manufacturerNameFirstDoseDelete_txtf = new JTextField();
		manufacturerNameFirstDoseDelete_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		manufacturerNameFirstDoseDelete_txtf.setEditable(false);
		manufacturerNameFirstDoseDelete_txtf.setBounds(35, 690, 320, 30);
		
		batchNumFirstDoseDelete_lbl = new JLabel();
		batchNumFirstDoseDelete_lbl.setText("Batch Number: ");
		batchNumFirstDoseDelete_lbl.setForeground(Color.WHITE);
		batchNumFirstDoseDelete_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		batchNumFirstDoseDelete_lbl.setBounds(410, 665, 205, 25);
		
		batchNumFirstDoseDelete_txtf = new JTextField();
		batchNumFirstDoseDelete_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		batchNumFirstDoseDelete_txtf.setEditable(false);
		batchNumFirstDoseDelete_txtf.setBounds(410, 690, 250, 30);
		
		vaccinationDateFirstDoseDelete_lbl = new JLabel();
		vaccinationDateFirstDoseDelete_lbl.setText("Vaccination Date: (YYYY-MM-DD)");
		vaccinationDateFirstDoseDelete_lbl.setForeground(Color.WHITE);
		vaccinationDateFirstDoseDelete_lbl.setFont(new Font("Helvetica", Font.BOLD, 15));
		vaccinationDateFirstDoseDelete_lbl.setBounds(715, 665, 300, 25);
		
		vaccinationDateFirstDoseDelete_txtf = new JTextField();
		vaccinationDateFirstDoseDelete_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		vaccinationDateFirstDoseDelete_txtf.setEditable(false);
		vaccinationDateFirstDoseDelete_txtf.setBounds(715, 690, 200, 30);
		
		JLabel secondDoseDelete_lbl = new JLabel();
		secondDoseDelete_lbl.setText("First Dose of Vaccine");
		secondDoseDelete_lbl.setFont(new Font("Helvetica", Font.BOLD, 25));
		secondDoseDelete_lbl.setForeground(Color.WHITE);
		secondDoseDelete_lbl.setBounds(35, 760, 300, 25);
		
		manufacturerNameSecondDoseDelete_lbl = new JLabel();
		manufacturerNameSecondDoseDelete_lbl.setText("Manufacturer Name: ");
		manufacturerNameSecondDoseDelete_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		manufacturerNameSecondDoseDelete_lbl.setForeground(Color.WHITE);
		manufacturerNameSecondDoseDelete_lbl.setBounds(35, 800, 205, 25);
		
		manufacturerNameSecondDoseDelete_txtf = new JTextField();
		manufacturerNameSecondDoseDelete_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		manufacturerNameSecondDoseDelete_txtf.setEditable(false);
		manufacturerNameSecondDoseDelete_txtf.setBounds(35, 825, 320, 30);
		
		batchNumSecondDoseDelete_lbl = new JLabel();
		batchNumSecondDoseDelete_lbl.setText("Batch Number: ");
		batchNumSecondDoseDelete_lbl.setForeground(Color.WHITE);
		batchNumSecondDoseDelete_lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
		batchNumSecondDoseDelete_lbl.setBounds(410, 800, 205, 25);
		
		batchNumSecondDoseDelete_txtf = new JTextField();
		batchNumSecondDoseDelete_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		batchNumSecondDoseDelete_txtf.setEditable(false);
		batchNumSecondDoseDelete_txtf.setBounds(410, 825, 250, 30);
		
		vaccinationDateSecondDoseDelete_lbl = new JLabel();
		vaccinationDateSecondDoseDelete_lbl.setText("Vaccination Date: (YYYY-MM-DD)");
		vaccinationDateSecondDoseDelete_lbl.setFont(new Font("Helvetica", Font.BOLD, 15));
		vaccinationDateSecondDoseDelete_lbl.setForeground(Color.WHITE);
		vaccinationDateSecondDoseDelete_lbl.setBounds(715, 800, 300, 25);
		
		vaccinationDateSecondDoseDelete_txtf = new JTextField();
		vaccinationDateSecondDoseDelete_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		vaccinationDateSecondDoseDelete_txtf.setEditable(false);
		vaccinationDateSecondDoseDelete_txtf.setBounds(715, 825, 200, 30);
		
		residentDeletion_btn = new JButton();
		residentDeletion_btn.setText("Delete Resident Information");
		residentDeletion_btn.setFont(new Font("Helvetica", Font.BOLD, 14));
		residentDeletion_btn.setFocusable(false);
		residentDeletion_btn.setVerticalTextPosition(SwingConstants.CENTER);
		residentDeletion_btn.setForeground(Color.WHITE);
		residentDeletion_btn.setBackground(Color.RED);
		residentDeletion_btn.addActionListener(this);
		residentDeletion_btn.setBounds(250, 920, 250, 40);
		residentDeletion_btn.setBorder(BorderFactory.createRaisedSoftBevelBorder());	
		
		deletedResidentInformation_btn = new JButton();
		deletedResidentInformation_btn.setFocusable(false);
		deletedResidentInformation_btn.setFont(new Font("Helvetica", Font.BOLD, 14));
		deletedResidentInformation_btn.setVerticalTextPosition(SwingConstants.CENTER);
		deletedResidentInformation_btn.setForeground(Color.BLACK);
		deletedResidentInformation_btn.setBackground(Color.LIGHT_GRAY);
		deletedResidentInformation_btn.addActionListener(this);
		deletedResidentInformation_btn.setBounds(540, 920, 250, 40);
		deletedResidentInformation_btn.setText("Deleted Resident Infromation");
		
		//
		// Component inside the Side MenuBar.
		//
		// Label with icon within the Side Bar.
		ImageIcon homePageImage = new ImageIcon(
				new ImageIcon("img/concepcion uno logo.png").getImage().getScaledInstance(80, 90, Image.SCALE_SMOOTH));

		JLabel labelHomePage = new JLabel("Profiling System");
		labelHomePage.setIcon(homePageImage);
		labelHomePage.setHorizontalTextPosition(SwingConstants.CENTER);
		labelHomePage.setVerticalTextPosition(SwingConstants.BOTTOM);
		labelHomePage.setForeground(Color.BLACK);
		labelHomePage.setFont(new Font("Helvetica", Font.BOLD, 23));
		labelHomePage.setVerticalAlignment(SwingConstants.CENTER);
		labelHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		labelHomePage.setIconTextGap(10);
		labelHomePage.setBounds(5, 0, 260, 230);

		// Button for the ADDING or Registering a Residents.
		ImageIcon addResidentImage = new ImageIcon(
				new ImageIcon("img/add user icon.png").getImage().getScaledInstance(55, 65, Image.SCALE_SMOOTH));

		addResident.setText("ADD RESIDENT");
		addResident.setIcon(addResidentImage);
		addResident.setBounds(1, 210, 278, 70);
		addResident.setFont(new Font("Helvetica", Font.BOLD, 18));
		addResident.setVerticalTextPosition(SwingConstants.CENTER);
		addResident.setHorizontalTextPosition(SwingConstants.LEFT);
		addResident.setVerticalAlignment(SwingConstants.CENTER);
		addResident.setHorizontalAlignment(SwingConstants.RIGHT);
		addResident.setOpaque(true);
		addResident.setContentAreaFilled(true);
		addResident.setBorderPainted(false);
		addResident.setFocusable(false);
		addResident.addActionListener(this);
		addResident.setBackground(Color.GREEN);
		addResident.setForeground(Color.WHITE);

		// Button for the DELETING or Removing a Residents.
		ImageIcon deleteResidentImage = new ImageIcon(
				new ImageIcon("img/Delete user icon.png").getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH));

		deleteResident.setText("DELETE RESIDENT");
		deleteResident.setIcon(deleteResidentImage);
		deleteResident.setBounds(1, 285, 278, 70);
		deleteResident.setFont(new Font("Helvetica", Font.BOLD, 18));
		deleteResident.setVerticalTextPosition(SwingConstants.CENTER);
		deleteResident.setHorizontalTextPosition(SwingConstants.LEFT);
		deleteResident.setVerticalAlignment(SwingConstants.CENTER);
		deleteResident.setHorizontalAlignment(SwingConstants.RIGHT);
		deleteResident.setFocusable(false);
		deleteResident.setBorderPainted(false);
		deleteResident.setContentAreaFilled(true);
		deleteResident.setOpaque(true);
		deleteResident.setBackground(Color.RED);
		deleteResident.setForeground(Color.WHITE);
		deleteResident.addActionListener(this);

		// JPanel of the side menu bar.
		Border backlineforSideMenu = BorderFactory.createLineBorder(Color.BLACK);
		JPanel sideMenuBar = new JPanel();
		sideMenuBar.setBackground(Color.WHITE);
		sideMenuBar.setBounds(0, 0, 280, 720);
		sideMenuBar.setLayout(null);
		sideMenuBar.setBorder(backlineforSideMenu);

		// Back Button to return to login
		logoutButton.setBounds(10, 635, 80, 35);
		logoutButton.setFocusable(false);
		logoutButton.addActionListener(this);
		logoutButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		logoutButton.setFont(new Font("Helvetica", Font.BOLD, 13));
		logoutButton.setBackground(Color.LIGHT_GRAY);
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorderPainted(false);
		
		//
		// JPanel for the Registration of the Residents.
		//
		jpanelResidentRegistration = new JPanel();
		jpanelResidentRegistration.setBackground(new Color(2, 53, 130));
		jpanelResidentRegistration.setLayout(null);
		jpanelResidentRegistration.setPreferredSize(new Dimension(800,1100));
		
		// Scroll Pane for the Resident Registration.
		addRessidentScroll = new JScrollPane(jpanelResidentRegistration);
		addRessidentScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		addRessidentScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		addRessidentScroll.setVisible(true);
		addRessidentScroll.getVerticalScrollBar().setUnitIncrement(16);
		addRessidentScroll.setBounds(280, 0, 1003, 680);
		
		//
		// Jpanel for the Deletion of the Residents.
		//
		jpanelResidentDeletion = new JPanel();
		jpanelResidentDeletion.setBackground(new Color(2, 53, 130));
		jpanelResidentDeletion.setPreferredSize(new Dimension(800,1000));
		jpanelResidentDeletion.setLayout(null);
		
		// Scroll Pane for the Deletion of Resident.
		deleteResidentScroll = new JScrollPane(jpanelResidentDeletion);
		deleteResidentScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		deleteResidentScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		deleteResidentScroll.setVisible(true);
		deleteResidentScroll.getVerticalScrollBar().setUnitIncrement(16);
		deleteResidentScroll.setBounds(280, 0, 1003, 680);					
		
		// The Body Frame of the System.
		jframe.setIconImage(framelogo.getImage());
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.setTitle("Profiling System - Home Page.");
		jframe.getContentPane().setBackground(new Color(2, 53, 130));
		jframe.setVisible(true);
		jframe.setSize(1300, 720);
		jframe.setLayout(null);
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);
		
		
		// Added Components to the Deletion of Resident Information.
		jpanelResidentDeletion.add(deletinglabel);
		jpanelResidentDeletion.add(searchResidentID);
		jpanelResidentDeletion.add(searchResidentIDDelete_txtf);
		jpanelResidentDeletion.add(searchResidentID_btn);
		jpanelResidentDeletion.add(firstNameDelete_lbl);
		jpanelResidentDeletion.add(firstNameDelete_txtf);
		jpanelResidentDeletion.add(middleNameDelete_lbl);
		jpanelResidentDeletion.add(middleNameDelete_txtf);
		jpanelResidentDeletion.add(lastNameDelete_lbl);
		jpanelResidentDeletion.add(lastNameDelete_txtf);
		jpanelResidentDeletion.add(suffixDelete_lbl);
		jpanelResidentDeletion.add(suffixDelete_txtf);		
		jpanelResidentDeletion.add(phoneNumberDelete_lbl);
		jpanelResidentDeletion.add(phoneNumberDelete_txtf);
		jpanelResidentDeletion.add(addressDelete_lbl);
		jpanelResidentDeletion.add(addressDelete_txtf);
		jpanelResidentDeletion.add(emailAddressDelete_lbl);
		jpanelResidentDeletion.add(emailAddressDelete_txtf);
		jpanelResidentDeletion.add(statusDelete_lbl);
		jpanelResidentDeletion.add(statusDelete_txtf);
		jpanelResidentDeletion.add(genderDelete_lbl);
		jpanelResidentDeletion.add(genderDelete_txtf);
		jpanelResidentDeletion.add(vaccineInformationDelete_lbl);
		jpanelResidentDeletion.add(firstDoseDelete_lbl);
		jpanelResidentDeletion.add(manufacturerNameFirstDoseDelete_lbl);
		jpanelResidentDeletion.add(manufacturerNameFirstDoseDelete_txtf);
		jpanelResidentDeletion.add(batchNumFirstDoseDelete_lbl);
		jpanelResidentDeletion.add(batchNumFirstDoseDelete_txtf);
		jpanelResidentDeletion.add(vaccinationDateFirstDoseDelete_lbl);
		jpanelResidentDeletion.add(vaccinationDateFirstDoseDelete_txtf);
		jpanelResidentDeletion.add(secondDoseDelete_lbl);
		jpanelResidentDeletion.add(manufacturerNameSecondDoseDelete_lbl);
		jpanelResidentDeletion.add(manufacturerNameSecondDoseDelete_txtf);
		jpanelResidentDeletion.add(batchNumSecondDoseDelete_lbl);
		jpanelResidentDeletion.add(batchNumSecondDoseDelete_txtf);
		jpanelResidentDeletion.add(vaccinationDateSecondDoseDelete_lbl);
		jpanelResidentDeletion.add(vaccinationDateSecondDoseDelete_txtf);
		jpanelResidentDeletion.add(residentDeletion_btn);
		jpanelResidentDeletion.add(deletedResidentInformation_btn);
		
		// Added Components to the Adding Resident Registration.	
		jpanelResidentRegistration.add(lblVaccinationInfomation);
		jpanelResidentRegistration.add(vaccineQuestion);
		jpanelResidentRegistration.add(yes_rb);
		jpanelResidentRegistration.add(no_rb);
		jpanelResidentRegistration.add(secondDose_lbl);
		jpanelResidentRegistration.add(manufacturerNameSecondDose_lbl);
		jpanelResidentRegistration.add(manufacturerNameSecondDose_txtf);
		jpanelResidentRegistration.add(batchNumSecondDose_lbl);
		jpanelResidentRegistration.add(batchNumSecondDose_txtf);
		jpanelResidentRegistration.add(vaccinationDateFirstDose_lbl);
		jpanelResidentRegistration.add(vaccinationDateFirstDose_txtf);
		jpanelResidentRegistration.add(firstDose_lbl);
		jpanelResidentRegistration.add(manufacturerNameFirstDose_lbl);
		jpanelResidentRegistration.add(manufacturerNameFirstDose_txtf);
		jpanelResidentRegistration.add(batchNumFirstDose_lbl);
		jpanelResidentRegistration.add(batchNumFirstDose_txtf);
		jpanelResidentRegistration.add(vaccinationDateSecondDose_lbl);
		jpanelResidentRegistration.add(vaccinationDateSecondDose_txtf);
		jpanelResidentRegistration.add(clearButton);
		jpanelResidentRegistration.add(addButton);
		jpanelResidentRegistration.add(gender_txtb);
		jpanelResidentRegistration.add(gender_lbl);
		jpanelResidentRegistration.add(emailAdd_lbl);
		jpanelResidentRegistration.add(emailAdd_txtf);
		jpanelResidentRegistration.add(generateRandomId);
		jpanelResidentRegistration.add(randomId_lbl);
		jpanelResidentRegistration.add(randomId_txtf);
		jpanelResidentRegistration.add(status_lbl);
		jpanelResidentRegistration.add(status_txtb);
		jpanelResidentRegistration.add(suffix_lbl);
		jpanelResidentRegistration.add(suffix_txtf);
		jpanelResidentRegistration.add(phoneNum_lbl);
		jpanelResidentRegistration.add(phoneNumber_txtf);
		jpanelResidentRegistration.add(address_lbl);
		jpanelResidentRegistration.add(address_txtf);
		jpanelResidentRegistration.add(middleinitial_lbl);
		jpanelResidentRegistration.add(middleInitial_txtf);
		jpanelResidentRegistration.add(lastname_lbl);
		jpanelResidentRegistration.add(lastName_txtf);
		jpanelResidentRegistration.add(firstName_txtf);
		jpanelResidentRegistration.add(firstname_lbl);
		jpanelResidentRegistration.add(registerlabel);
		
		// Side Menu Bar.
		sideMenuBar.add(deleteResident);
		sideMenuBar.add(addResident);
		sideMenuBar.add(logoutButton);
		sideMenuBar.add(labelHomePage);
		
		// The Main Frame where all of the components are stored.
		jframe.add(sideMenuBar);
		jframe.add(addRessidentScroll);
		jframe.add(deleteResidentScroll);
	}
	
	
	//
	// Deleted Resident Information.
	//
	public void deletedResidentInformation() {
		
		JLabel residentId_lbl2 = new JLabel();
		residentId_lbl2.setText("Enter Resident ID: ");
		residentId_lbl2.setFont(new Font("Helvetica", Font.BOLD, 18));
		residentId_lbl2.setForeground(Color.WHITE);
		residentId_lbl2.setBounds(230, 50, 200, 25);
		
		search_txtf = new JTextField();
		search_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		search_txtf.setBounds(395, 47, 130, 30);
		
		restore_btn = new JButton();
		restore_btn.setFocusable(false);
		restore_btn.setFont(new Font("Helvetica", Font.BOLD, 14));
		restore_btn.setText("RESTORE");
		restore_btn.setForeground(Color.BLACK);
		restore_btn.setBackground(Color.LIGHT_GRAY);
		restore_btn.addActionListener(this);
		restore_btn.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		restore_btn.setBounds(540, 47, 100, 30); 
	
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Resident ID");
		tableModel.addColumn("First Name");
		tableModel.addColumn("Middle Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Suffix");
		tableModel.addColumn("Phone Number");
		tableModel.addColumn("Address");
		tableModel.addColumn("Email Address");
		tableModel.addColumn("Status");
		tableModel.addColumn("Gender");
		tableModel.addColumn("1st Dose Manufacturer Name");
		tableModel.addColumn("1st Dose BatchNo");
		tableModel.addColumn("1st Dose Vaccination Date");
		tableModel.addColumn("2nd Dose Manufacturer Name");
		tableModel.addColumn("2nd Dose BatchNo");
		tableModel.addColumn("2nd Dose Vaccination Date");
		jtable = new JTable(tableModel);
		jtable.setModel(tableModel);
		jtable.setEnabled(false);
		jtable.getColumnModel().getColumn(0).setPreferredWidth(200);
		jtable.getColumnModel().getColumn(1).setPreferredWidth(200);
		jtable.getColumnModel().getColumn(2).setPreferredWidth(200);
		jtable.getColumnModel().getColumn(3).setPreferredWidth(200);
		jtable.getColumnModel().getColumn(4).setPreferredWidth(200);
		jtable.getColumnModel().getColumn(5).setPreferredWidth(200);
		jtable.getColumnModel().getColumn(6).setPreferredWidth(500);
		jtable.getColumnModel().getColumn(7).setPreferredWidth(250);
		jtable.getColumnModel().getColumn(8).setPreferredWidth(200);
		jtable.getColumnModel().getColumn(9).setPreferredWidth(200);
		jtable.getColumnModel().getColumn(10).setPreferredWidth(400);
		jtable.getColumnModel().getColumn(11).setPreferredWidth(400);
		jtable.getColumnModel().getColumn(12).setPreferredWidth(400);
		jtable.getColumnModel().getColumn(13).setPreferredWidth(400);
		jtable.getColumnModel().getColumn(14).setPreferredWidth(400);
		jtable.getColumnModel().getColumn(15).setPreferredWidth(400);
		jtable.setAutoResizeMode(0);
		jtable.setPreferredSize(new Dimension(4750, 1000));
		jtable.setFillsViewportHeight(true);
		
		// Scroll Pane for the Resident Registration.
		addjtableScroll = new JScrollPane(jtable);
		addjtableScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		addjtableScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		addjtableScroll.setVisible(true);
		addjtableScroll.getVerticalScrollBar().setUnitIncrement(10);
		addjtableScroll.setBounds(50, 100, 800, 350);
		
		// Icon Properties.
		ImageIcon deletedResidentInformationIcon = new ImageIcon("img/concepcion uno logo.png");
		
		// JFrame Properties.
		deletedframe = new JFrame();
		deletedframe.setTitle("Deleted Resident Information");
		deletedframe.setVisible(true);
		deletedframe.setResizable(false);
		deletedframe.setLayout(null);
		deletedframe.setSize(900, 500);
		deletedframe.getContentPane().setBackground(new Color(2, 53, 130));
		deletedframe.setLocationRelativeTo(null);	
		deletedframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// added components to the JFrame.
		deletedframe.setIconImage(deletedResidentInformationIcon.getImage());
		deletedframe.add(residentId_lbl2);
		deletedframe.add(search_txtf);
		deletedframe.add(restore_btn);
		deletedframe.add(addjtableScroll);
	
		// This Will Show the Data Inside the Database.
				deletedframe.addWindowListener(new WindowAdapter() {
					
					public void windowOpened(WindowEvent e) {
												
						try {
							listOfDeletedResident();
						
							while(myrst.next()){
								tableModel.addRow(new Object[] {
									myrst.getString("resident_id"),
									myrst.getString("first_name"),
									myrst.getString("middle_initial"),
									myrst.getString("last_name"),
									myrst.getString("suffix"),
									myrst.getString("phone_number"),
									myrst.getString("address"),
									myrst.getString("email_address"),
									myrst.getString("status"),
									myrst.getString("gender"),
									myrst.getString("1stDose_ManufacturerName"),
									myrst.getString("1stDose_BatchNo"),
									myrst.getString("1stDose_VaccinationDate"),
									myrst.getString("2ndDose_ManufacturerName"),
									myrst.getString("2ndDose_BatchNo"),
									myrst.getString("2ndDose_VaccinationDate")
								});
								
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
		// This will set the button to enable after closing this frame.
		deletedframe.addWindowListener(new WindowAdapter() {
		
			public void windowClosed(WindowEvent e) {
				deletedResidentInformation_btn.setEnabled(true);
			}
		});
		
	}
	
	//
	// This is ActionPerformed.
	//

	@Override
	public void actionPerformed(ActionEvent e) {

		// the Employee will login and will open the Home page of the Profiling System
		if (e.getSource() == buttonLogin) {
			try {	
			String user = usernameTextField.getText();
			String pass = userpassword.getText();
			String usernameindb = null;
			String userpassindb = null;
			
			employeeLogin(user, pass);
					
				while (myrst.next()) {
					 usernameindb = myrst.getString("username");
					 userpassindb = myrst.getString("password");
				}
				
				if(user.equals(usernameindb) && pass.equals(userpassindb)) {
					LoginFrame.dispose();
					residentRegistrationPage();
					searchResidentIDDelete_txtf.setVisible(false);
					firstNameDelete_txtf.setVisible(false);
					middleNameDelete_txtf.setVisible(false);
					lastNameDelete_txtf.setVisible(false);
					suffixDelete_txtf.setVisible(false);
					phoneNumberDelete_txtf.setVisible(false);
					addressDelete_txtf.setVisible(false);
					emailAddressDelete_txtf.setVisible(false);
					statusDelete_txtf.setVisible(false);
					manufacturerNameFirstDoseDelete_txtf.setVisible(false);
					batchNumFirstDoseDelete_txtf.setVisible(false);
					vaccinationDateFirstDoseDelete_txtf.setVisible(false);
					manufacturerNameSecondDoseDelete_txtf.setVisible(false);
					batchNumSecondDoseDelete_txtf.setVisible(false);
					vaccinationDateSecondDoseDelete_txtf.setVisible(false);
					genderDelete_txtf.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "username or password is Incorrect!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "username or password is Empty!", "Error",
						JOptionPane.ERROR_MESSAGE);
				e1.getSQLState();
			}
		}	

		// The Employee will be logout back to the Login Page
		if (e.getSource() == logoutButton) {
			int backToLoginWindow = JOptionPane.showConfirmDialog(null, "Are you Sure ?", "Log Out",
					JOptionPane.YES_NO_OPTION);

			if (backToLoginWindow == 0) {
				jframe.dispose();
				new Profiling_System();
			}
		}

		// This Will Randomly generates resident ID.
		if (e.getSource() == generateRandomId) {
			generateRandomId.setEnabled(false);

			list = generateID(1, 100000, 999999);

			for (Object element : list) {
				randomId_txtf.setText("" + element);
			}
		}
		
		// This is for the vaccination Iformation radiobutton.
		if(e.getSource()==yes_rb) {
			vaccinationDateFirstDose_txtf.setEditable(true);
			vaccinationDateSecondDose_txtf.setEditable(true);
			manufacturerNameFirstDose_txtf.setEditable(true);
			batchNumFirstDose_txtf.setEditable(true);
			manufacturerNameSecondDose_txtf.setEditable(true);
			batchNumSecondDose_txtf.setEditable(true);
			manufacturerNameSecondDose_txtf.setText("");
			batchNumSecondDose_txtf.setText("");
			manufacturerNameFirstDose_txtf.setText("");
			batchNumFirstDose_txtf.setText("");
			vaccinationDateFirstDose_txtf.setText("YYYY-MM-DD");
			vaccinationDateSecondDose_txtf.setText("YYYY-MM-DD");
		}
		if(e.getSource() == no_rb) {
			manufacturerNameFirstDose_txtf.setEditable(false);
			vaccinationDateFirstDose_txtf.setEditable(false);
			vaccinationDateSecondDose_txtf.setEditable(false);
			batchNumFirstDose_txtf.setEditable(false);
			manufacturerNameSecondDose_txtf.setEditable(false);
			batchNumSecondDose_txtf.setEditable(false);
			manufacturerNameSecondDose_txtf.setText("None");
			batchNumSecondDose_txtf.setText("None");
			manufacturerNameFirstDose_txtf.setText("None");
			batchNumFirstDose_txtf.setText("None");
			vaccinationDateFirstDose_txtf.setText("0000-00-00");
			vaccinationDateSecondDose_txtf.setText("0000-00-00");
		}

		// This will insert the resident details in the database
		if (e.getSource() == addButton) {
			
			if(CheckDate(vaccinationDateFirstDose_txtf.getText()) && CheckDate(vaccinationDateSecondDose_txtf.getText())) {
				try {
					long randomId = Long.parseLong(randomId_txtf.getText());
					long phoneNum = Long.parseLong(phoneNumber_txtf.getText());
					String userStatus = status_txtb.getSelectedItem().toString();
					String userGender = gender_txtb.getSelectedItem().toString();

					addResidentdb(randomId, firstName_txtf.getText(), lastName_txtf.getText(), suffix_txtf.getText(),
							middleInitial_txtf.getText(), phoneNum, address_txtf.getText(), emailAdd_txtf.getText(),
							userStatus, userGender,manufacturerNameFirstDose_txtf.getText(), batchNumFirstDose_txtf.getText(),
							vaccinationDateFirstDose_txtf.getText(),manufacturerNameSecondDose_txtf.getText(), 
							batchNumSecondDose_txtf.getText(), vaccinationDateSecondDose_txtf.getText());

					if (getResidentAdded() >= 1) {
						JOptionPane.showMessageDialog(null, firstName_txtf.getText() + " is now Added Successfully!", "Added Successfully",
								JOptionPane.INFORMATION_MESSAGE);
					generateRandomId.setEnabled(true);
					randomId_txtf.setText("");
					emailAdd_txtf.setText("");
					firstName_txtf.setText("");
					middleInitial_txtf.setText("");
					lastName_txtf.setText("");
					address_txtf.setText("");
					phoneNumber_txtf.setText("");
					gender_txtb.setSelectedIndex(0);
					status_txtb.setSelectedIndex(0);
					manufacturerNameFirstDose_txtf.setText("");
					batchNumFirstDose_txtf.setText("");
					vaccinationDateSecondDose_txtf.setText("YYYY/MM/DD");
					vaccinationDateFirstDose_txtf.setText("YYYY/MM/DD");
					manufacturerNameSecondDose_txtf.setText("");
					batchNumSecondDose_txtf.setText("");
					yes_rb.setSelected(false);
					no_rb.setSelected(false);
					
					}
				} catch (Exception ewan) {
					JOptionPane.showMessageDialog(null, "Fillup all the form!", "Error", JOptionPane.ERROR_MESSAGE);
					ewan.getStackTrace();
				}
				suffix_txtf.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "Invalid Date Format", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		// This will now Open the Panel of the add Resident Jpanel and hide the Delete
		// Resident Jpanel
		if (e.getSource() == addResident) {
			addRessidentScroll.setVisible(true);
			jpanelResidentRegistration.setVisible(true);
			jpanelResidentDeletion.setVisible(false);
		}
		
		// This will now Open the Panel of the Delete Resident Jpanel and hide the add
		// Resident JPanel
		if (e.getSource() == deleteResident) {
			jpanelResidentDeletion.setVisible(true);
			addRessidentScroll.setVisible(false);
			jpanelResidentRegistration.setVisible(false);
			searchResidentIDDelete_txtf.setVisible(true);
			firstNameDelete_txtf.setVisible(true);
			middleNameDelete_txtf.setVisible(true);
			lastNameDelete_txtf.setVisible(true);
			suffixDelete_txtf.setVisible(true);
			phoneNumberDelete_txtf.setVisible(true);
			addressDelete_txtf.setVisible(true);
			emailAddressDelete_txtf.setVisible(true);
			statusDelete_txtf.setVisible(true);
			manufacturerNameFirstDoseDelete_txtf.setVisible(true);
			batchNumFirstDoseDelete_txtf.setVisible(true);
			vaccinationDateFirstDoseDelete_txtf.setVisible(true);
			manufacturerNameSecondDoseDelete_txtf.setVisible(true);
			batchNumSecondDoseDelete_txtf.setVisible(true);
			vaccinationDateSecondDoseDelete_txtf.setVisible(true);
			genderDelete_txtf.setVisible(true);
		}
		
		// Search for the Resident with the Use of the Resident ID (DELETE SECTION)
		if(e.getSource() == searchResidentID_btn) {
			try {
				int resident_ID = Integer.parseInt(searchResidentIDDelete_txtf.getText());
			
				getResidentDetails(resident_ID);
				
				while(myrst.next()) {
					
					firstNameDelete_txtf.setText(myrst.getString(2));
					middleNameDelete_txtf.setText(myrst.getString(3));
					lastNameDelete_txtf.setText(myrst.getString(4));
					suffixDelete_txtf.setText(myrst.getString(5));
					phoneNumberDelete_txtf.setText(myrst.getString(6));
					addressDelete_txtf.setText(myrst.getString(7));
					emailAddressDelete_txtf.setText(myrst.getString(8));
					statusDelete_txtf.setText(myrst.getString(9));
					genderDelete_txtf.setText(myrst.getString(10));
					manufacturerNameFirstDoseDelete_txtf.setText(myrst.getString(11));
					batchNumFirstDoseDelete_txtf.setText(myrst.getString(12));
					vaccinationDateFirstDoseDelete_txtf.setText(myrst.getString(13));
					manufacturerNameSecondDoseDelete_txtf.setText(myrst.getString(14));
					batchNumSecondDoseDelete_txtf.setText(myrst.getString(15));
					vaccinationDateSecondDoseDelete_txtf.setText(myrst.getString(16));
				}
			}catch(Exception e2) {
				JOptionPane.showMessageDialog(null, "Please Enter Resident ID!", "Error!", JOptionPane.ERROR_MESSAGE);
				searchResidentIDDelete_txtf.setText("");
				e2.getStackTrace();
			}
		}
		
		// This will delete the information of the resident.
		if(e.getSource() == residentDeletion_btn) {
			try {	
			int residentID = Integer.parseInt(searchResidentIDDelete_txtf.getText());
				
			deleteResidentInformation(residentID);
			
			if(getResidentDeleted() >= 1) {
				JOptionPane.showMessageDialog(null, "Resident Data is Deleted Successfully", "Deleted Succesfuly", JOptionPane.INFORMATION_MESSAGE);
				firstNameDelete_txtf.setText("");
				middleNameDelete_txtf.setText("");
				lastNameDelete_txtf.setText("");
				suffixDelete_txtf.setText("");
				statusDelete_txtf.setText("");
				genderDelete_txtf.setText("");
				phoneNumberDelete_txtf.setText("");
				emailAddressDelete_txtf.setText("");
				addressDelete_txtf.setText("");
				
				manufacturerNameFirstDoseDelete_txtf.setText("");
				batchNumFirstDoseDelete_txtf.setText("");
				vaccinationDateFirstDoseDelete_txtf.setText("");
				manufacturerNameSecondDoseDelete_txtf.setText("");
				batchNumSecondDoseDelete_txtf.setText("");
				vaccinationDateSecondDoseDelete_txtf.setText("");
			}
			}catch(Exception sql) {
				JOptionPane.showMessageDialog(null, "No Resident Deleted", "Failed", JOptionPane.INFORMATION_MESSAGE);
				sql.getStackTrace();
			}
		}
		
		// this will show the deleted Infromation of the Resident and the employee can restore the deleted information.
		if(e.getSource() == deletedResidentInformation_btn) {
			deletedResidentInformation();
			deletedResidentInformation_btn.setEnabled(false);
		}	
		// This will Restore the deleted informationa of the resident
		if(e.getSource() == restore_btn) {
			try {
				int id = Integer.parseInt(search_txtf.getText());
				restoreDeletedResident(id);
				
				if(getResidentRestored() >= 1) {
					JOptionPane.showMessageDialog(null, "Resident Data is Restored Successfully", "Restored Succesfuly", JOptionPane.INFORMATION_MESSAGE);
					search_txtf.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Failed, Please Check the Resident ID!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				
				
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "Failed, Please Check the Resident ID!", "Error!", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		// Clearing the TextField in the Resident Registration Jpanel
		if (e.getSource() == clearButton) {
			generateRandomId.setEnabled(true);
			randomId_txtf.setText("");
			emailAdd_txtf.setText("");
			firstName_txtf.setText("");
			middleInitial_txtf.setText("");
			lastName_txtf.setText("");
			suffix_txtf.setText("");
			address_txtf.setText("");
			phoneNumber_txtf.setText("");
			status_txtb.setSelectedIndex(0);
		}
	}
}
