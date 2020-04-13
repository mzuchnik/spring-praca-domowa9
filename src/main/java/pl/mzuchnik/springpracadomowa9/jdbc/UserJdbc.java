package pl.mzuchnik.springpracadomowa9.jdbc;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import pl.mzuchnik.springpracadomowa9.Gender;

import javax.persistence.Id;

@JsonPropertyOrder({ "id","firstName", "lastName", "email", "gender","ipAddress" })
public class UserJdbc {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Gender gender;

    private String ipAddress;

    public UserJdbc() {
    }

    public UserJdbc(Long id,String firstName, String lastName, String email, Gender gender, String ipAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.ipAddress = ipAddress;
    }
    public UserJdbc(String firstName, String lastName, String email, Gender gender, String ipAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.ipAddress = ipAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "UserJdbc{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
