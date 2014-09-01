//  Assignment 1, Student Grades
//  Name: Cory Siebler
//  StudentID: 1000832292
//  Lecture Topic: CSE 494 @ 7:30 MW
//  Description: (Description of each file/class)
package studentgrades;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import studentgrades.Student.Grade;

/**
 *
 * @author csiebler
 */
class StudentGradesPanel extends JPanel {

    // Define the Result strings that are reused often
    private static final String NEW_LINE = "\n";
    private static final String FILENAME = "grades.ser";
    private static final String EMPTY = "";
    private static final String SUCCESS = "Student grade serialized successfully";
    
    // Declare a List to hold the Student's grade in memory
    private final List<Student> students;

    // Declare the GUI components
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel ssnLabel;
    private JLabel classLabel;
    private JLabel gradeLabel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JPasswordField ssnField;
    private JTextField classField;
    private JComboBox gradeComboBox;
    private JTextArea resultsArea;
    private JScrollPane scrollPane;
    private JButton loadButton;
    private JButton saveButton;
    
    /**
     * Constructor
     */
    public StudentGradesPanel() {
        initComponents();
        
        // Initialize the List
        students = new ArrayList<>();
        
        // Load the Students from the file
        loadButton.doClick();
    }

    /**
     * Initialize the Components for the GUI.
     */
    private void initComponents() {
        // Initialize the components
        firstNameLabel = new JLabel("First Name:");
        lastNameLabel = new JLabel("Last Name:");
        ssnLabel = new JLabel("SSN:");
        classLabel = new JLabel("Class:");
        gradeLabel = new JLabel("Grade:");
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        ssnField = new JPasswordField();
        classField = new JTextField();
        gradeComboBox = new JComboBox();
        resultsArea = new JTextArea(20, 50);
        scrollPane = new JScrollPane(resultsArea);
        loadButton = new JButton("Load");
        saveButton = new JButton("Save");
        
        // Initialize panels for GUI styling
        JPanel inputPanel = new JPanel();
        JPanel actionPanel = new JPanel();
        
        // Do not allow the user to edit the text area
        resultsArea.setEditable(false);
        
        // Show a scroll bar for the text area when needed
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Define the label-field relationship
        firstNameLabel.setLabelFor(firstNameField);
        lastNameLabel.setLabelFor(lastNameField);
        ssnLabel.setLabelFor(ssnField);
        classLabel.setLabelFor(classField);
        ssnLabel.setLabelFor(ssnField);
        gradeLabel.setLabelFor(gradeComboBox);
        
        // Add the Grades to the Combo Box
        gradeComboBox.addItem(Grade.A_PLUS);
        gradeComboBox.addItem(Grade.A);
        gradeComboBox.addItem(Grade.A_MINUS);
        gradeComboBox.addItem(Grade.B_PLUS);
        gradeComboBox.addItem(Grade.B);
        gradeComboBox.addItem(Grade.B_MINUS);
        gradeComboBox.addItem(Grade.C_PLUS);
        gradeComboBox.addItem(Grade.C);
        gradeComboBox.addItem(Grade.C_MINUS);
        gradeComboBox.addItem(Grade.D_PLUS);
        gradeComboBox.addItem(Grade.D);
        gradeComboBox.addItem(Grade.D_MINUS);
        gradeComboBox.addItem(Grade.F);
        
        // Add listeners to the buttons
        saveButton.addActionListener(new SaveListener());
        loadButton.addActionListener(new LoadListener());
        
        // Set the layout for the panels
        inputPanel.setLayout(new SpringLayout());
        actionPanel.setLayout(new GridLayout(1, 2));
        setLayout(new BorderLayout());

        // Add the components to the subpanels
        inputPanel.add(firstNameLabel);
        inputPanel.add(firstNameField);
        inputPanel.add(lastNameLabel);
        inputPanel.add(lastNameField);
        inputPanel.add(ssnLabel);
        inputPanel.add(ssnField);
        inputPanel.add(classLabel);
        inputPanel.add(classField);
        inputPanel.add(gradeLabel);
        inputPanel.add(gradeComboBox);
        actionPanel.add(loadButton);
        actionPanel.add(saveButton);
        
        // Use the Java provided layout on the input panel
        SpringUtilities.makeCompactGrid(inputPanel,
                5, 2, // Rows x Cols
                5, 5, 5, 5 // Padding
        );
        
        // Add the subpanels to the main panel
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(actionPanel, BorderLayout.SOUTH);
    }
    
