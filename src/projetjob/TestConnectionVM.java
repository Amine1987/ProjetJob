/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjob;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aminedrum
 */
public class TestConnectionVM {
    public static void main(String[] args) throws SQLException{
        
        
        String dbName = "test";
        String serverip="192.168.233.1";
        String serverport="1433";
        String url = "jdbc:sqlserver://"+serverip+"\\SQLEXPRESS:"+serverport+";databaseName="+dbName+"";
        
    try {
                       
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(TestConnectionVM.class.getName()).log(Level.SEVERE, null, ex);
                    }   catch (ClassNotFoundException ex) {
                            Logger.getLogger(TestConnectionVM.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InstantiationException ex) {
                            Logger.getLogger(TestConnectionVM.class.getName()).log(Level.SEVERE, null, ex);
                        }
            Connection conn = null;
                        try {
                            conn = DriverManager.getConnection(url,"sa","test101");
                        } catch (SQLException ex) {
                            Logger.getLogger(TestConnectionVM.class.getName()).log(Level.SEVERE, null, ex);
                        }
                                   
			       
			    
				    Statement valeur = null;
                        try {
                            valeur = conn.createStatement();
                        } catch (SQLException ex) {
                            Logger.getLogger(TestConnectionVM.class.getName()).log(Level.SEVERE, null, ex);
                        }
    String requete = "SELECT * FROM Client";

   //ResultSet resultat = null;
    ResultSet  resultat = null;
                        try {
                            resultat = valeur.executeQuery(requete);
                        } catch (SQLException ex) {
                            Logger.getLogger(TestConnectionVM.class.getName()).log(Level.SEVERE, null, ex);
                        }
    
    while (resultat.next()){
    System.out.println(resultat.getString(1));   
      System.out.println(resultat.getString(2));
      System.out.println(resultat.getString(3));
    }
    
    
    
    }





}
