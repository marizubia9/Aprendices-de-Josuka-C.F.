package ServiciosExternos;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * @class RestClient
 * @brief Sirve para conectar dos aplicaciones. En este caso la raspberry y la aplicación de Aprendices de Josuka
 * @author Alumno
 * @param <T> objeto del que se hara POST o PUT
 */
public class RestClient < T extends DF_Printable >
{
	protected Client client;
	protected WebTarget webTarget;
	/**
	 * Parsea la respuesta de la solicitud
	 * @param response_status código de la respuesta
	 * @return respuesta parseada a OK, CREADA o ACEPTADA
	 */
	public boolean request_OK(int response_status)
	{
		return  response_status == Status.OK.getStatusCode()           ||     // Code: 200
				response_status == Status.CREATED.getStatusCode()      ||     // Code: 201
				response_status == Status.ACCEPTED.getStatusCode();           // Code: 202
	}
	/**
	 * Constructor de la clase
	 * @param hostname el host con el que se realiza la conexión
	 * @param port puerto en el que se realiza la conexión
	 */
	public RestClient(String hostname, String port)
	{
		this.client = ClientBuilder.newClient();
		this.webTarget = client.target(String.format("http://%s:%s", hostname, port));
	}


	public Invocation.Builder createInvocationBuilder(String resource_URL) throws Exception
	{
		WebTarget requestController = this.webTarget.path(resource_URL);
		Invocation.Builder invocationBuilder = requestController
				.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		System.out.println("Java Client preparing Jersey request call to " +
				String.format("http://%s:%s%s",
						webTarget.getUri().getHost(),
						webTarget.getUri().getPort(),
						webTarget.getUri().getRawPath()
				));

		return invocationBuilder;
	}
	/**
	 * Método donde se realiza una petición GET
	 * @param invocationBuilder una interfaz que proporciona métodos para preparar la petición del cliente y también para invocarla.
	 * @return devuelve la respuesta de la petición
	 * @throws Exception
	 */
	public Response makeGetRequest(Invocation.Builder invocationBuilder) throws Exception
	{
		System.out.println("Sending GET Request");
		return invocationBuilder.get();
	}
	/**
	 * Método donde se realiza una petición POST
	 * @param invocationBuilder una interfaz que proporciona métodos para preparar la petición del cliente y también para invocarla.
	 * @param objectToSend la entidad que se va a mandar
	 * @return devuelve la respuesta de la petición
	 * @throws Exception
	 */
	public Response makePostRequest(Invocation.Builder invocationBuilder, T objectToSend) throws Exception
	{
		System.out.println("Content of message to send in POST Request");
		objectToSend.print();
		return invocationBuilder.post(Entity.entity(objectToSend, MediaType.APPLICATION_JSON));
	}
	/**
	 * Método donde se realiza una petición PUT
	 * @param invocationBuilder una interfaz que proporciona métodos para preparar la petición del cliente y también para invocarla.
	 * @param objectToSend la entidad que se va a mandar
	 * @return devuelve la respuesta de la petición
	 * @throws Exception
	 */
	public Response makePutRequest(Invocation.Builder invocationBuilder, T objectToSend) throws Exception
	{
		System.out.println("Content of message to send in PUT Request");
		objectToSend.print();
		return invocationBuilder.put(Entity.entity(objectToSend, MediaType.APPLICATION_JSON));
	}
	/**
	 * Se imprime la respuesta como un string
	 * @param response la respuesta que debe imprimir
	 */
	public void simplePrint(Response response)
	{

		System.out.println("Java Jersey Client received the following output:");
		System.out.println(response.toString());

		if ( request_OK( response.getStatus() ) ) {
			System.out.println("Successfully made Rest request... ");
			System.out.println("Goint to print response content as string");

			System.out.println( response.readEntity(String.class) );
		}
		else {
			System.out.println("BadAss error happened. Can't print result.");
		}
	}
}
