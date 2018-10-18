package Human;

import javax.swing.JTextField;

/**
 *
 * @author Emmanouil Paterakis
 */
public abstract class Human {

    // Constructors    
    public Human() {
        this.firstName = "";
        this.lastName = "";
        this.description = "";
        this.age = 0;
    };
    
    public Human(JTextField infoTf){
        this("","","",0,infoTf);
    };
    
    public Human(String firstName, String lastName, String description, int age, JTextField infoTf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.age = age;
        this.infoTf = infoTf;
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
    
    // Custom methods
    public void introduceSelf() {
        //
    };
    
    // Fields
    private String firstName, lastName, description;
    private int age;
    private JTextField infoTf; 
}
