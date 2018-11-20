/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Klijent;
import domen.Predmet;
import domen.VrstaPostupka;
import helper.DBHelper;
import helper.Konstante;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milos Dragovic
 */
public class DBBroker {

    private Connection konekcija;
    private DBHelper dbhelper;

    public DBBroker() {
        try {
            this.dbhelper = new DBHelper();
        } catch (IOException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ucitajDriver() throws ClassNotFoundException {
        Class.forName(dbhelper.vratiVrednost(Konstante.DRIVER));
    }

    public void uspostaviKonekciju() throws SQLException {
        String url = dbhelper.vratiVrednost(Konstante.URL);
        String user = dbhelper.vratiVrednost(Konstante.USER);
        String pass = dbhelper.vratiVrednost(Konstante.PASS);
        konekcija = DriverManager.getConnection(url, user, pass);
        konekcija.setAutoCommit(false);
    }

    public void zatvoriKonekciju() throws SQLException {
        konekcija.close();
    }

    public void commit() throws SQLException {
        konekcija.commit();
    }

    public void rollback() throws SQLException {
        konekcija.rollback();
    }

    public ArrayList<Klijent> vratiKlijente() throws SQLException {
        ArrayList<Klijent> lista = new ArrayList<>();
        String upit = "SELECT * FROM Klijent ORDER BY Prezime ASC";
        Statement stm = konekcija.createStatement();
        ResultSet rs = stm.executeQuery(upit);
        while (rs.next()) {
            int klijentID = rs.getInt("klijentID");
            String ime = rs.getString("Ime");
            String prezime = rs.getString("Prezime");
            String telefon = rs.getString("Telefon");
            String elposta = rs.getString("ElPosta");
            String adresa = rs.getString("Adresa");

            Klijent klijent = new Klijent(klijentID, ime, prezime, telefon, elposta, adresa);
            lista.add(klijent);

        }
        rs.close();
        stm.close();
        return lista;
    }

    public ArrayList<VrstaPostupka> vratiVrstePostupka() throws SQLException {
        ArrayList<VrstaPostupka> lista = new ArrayList<>();
        String upit = "SELECT * FROM VrstaPostupka ORDER BY Naziv ASC";
        Statement stm = konekcija.createStatement();
        ResultSet rs = stm.executeQuery(upit);
        while (rs.next()) {
            int vpID = rs.getInt("VrstaPostupkaID");
            String naziv = rs.getString("Naziv");
            lista.add(new VrstaPostupka(vpID, naziv));
        }
        rs.close();
        stm.close();
        return lista;
    }

    public void sacuvajPredmet(Predmet predmet) throws SQLException {
        String upit = "INSERT INTO Predmet(PredmetID,Naziv,Problem,Datum,Advokat,KlijentID,VrstaPostupkaID) VALUES (?,?,?,?,?,?,?) ";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setInt(1, vratiMaxID());
        ps.setString(2, predmet.getNaziv());
        ps.setString(3, predmet.getProblem());
        ps.setDate(4, new Date(predmet.getDatum().getTime()));
        ps.setString(5, predmet.getAdvokat().getUsername());
        ps.setInt(6, predmet.getK().getKlijentID());
        ps.setInt(7, predmet.getVp().getVrstaPostupkaID());
        
        ps.executeUpdate();
        ps.close();
    }

    private int vratiMaxID() throws SQLException {
        int max = 0;
        String upit = "SELECT MAX(PredmetID) as Max FROM Predmet";
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        while (rs.next()) {            
            max = rs.getInt("max");
        }
        return ++max;
    }
}
