/*
 * @author Amine Chikhaoui
 * @date 3 juin 2015
 * 
 * 
 */
package projetjob;


import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import static java.lang.String.format;

import java.sql.*;
import java.util.Calendar;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import org.apache.commons.net.*;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;



/**
 *
 * 
 * Classe principale, ouvre une connexion sur le serveurSQL 2008 et extait les
 * données à l'intérieur des tables créées.
 */
public class ProjetJob {
  
 
		public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, InterruptedException, IOException {
		
                    
                    
                            Timer temps = new Timer();
        TimerTask tempsschedule = new TimerTask(){
       

              
                    public void run() {
                               
                                 
                    
                    
                    
                    String dbName = "test";
        String serverip="localhost";
        String serverport="1433";
        String url = "jdbc:sqlserver://"+serverip+"\\SQLEXPRESS:"+serverport+";databaseName="+dbName+"";
                    try {
                       
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(ProjetJob.class.getName()).log(Level.SEVERE, null, ex);
                    }   catch (ClassNotFoundException ex) {
                            Logger.getLogger(ProjetJob.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InstantiationException ex) {
                            Logger.getLogger(ProjetJob.class.getName()).log(Level.SEVERE, null, ex);
                        }
            Connection conn = null;
                        try {
                            conn = DriverManager.getConnection(url,"sa","test101");
                        } catch (SQLException ex) {
                            Logger.getLogger(ProjetJob.class.getName()).log(Level.SEVERE, null, ex);
                        }
                                   
			       
			    
				    Statement valeur = null;
                        try {
                            valeur = conn.createStatement();
                        } catch (SQLException ex) {
                            Logger.getLogger(ProjetJob.class.getName()).log(Level.SEVERE, null, ex);
                        }
    String requete = "SELECT * FROM Client";

   //ResultSet resultat = null;
    ResultSet  resultat = null;
                        try {
                            resultat = valeur.executeQuery(requete);
                        } catch (SQLException ex) {
                            Logger.getLogger(ProjetJob.class.getName()).log(Level.SEVERE, null, ex);
                        }
  

  
   
    // Format date to append to new file name
SimpleDateFormat simple = new SimpleDateFormat("ddMMyyyy_hhmmss");
Date dateCourrante = new Date();
String Datestring = simple.format(dateCourrante);
String nomFile = Datestring;
 File csvCreer= new File(nomFile);
    
    
    
    
                     
    
  boolean bool = false;
                        try {
                            bool = csvCreer.createNewFile();
                        } catch (IOException ex) {
                            Logger.getLogger(ProjetJob.class.getName()).log(Level.SEVERE, null, ex);
                        }

  System.out.println("Fichier créé");

                   CSVWriter ecriture = null;
                        try {
                            ecriture = new CSVWriter(new FileWriter(csvCreer));
                        } catch (IOException ex) {
                            Logger.getLogger(ProjetJob.class.getName()).log(Level.SEVERE, null, ex);
                        }
     
                                        
                        
                        try {
                            ecriture.writeAll(resultat, bool);
                        } catch (SQLException ex) {
                            Logger.getLogger(ProjetJob.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(ProjetJob.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        try {
                            ecriture.close();
                        } catch (IOException ex) {
                            Logger.getLogger(ProjetJob.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       
                        
                        //Connexion ftp données
                        
                                String serveur = "ftp.oxfamquebec.org";
        int port = 21;
        String nom = "phoenix";
        String motDepasse = "Gp1Kd9)&fSx4-";
        FTPClient ftpClient = new FTPClient();
                        try {
                            ftpClient.connect(serveur, port);
                        } catch (IOException ex) {
                            Logger.getLogger(ProjetJob.class.getName()).log(Level.SEVERE, null, ex);
                        }
   
        int CodeDeReponse = ftpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(CodeDeReponse )) {
            System.out.println("OOperation sans succès, réponse du serveur: " +  CodeDeReponse );
            return;
        }
        boolean ok = false;
                        try {
                            ok = ftpClient.login(nom, motDepasse);
                        } catch (IOException ex) {
                            Logger.getLogger(ProjetJob.class.getName()).log(Level.SEVERE, null, ex);
                        }
      
        if (!ok) {
            System.out.println("Impossible de se connecter");
            return;
        } else {
            System.out.println("Connecté au serveur");
        }
                       
        
                       
                    }
            
        };
        temps.schedule(tempsschedule,1000, 5184000*1000);
}
}              
                            
     
            
       
       
        
    
    
      
                
                
                
                

  
  
                   

              
        
            

           


	
	
	 


    






	
	