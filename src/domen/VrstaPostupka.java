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
public class VrstaPostupka {

    private int vrstaPostupkaID;
    private String naziv;

    public VrstaPostupka() {
    }

    public VrstaPostupka(int vrstaPostupkaID, String naziv) {
        this.vrstaPostupkaID = vrstaPostupkaID;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getVrstaPostupkaID() {
        return vrstaPostupkaID;
    }

    public void setVrstaPostupkaID(int vrstaPostupkaID) {
        this.vrstaPostupkaID = vrstaPostupkaID;
    }

    @Override
    public String toString() {
        return naziv;
    }

}
