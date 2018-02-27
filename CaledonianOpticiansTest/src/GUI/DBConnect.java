/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.*;

/**
 *
 * @author jonty
 */
public class DBConnect {
    public Connection Connect(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/caledonianopticians1", "root", "");
            System.out.print("Database is connected !");
        }
        catch(Exception e)
        {
            System.out.print("Did not connect to DB - Error:"+e);
        }
        return con;
    }
}
