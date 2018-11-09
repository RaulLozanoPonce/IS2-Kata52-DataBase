package kata5p2.model;

public class Mail {
    private final String mail;
    
    public Mail(String mail){
        this.mail = mail;
    }
    
    public String getDomain(){
        int indexOfAtSign = mail.indexOf('@');
        if (indexOfAtSign < mail.length() - 1 && indexOfAtSign > 0){
            return mail.substring(indexOfAtSign + 1, mail.length());
        }else{ return ""; }
    }
}
