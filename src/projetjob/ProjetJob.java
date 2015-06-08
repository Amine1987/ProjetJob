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
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.apache.commons.csv.*;


/**
 *
 * 
 * Classe principale, ouvre une connexion sur le serveurSQL 2008 et extait les
 * données à l'intérieur des tables créées.
 */
public class ProjetJob {
  
 
		public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, InterruptedException, IOException {
		String dbName = "test";
        String serverip="localhost";
        String serverport="1433";
        String url = "jdbc:sqlserver://"+serverip+"\\SQLEXPRESS:"+serverport+";databaseName="+dbName+"";
                    try {
                       
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(ProjetJob.class.getName()).log(Level.SEVERE, null, ex);
                    }
            Connection conn = DriverManager.getConnection(url,"sa","test101");
                                   
			       
			    
				    Statement valeur = conn.createStatement();
    String requete = "SELECT * FROM Client";

   //ResultSet resultat = null;
    ResultSet  resultat = valeur.executeQuery(requete);
    int size= 0;
    
    
    
    File csvCreer= new File("test.csv");
    
  //boolean bool= csvCreer.createNewFile();
   
  //System.out.println("Fichier créé: "+bool);
    //String sFilename="test.csv";
                   CSVWriter ecriture = new CSVWriter(new FileWriter(csvCreer));
     
                                        
            
                        ecriture.writeAll(resultat, bool);
                        
                        ecriture.close();
                        
                        
                        // for (int i=1; i<size;++i){
                        // System.out.println( resultat.getString(1) + ", " );
                        //Thread.sleep(2000);
                        //System.out.println( resultat.getString(2) + ", " );
                        // Thread.sleep(2000);
                        // System.out.println( resultat.getString(3) + ", " );
                        // Thread.sleep(2000);
                        
                        
                        //writer.append(resultat.getString(i));
                        
                        
                        //  }
                    }
                    
                            
     
            
       
       
        
    
    
      
                }
                
                
                

  
  
                   

              
        
            

           


	
	
	 


    






	
	