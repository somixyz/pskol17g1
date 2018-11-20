/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.util.Date;

/**
 *
 * @author Milos Dragovic
 */
public class Predmet {

    private int predmetID;
    private String naziv;
    private String problem; 
    private Date datum;
    private Advokat advokat;
    private VrstaPostupka vp;
    private Klijent k;

    public Predmet() {
    }

    public Predmet(int predmetID, String naziv, String problem, Date datum, Advokat advokat, VrstaPostupka vp, Klijent k) {
        this.predmetID = predmetID;
        this.naziv = naziv;
        this.problem = problem;
        this.datum = datum;
        this.advokat = advokat;
        this.vp = vp;
        this.k = k;
    }

    public Klijent getK() {
        return k;
    }

    public void setK(Klijent k) {
        this.k = k;
    }

    public int getPredmetID() {
        return predmetID;
    }

    public void setPredmetID(int predmetID) {
        this.predmetID = predmetID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Advokat getAdvokat() {
        return advokat;
    }

    public void setAdvokat(Advokat advokat) {
        this.advokat = advokat;
    }

    public VrstaPostupka getVp() {
        return vp;
    }

    public void setVp(VrstaPostupka vp) {
        this.vp = vp;
    }
    
    
    
}
