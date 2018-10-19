package Human;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Emmanouil Paterakis
 */
public abstract class Human {

    // Constructors    
    public Human(){
        this(" "," "," ",0);
    };
    
    public Human(String firstName, String lastName, String description, int age, JTextArea infoArea) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.age = age;
        this.infoArea = infoArea;
    };
    
    public Human(String firstName, String lastName, String description, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.age = age;
    };
    
    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public JTextArea getInfoArea() {
        return infoArea;
    }

    public void setInfoArea(JTextArea infoArea) {
        this.infoArea = infoArea;
    }
    
    // Custom methods
    public abstract void introduceSelf();
    // Fields
    protected String firstName, lastName, description;
    protected int age;
    protected JTextArea infoArea; 
}
