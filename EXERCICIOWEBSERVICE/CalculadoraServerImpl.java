package calc;


//import java.util.Date;
import javax.jws.WebService;

@WebService(endpointInterface = "calc.CalculadoraServer")
public class CalculadoraServerImpl implements CalculadoraServer {
		
	public String incluir(String descricao, int estoque) {
		String query;
		query = "INSERT INTO ESTOQUE (descricao, estoque) VALUES ('?descricao', '?estoque');";
		Connetion c = new Connetion();
		c.EscreveBanco(query);
		return "S";
	}
	
	public String consultar(int cod) {
		String query;
		query = "SELECT * FROM estoque WHERE codigo = ?cod;";
		Connetion c = new Connetion();
		c.leBanco(query);
		return "N";
	}

	public String vender(int cod, int qtd) {
		String query;
		query = "UPDATE estoque SET estoque = estoque.estoque - ?qtd WHERE codigo = ?cod;";
		Connetion c = new Connetion();
		c.EscreveBanco(query);
		return "S";
	}

	public String reposicao(int codigo, int qtd) {
		String query;
		query = "UPDATE estoque SET estoque = estoque.estoque + ?qtd WHERE codigo = ?cod;";
		Connetion c = new Connetion();
		c.EscreveBanco(query);
		return "S";
	}

}