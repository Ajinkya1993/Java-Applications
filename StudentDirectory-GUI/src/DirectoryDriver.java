import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javax.swing.JTextArea;

/**
 * class to create the swing ui for the directory.
 * @author Ajinkya Nimbalkar
 *
 */
public class DirectoryDriver {

    /**
     * frame for the ui.
     */
    private JFrame frame;
    /**
     * text field for last name.
     */
    private JTextField txtLastName;
    /**
     * text field for first name.
     */
    private JTextField txtFirstname;
    /**
     * text field for Andrew ID.
     */
    private JTextField txtAndrewIdadd;
    /**
     * text field for Phone number.
     */
    private JTextField txtPhoneNumber;
    /**
     * text field for andrew id to be deleted.
     */
    private JTextField txtAndrewIDdel;
    /**
     * text field for searching by.
     */
    private JTextField txtSearchK;
    /**
     * text area to display the results.
     */
    private JTextArea txtResults;
    /**
     * Directory for storing the student info.
     */
    private Directory dir;

    /**
     * Launch the application.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Directory dir = new Directory();
        if (args.length == 1) {
            String csvfile = args[0];
            BufferedReader br = null;
            String line = "";
            String splitby = ",";
            int count = 0;
            try {
                br = new BufferedReader(new FileReader(csvfile));
                while ((line = br.readLine()) != null) {
                    if (count == 0) {
                        count = count + 1;
                        continue;
                    }
                    String line1 = line.replaceAll("\"", "");
                    String line2 = line1.replaceAll("\"", "");
                    System.out.println(line2);
                    String[] studentinfo = line2.split(splitby);
                    Student s = new Student(studentinfo[2]);
                    s.setFirstName(studentinfo[0]);
                    s.setLastName(studentinfo[1]);
                    s.setPhoneNumber(studentinfo[3]);
                    dir.addStudent(s);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DirectoryDriver window = new DirectoryDriver(dir);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     * @param d directory of students
     */
    public DirectoryDriver(Directory d) {
        dir = d;
        initialize();
    }
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 7));
        frame.setBounds(100, 100, 738, 487);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        txtLastName = new JTextField();
        txtLastName.setBounds(261, 25, 86, 20);
        frame.getContentPane().add(txtLastName);
        txtLastName.setColumns(10);
        txtFirstname = new JTextField();
        txtFirstname.setBounds(99, 25, 86, 20);
        frame.getContentPane().add(txtFirstname);
        txtFirstname.setColumns(10);
        txtAndrewIdadd = new JTextField();
        txtAndrewIdadd.setBounds(423, 25, 86, 20);
        frame.getContentPane().add(txtAndrewIdadd);
        txtAndrewIdadd.setColumns(10);
        txtPhoneNumber = new JTextField();
        txtPhoneNumber.setBounds(608, 25, 86, 20);
        frame.getContentPane().add(txtPhoneNumber);
        txtPhoneNumber.setColumns(10);
        JLabel lblFirstName = new JLabel("First name:");
        lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblFirstName.setBounds(33, 28, 56, 14);
        frame.getContentPane().add(lblFirstName);
        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblLastName.setBounds(195, 28, 56, 14);
        frame.getContentPane().add(lblLastName);
        JLabel lblAndrewIdadd = new JLabel("Andrew ID:");
        lblAndrewIdadd.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblAndrewIdadd.setBounds(357, 28, 56, 14);
        frame.getContentPane().add(lblAndrewIdadd);
        JLabel lblPhoneNumber = new JLabel("Phone Number:");
        lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblPhoneNumber.setBounds(519, 28, 79, 14);
        frame.getContentPane().add(lblPhoneNumber);
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student s;
                try {
                    txtResults.setText("");
                    String[] fields = new String[4];
                    fields[0] = txtFirstname.getText();
                    fields[1] = txtLastName.getText();
                    fields[2] = txtAndrewIdadd.getText();
                    fields[3] = txtPhoneNumber.getText();
                    if (!(fields[2].equals(""))) {
                        s = new Student(fields[2]);
                    } else {
                        txtResults.setText("Error: Andrew ID missing");
                        return;
                    }
                    if (!(fields[0].equals(""))) {
                        s.setFirstName(fields[0]);
                    } else {
                        txtResults.setText("Error: First Name missing");
                        return;
                    }
                    if (!(fields[1].equals(""))) {
                        s.setLastName(fields[1]);
                    } else {
                        txtResults.setText("Error: Last Name missing");
                        return;
                    }
                    if (!(fields[3].equals(""))) {
                        s.setPhoneNumber(fields[3]);
                    }
                    txtFirstname.setText("");
                    txtLastName.setText("");
                    txtAndrewIdadd.setText("");
                    txtPhoneNumber.setText("");
                    txtResults.setText("A new entry waas added");
                    dir.addStudent(s);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid andrewId");
                }
            }
        });
        btnAdd.setBounds(33, 62, 89, 23);
        frame.getContentPane().add(btnAdd);
        JLabel lblAdd = new JLabel("Add a new student");
        lblAdd.setFont(new Font("Tahoma", Font.BOLD, 9));
        lblAdd.setBounds(33, 1, 106, 14);
        frame.getContentPane().add(lblAdd);
        JLabel lblAndrewIDdel = new JLabel("Andrew ID:");
        lblAndrewIDdel.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblAndrewIDdel.setBounds(33, 135, 56, 14);
        frame.getContentPane().add(lblAndrewIDdel);
        txtAndrewIDdel = new JTextField();
        txtAndrewIDdel.setBounds(99, 132, 86, 20);
        frame.getContentPane().add(txtAndrewIDdel);
        txtAndrewIDdel.setColumns(10);
        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String andrewid;
                try {
                    txtResults.setText("");
                    andrewid = txtAndrewIDdel.getText();
                    if (andrewid.equals("")) {
                        txtResults.setText("Error: Andrew ID missing");
                        return;
                    }
                    txtAndrewIDdel.setText("");
                    Student s = dir.searchByAndrewId(andrewid);
                    if (s != null) {
                        txtResults.setText("Deleted the following entry:");
                        txtResults.setText(txtResults.getText() + "\n" + s.toString());
                        dir.deleteStudent(andrewid);
                    } else {
                        txtResults.setText("No entry for the Andrew ID: " + andrewid);
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid andrewId");
                }
            }
        });
        btnDelete.setBounds(33, 172, 89, 23);
        frame.getContentPane().add(btnDelete);
        JLabel lblDeleteAStudent = new JLabel("Delete a student");
        lblDeleteAStudent.setFont(new Font("Tahoma", Font.BOLD, 9));
        lblDeleteAStudent.setBounds(33, 103, 86, 14);
        frame.getContentPane().add(lblDeleteAStudent);
        JLabel lblSearchStudent = new JLabel("Search Student(s)");
        lblSearchStudent.setFont(new Font("Tahoma", Font.BOLD, 9));
        lblSearchStudent.setBounds(33, 210, 106, 14);
        frame.getContentPane().add(lblSearchStudent);
        JLabel lblSearchKey = new JLabel("Search Key:");
        lblSearchKey.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblSearchKey.setBounds(33, 235, 67, 14);
        frame.getContentPane().add(lblSearchKey);
        txtSearchK = new JTextField();
        txtSearchK.setBounds(99, 232, 86, 20);
        frame.getContentPane().add(txtSearchK);
        txtSearchK.setColumns(10);
        JButton btnByAndrew = new JButton("By Andrew ID");
        btnByAndrew.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnByAndrew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String andrewid;
                try {
                    txtResults.setText("");
                    andrewid = txtSearchK.getText();
                    if (andrewid.equals("")) {
                        txtResults.setText("Error: Andrew ID missing");                        
                        return;
                    }
                    txtSearchK.setText("");
                    Student s = dir.searchByAndrewId(andrewid);
                    if (s == null) {
                        txtResults.setText("No entries for the following andrew ID: " + andrewid);
                    } else {
                        txtResults.setText(s.toString());
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid andrewId");
                }
            }
        });
        btnByAndrew.setBounds(261, 231, 106, 23);
        frame.getContentPane().add(btnByAndrew);
        JButton btnByFirstName = new JButton("By First Name");
        btnByFirstName.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnByFirstName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String firstname;
                try {
                    txtResults.setText("");
                    firstname = txtSearchK.getText();
                    if (firstname.equals("")) {
                        txtResults.setText("Error: First Name missing");
                        return;
                    }
                    txtSearchK.setText("");
                    List<Student> slist = dir.searchByFirstName(firstname);
                    if (slist.size() == 0) {
                        txtResults.setText("No entries for the following first name: " + firstname);
                    } else {
                        int size = slist.size();
                        for (int i = 0; i < size; i++) {
                            Student s = slist.get(i);
                            txtResults.setText(s.toString() + "\n" + txtResults.getText());
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid first name");
                }
            }
        });
        btnByFirstName.setBounds(391, 231, 106, 23);
        frame.getContentPane().add(btnByFirstName);
        JButton btnByLastName = new JButton("By Last Name");
        btnByLastName.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnByLastName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String lastname;
                try {
                    txtResults.setText("");
                    lastname = txtSearchK.getText();
                    if (lastname.equals("")) {
                        txtResults.setText("Error: Last Name missing");
                        return;
                    }
                    txtSearchK.setText("");
                    List<Student> slist = dir.searchByLastName(lastname);
                    if (slist.size() == 0) {
                        txtResults.setText("No entries for the following last name: " + lastname);
                    } else {
                        int size = slist.size();
                        for (int i = 0; i < size; i++) {
                            Student s = slist.get(i);
                            txtResults.setText(s.toString() + "\n" +  txtResults.getText());
                        }
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid last name");
                }
            }
        });
        /**
         * sets the enter key to activate the search ID button.
         */
        frame.getRootPane().setDefaultButton(btnByAndrew);
        btnByLastName.setBounds(519, 231, 106, 23);
        frame.getContentPane().add(btnByLastName);
        JLabel lblResults = new JLabel("Results");
        lblResults.setFont(new Font("Tahoma", Font.BOLD, 9));
        lblResults.setBounds(33, 268, 46, 14);
        frame.getContentPane().add(lblResults);
        txtResults = new JTextArea();
        txtResults.setBounds(33, 293, 663, 144);
        frame.getContentPane().add(txtResults);
        txtResults.setColumns(10);
    }
}
