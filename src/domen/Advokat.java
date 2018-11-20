/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Milos Dragovic
 */
public class Advokat {

    private String ime, prezime, username,password,specijalnost;

    public Advokat() {
    }

    public Advokat(String ime, String prezime, String username, String password, String specijalnost) {
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.specijalnost = specijalnost;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSpecijalnost() {
        return specijalnost;
    }

    public void setSpecijalnost(String specijalnost) {
        this.specijalnost = specijalnost;
    }

    @Override
    public String toString() {
        return ime+" "+prezime; 
    }
    
    
    
    
}
