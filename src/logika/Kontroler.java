/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import db.DBBroker;
import domen.Advokat;
import domen.Klijent;
import domen.Predmet;
import domen.VrstaPostupka;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milos Dragovic
 */
public class Kontroler {

    private static Kontroler instanca;
    private ArrayList<Advokat> listaAdvokataUKomori;
    private DBBroker db;

    private Kontroler() {
        db = new DBBroker();
        listaAdvokataUKomori = new ArrayList<>();
        listaAdvokataUKomori.add(new Advokat("Milos", "Dragovic", "somi", "somi", "Parnicni postupak"));
        listaAdvokataUKomori.add(new Advokat("Pera", "Petrovic", "pera", "pera", "Vanparnicni postupak"));
        listaAdvokataUKomori.add(new Advokat("Zika", "Zivkovic", "zika", "zika", "upravni spor"));

    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public Advokat proveriAdvokata(String username, String password) {
        for (Advokat advokat : listaAdvokataUKomori) {
            if (advokat.getUsername().equals(username) & advokat.getPassword().equals(password)) {
                return advokat;
            }
        }
        return null;
    }

    public ArrayList<Klijent> getListaKlijenata() {
        ArrayList<Klijent> klijenti = new ArrayList<>();
        try {
            db.ucitajDriver();
            db.uspostaviKonekciju();
            klijenti = db.vratiKlijente();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                db.zatvoriKonekciju();
            } catch (SQLException ex) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return klijenti;
    }

    public ArrayList<VrstaPostupka> getListaVrstaPostupka() {
        ArrayList<VrstaPostupka> lista = new ArrayList<>();
        try {
            db.ucitajDriver();
            db.uspostaviKonekciju();
            lista = db.vratiVrstePostupka();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                db.zatvoriKonekciju();
            } catch (SQLException ex) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public boolean sacuvajSve(ArrayList<Predmet> lista) throws SQLException {
        boolean sacuvano = false;
        try {
            db.ucitajDriver();
            db.uspostaviKonekciju();
            for (Predmet predmet : lista) {
                db.sacuvajPredmet(predmet);
            }
            db.commit();
            sacuvano = true;
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            try {
                db.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex1);
                try {
                    db.rollback();
                } catch (SQLException ex2) {
                    Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex2);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                db.zatvoriKonekciju();
            } catch (SQLException e) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, e);
            } 
        }
        return sacuvano;
    }

}
