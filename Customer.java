
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbenav200
 */
public class Customer {
    import Java.util.Date;
    
    private String name;
    private String gender;
    private int customerId;
    private Date dateOfBirth;
    
    Customer(){
        this.name = "John Doe";
            this.customerId = 123456789;
            this.dateOfBirth = new GregorianCalendar(1995, Calendar.JUNE, 10);
    }
    
    Customer(String gender){
        
        if (gender = "male")
        {
            this.name = "John Doe";
            this.customerId = 123456789;
            this.dateOfBirth = new GregorianCalendar(1995, Calendar.JUNE, 10);
        }
        else
        {
            this.name = "Jane Doe";
            this.customerId = 123456789;
            this.dateOfBirth = new GregorianCalendar(1969, Calendar.APRIL, 28);
        }
    }
    
    Customer(String name, int customerId, Date dateOfBirth, String gender)
    {
        this.name = name;
        this.customerId = customerId;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
    
}
