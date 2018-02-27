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
public class Patients {
    
    private List patients = new ArrayList();
    public Patients(){}
    
    public List getPatients(){
        return patients;
    }
    
    public void setPatients(List patients){
        this.patients = patients;
    }
    
    public String toString(){
        String patients ="";
        for(Patient patient:getPatients()){
                patients += patient.getName()+", ";
        }
        return patients; 
	}	
    
}
