import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class Registration_MainPage extends Profiling_System implements ActionListener{

	JButton logoutButton = new JButton("Logout");
	ImageIcon framelogo = new ImageIcon("img/concepcion uno logo.png");
	JButton addResident = new JButton();
	JButton deleteResident = new JButton();
	JFrame jframe = new JFrame();

	private int backToLoginWindow;

	public Registration_MainPage(){


		//Component inside the Body of the frame.
		//Label the show the Greetin for the employee
		JLabel labelGreetEmployee = new JLabel();
		labelGreetEmployee.setText("Wellcome ");
		labelGreetEmployee.setFont(new Font("Helvetica", Font.BOLD, 30));
		labelGreetEmployee.setBounds(5, 30, 290, 30);

		//Jpanel fot the body of the frame, here we can see the changing of properties depends on the button clicked in the sidebar menu
		JPanel jpanelBodyFrame = new JPanel();
		jpanelBodyFrame.setBackground(new Color(2,53,130));
		jpanelBodyFrame.setBounds(280, 0, 1020, 720);
		jpanelBodyFrame.setLayout(null);


		//Component inside the Side MenuBar.
		//Label with icon within the Side Bar.
		ImageIcon homePageImage = new ImageIcon(new ImageIcon("img/concepcion uno logo.png").getImage().getScaledInstance(80, 90, Image.SCALE_SMOOTH));

		JLabel labelHomePage = new JLabel("Profiling System");
		labelHomePage.setIcon(homePageImage);
		labelHomePage.setHorizontalTextPosition(SwingConstants.CENTER);
		labelHomePage.setVerticalTextPosition(SwingConstants.BOTTOM);
		labelHomePage.setForeground(Color.BLACK);
		labelHomePage.setFont(new Font("Helvetica", Font.BOLD,23));
		labelHomePage.setVerticalAlignment(SwingConstants.CENTER);
		labelHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		labelHomePage.setIconTextGap(10);
		labelHomePage.setBounds(5, 0, 260, 230);

		//Button for the ADDING or Registering a Residents.
		ImageIcon addResidentImage = new ImageIcon(new ImageIcon("img/add user icon.png").getImage().getScaledInstance(55, 65, Image.SCALE_SMOOTH));

		addResident.setText("ADD RESIDENT");
		addResident.setIcon(addResidentImage);
		addResident.setBounds(1, 210, 278, 70);
		addResident.setFont(new Font("Helvetica", Font.BOLD, 18));
		addResident.setVerticalTextPosition(SwingConstants.CENTER);
		addResident.setHorizontalTextPosition(SwingConstants.LEFT);
		addResident.setVerticalAlignment(SwingConstants.CENTER);
		addResident.setHorizontalAlignment(SwingConstants.CENTER);
		addResident.setOpaque(true);
		addResident.setContentAreaFilled(true);
		addResident.setBorderPainted(false);
		addResident.setFocusable(false);
		addResident.setBackground(Color.GREEN);
		addResident.setForeground(Color.WHITE);

		//Button for the DELETING or Removing a Residents.
		ImageIcon deleteResidentImage = new ImageIcon(new ImageIcon("img/Delete user icon.png").getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH));

		deleteResident.setText("DELETE RESIDENT");
		deleteResident.setIcon(deleteResidentImage);
		deleteResident.setBounds(1, 285, 278, 70);
		deleteResident.setFont(new Font("Helvetica", Font.BOLD, 18));
		deleteResident.setVerticalTextPosition(SwingConstants.CENTER);
		deleteResident.setHorizontalTextPosition(SwingConstants.LEFT);
		deleteResident.setVerticalAlignment(SwingConstants.CENTER);
		deleteResident.setHorizontalAlignment(SwingConstants.CENTER);
		deleteResident.setFocusable(false);
		deleteResident.setBorderPainted(false);
		deleteResident.setContentAreaFilled(true);
		deleteResident.setOpaque(true);
		deleteResident.setBackground(Color.RED);
		deleteResident.setForeground(Color.WHITE);

		//JPanel of the side menu bar.
		Border backlineforSideMenu = BorderFactory.createLineBorder(Color.BLACK);
		JPanel sideMenuBar = new JPanel();
		sideMenuBar.setBackground(Color.WHITE);
		sideMenuBar.setBounds(0, 0, 280, 720);
		sideMenuBar.setLayout(null);
		sideMenuBar.setBorder(backlineforSideMenu);

		//Back Button to return to login
		logoutButton.setBounds(10, 635, 80, 35);
		logoutButton.setFocusable(false);
		logoutButton.addActionListener(this);
		logoutButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		logoutButton.setFont(new Font("Helvetica", Font.BOLD, 13));
		logoutButton.setBackground(Color.LIGHT_GRAY);
		logoutButton.setOpaque(false);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setBorderPainted(false);

		//Frame Properties
		jframe.setIconImage(framelogo.getImage());
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.setTitle("Profiling System - Home Page.");
		jframe.getContentPane().setBackground(new Color(2,53,130));
		jframe.setVisible(true);
		jframe.setSize(1300,720);
		jframe.setLayout(null);
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);

		//Added Components to the Frame.
		jpanelBodyFrame.add(labelGreetEmployee);
		sideMenuBar.add(deleteResident);
		sideMenuBar.add(addResident);
		sideMenuBar.add(logoutButton);
		sideMenuBar.add(labelHomePage);
		jframe.add(sideMenuBar);
		jframe.add(jpanelBodyFrame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==logoutButton) {

			backToLoginWindow = JOptionPane.showConfirmDialog(null, "Are you Sure ?", "Go Back", JOptionPane.YES_NO_OPTION);

			if(backToLoginWindow == 0) {
				jframe.dispose();
			new Profiling_System();
			}
		}
	}
}
