package calc;

import java.sql.*;

public class Connetion {
	


	public ResultSet leBanco(String query)
	{
		Connection con = null ;
		ResultSet rs = null;
		try{
		con = DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433","sa","");
	    //con = DriverManager.getConnection("http://127.0.0.1:9576/calc","sa","");
		}
		catch(SQLException ex)
	    {
	            System.err.println("SQLException: " + ex.getMessage());
	    }
		try
		    {
		            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		
		    }
		    catch(java.lang.ClassNotFoundException e)
		    {
		            System.err.print("ClassNotFoundException: ");
		            System.err.println(e.getMessage());
		    }
		Statement stmt;
		try
		{

		 // Abrindo a conex�o com o servidor localhost /login sa e sem senha
		 

            stmt = con.createStatement();

            // Criando a instru��o a partir do SELECT que est� dentro da vari�vel query
            rs = stmt.executeQuery(query);

            //Fechando a instru��o e a conex�o
            stmt.close();
            con.close();
    		return rs;
		}
            catch(SQLException ex)
		{
            System.err.println("SQLException: " + ex.getMessage());
		}
		return rs;

	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public boolean EscreveBanco(String query)
	{
			Connection con ;
			try{
			con = DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433","sa","");
		    //con = DriverManager.getConnection("http://127.0.0.1:9576/calc","sa","");
			}
			catch(SQLException ex)
		    {
		            System.err.println("SQLException: " + ex.getMessage());
		            return false;
		    }
			
			
			try
			    {
			            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			
			    }
			    catch(java.lang.ClassNotFoundException e)
			    {
			            System.err.print("ClassNotFoundException: ");
			            System.err.println(e.getMessage());
			    }
		Statement stmt;
		try
	    {
	
			// Abrindo a conex�o com o servidor localhost /login sa e sem senha
			 
	
	            stmt = con.createStatement();
	
	            // Criando a instru��o a partir do SELECT que est� dentro da vari�vel query
	
	            //Boolean cs = stmt.execute(query);
	            //Fechando a instru��o e a conex�o
	            stmt.close();
	            con.close();
	            
	            stmt.execute(query);
	            
	    }
	            catch(SQLException ex)
	    {
	            System.err.println("SQLException: " + ex.getMessage());
	            return false;
	    }
		return true;	
	
	}
}	


