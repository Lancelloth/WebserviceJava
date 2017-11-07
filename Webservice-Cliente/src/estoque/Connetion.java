package estoque;

import java.sql.*;

import javax.swing.JOptionPane;

public class Connetion {
	
	public String leBanco(String query)
	{
		Connection con = null ;
		ResultSet rs = null;
		String descricao = null;
		int codigo = -1;
		try{
		//con = DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433","sa","");
	    //con = DriverManager.getConnection("http://127.0.0.1:9576/calc","sa","");
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/estoque","postgres","passcode");
		}
		catch(SQLException ex)
	    {
	            System.err.println("SQLException: " + ex.getMessage());
	    }
		try
		    {
		            //Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		            Class.forName("org.postgresql.Driver");
		
		    }
		    catch(ArrayIndexOutOfBoundsException | ClassNotFoundException e)
		    {
		            System.err.print("ClassNotFoundException: ");
		            System.err.println(e);
		    }
		Statement stmt;
		try
		{

		 // Abrindo a conex�o com o servidor localhost /login sa e sem senha
		 

            stmt = con.createStatement();

            // Criando a instru��o a partir do SELECT que est� dentro da vari�vel query
            rs = stmt.executeQuery(query);

            while(rs.next()){
            	descricao = rs.getString("descricao");
            	codigo = rs.getInt("codigo");
            }
            //Fechando a instru��o e a conex�o
            stmt.close();
            con.close();
            

		}
            catch(ArrayIndexOutOfBoundsException | SQLException e)
		{
            System.err.println("SQLException: " + e);
		}

		return "Item c�digo:"+codigo+" - "+descricao;

	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public boolean EscreveBanco(String query)
	{
			Connection con ;
			try{
			//con = DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433","sa","");
		    con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/estoque","postgres","passcode");
			}
			catch(SQLException ex)
		    {
		            System.err.println("SQLException: " + ex.getMessage());
		            return false;
		    }
			
			
			try
			    {
			            //Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
						Class.forName("org.postgresql.Driver");
			
			    }
			    catch(ArrayIndexOutOfBoundsException | ClassNotFoundException e)
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

	            
	            stmt.execute(query);
	            stmt.close();
	            con.close();
	            
	    }
	            catch(SQLException ex)
	    {
	            System.err.println("SQLException: " + ex.getMessage());
	            return false;
	    }
		return true;	
	
	}
}	


