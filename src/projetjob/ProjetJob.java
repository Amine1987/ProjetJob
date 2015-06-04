/*
 * @author Amine Chikhaoui
 * @date 3 juin 2015
 * 
 * 
 */
package projetjob;
import java.lang.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

;
/**
 *
 * 
 * Classe principale, ouvre une connexion sur le serveurSQL 2008 et extait les
 * données à l'intérieur des tables créées.
 */
public class ProjetJob {
  
 
		public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, InterruptedException {
		String dbName = "test";
        String serverip="localhost";
        String serverport="1433";
        String url = "jdbc:sqlserver://"+serverip+"\\SQLEXPRESS:"+serverport+";databaseName="+dbName+"";
                    try {
                        //Class.forName("net.sourceforge.jtds.jdbc.Driver");
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(ProjetJob.class.getName()).log(Level.SEVERE, null, ex);
                    }
            Connection conn = DriverManager.getConnection(url,"sa","test101");
                                   
			       
			    
				    Statement valeur = conn.createStatement();
    String requete = "SELECT * FROM Client";

    ResultSet resultat = null;
    int size= 0;

                    try {
                        resultat = valeur.executeQuery(requete);
                    } catch (SQLException ex) {
                        Logger.getLogger(ProjetJob.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                    
                        while ( resultat.next()) {
                            size++;
                           for (int i=0; i<size;++i){
                            System.out.println( resultat.getString(1) + ", " );
                            Thread.sleep(2000);
                            System.out.println( resultat.getString(2) + ", " );
                             Thread.sleep(2000);
                             System.out.println( resultat.getString(3) + ", " );
                             Thread.sleep(2000);
                           }
                                 
                               Thread.sleep(2000);
                        }   
                    }catch (SQLException ex) {
                        Logger.getLogger(ProjetJob.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    
                    }
                }

	 class baseDonnee{
		 
		 public  baseDonnee(){}
		 
	public void  Connexion (String connexion_db, String username, String password)
	{


		try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
             connexion_db, username,password);
            System.out.println("connecté");
            //System.out.println(username);
            //System.out.println(password);
 
            
             
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
	
	
	 
	 }

    






	
	