package main;

public class MainModule{
    Checker checker = new Checker();
    public boolean isPhoneInvalid(String number){
        if (!checker.CheckPhoneLenght(number) || checker.checkSymbols(number)){
            System.out.println("Error: phone number invalid");
            return true;
        }
        return false;
    }
    public boolean isPasswordInvalid(String password){
        if (!checker.checkLenght(password) || !checker.checkUppercase(password) || !checker.checkSpecial(password)) {
            System.out.println("Error: password invalid");
            return true;
        }
        return false;
    }
    public boolean isEmailInvalid(String email){
        if (!checker.checkTLD(email) || checker.checkBadSymbols(email)
                || !checker.checkDomain(email) || !checker.checkEtaSymbol(email)){
            System.out.println("Error: email invalid");
            return true;
        }
        return false;
    }
}
