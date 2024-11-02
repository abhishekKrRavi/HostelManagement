import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.RoundRectangle2D;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {


    public void login(){
        JFrame jf = new JFrame("NITTE HOSTEL LEAVE MANAGER ");
        JLabel LoginID, password;
        LoginID = new JLabel("LOGIN ID");
        password = new JLabel("PASSWORD");
        LoginID.setBounds(20,10,100,30);
        jf.add(LoginID);

        password.setBounds(20,50,100,30);
        jf.add(password);

        JTextField id_text = new JTextField();
        id_text.setBounds(100,10,200,30);
        JPasswordField pwrd = new JPasswordField();
        pwrd.setBounds(100,50,200,30);
        jf.add(id_text);
        jf.add(pwrd);

        JButton submit = new JButton("SUBMIT");
        submit.setBounds(150,110,100,30);
        jf.add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String loginID = id_text.getText();
                String passwrd = pwrd.getText();
                if(loginID.equals("user") && passwrd.equals("illa") ){
                    Main nextPage = new Main();
                    nextPage.homeScreen();
                    jf.dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"WRONG LOGIN ID/PASSWORD");
                    id_text.setText("");
                    pwrd.setText("");
                }
            }
        });

        jf.getContentPane().setBackground( new Color(167, 197, 241));
        jf.setSize(400,200);
        jf.setLayout(null);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        //jf.setLocation(50,50);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void homeScreen(){
        JFrame frame = new JFrame("NITTE HOSTEL LEAVE MANAGER");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,400);
        frame.getContentPane().setBackground(new Color(167, 197, 241));
        frame.setLocationRelativeTo(null);

        JButton leave = new JButton("APPLY FOR LEAVE");
        JButton complaints = new JButton("COMPLAINTS");
        JButton announcements = new JButton("ANNOUNCEMENTS");
        JLabel collegeName = new JLabel("NITTE Hostels, NMIT College");
        JLabel collegeAddress = new JLabel("Yelahanka,Bangalore - 560064");
        Font clgNameFont = new Font("TimesNewRoman", Font.BOLD, 30);
        collegeName.setFont(clgNameFont);
        collegeAddress.setFont(new Font("TimesNewRoman",Font.ROMAN_BASELINE,20));
        collegeName.setHorizontalAlignment(SwingConstants.CENTER);
        collegeAddress.setHorizontalAlignment(SwingConstants.CENTER);
        collegeName.setBounds(280,10,420,100);
        collegeAddress.setBounds(280,50,420,100);

        leave.setBounds(60,180,250,60);
        complaints.setBounds(350,180,250,60);
        announcements.setBounds(650,180,250,60);

        leave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Main().leaveForm();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        complaints.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Main().complaintForm();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        frame.add(collegeName);
        frame.add(collegeAddress);
        frame.add(leave);
        frame.add(complaints);
        frame.add(announcements);


        frame.setLayout(null);
        frame.setVisible(true);
    }

    class LeaveDetails{
        String leaveType,fromdate,todate,reason,place,mode;
        LeaveDetails(){}
    }
    public void leaveForm() throws IOException {


        JFrame frame = new JFrame("NITTE HOSTEL LEAVE MANAGER");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500,600);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(167, 197, 241));



        JLabel leaveType = new JLabel("SELECT LEAVE TYPE");
        leaveType.setBounds(20,10,150,30);
//        String[] types = {"Outpass","Leave","Extended Leave"};
//        JComboBox<String> dropdown = new JComboBox<String>(types);
        JTextField dropdown = new JTextField();
        dropdown.setBounds(160,10,300,30);


//        String[] dates = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
//        String[] months = {"January","Feburary","March","April","June","July","August","September","October","November","December"};
//        String[] years = {"2023", "2024","2025"};

        JLabel from = new JLabel("From Date : ");
        from.setBounds(20,60,100,30);
//        JComboBox<String> fromDate = new JComboBox<String>(dates);
//        JComboBox<String> fromMonth = new JComboBox<>(months);
//        JComboBox<String> fromYear = new JComboBox<>(years);
        JTextField fromCalendar = new JTextField();
//        JTextField fromMonth = new JTextField();
//        JTextField fromYear = new JTextField();
//        JPanel fromCalendar = new JPanel();
//        fromCalendar.setLayout(new GridBagLayout());
//        GridBagConstraints fromConstraints = new GridBagConstraints();
//        fromConstraints.gridx = GridBagConstraints.RELATIVE;
//        fromConstraints.gridy = 1;
//        fromCalendar.add(fromDate,fromConstraints);
//        fromCalendar.add(fromMonth,fromConstraints);
//        fromCalendar.add(fromYear,fromConstraints);
        fromCalendar.setBounds(110,60,183,25);
