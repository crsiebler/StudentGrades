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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author csiebler
 */
class StudentGradesPanel extends JPanel {

    // Define the Result strings that are reused often
    private static final String NEW_LINE = "\n";

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

        firstNameLabel.setLabelFor(firstNameField);
        lastNameLabel.setLabelFor(lastNameField);
        ssnLabel.setLabelFor(ssnField);
        classLabel.setLabelFor(classField);
        ssnLabel.setLabelFor(ssnField);
        gradeLabel.setLabelFor(gradeComboBox);
        
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
        
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(actionPanel, BorderLayout.SOUTH);
    }
    
    public class SaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    
    public class LoadListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    
}
