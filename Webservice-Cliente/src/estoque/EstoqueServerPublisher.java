package estoque;

import javax.xml.ws.Endpoint;

public class EstoqueServerPublisher {

	public static void main (String[] args) {
		Endpoint.publish("http://127.0.0.1:9878/resposta",//alterei um numero da
				new EstoqueServerImpl());//porta para funcionar

	}

}
