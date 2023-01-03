

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.NumberFormatter;


public class MainPage implements ActionListener {
    
    final static Font mainFont2 = new Font("Tahoma", Font.PLAIN, 19);
    Object[] row;

    JLabel lblFirstName, lblLastName, lblClass, lblFinalGrade, lblStudentID;
    JButton btnAdd, btnDelete;
    JMenuBar menuBar;
    JMenu fileMenu, editMenu, helpMenu;
    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem exitItem;
    JFrame frame;
    JTable table;
    //final private Font mainFront = new Font("Segoe print", Font.BOLD, 20);
    //private static final String Font = null;

    private static JTextField textStudentID, textFirstName, textLastName;
    JFormattedTextField textGrade, textFinalGrade;
    public static void main(String[] args){
        //MangagePage();
    }


    public void MangagePage(){
        frame = new JFrame("Student Management");
        frame.setBounds(100,100,467,315);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Log Out");

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        loadItem.setMnemonic(KeyEvent.VK_L);
        saveItem.setMnemonic(KeyEvent.VK_S);
        exitItem.setMnemonic(KeyEvent.VK_L);
        
        // exitMenu.addActionListener(new ActionListener(){

        // @Override
        // public void actionPerformed(ActionEvent e) {
        //     // TODO Auto-generated method stub
        //     frame.setVisible(false);
        //     GUI_Department back = new GUI_Department();
        //     back.welcomePage();
        //     back.UserLogin();
        // }

        // });

        //Create a table 
        table = new JTable();
        Object[] cols = {"First Name", "Last Name", "Class", "Final Grade", "Student ID"};
        DefaultTableModel model = new DefaultTableModel();
        frame.getContentPane().setBackground(new Color(0, 0, 0));                
        frame.getContentPane().setForeground(Color.WHITE);
        frame.setBounds(100, 100, 630, 660);//720
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        model.setColumnIdentifiers(cols);
        table.setModel(model);
        

        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(Color.RED);
        table.setGridColor(Color.RED);
        table.setSelectionForeground(Color.WHITE);
        table.setFont(new Font("Tahoma", Font.PLAIN,17));
        table.setRowHeight(30); 
        table.setAutoCreateRowSorter(true);

        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.WHITE);
        pane.setBounds(10,10,593,354);
        frame.getContentPane().add(pane);

        // Student ID, Text First, Last Name, grade = class, final grade
        textFirstName = new JTextField();
        textFirstName.setBounds(121, 374, 184, 35);
        textFirstName.setBackground(Color.WHITE);
        frame.getContentPane().add(textFirstName);
        textFirstName.setColumns(10);

        // (121, 418, 184, 35);
        textLastName = new JTextField();
        textLastName.setBounds(432, 374, 171, 35);
        frame.getContentPane().add(textLastName);
        textLastName.setColumns(10);

        textGrade = new JFormattedTextField(NumberFormat.getNumberInstance());
        textGrade.setBounds(121, 418, 184, 35);
        frame.getContentPane().add(textGrade);
        textGrade.setColumns(10);

        textFinalGrade = new JFormattedTextField(NumberFormat.getNumberInstance());
        textFinalGrade.setBounds(432, 418, 171, 35);
        frame.getContentPane().add(textFinalGrade);
        textFinalGrade.setColumns(10);

        textStudentID = new JTextField();
        textStudentID.setBounds(121, 462, 184, 35);
        textStudentID.setBackground(Color.WHITE);
        frame.getContentPane().add(textStudentID);
        textStudentID.setColumns(10);

        //DO Label
        lblFirstName = new JLabel("First Name");
        lblFirstName.setFont(mainFont2);
        lblFirstName.setForeground(Color.WHITE);
        lblFirstName.setBounds(10, 385, 103, 20);
        frame.getContentPane().add(lblFirstName);

        lblLastName = new JLabel("Last Name");
        lblLastName.setFont(mainFont2);
        lblLastName.setForeground(Color.WHITE);
        lblLastName.setBounds(326, 385, 103, 20);
        frame.getContentPane().add(lblLastName);

