/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import GUI.DBConnect;
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
public class Appointment {
    private String appointmentID;
    private String patientID;
    private String opticianID;
    private String time;
    private String date;
    private String reference;
    
    public Appointment(){
        this.patientID = "GilFre69";
        this.opticianID = "JonLes97";
        this.time = "12:00";
        this.date = "12/12/2018";
        this.reference = "eye test";
        this.appointmentID = this.patientID;
        try{
            saveAppointment(appointmentID, patientID, opticianID, time, date, reference);
        }catch (SQLException e){
            System.out.println("failed to save appt");
        }
    }
    
    public Appointment(String patientID, String opticianID, String time, String date){
        this.patientID = patientID;
        this.opticianID = opticianID;
        this.time = time;
        this.date = date;
        this.appointmentID = patientID;
    }
    
    public void saveAppointment(String appointmentID, String patientID, String opticianID, String time, String date, String reference) throws SQLException{
        this.appointmentID = appointmentID;
        this.patientID = patientID;
        this.opticianID = opticianID;
        this.time = time;
        this.date = date;
        this.reference = reference;
        Connection con = null;
        Statement statement = null;
        String newAppointment = "INSERT INTO appointments (appointmentID, patientID, opticianID, time, date, reference) VALUES ('"+ this.appointmentID +"', '"+ this.patientID +"', '"+ this.opticianID +"', '"+ this.time +"', '" + this.date +"', '"+ this.reference +"')";
        try {
			
            
                DBConnect dbcon = new DBConnect();
                con = dbcon.Connect();
                statement = con.createStatement();

                System.out.println(newAppointment);

                // execute insert SQL stetement
                statement.executeUpdate(newAppointment);

                System.out.println("Record is inserted into appointments table!");
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
    
    public void deleteAppointment(String patientID, String time, String date) throws SQLException{
        this.patientID = patientID;
        this.time = time;
        this.date = date;
        Connection con = null;
        Statement statement = null;
        String deleteAppointment = "DELETE FROM appointments WHERE patientID = '"+ this.patientID +"' AND time='"+ this.time +"' AND date ='"+this.date+"'";
        try {
			
            
                DBConnect dbcon = new DBConnect();
                con = dbcon.Connect();
                statement = con.createStatement();

                System.out.println(deleteAppointment);

                // execute insert SQL stetement
                statement.executeQuery(deleteAppointment);

                System.out.println("Record has been removed from appointments table!");

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
