package entity;

public class User {

    private String name;
    private String surname;
    private String middleName;
    private String dateOfBirth;
    private long phoneNumber;
    private char gender;

    public User(String name, String surname, String middleName,
                String dateOfBirth, long phoneNumber, char gender) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
}
