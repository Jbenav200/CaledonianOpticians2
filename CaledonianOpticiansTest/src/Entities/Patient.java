/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import GUI.DBConnect;
import GUI.ManageOpticians;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonty
 */
public final class Patient {
    private String patientID;
    private String name;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String postCode;
    private String email;
    private String password;
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
    
    public Patient(String patientID){
        this.patientID = patientID;
        receivePatientData(patientID);
        
        
    }
    
    public Patient(String name, String lastName, String dateOfBirth, String address, String postCode, String email, String password){
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
    
    public String getPatientID(){
        return patientID;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void retrievePatientDetails(String patientID, String password){
        
    }
    
    public void updatePatientDetails(String patientID, String name, String lastName, String dateOB){
        Connection conn;
        Statement statement;
        System.out.println(patientID + name + lastName);
        String setOpticianDetails = "UPDATE patients SET PatientID= '" + patientID + "',Name='"+ name +"',LastName='"+ lastName +"',DateOfBirth='"+ dateOB +"' WHERE PatientID = '"+ this.patientID +"'";
        DBConnect db = new DBConnect();
        conn = db.Connect();
        try {
            statement = conn.createStatement();
            statement.executeUpdate(setOpticianDetails);
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            System.out.println("Complete!");
        
    }
    
    public void receivePatientData(String patientID){
        Connection conn;
        Statement statement;
        String getOpticianDetails = "SELECT * FROM patients WHERE patientID = '"+ this.patientID +"'";
            DBConnect db = new DBConnect();
            conn = db.Connect();
        try {
            statement = conn.createStatement();
            ResultSet rs;
            String opID;
            rs = statement.executeQuery(getOpticianDetails);
            if(rs.next()){
                this.patientID = rs.getString(2);
                this.name = rs.getString(3);
                this.lastName = rs.getString(4);
                this.dateOfBirth = rs.getString(5);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletePatient(String patientID){
        Connection conn;
        Statement statement;
        System.out.println(patientID + name + lastName);
        String setOpticianDetails = "DELETE FROM patients WHERE patientID = '"+ patientID +"'";
        try {
            DBConnect db = new DBConnect();
            conn = db.Connect();
            statement = conn.createStatement();
            statement.execute(setOpticianDetails);
            
            System.out.println("Deleted!");
        } catch (SQLException ex) {
            Logger.getLogger(ManageOpticians.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
