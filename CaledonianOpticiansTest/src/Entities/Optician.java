/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import GUI.DBConnect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    public String getPassword(){
        return password;
    }
    
    public String getName(){
        return name;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getOpticianID(){
        return opticianID;
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
    
}
