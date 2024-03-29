//  Assignment 1, Student Grades
//  Name: Cory Siebler
//  StudentID: 1000832292
//  Lecture Topic: CSE 494 @ 7:30 MW
//  Description: Stores the information required to track the student grades.
//              Must implement Serializable to store the object into a file.
//              Utilizes an Enum to represent the letter grade. Also, the SSN
//              field should not be serialized so it is declared as transient.
package studentgrades;

import java.io.Serializable;

/**
 * Stores the information required to track the student grades. Must implement
 * Serializable to store the object into a file. Utilizes an Enum to represent
 * the letter grade. Also, the SSN field should not be serialized so it is
 * declared as transient.
 *
 * @author csiebler
 */
public class Student implements Serializable {
    
    // Define the Result strings that are reused often
    private static final String COMMA = ", ";
    private static final String PERIOD = ".";
    
    // Declare the Student fields
    private String firstName;
    private String lastName;
    private transient String ssn;
    private String className;
    private Grade grade;
    
    // Declare an enum to represent the grades
    public enum Grade {
        A_PLUS,
        A,
        A_MINUS,
        B_PLUS,
        B,
        B_MINUS,
        C_PLUS,
        C,
        C_MINUS,
        D_PLUS,
        D,
        D_MINUS,
        F;
        
        /**
         * @return Representation of the grade
         */
        @Override
        public String toString() {
            switch (this) {
                case A_PLUS:
                    return "A+";
                case A:
                    return "A";
                case A_MINUS:
                    return "A-";
                case B_PLUS:
                    return "B+";
                case B:
                    return "B";
                case B_MINUS:
                    return "B-";
                case C_PLUS:
                    return "C-";
                case C:
                    return "C";
                case C_MINUS:
                    return "C-";
                case D_PLUS:
                    return "D+";
                case D:
                    return "D";
                case D_MINUS:
                    return "D-";
                case F:
                    return "F";
                default:
                    // Should never reach here
                    return "";
            }
        }
        
        public Grade getEnum(String input) {
            switch (input) {
                case "A+":
                    return A_PLUS;
                case "A":
                    return A;
                case "A-":
                    return A_MINUS;
                case "B+":
                    return B_PLUS;
                case "B":
                    return B;
                case "B-":
                    return B_MINUS;
                case "C+":
                    return C_PLUS;
                case "C":
                    return C;
                case "C-":
                    return C_MINUS;
                case "D+":
                    return D_PLUS;
                case "D":
                    return D;
                case "D-":
                    return D_MINUS;
                case "F":
                    return F;
                default:
                    return null;
            }
        }
        
    }

    /**
     * Empty constructor
     */
    public Student() {
        
    }

    /**
     * Overloaded constructor used to initialize all the fields upon creation.
     *
     * @param firstName First name
     * @param lastName Last name
     * @param ssn Social Security Number
     * @param className Name of the class
     * @param grade Letter grade
     */
    public Student(String firstName, String lastName, String ssn, String className, Grade grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.className = className;
        this.grade = grade;
    }

    /**
     * Return a String representing the class.
     * 
     * @return Representation of the Student class
     */
    @Override
    public String toString() {
        return lastName + COMMA + firstName + COMMA + className + COMMA + grade.toString() + PERIOD;
    }

    /**
     * Get the first name
     * 
     * @return First name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name
     * 
     * @param firstName First name
     * @return Student for method chaining
     */
    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Get the last name
     * 
     * @return Last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name
     * 
     * @param lastName Last name
     * @return Student for method chaining
     */
    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Get the Social Security Number
     * 
     * @return Social Security Number
     */
    public String getSsn() {
        return ssn;
    }

    /**
     * Set the Social Security Number
     * 
     * @param ssn Social Security Number
     * @return Student for method chaining
     */
    public Student setSsn(String ssn) {
        this.ssn = ssn;
        return this;
    }

    /**
     * Get the class name
     * 
     * @return name of the class
     */
    public String getClassName() {
        return className;
    }

    /**
     * Set the class name
     * 
     * @param className name of the class
     * @return Student for method chaining
     */
    public Student setClassName(String className) {
        this.className = className;
        return this;
    }

    /**
     * Get the grade
     * 
     * @return Letter grade
     */
    public Grade getGrade() {
        return grade;
    }

    /**
     * Set the grade
     * 
     * @param grade Letter grade (Plus & Minus available)
     * @return Student for method chaining
     */
    public Student setGrade(Grade grade) {
        this.grade = grade;
        return this;
    }

}
