package entity;

public class User {
    private int id;
    private String name;
    private String surname;
    private String middleName;
    private String dateOfBirth;
    private int phoneNumber;
    private char gender;

    public User(String dateOfBirth, char gender, int id, String middleName,
                String name, int phoneNumber, String surname) {
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
        this.middleName = middleName;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.surname = surname;
    }
}
