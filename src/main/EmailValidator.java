package main;

import java.util.ArrayList;
import java.util.List;

public class EmailValidator {
    private List<Character> inadmissibleSymbols = new ArrayList<>();
    private List<String> domains = new ArrayList<>();
    private List<String> TLDs = new ArrayList<>();

    public EmailValidator(){
        addInadmissibleSymbol('©');
        addDomain("google");
        addTLD(".com");
    }

    public boolean containsAtSymbol(String email){
        return email.contains("@");
    }
    public boolean containsInadmissibleSymbol(String email){
        for(char inadmissibleSymbol : inadmissibleSymbols){
            if(email.contains(Character.toString(inadmissibleSymbol))){
                return true;
            }
        }
        return false;
    }
    public boolean hasBadDomain(String email){
        String afterEta = email.substring(email.indexOf('@')+1);
        for(String domain : domains){
            if(afterEta.contains(domain)){
                return false;
            }
        }
        return true;
    }
    public boolean hasBadTopLevelDomain(String email){
        String afterEta = email.substring(email.indexOf('@')+1);
        for(String TLD : TLDs){
            if(afterEta.contains(TLD)){
                return false;
            }
        }
        return true;
    }
    public void addInadmissibleSymbol(char character){
        inadmissibleSymbols.add(character);
    }
    public void removeInadmissibleSymbol(char character){
        inadmissibleSymbols.remove(character);
    }
    public void addDomain(String domain){
        domains.add(domain);
    }
    public void removeDomain(String domain){
        domains.remove(domain);
    }
    public void addTLD(String TLD){
        TLDs.add(TLD);
    }
    public void removeTLD(String TLD){
        TLDs.remove(TLD);
    }
}
