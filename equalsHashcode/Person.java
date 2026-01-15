package equalsHashcode;

import java.util.Date;
import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private Date date;
    private String email;

    public Person(String firstName, String lastName, Date date, String email) {
        if(firstName == null || firstName.isEmpty()){
            throw new IllegalArgumentException("First Name cannot be empty");
        }

        if(lastName == null || lastName.isEmpty()){
            throw new IllegalArgumentException("Last Name cannot be empty");
        }

        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("email cannot be empty");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isEmpty()){
            throw new IllegalArgumentException("First Name cannot be empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isEmpty()){
            throw new IllegalArgumentException("Last Name cannot be empty");
        }
        this.lastName = lastName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("email cannot be empty");
        }
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }


}
