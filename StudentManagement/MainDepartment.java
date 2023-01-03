

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainDepartment extends JFrame implements ActionListener {
	private static MainDepartment _instance = null;

	public static MainDepartment getInstance(){
		if(_instance == null)
			_instance = new MainDepartment();

		return _instance;
	}

	
	// DB Connection variables

	// static Connection connection = null;
	static String databaseName = "alexfirstcompany";
	private static String url = "jdbc:mysql://localhost:3306/" + databaseName;

	private static String username = "root";
	private static String password = "Alex12142002";// Please change ! don't expose my sec ret! 
	private static String QUERY = "SELECT FirstName, LastName, Age, EmployeesID FROM alexfirstcompany.department";

	private static final String InsertDynamic = "INSERT INTO department"
			+ "(FirstName, LastName, Age, EmployeesID) VALUES " + " (?, ?, ?, ?);";

	private static final String InsertSecondTable = "INSERT INTO aledwdwxfirstcompany.users"
			+ "(UserID, UserName, Password) VALUES " + " (?, ?, ?);";

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);		
	}

	// Variables for frame
	private JFrame frame;
	private JPanel contentPane;
	private JTextField firstname;
    private JTextField lastname;
	private JTextField email;
    private JTextField usernameTextField;
	private JTextField mob;
    private JPasswordField passwordField;
    private JButton btnNewButton, btnBackButton;
	
	//BOOLEAN LOGIN
	public boolean login(UserInfo ui){
		try (Connection conn = getConnection()){
			String sql = "SELECT * FROM users WHERE UserName = '" + ui.getUserName() + "' AND Password = '" + ui.getPassword() + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			boolean flag = rs.next();
			conn.close();
			return flag;

		} catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	// Register User and save it into the database
	public void registerUser() {
		frame = new JFrame("User Register");
		frame.setBounds(450, 190, 1014, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

		// Label stuff
		JLabel lblNewUserRegister = new JLabel("New User Register");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 52, 325, 50);
        contentPane.add(lblNewUserRegister);

		JLabel lblFirstName = new JLabel("First name");
        lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblFirstName.setBounds(58, 152, 99, 43);
        contentPane.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last name");
        lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblLastName.setBounds(58, 243, 110, 29);
        contentPane.add(lblLastName);

		JLabel lblEmailAddress = new JLabel("Email\r\n address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(58, 324, 124, 36);
        contentPane.add(lblEmailAddress);

		firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(214, 151, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastname.setBounds(214, 235, 228, 50);
        contentPane.add(lastname);
        lastname.setColumns(10);

		email = new JTextField();

        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(214, 320, 228, 50);
        contentPane.add(email);
        email.setColumns(10);

        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        usernameTextField.setBounds(707, 151, 228, 50);
        contentPane.add(usernameTextField);
        usernameTextField.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(542, 159, 99, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(542, 245, 99, 24);
        contentPane.add(lblPassword);

        JLabel lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(542, 329, 139, 26);
        contentPane.add(lblMobileNumber);

		mob = new JTextField();
        mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
        mob.setBounds(707, 320, 228, 50);
        contentPane.add(mob);
        mob.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(707, 235, 228, 50);
        contentPane.add(passwordField);

		// Register button
		btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String firstName = firstname.getText();
			String lastName = lastname.getText();
			String emailId = email.getText();
			String userNameTex = usernameTextField.getText();
			String mobileNumber = mob.getText();
			int len = mobileNumber.length();
			String password = passwordField.getText();

			String msg = "" + firstName;
            msg += " \n";
			if (len != 10) {
				JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
			}
			//connection
			try (Connection conn = getConnection()){
				String query = "INSERT INTO account values('" + firstName + "','" + lastName + "','" + userNameTex + "','" +
				password + "','" + emailId + "','" + mobileNumber + "')";

				PreparedStatement ps = conn.prepareStatement(query);
				System.out.println(ps);

				Statement sta = conn.createStatement();
                int x = sta.executeUpdate(query);

				if (x == 0) {
					JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
				} else {
					JOptionPane.showMessageDialog(btnNewButton,
						"Welcome, " + msg + "Your account is sucessfully created");
				}

				//Working
				UserInfo u = new UserInfo(userNameTex, password);

				String query2 = "INSERT INTO users('" + userNameTex + "','" + password + "')" +  " SELECT " + u.getUserName() + "','" + u.getPassword() + " FROM account";  
				sta.executeUpdate(query2);

				conn.close(); 

				
				Login back = new Login();
				back.welcomePage();
				back.UserLogin();


			}catch (Exception e){
				e.printStackTrace();
			}

		}
	});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(200, 447, 259, 74);
		contentPane.add(btnNewButton);

		//Back button
		btnBackButton = new JButton("Back");
		btnBackButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
            	Login back = new Login();
            	back.welcomePage();
            	back.UserLogin();
			}

		});

		btnBackButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnBackButton.setBounds(550, 447, 259, 74); 
		contentPane.add(btnBackButton);

		frame.add(contentPane);
		frame.setVisible(true);
		
	}

	public boolean insertGradeKeeper(String fn, String ln, int cls, int grade, String stdid) throws SQLException {

		String insert = "INSERT INTO gradekeeper(FirstName, LastName, class, FinalGrade, StudentID) VALUES(?, ?, ?, ?, ?)";

		// 1. Open the connection
		try (Connection conn = getConnection();) {

			// 2. Create a prepstatement using connection object
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setInt(3, cls);
			ps.setInt(4, grade);
			ps.setString(5, stdid);

			int status = ps.executeUpdate();

			conn.close();

			if (status != 0) {
				
				System.out.println("INSERTED SUCESSFULLY!");
				return true;
			}

			// For sure, after using we have to close the connection explicitly! what if we
							// dont close?
			// The number of connections will be reached to max #
			// at that time, no one can make more connection to database server!

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return false;
	}

	public boolean deleteGradeKeeper(String stdid) {

		String delete = "DELETE FROM gradekeeper WHERE StudentID = ?";

		// 1. Open the connection
		try (Connection conn = getConnection();) {

			// 2. Create a prepstatement using connection object
			PreparedStatement ps = conn.prepareStatement(delete);
			
			ps.setString(1, stdid);

			int status = ps.executeUpdate();

			conn.close();

			if (status != 0) {

				System.out.println("DELETE SUCESSFULLY!");
				return true;
			}

			// For sure, after using we have to close the connection explicitly! what if we
			// dont close?
			// The number of connections will be reached to max #
			// at that time, no one can make more connection to database server!

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public void loadAllGradeKeepers(DefaultTableModel model){
		try{
			if(model.getRowCount() > 0){
				for(int i = model.getRowCount() - 1; i > -1; i--){
					model.removeRow(i);
				}
			}

			String query = "SELECT * FROM gradekeeper";
			Object[] row = new Object[5];

			// connection
			Connection conn = getConnection();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(query);

			while(rs.next()){
				
				System.out.print(rs.getString(1)); 
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t" + rs.getInt(3));
				System.out.print("\t" + rs.getInt(4));
				System.out.println("\t" + rs.getString(5));

				row[0] =  rs.getString(1);
				row[1] =  rs.getString(2);
				row[2] =  rs.getInt(3);
				row[3] = rs.getInt(4);
				row[4] = rs.getString("StudentID");

				model.addRow(row);
			}

			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public boolean IsExistingStudentID(String stuID) {
		String query = "SELECT * FROM gradekeeper WHERE StudentID = ? ";
		try (Connection conn = getConnection();){
			
			// connection
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, stuID);

			ResultSet rs = ps.executeQuery();
			boolean flag = rs.next();	

			conn.close();
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

		

	}

	//UPDATE FIRST NAME
	public void updateAgeByFirstLastName(DepartmentInfo di) {
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement();) {
			String sql = "UPDATE alexfirstcompany.department " + "SET age = " + di.getAge() + " WHERE FirstName = '"
					+ di.getFirstName() + "' and LastName = '" + di.getLastName() + "';";
			stmt.executeUpdate(sql);

			// fix
			/*
			 * ResultSet rs = stmt.executeQuery(QUERY);
			 * 
			 * while (rs.next()) { // Display values System.out.print("FirstName:" +
			 * rs.getString("FirstName")); System.out.print(", LastName: " +
			 * rs.getString("LastName")); System.out.print(", Age: " + rs.getInt("Age"));
			 * System.out.println(", EmployeesID: " + rs.getInt("EmployeesID")); }
			 */

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//UPDATE AGE EMPLOYEES
	public void updateAgeByEmployeeID(DepartmentInfo di) {
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement();) {
			String sql = "UPDATE alexfirstcompany.department " + "SET age = " + di.getAge() + " WHERE EmployeesID = "
					+ di.getEmployeesID();
			stmt.executeUpdate(sql);

			ResultSet rs = stmt.executeQuery(QUERY);

			while (rs.next()) { // Display values
				System.out.print("FirstName:" + rs.getString("FirstName"));
				System.out.print(", LastName: " + rs.getString("LastName"));
				System.out.print(", Age: " + rs.getInt("Age"));
				System.out.println(", EmployeesID: " + rs.getInt("EmployeesID"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		
		// create file object for current folder
		File file = new File("");
		String currentPath = file.getAbsolutePath();
		System.out.println("Current path is:: " + currentPath);
		
		long start = System.nanoTime();
		Login myFrame = new Login();
		myFrame.welcomePage();
		myFrame.UserLogin();
		//new temp();

		// MainPage main = new MainPage();
		// main.MangagePage();


		long duration = (System.nanoTime() - start)/1000000;
		System.out.println(duration + "ms");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
