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
public class Klijent {
    
    private int KlijentID;
    private String ime, prezime, telefon, elPosta, adresa;

    public Klijent() {
    }

    public Klijent(int KlijentID, String ime, String prezime, String telefon, String elPosta, String Adresa) {
        this.KlijentID = KlijentID;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.elPosta = elPosta;
        this.adresa = Adresa;
    }

    public int getKlijentID() {
        return KlijentID;
    }

    public void setKlijentID(int KlijentID) {
        this.KlijentID = KlijentID;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getElPosta() {
        return elPosta;
    }

    public void setElPosta(String elPosta) {
        this.elPosta = elPosta;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String Adresa) {
        this.adresa = Adresa;
    }

    @Override
    public String toString() {
        return this.ime + " "+ this.prezime;
    }
    
    
    
    
    
    
}
