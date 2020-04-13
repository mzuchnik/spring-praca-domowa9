package pl.mzuchnik.springpracadomowa9.document;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.mzuchnik.springpracadomowa9.Gender;

import javax.persistence.Id;

@Document
@JsonPropertyOrder({ "id","firstName", "lastName", "email", "gender","ipAddress" })
public class UserDocument {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private Gender gender;

    private String ipAddress;

    public UserDocument() {
    }

    public UserDocument(String firstName, String lastName, String email, Gender gender, String ipAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.ipAddress = ipAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return "UserDocument{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
