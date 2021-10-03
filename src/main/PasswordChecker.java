package main;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isUpperCase;

public class PasswordChecker {
    private List<Character> specialCharacters = new ArrayList<>();
    public PasswordChecker() {
        addSpecialCharacter('@');
    }

    public boolean meetsLengthRequirement(String password, int length) {
        return password.length() >= length;
    }

    public boolean containsUppercaseLetter(String password){
        for(int i = 0; i < password.length(); i++){
            if(isUpperCase(password.charAt(i)))
                return true;
        }
        return false;
    }

    public boolean containsSpecialCharacter(String password){
        for(char specialChar : specialCharacters){
            if(password.contains(Character.toString(specialChar))){
                return true;
            }
        }
        return false;
    }

    public void addSpecialCharacter(char character){
        specialCharacters.add(character);
    }
    public void removeSpecialCharacter(char character){
        specialCharacters.remove(character);
    }
}
