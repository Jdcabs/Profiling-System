import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

public class Profiling_System extends JDBC_Connector implements ActionListener {

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
		
			
	//Adding of Resident Properties.
	//Vaccination Information of the Resident.
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
	
	//Information of the Resident.
	JLabel emailAdd_lbl;
	JLabel randomId_lbl;
	JLabel suffix_lbl;
	JLabel address_lbl;
	JLabel lastname_lbl;
	JLabel middleinitial_lbl;
	JLabel firstname_lbl;
	JLabel phoneNum_lbl;
	JLabel status_lbl;
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
	JButton generateIDNum;
	JButton generateRandomId;
	JScrollPane addRessidentScroll;
	JPanel jpanelResidentRegistration;
	
	//Deletion of the Resident Properties.
	JPanel jpanelResidentDeletion;
	JTextField searchResidentID_txtf;
	JButton searchResidentID_btn;
	JLabel firstNameDelete_lbl;
	JLabel lastnameDelete_lbl;
	JLabel middleNameDelete_lbl;
	JLabel suffixDelete_lbl;
	JTextField firstNameDelete_txtf;
	JTextField lastNameDelete_txtf;
	JTextField middleNameDelete_txtf;
	JTextField suffixDelete_txtf;
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 																														//
	//			 LOGIN PAGE OF THE PROFILING SYSTTEM.                                                                       //
	// 																													    //
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
		firstDose_lbl.setFont(new Font("Helvetica", Font.BOLD, 20));
		firstDose_lbl.setForeground(Color.WHITE);
		firstDose_lbl.setBounds(35, 660, 250, 25);
		
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
		secondDose_lbl.setFont(new Font("Helvetica", Font.BOLD, 20));
		secondDose_lbl.setForeground(Color.WHITE);
		secondDose_lbl.setBounds(35, 800, 250, 25);
		
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
		//
		JLabel deletinglabel = new JLabel("Delete Resident Information");
		deletinglabel.setForeground(Color.WHITE);
		deletinglabel.setFont(new Font("Helvetica", Font.BOLD, 35));
		deletinglabel.setBounds(35, 50, 500, 45);
		
		JLabel searchResidentID = new JLabel("Search for Resident ID: ");
		searchResidentID.setForeground(Color.WHITE);
		searchResidentID.setFont(new Font("Helvetica", Font.BOLD, 18));
		searchResidentID.setBounds(220, 130, 250, 25);
		
		searchResidentID_txtf = new JTextField();
		searchResidentID_txtf.setFont(new Font("Helvetica", Font.BOLD, 20));
		searchResidentID_txtf.setBounds(430, 128, 150, 30);

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
		firstNameDelete_txtf.setBounds(35, 225, 205, 30);
		
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
		jpanelResidentRegistration.setPreferredSize(new Dimension(800,1100));
		jpanelResidentRegistration.setLayout(null);
		
		//
		//Jpanel for the Deletion of the Residents.
		//
		jpanelResidentDeletion = new JPanel();
		jpanelResidentDeletion.setBackground(new Color(2, 53, 130));
		jpanelResidentDeletion.setPreferredSize(new Dimension(800,1100));
		jpanelResidentDeletion.setBounds(280, 0, 1003, 680);
		jpanelResidentDeletion.setLayout(null);
		
		jframe.setIconImage(framelogo.getImage());
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.setTitle("Profiling System - Home Page.");
		jframe.getContentPane().setBackground(new Color(2, 53, 130));
		jframe.setVisible(true);
		jframe.setSize(1300, 720);
		jframe.setLayout(null);
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);
		
		addRessidentScroll = new JScrollPane(jpanelResidentRegistration);
		addRessidentScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		addRessidentScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		addRessidentScroll.setVisible(true);
		addRessidentScroll.getVerticalScrollBar().setUnitIncrement(16);
		addRessidentScroll.setBounds(280, 0, 1003, 680);
				
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
		
		// Added Components to the Deletion of Resident Information.
		jpanelResidentDeletion.add(deletinglabel);
		jpanelResidentDeletion.add(searchResidentID);
		jpanelResidentDeletion.add(searchResidentID_txtf);
		jpanelResidentDeletion.add(searchResidentID_btn);
		jpanelResidentDeletion.add(firstNameDelete_lbl);
		jpanelResidentDeletion.add(firstNameDelete_txtf);
		
		//Side Menu Bar.
		sideMenuBar.add(deleteResident);
		sideMenuBar.add(addResident);
		sideMenuBar.add(logoutButton);
		sideMenuBar.add(labelHomePage);
		
		//The Main Frame where all of the components are stored.
		jframe.add(sideMenuBar);
		jframe.add(addRessidentScroll);
		jframe.add(jpanelResidentDeletion);
	}
	
	
	//
	//This is ActionPerformed.
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
					searchResidentID_txtf.setVisible(false);
					firstNameDelete_txtf.setVisible(false);
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
		
		//This is for the vaccination Iformation radiobutton.
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

					addResidentdb(randomId, firstName_txtf.getText(), lastName_txtf.getText(), suffix_txtf.getText(),
							middleInitial_txtf.getText(), phoneNum, address_txtf.getText(), emailAdd_txtf.getText(),
							userStatus, manufacturerNameFirstDose_txtf.getText(), batchNumFirstDose_txtf.getText(),
							vaccinationDateFirstDose_txtf.getText(),manufacturerNameSecondDose_txtf.getText(), 
							batchNumSecondDose_txtf.getText(), vaccinationDateSecondDose_txtf.getText());

					if (getResidentAdded() >= 1) {
						JOptionPane.showMessageDialog(null, firstName_txtf.getText() + " is now Added!", "Added Succesfuly",
								JOptionPane.INFORMATION_MESSAGE);
					
					generateRandomId.setEnabled(true);
					randomId_txtf.setText("");
					emailAdd_txtf.setText("");
					firstName_txtf.setText("");
					middleInitial_txtf.setText("");
					lastName_txtf.setText("");
					address_txtf.setText("");
					phoneNumber_txtf.setText("");
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
			searchResidentID_txtf.setVisible(true);
			firstNameDelete_txtf.setVisible(true);
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