        // (10, 429, 103, 20);
        lblClass = new JLabel("Class");
        lblClass.setFont(mainFont2);
        lblClass.setForeground(Color.WHITE);
        lblClass.setBounds(10, 429, 103, 20);
        frame.getContentPane().add(lblClass);

        lblFinalGrade = new JLabel("Final Grade");
        lblFinalGrade.setFont(mainFont2);
        lblFinalGrade.setForeground(Color.WHITE);
        lblFinalGrade.setBounds(326, 429, 103, 20);
        frame.getContentPane().add(lblFinalGrade);

        lblStudentID = new JLabel("Student ID");
        lblStudentID.setFont(mainFont2);
        lblStudentID.setForeground(Color.WHITE);
        lblStudentID.setBounds(10, 473, 103, 20);
        frame.getContentPane().add(lblStudentID);
        // ROW
        row = new Object[5];


        //Buttons ADD
        btnAdd = new JButton("ADD");
        btnAdd.setBounds(10, 507, 295, 35);
        frame.getContentPane().add(btnAdd);
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){

                MainDepartment department = new MainDepartment();
                
                //Validate input data
                if(textFirstName.getText().isEmpty() || textLastName.getText().isEmpty() || textGrade.getText().isEmpty() || textFinalGrade.getText().isEmpty() || textStudentID.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "All information required!");
                    return;
                }
                if(department.IsExistingStudentID(textStudentID.getText().trim())){
                    JOptionPane.showMessageDialog(frame, "Duplicated student ID!");
                    return;
                }

                row[0] = textFirstName.getText();
                row[1] = textLastName.getText();
                row[2] = textGrade.getText().trim();
                row[3] = textFinalGrade.getText().trim();
                row[4] = textStudentID.getText().trim();

                try{
                if (department.insertGradeKeeper((String) row[0], (String) row[1], Integer.parseInt((String)row[2]), Integer.parseInt((String)row[3]), (String) row[4])) {
                    model.addRow(row);
                    JOptionPane.showMessageDialog(frame, "Inserted Sucessfully!");
                }else{
                    //JOptionPane.showMessageDialog("error");

                    System.out.println("error");
                }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(frame, e.getMessage());

                    

                }
            }
        });

        //Buttons DELETE
        btnDelete = new JButton("DELETE");
        btnDelete.setBounds(313, 507, 290, 35);
        frame.getContentPane().add(btnDelete);
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                MainDepartment department = new MainDepartment();

                int i = table.getSelectedRow();
                if(i >= 0){
                    System.out.println(i);
                    System.out.println(table.getValueAt(i, 4));
                    if(department.deleteGradeKeeper((String) table.getValueAt(i, 4))){
                        model.removeRow(i);
                        JOptionPane.showMessageDialog(frame, "Deleted Sucessfully!");
                    }else{
                        JOptionPane.showMessageDialog(frame, "Deleted Error!");                       

                    }
                    
                }else{
                    JOptionPane.showMessageDialog(frame, "Delete Error!");
                }
            }
        });

        frame.revalidate();
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == loadItem){
            System.out.println("Loading.... 99%");
            loadData();
        }
        if(e.getSource() == saveItem){
            System.out.println("Saving.... 99%");
        }
        if(e.getSource() == exitItem){
            frame.setVisible(false);
            Login back = new Login();
            back.welcomePage();
            back.UserLogin();
        }
    }

    private void loadData(){
        DefaultTableModel m = (DefaultTableModel)table.getModel();

        // for(int i = 0; i < 10; i++){
        //     row[0] = "First" + i;
        //     row[1] = "Last" + i;
        //     row[2] = 5;
        //     row[3] = 100;
                    
        //     m.addRow(row);
        // }

        MainDepartment department = new MainDepartment();
        department.loadAllGradeKeepers(m);
    }
}

       
    // JLabel lblWindow = new JLabel("WINDOW 2");
    // lblWindow.setFont(mainFront);
    // lblWindow.setBounds(173, 92, 181, 74);
    // frame.getContentPane().add(lblWindow);

    // JButton btnBack = new JButton("BACK");
    // btnBack.setBounds(8,10,110,36);
    // frame.getContentPane().add(btnBack);
    // btnBack.addActionListener(new ActionListener()