//        fromDate.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JComboBox cb = (JComboBox)e.getSource();
//                list.get(i).fromdate = (String)cb.getSelectedItem();
//            }
//        });
//        fromMonth.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JComboBox cb = (JComboBox)e.getSource();
//                list.get(i).frommonth= (String)cb.getSelectedItem();
//            }
//        });
//        fromYear.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JComboBox cb = (JComboBox)e.getSource();
//                list.get(i).fromyear = (String)cb.getSelectedItem();
//            }
//        });

//
//        JComboBox<String> toDate = new JComboBox<String>(dates);
//        JComboBox<String> toMonth = new JComboBox<>(months);
//        JComboBox<String> toYear = new JComboBox<>(years);
        JTextField toCalendar = new JTextField();
//        JTextField toMonth = new JTextField();
//        JTextField toYear = new JTextField();
        JLabel to = new JLabel("To date : ");
//        JPanel toCalendar = new JPanel();
////        toCalendar.setLayout(new GridBagLayout());
////        GridBagConstraints toConstarints = new GridBagConstraints();
////        toConstarints.gridx = GridBagConstraints.RELATIVE;
////        toConstarints.gridy = 1;
//        toCalendar.add(toDate,toConstarints);
//        toCalendar.add(toMonth,toConstarints);
//        toCalendar.add(toYear,toConstarints);
        to.setBounds(20,100,100,30);
        toCalendar.setBounds(110,100,183,25);
//        toDate.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JComboBox cb = (JComboBox)e.getSource();
//                list.get(i).todate = (String)cb.getSelectedItem();
//            }
//        });
//        toMonth.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JComboBox cb = (JComboBox)e.getSource();
//                list.get(i).tomonth = (String)cb.getSelectedItem();
//            }
//        });
//        toYear.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JComboBox cb = (JComboBox)e.getSource();
//                list.get(i).toyear = (String)cb.getSelectedItem();
//            }
//        });
//
//        JComboBox<String> leaveReason = new JComboBox<>(new String[]{"Casual", "Outing","Semester Leave","Visiting Home Town","Meeting Local Guardian"});
        JTextField leaveReason = new JTextField();
        JLabel leaveReasonLabel = new JLabel("Select Leave Reason : ");
        leaveReasonLabel.setBounds(20,150,150,30);
        leaveReason.setBounds(160,150,280,30);
//        leaveReason.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JComboBox cb = (JComboBox)e.getSource();
//                list.get(i).reason = (String)cb.getSelectedItem();
//            }
//        });

        JLabel contactDetails = new JLabel("Parents Contact Details : ");
        JTextField parentsName = new JTextField("NARESH LAL RAVI");
        JTextField parentsMobNo = new JTextField("9798092934");
        parentsName.setEditable(false);
        parentsMobNo.setEditable(false);
        contactDetails.setBounds(20,190,150,30);
        parentsName.setBounds(20,230,200,30);
        parentsMobNo.setBounds(230,230,200,30);

        JLabel approverLabel = new JLabel("Note to the Approver : ");
        JLabel placeVisit = new JLabel("Place Of Visit : ");
        JTextField placeOfVisit = new JTextField();
        JLabel modeVisit = new JLabel("Mode Of Visit : ");
        JTextField modeOfVisit = new JTextField();
        approverLabel.setBounds(20,280,200,30);
        placeVisit.setBounds(20,320,100,30);
        placeOfVisit.setBounds(130,330,200,20);
        modeVisit.setBounds(20,350,100,30);
        modeOfVisit.setBounds(130,360,200,20);
//        list.get(i).place = placeOfVisit.getText();
//        list.get(i).mode = modeOfVisit.getText();

        JCheckBox termsAndConditions = new JCheckBox("I Accept all the Terms and Conditions .");
        termsAndConditions.setBounds(20,400,250,30);

        JButton apply = new JButton("APPLY");
        JButton refresh  = new JButton("REFRESH");
        apply.setBounds(100,470,100,30);
        refresh.setBounds(300,470,100,30);

