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
public class Administrator {
    private String adminID;
    private String password;
    
    public Administrator(){
        
    }
    
    public Administrator(String adminID, String password){
        this.adminID = adminID;
        this.password = password;
    }
    
    public void registerOptician(String opticianID, String password, String name, String lastName){
        Optician newOp = new Optician(opticianID, password, name, lastName);
        newOp.saveOptician();
    }
    
}
