/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import java.util.*;

/**
 *
 * @author jonty
 */
public class Optician {
    private String opticianID;
    private String password;
    private List patients;
    private List appointments;
    private String name;
    private String lastName;
    
    public Optician(){
        this.opticianID = "1234567890";
        this.name = "John";
        this.lastName = "Doe";
    }
    
    public Optician(String opticianID, String password, String name, String lastName){
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.opticianID = opticianID;
    }
    
    public Optician(String opticianID, List patients, List appointments)
    {
        this.opticianID = opticianID;
        this.patients = patients;
        this.appointments = appointments;
    }
    
    public void saveOptician(){
        
    }
    
}
