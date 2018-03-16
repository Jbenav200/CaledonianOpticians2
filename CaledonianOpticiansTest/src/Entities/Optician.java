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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.*;

/**
 *
 * @author jonty
 */
public final class Optician {
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
    
    public Optician(String opticianID){
        this.opticianID = opticianID;
        this.name = "";
        this.lastName = "";
        retrieveOpticianDetails(opticianID);
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
    
    public String getPassword(){
        return password;
    }
    
    public String setName(String name){
        this.name = name;
        return this.name;
    }
    
    public String getName(){
        return name;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String setLastName(String lastName){
        this.lastName = lastName;
        return this.lastName;
    }
    
    public String getOpticianID(){
        return opticianID;
    }
    
    public String setOpticianID(String opticianID){
        this.opticianID = opticianID;
        return this.opticianID;
    }
    
    public void saveOptician() throws SQLException{
        Connection con = null;
        Statement statement = null;
        String newOptician = "INSERT INTO opticians(opticianID, password, name, lastName) VALUES ('" + getOpticianID() + "', '" + getPassword() + "', '"+ getName() + "', '" + getLastName() + "')";
        try {
			
            
                DBConnect dbcon = new DBConnect();
                con = dbcon.Connect();
                statement = con.createStatement();

                System.out.println(newOptician);

                // execute insert SQL stetement
                statement.executeUpdate(newOptician);

                System.out.println("Record is inserted into Patient table!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                    statement.close();
            }

            if (con != null) {
                    con.close();
            }

        }
        
    }
    
    public void retrieveOpticianDetails(String opticianID){
        Connection conn;
        Statement statement;
        String getOpticianDetails = "SELECT * FROM opticians WHERE opticianID = '"+ this.opticianID +"'";
        try {
            DBConnect db = new DBConnect();
            conn = db.Connect();
            statement = conn.createStatement();
            ResultSet rs;
            String opID;
            rs = statement.executeQuery(getOpticianDetails);
            if(rs.next()){
                this.opticianID = rs.getString(2);
                this.name = rs.getString(4);
                this.lastName = rs.getString(5);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ManageOpticians.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateOpticianDetails(String opticianID, String name, String lastName){
        Connection conn;
        Statement statement;
        System.out.println(opticianID + name + lastName);
        String setOpticianDetails = "UPDATE opticians SET opticianID  = '"+ opticianID + "' , name = '"+ name + "' , lastName = '" + lastName + "' WHERE opticianID = '"+ this.opticianID +"'";
        try {
            DBConnect db = new DBConnect();
            conn = db.Connect();
            statement = conn.createStatement();
            String opID;
            statement.executeUpdate(setOpticianDetails);
            
            System.out.println("Complete!");
        } catch (SQLException ex) {
            Logger.getLogger(ManageOpticians.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteOptician(String OpticianID){
        Connection conn;
        Statement statement;
        System.out.println(OpticianID + name + lastName);
        String setOpticianDetails = "DELETE FROM opticians WHERE opticianID = '"+ OpticianID +"'";
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
