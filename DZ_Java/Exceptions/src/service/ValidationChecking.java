package service;

import exceptions.NotValidFormatDateException;
import exceptions.NotValidGenderFormatException;
import exceptions.NotValidPhoneNumberFormatException;

public class ValidationChecking {

    public String[] check(String[] user){
        validationDateOfBirth(user);
        validationPhoneNumber(user);
        validationGender(user);
        return user;
    }

    private void validationDateOfBirth(String[] user) {
        try {
            String[] date = user[3].split("\\.");
            if (date.length != 3) throw new NotValidFormatDateException();
            else {
                if (date[0].length() != 2 ||
                        date[1].length() != 2 ||
                        date[2].length() != 4)
                    throw new NotValidFormatDateException();
                else {
                    Integer.parseInt(date[0]);
                    Integer.parseInt(date[1]);
                    Integer.parseInt(date[2]);
                }
            }
        } catch (NotValidFormatDateException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    private void validationPhoneNumber(String[] user) {
        try {
            String phone = user[4];
            if (phone.length() != 10) throw new NotValidPhoneNumberFormatException();
            else {
                Long.parseLong(phone);
            }
        } catch (NotValidPhoneNumberFormatException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    private void validationGender(String[] user){
        try {
            String gender = user[5];
            if(!gender.equals("f") &&
                    !gender.equals("m") &&
                    !gender.equals("F") &&
                    !gender.equals("M")) throw new NotValidGenderFormatException();
        }catch (NotValidGenderFormatException e){
            throw new RuntimeException(e);
        }
    }

}
