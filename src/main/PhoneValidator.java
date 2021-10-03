package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PhoneValidator {
    private Map<String, String> countryPrefixes = new HashMap<>();
    private Map<String, Integer> countryLengths = new HashMap<>();

    public PhoneValidator() {
        addCountryCode("LT", "+3706", 12);
        addCountryCode("UK", "+44", 13);
    }

    public boolean containsOnlyNumbers(String number){
        char firstChar = number.charAt(0);
        if(firstChar == '+' || (firstChar >= '0' && firstChar <= '9')) {
            for (int i = 1; i < number.length(); i++) {
                if (!(number.charAt(i) >= '0' && number.charAt(i) <= '9'))
                    return false;
            }
            return true;
        }
        return false;
    }

    public String switchesNumberPrefix(String number){
        char[] newNumberArr = new char[number.length()+3];
        String prefix = "+370";
        if(number.charAt(0) == '8'){
            for(int i = 4; i < number.length()+3; i++){
                newNumberArr[i] = number.charAt(i-3);
            }
            for(int i = 0; i < 4; i++){
                newNumberArr[i] = prefix.charAt(i);
            }
            return new String(newNumberArr);
        }
        else{
            return number;
        }
    }
    public boolean correctNumberLength(String code, int length){
        return countryLengths.get(code) == length;
    }
    public boolean correctNumberPrefix(String code, String prefix){
        return Objects.equals(countryPrefixes.get(code), prefix);
    }
    public boolean correctForeignNumberLength(String code, int length){
        return countryLengths.get(code) == length;
    }
    public boolean correctForeignNumberPrefix(String code, String prefix){
        return Objects.equals(countryPrefixes.get(code), prefix);
    }
    public void addCountryCode(String countryCode, String countryPrefix, int countryLength){
        countryPrefixes.put(countryCode, countryPrefix);
        countryLengths.put(countryCode, countryLength);
    }
    public void removeCountryCode(String countryCode){
        countryPrefixes.remove(countryCode);
        countryLengths.remove(countryCode);
    }

}
