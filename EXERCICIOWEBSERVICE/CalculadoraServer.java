package calc;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface CalculadoraServer {
	@WebMethod String incluir(String descricao, int estoque);
	@WebMethod String consultar(int cod);
	@WebMethod String vender(int codigo, int qtd);
	@WebMethod String reposicao(int codigo, int qtd);
}