/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author jonty
 */
public class Patient {
    private String patientID;
    private String name;
    private String lastName;
    private int age;
    private String dateOfBirth;
    private String address;
    private String postCode;
    private String email;
    private char[] password;
    private boolean patientExists = false;
    
    public Patient(){
        this.name = "John";
        this.lastName = "Doe";
        this.dateOfBirth = "1/1/1995";
        this.address = "25 wallaby way";
        this.postCode = "G70 9LU";
        this.email = "john.doe@gmail.com";
        this.patientExists = false;
    }
    
    public Patient(String name, String lastName, String dateOfBirth, String address, String postCode, String email, char[] password){
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.postCode = postCode;
        this.email = email;
        this.password = password;
        this.patientID = this.name.substring(0, 1) + this.name.substring(1,2) + this.name.substring(2,3) + this.lastName.substring(0,1) + this.lastName.substring(1,2) + this.lastName.substring(2,3) + this.dateOfBirth.substring(8,9) + this.dateOfBirth.substring(9,10);
        System.out.println(patientID);
        this.patientExists = true;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public String getDOB(){
        return this.dateOfBirth;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public String getPostCode(){
        return this.postCode;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public boolean getPatientExists(){
        return patientExists;
    }
    
    public void savePatient(){
        
    }
    
    public void retrievePatientDetails(String patientID, String password){
        
    }
    
}
