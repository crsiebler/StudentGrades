//  Assignment 1, Student Grades
//  Name: Cory Siebler
//  StudentID: 1000832292
//  Lecture Topic: CSE 494 @ 7:30 MW
//  Description: (Description of each file/class)
package studentgrades;

import javax.swing.JFrame;

/**
 *
 * @author csiebler
 */
public class StudentGrades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            // Initialize JFrame & Dimensions
            JFrame frame = new JFrame("CSE 494 - File Scanner");

            // Set Default Dimension, Close Operation, Bounds, and Resizable
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Initialize the Panel to perform file searching
            StudentGradesPanel studentGradesPanel = new StudentGradesPanel();

            // Add the panel and set the frame size & visibility
            frame.add(studentGradesPanel);
            frame.pack();
            frame.setVisible(true);
        });
    }
    
}
