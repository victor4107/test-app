/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.e4x.mit21.dm2020MIT21;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Roman
 */
@Entity
@Table(name = "Ilnitsky")/*Bruh*/
public class TableSample {

   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Name is mandatory")
    private String name;
    private String uzer;
    private String password;
   
   

    TableSample() {
    }

    TableSample(String name, String uzer,String password) {
        this.name = name;
        this.uzer = uzer;
        this.password = password;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }





   

    @Override
    public String toString() {
        return "\n" + getId() + ", " + getName() + ", " + getUzer() + ", "+ getPassword();
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the user
     */
    public String getUzer() {
        return uzer;
    }

    /**
     * @param user the user to set
     */
    public void setUzer(String uzer) {
        this.uzer = uzer;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
