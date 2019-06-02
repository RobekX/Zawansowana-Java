package model.enities;

import lombok.Data;
import org.apache.log4j.Logger;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Client {

    static Logger log = Logger.getLogger(Client.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //Client Data
    private String forename;
    private String surname;
    private String pesel;
    //Address
    private String street;
    private String postCode;
    private String city;
    //contact Data
    private String phoneNumber;
    private String emailAddress;

    //methods
    public Client(String forename, String surname, String pesel, String street, String postCode, String city,
                  String phoneNumber, String emailAddress) {
        this.forename = forename;
        this.surname = surname;
        this.pesel = pesel;
        //boolean wrongPesel= isValidPESEL(pesel);
        //if(wrongPesel){
        //    this.pesel=pesel;
        //}else{
        //    log.error("Wrong PESEL");
        //}
        this.street = street;
        this.postCode = postCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        //boolean wrongEmail=isValidEmailAddress(emailAddress);
        //   if(wrongEmail){
        //       this.emailAddress=emailAddress;
        //   }else{
        //       log.error("Wrong Email");
        //   }

    }

    private static boolean isValidPESEL(String pesel) {

        int psize = pesel.length();
        if (psize != 11) {
            return false;
        }
        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int j = 0;
        int sum = 0;
        int control = 0;
        int csum = Integer.valueOf(pesel.substring(psize - 1));
        for (int i = 0; i < psize - 1; i++) {
            char c = pesel.charAt(i);
            j = Integer.valueOf(String.valueOf(c));
            sum += j * weights[i];
        }
        control = 10 - (sum % 10);
        if (control == 10) {
            control = 0;
        }
        return (control == csum);

    }

    private static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}