import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class JDBC_Connector {

	Connection myCon = null;
	PreparedStatement myStmnt = null;
	ResultSet myrst = null;

	private final String connection = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private final String username = "profiling system";
	private final String password = "12345";

	// properties of the Resident
	private long resident_id;
	private String first_name_Resident;
	private String middle_initial_Resident;
	private String last_name_Resident;
	private String suffix;
	private long phone_number_Resident;
	private String address_Resident;
	private String email_address_Resident;
	private String status_Resident;
	private String gender_Resident;
	private int residentDeleted;
	private int residentAdded;
	private int residentRestored;
	private String firstDose_ManufacturerName;
	private String firstDose_BatchNumber;
	private String secondDose_ManufacturerName;
	private String secondDose_BatchNumber;
	private String firstDose_VaccinationDate;
	private String secondDose_VaccinationDate;

	// Getters and Setters of the Resident Properties.
	public long getResident_id() {
		return resident_id;
	}

	public String getFirst_name_Resident() {
		return first_name_Resident;
	}

	public String getMiddle_initial_Resident() {
		return middle_initial_Resident;
	}

	public String getLast_name_Resident() {
		return last_name_Resident;
	}

	public String getSuffix() {
		return suffix;
	}

	public long getPhone_number_Resident() {
		return phone_number_Resident;
	}

	public String getAddress_Resident() {
		return address_Resident;
	}

	public String getEmail_address_Resident() {
		return email_address_Resident;
	}

	public String getStatus_Resident() {
		return status_Resident;
	}

	public String getGender_Resident() {
		return gender_Resident;
	}

	public int getResidentAdded() {
		return residentAdded;
	}

	public int getResidentDeleted() {
		return residentDeleted;
	}

	public int getResidentRestored() {
		return residentRestored;
	}

	public String getFirstDoseManufacturerName() {
		return firstDose_ManufacturerName;
	}

	public String getFirstDoseBatchNumber() {
		return firstDose_BatchNumber;
	}

	public String getFirstDose_VaccinationDate() {
		return firstDose_VaccinationDate;
	}

	public String getSecondDoseManufacturerName() {
		return secondDose_ManufacturerName;
	}

	public String getSecondDoseBatchNumber() {
		return secondDose_BatchNumber;
	}

	public String getSecondDoseVaccinationDate() {
		return secondDose_VaccinationDate;
	}

	public void setResidentRestored(int residentRestored) {
		this.residentRestored = residentRestored;
	}

	public void setResidentAdded(int residentAdded) {
		this.residentAdded = residentAdded;
	}

	public void setResidentDeleted(int residentDeleted) {
		this.residentDeleted = residentDeleted;
	}

	public void setResident_id(long resident_id) {
		this.resident_id = resident_id;
	}

	public void setFirst_name_Resident(String first_name_Resident) {
		this.first_name_Resident = first_name_Resident;
	}

	public void setMiddle_initial_Resident(String middle_initial_Resident) {
		this.middle_initial_Resident = middle_initial_Resident;
	}

	public void setLast_name_Resident(String last_name_Resident) {
		this.last_name_Resident = last_name_Resident;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setPhone_number_Resident(long phone_number_Resident) {
		this.phone_number_Resident = phone_number_Resident;
	}

	public void setAddress_Resident(String address_Resident) {
		this.address_Resident = address_Resident;
	}

	public void setEmail_address_Resident(String email_address_Resident) {
		this.email_address_Resident = email_address_Resident;
	}

	public void setStatus_Resident(String status_Resident) {
		this.status_Resident = status_Resident;
	}

	public void setGender_Resident(String gender_Resident) {
		this.gender_Resident = gender_Resident;
	}

	public void setFirstDose_ManufacturerName(String manufacturerName) {
		this.firstDose_ManufacturerName = manufacturerName;
	}

	public void setFirstDose_BatchNumber(String batchNumber) {
		this.firstDose_BatchNumber = batchNumber;
	}

	public void setFirstDose_VaccinationDate(String FirstDose_VaccinationDate) {
		this.firstDose_VaccinationDate = FirstDose_VaccinationDate;
	}

	public void setSecondDose_ManufacturerName(String secondDose_ManufacturerName) {
		this.secondDose_ManufacturerName = secondDose_ManufacturerName;
	}

	public void setSecondDose_BatchNumber(String secondDose_BatchNumber) {
		this.secondDose_BatchNumber = secondDose_BatchNumber;
	}

	public void setSecondDose_VaccinationDate(String secondDose_VaccinationDate) {
		this.secondDose_VaccinationDate = secondDose_VaccinationDate;
	}

	// properties of the Employee
	private String user_name_Employee;
	private String user_password_Employee;
	private String fullname_Employee;
	private String address_Employee;
	private String phone_number_Employee;

	private int login;

	// Getters and Setters of the Employee properties.
	public String getUser_name() {
		return user_name_Employee;
	}

	public String getUser_password() {
		return user_password_Employee;
	}

	public String getFullname() {
		return fullname_Employee;
	}

	public String getAddress() {
		return address_Employee;
	}

	public String getPhone_number() {
		return phone_number_Employee;
	}

	public int getlogin() {
		return login;
	}

	public void setUser_name(String user_name) {
		this.user_name_Employee = user_name;
	}

	public void setUser_password(String user_password) {
		this.user_password_Employee = user_password;
	}

	public void setFullname(String fullname) {
		this.fullname_Employee = fullname;
	}

	public void setAddress(String address) {
		this.address_Employee = address;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number_Employee = phone_number;
	}

	public int setLogin(int login) {
		return this.login = login;
	}

	// Empty Constructor.
	public JDBC_Connector() {
		try {
			myCon = DriverManager.getConnection(connection, username, password);
			myCon.setAutoCommit(false);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	// This will check if the employee is able to login to the profiling system.
	public void employeeLogin(String user_name, String user_password) {
		setUser_name(user_name);
		setUser_password(user_password);
		try {
			myStmnt = myCon.prepareStatement("select * from employee where username = ? and password = ?");

			myStmnt.setString(1, getUser_name());
			myStmnt.setString(2, getUser_password());

			myrst = myStmnt.executeQuery();

			myCon.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Here is were the Employee Details will show up
	public void getResidentDetails(int resident_Id) {
		try {
			setResident_id(resident_Id);
			myStmnt = myCon.prepareStatement("select * from resident where deleted = 0 and resident_id = ?");

			myStmnt.setLong(1, getResident_id());

			myrst = myStmnt.executeQuery();

			myCon.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteResidentInformation(int resident_ID) {
		try {
			setResident_id(resident_ID);

			myStmnt = myCon.prepareStatement("UPDATE resident SET deleted = 1 where resident_id = ?");

			myStmnt.setLong(1, getResident_id());

			int deleted = myStmnt.executeUpdate();

			setResidentDeleted(deleted);

			myCon.commit();
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	// This will add new Resident to the database.
	public void addResidentdb(long randomId, String first_name, String last_name, String suffix, String middle_initial,
			long phoneNum, String address, String email_address, String status, String gender,
			String firstDoseManufacturerName, String firstDoseBatchNumber, String firstDoseVaccinationDate,
			String secondDoseManufacturerName, String secondDoseBatchNumber, String secondDoseVaccinationDate) {

		setResident_id(randomId);
		setFirst_name_Resident(first_name);
		setLast_name_Resident(last_name);
		setSuffix(suffix);
		setMiddle_initial_Resident(middle_initial);
		setPhone_number_Resident(phoneNum);
		setAddress_Resident(address);
		setEmail_address_Resident(email_address);
		setStatus_Resident(status);
		setGender_Resident(gender);
		setFirstDose_ManufacturerName(firstDoseManufacturerName);
		setFirstDose_BatchNumber(firstDoseBatchNumber);
		setFirstDose_VaccinationDate(firstDoseVaccinationDate);
		setSecondDose_ManufacturerName(secondDoseManufacturerName);
		setSecondDose_BatchNumber(secondDoseBatchNumber);
		setSecondDose_VaccinationDate(secondDoseVaccinationDate);

		try {

			myCon = DriverManager.getConnection(connection, username, password);

			myCon.setAutoCommit(false);

			myStmnt = myCon.prepareStatement("insert into resident "
					+ "(resident_id, first_name, middle_initial, last_name, suffix, phone_number, address, email_address, status, gender, 1stDose_manufacturerName, 1stDose_BatchNo, 1stDose_VaccinationDate, 2ndDose_ManufacturerName, 2ndDose_batchNo, 2ndDose_VaccinationDate)"
					+ " values " + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			myStmnt.setLong(1, getResident_id());
			myStmnt.setString(2, getFirst_name_Resident());
			myStmnt.setString(3, getMiddle_initial_Resident());
			myStmnt.setString(4, getLast_name_Resident());
			myStmnt.setString(5, getSuffix());
			myStmnt.setLong(6, getPhone_number_Resident());
			myStmnt.setString(7, getAddress_Resident());
			myStmnt.setString(8, getEmail_address_Resident());
			myStmnt.setString(9, getStatus_Resident());
			myStmnt.setString(10, getGender_Resident());
			myStmnt.setString(11, getFirstDoseManufacturerName());
			myStmnt.setString(12, getFirstDoseBatchNumber());
			myStmnt.setString(13, getFirstDose_VaccinationDate());
			myStmnt.setString(14, getSecondDoseManufacturerName());
			myStmnt.setString(15, getSecondDoseBatchNumber());
			myStmnt.setString(16, getSecondDoseVaccinationDate());

			int success = myStmnt.executeUpdate();

			setResidentAdded(success);

			myCon.commit();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	// This will Show the deleted information of the resident
	public void listOfDeletedResident() {
			try {

				myStmnt = myCon.prepareStatement("select * from resident where deleted = 1");

				myrst = myStmnt.executeQuery();

				myCon.commit();
			} catch (SQLException sql) {
				sql.getStackTrace();
			}
		}
	
	// This will Show the  Registered Resident 
	public void listOfResident() {
		try {
			myStmnt = myCon.prepareStatement("select * from resident where deleted = 0");
			
			myrst = myStmnt.executeQuery();
			
			myCon.commit();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}	
	
	// This will generate random numbers for the resident.
	public static ArrayList generateID(int size, int min, int max) {

		ArrayList numbers = new ArrayList();
		Random random = new Random();

		while (numbers.size() < size) {
			int randomNum = random.nextInt((max - min) + 1) + min;

			if (!numbers.contains(randomNum)) {
				numbers.add(randomNum);
			}
		}
		return numbers;
	}
	// This will Restore the Deleted Resident
	public void restoreDeletedResident(int residentID) {
		try {
			setResident_id(residentID);

			myStmnt = myCon.prepareStatement("UPDATE resident SET deleted = 0 where resident_id = ?");

			myStmnt.setLong(1, getResident_id());

			int restore = myStmnt.executeUpdate();

			setResidentRestored(restore);

			myCon.commit();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	// this will check if the date format inputted is correct or not. if not? it
	// will throw an Exception.
	public static Boolean CheckDate(String datecheck) {

		DateFormat format = new SimpleDateFormat("YYYY-MM-dd");
		Date date = null;
		format.setLenient(false);

		try {
			date = format.parse(datecheck);
			return true;

		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}
}
