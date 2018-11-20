/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Milos Dragovic
 */
public class DBHelper {

    private Properties props;

    public DBHelper() throws FileNotFoundException, IOException {
        ucitajProperies();
    }

    private void ucitajProperies() throws FileNotFoundException, IOException {
        props = new Properties();
        FileInputStream fis = new FileInputStream("db.properties");
        props.load(fis); 
    }
    
    public String vratiVrednost(String kljuc){
        return props.getProperty(kljuc); 
    }
    
}