    public class SaveListener implements ActionListener {

        /**
         * 
         * @param e 
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Clear the results
            resultsArea.setText(EMPTY);

            // Validate the user input
            if (validInput()) {
                // Serialize the Student class to a file
                try (
                        OutputStream file = new FileOutputStream(FILENAME);
                        OutputStream buffer = new BufferedOutputStream(file);
                        ObjectOutput output = new ObjectOutputStream(buffer);) {
                    // Initialize a new Student from the user information
                    Student student = new Student(
                            firstNameField.getText().trim(),
                            lastNameField.getText().trim(),
                            String.valueOf(ssnField.getPassword()).trim(),
                            classField.getText().trim(),
                            (Grade) gradeComboBox.getSelectedItem()
                    );
                    
                    // Add the student to the list in memory
                    students.add(student);
                    
                    // Loop through all the students and add them to the file
                    for (Student s : students) {
                        // Serialize the Student
                        output.writeObject(s);
                    }
                    
                    // Display success confirmation
                    resultsArea.setText(SUCCESS);
                    
                    // Remove an user input
                    clearInputs();
                } catch (IOException ex) {
                    resultsArea.setText("ERROR: Could not serialize input." + NEW_LINE
                            + "Message: " + ex.getMessage());
                }
            } else {
                resultsArea.setText("Please insert valid information");
            }
        }

        /**
         * Checks all the text fields to make sure the user inputted valid
         * information.
         * 
         * @return True if the input is valid, false if not valid
         */
        private boolean validInput() {
            return !firstNameField.getText().isEmpty()
                    && !lastNameField.getText().isEmpty()
                    && ssnField.getPassword().length != 0
                    && !classField.getText().isEmpty()
                    && gradeComboBox.getSelectedIndex() >= 0;
        }

        /**
         * Remove the user input from the text fields.
         */
        private void clearInputs() {
            firstNameField.setText(EMPTY);
            lastNameField.setText(EMPTY);
            ssnField.setText(EMPTY);
            classField.setText(EMPTY);
            gradeComboBox.setSelectedIndex(0);
        }
        
    }
    
    /**
     * 
     */
    public class LoadListener implements ActionListener {

        /**
         * 
         * @param e 
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Clear the results
            resultsArea.setText(EMPTY);
            
            // Remove any Students previously in memory
            students.clear();
            
            // Open an Object Stream from the file
            try (
                    InputStream file = new FileInputStream(FILENAME);
                    InputStream buffer = new BufferedInputStream(file);
                    ObjectInput input = new ObjectInputStream(buffer);) {
                // Deserialize the Student Grades
                while (true) {
                    // Read the object from the file
                    Student student = (Student) input.readObject();
                    
                    // Add the loaded Object into the List and Print
                    students.add(student);
                    printStudent(student);
                }
            } catch (EOFException ex) {
                // Reached the EOF as expected
            } catch (ClassNotFoundException ex) {
                resultsArea.setText("WARNING: Cannot perform input. Class not found.");
            } catch (IOException ex) {
                resultsArea.setText("WARNING: Cannot loan file");
            }
        }

        /**
         * Display the deserialized Student object to the text area.
         * 
         * @param student Deserialized Student Object
         */
        private void printStudent(Student student) {
            resultsArea.append(student + NEW_LINE);
        }
        
    }
    
}