//        apply.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                list.add(leaveRecord);
//
//            }
//        });
//


        frame.add(leaveType);
        frame.add(dropdown);
        frame.add(from);
        frame.add(fromCalendar);
        frame.add(to);
        frame.add(toCalendar);
        frame.add(leaveReasonLabel);
        frame.add(leaveReason);
        frame.add(contactDetails);
        frame.add(parentsName);
        frame.add(parentsMobNo);
        frame.add(approverLabel);
        frame.add(placeVisit);
        frame.add(placeOfVisit);
        frame.add(modeVisit);
        frame.add(modeOfVisit);
        frame.add(termsAndConditions);
        frame.add(apply);
        frame.add(refresh);

        frame.setLayout(null);
        frame.setVisible(true);

//
        File file = new File("C:\\Users\\User\\IdeaProjects\\HostelManagement\\Database.txt");
        BufferedWriter fw = new BufferedWriter(new FileWriter(file,true));
        fw.write("Leave Type\tFrom Date\tTo Date\tLeave Reason\tPlace Of visit\t\tMode Of visit\n");
        //fw.close();
        apply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //FileWriter fw1 = new FileWriter(file);
                    fw.write(dropdown.getText()+"\t\t"+fromCalendar.getText()+"\t\t"+toCalendar.getText()+"\t\t"+leaveReason.getText()+"\t\t"+placeOfVisit.getText()+"\t\t"+modeOfVisit.getText()+"\n");
                    fw.flush();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dropdown.setText("");
                fromCalendar.setText("");
                toCalendar.setText("");
                leaveReason.setText("");
                placeOfVisit.setText("");
                modeOfVisit.setText("");
            }
        });
    }
    public void complaintForm() throws IOException {

        JFrame frame = new JFrame("NITTE HOSTEL LEAVE MANAGER");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500,600);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(167, 197, 241));

//        JComboBox<String> category = new JComboBox<>(new String[]{"Maintenance","Housekeeping","Medical"});
        JTextField category = new JTextField();
        JLabel categoryLabel = new JLabel("Enter Category : ");
        categoryLabel.setBounds(20,20,100,30);
        category.setBounds(20,50,450,30);

//        JComboBox<String> subCategory = new JComboBox<>(new String[]{"Electrical","Plumbing","Food","Carpentry","Water","WiFi"});
        JTextField subCategory = new JTextField();
        JLabel subCategoryLabel = new JLabel("Enter Sub Category : ");
        subCategoryLabel.setBounds(20,80,150,30);
        subCategory.setBounds(20,110,450,30);

        JLabel urgency = new JLabel("Urgency");
        JCheckBox basic = new JCheckBox("BASIC");
        JCheckBox medium = new JCheckBox("MEDIUM");
        JCheckBox critical = new JCheckBox("CRITICAL");
        ButtonGroup urgencyGroup = new ButtonGroup();
        urgencyGroup.add(basic);
        urgencyGroup.add(medium);
        urgencyGroup.add(critical);
        JPanel urgencyCheckBox = new JPanel();
        urgencyCheckBox.setLayout(new GridBagLayout());
        GridBagConstraints urgencyConstraints = new GridBagConstraints();
        urgencyConstraints.gridx = GridBagConstraints.RELATIVE;
        urgencyConstraints.gridy = 1;
        urgencyCheckBox.add(basic,urgencyConstraints);
        urgencyCheckBox.add(medium,urgencyConstraints);
        urgencyCheckBox.add(critical,urgencyConstraints);
        urgency.setBounds(20,150,50,30);
        urgencyCheckBox.setBounds(100,150,250,30);


        JLabel description = new JLabel("Describe Your Complain : ");
        JTextField descriptionField = new JTextField();
        description.setBounds(20,180,200,30);
        descriptionField.setBounds(20,220,400,200);

        JButton submit = new JButton("SUBMIT");
        JButton refresh = new JButton("REFRESH");
        submit.setBounds(100,470,100,30);
        refresh.setBounds(300,470,100,30);


        frame.add(categoryLabel);
        frame.add(category);
        frame.add(subCategoryLabel);
        frame.add(subCategory);
        frame.add(urgency);
        frame.add(urgencyCheckBox);
        frame.add(description);
        frame.add(descriptionField);
        frame.add(submit);
        frame.add(refresh);

        frame.setLayout(null);
        frame.setVisible(true);
        File complains = new File("C:\\Users\\User\\IdeaProjects\\HostelManagement\\complains.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(complains));
        bw.write("Category\tSub - Category\t Description");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                    bw.write(category.getText()+"\t"+subCategory.getText()+"\t"+descriptionField.getText()+"\n");
                    bw.flush();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                category.setText("");
                subCategory.setText("");
                descriptionField.setText("");
            }
        });
    }
    public static void main(String[] args) {

        new Main().login();
    }
}