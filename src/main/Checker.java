package main;

public class Checker {

    private int minPasswordLength;
    private char[] specialPasswordSymbols;
    private int minPhoneNrLength;
    private int maxPhoneNrLength;
    private String phoneNrPrefix;
    private char[] forbiddenEmailSymbols;
    private final int MAX_DOMAIN_LENGTH = 253;
    private final int MIN_DOMAIN_LENGTH = 1;
    private final int MAX_TLD_LENGTH = 63;
    private final int MIN_TLD_LENGTH = 2;

    public Checker() {
        minPasswordLength = 5;
        specialPasswordSymbols = new char[]{'_'};
        minPhoneNrLength = 6;
        maxPhoneNrLength = 12;
        phoneNrPrefix = "86";
        forbiddenEmailSymbols = new char[]{'&'};
    }

    public boolean checkLenght(String password) {
        return password.length() >= minPasswordLength;
    }

    public boolean checkUppercase(String password) {
        for (char character : password.toCharArray()) {
            if (Character.isUpperCase(character)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkSpecial(String password) {
        for (char specialSymbol : specialPasswordSymbols) {
            if (!password.contains(Character.toString(specialSymbol))) {
                return false;
            }
        }

        return true;
    }

    public boolean checkSymbols(String phoneNr) {
        for (char character : phoneNr.toCharArray()) {
            if (!Character.isDigit(character)) {
                return true;
            }
        }

        return false;
    }

    public boolean CheckPhoneLenght(String phoneNr) {
        return phoneNr.length() >= minPhoneNrLength
                && phoneNr.length() <= maxPhoneNrLength;
    }

    public boolean checkprefix(String phoneNr) {
        return phoneNr.startsWith(phoneNrPrefix);
    }

    public boolean checkEtaSymbol(String email) {
        return email.contains("@");
    }

    public boolean checkBadSymbols(String email) {
        for (char forbiddenSymbol : forbiddenEmailSymbols) {
            if (email.contains(Character.toString(forbiddenSymbol))) {
                return true;
            }
        }

        return false;
    }

    public boolean checkDomain(String email) {
        int domainStartIndex = email.indexOf('@') + 1;
        int domainEndIndex = email.lastIndexOf('.');
        if (!isDomainIndexValid(domainStartIndex)) {
            return false;
        }

        String domain = email.substring(domainStartIndex, domainEndIndex);
        if (!isDomainLengthValid(domain.length())) {
            return false;
        }

        if (!onlyAllowedCharsDomain(domain)) {
            return false;
        }

        return true;
    }

    private boolean isDomainIndexValid(int index) {
        return index != 0;
    }

    private boolean isDomainLengthValid(int domainLenght) {
        return domainLenght >= MIN_DOMAIN_LENGTH && domainLenght <= MAX_DOMAIN_LENGTH;
    }

    private boolean onlyAllowedCharsDomain(String domain) {
        for (char ch : domain.toCharArray()) {
            if (Character.isLetter(ch) || Character.isDigit(ch) || ch == '-' || ch == '.') {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean checkTLD(String email) {
        int tldIndex = email.lastIndexOf('.') + 1;
        if (!isTLDIndexValid(tldIndex, email.length())) {
            return false;
        }

        String tld = email.substring(tldIndex);
        if (!isTLDLengthValid(tld.length())) {
            return false;
        }

        if (!TLDStartsWithLetter(tld)) {
            return false;
        }

        if (!onlyAllowedCharsTLD(tld)) {
            return false;
        }

        if (email.endsWith(Character.toString('-'))) {
            return false;
        }

        return true;
    }

    private boolean isTLDIndexValid(int index, int emailLength) {
        if (index == 0 || index == emailLength) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isTLDLengthValid(int tldLength) {
        return tldLength >= MIN_TLD_LENGTH && tldLength <= MAX_TLD_LENGTH;
    }

    private boolean TLDStartsWithLetter(String tld) {
        char firstChar = tld.charAt(0);
        return Character.isLetter(firstChar);
    }

    private boolean onlyAllowedCharsTLD(String tld) {
        for (char ch : tld.toCharArray()) {
            if (Character.isLetter(ch) || Character.isDigit(ch) || ch == '-') {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}

