//  Assignment 1, Student Grades
//  Name: Cory Siebler
//  StudentID: 1000832292
//  Lecture Topic: CSE 494 @ 7:30 MW
//  Description: Loader class for the Student Grades program. This creates the
//              Frame and the Panel to interface with the user. Makes sure that
//              the initialize setup of the GUI is thread safe.
package studentgrades;

import javax.swing.JFrame;

/**
 * Loader class for the Student Grades program. This creates the Frame and the
 * Panel to interface with the user. Makes sure that the initialize setup of the
 * GUI is thread safe.
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
            JFrame frame = new JFrame("CSE 494 - Student Grades");

            // Set Default Dimension, Close Operation, Bounds, and Resizable
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Initialize the Panel to perform file serialization
            StudentGradesPanel studentGradesPanel = new StudentGradesPanel();

            // Add the panel and set the frame size & visibility
            frame.add(studentGradesPanel);
            frame.pack();
            frame.setVisible(true);
        });
    }
    
}
