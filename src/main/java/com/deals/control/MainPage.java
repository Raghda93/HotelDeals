package main.java.com.deals.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.com.deals.beans.HotelsInfoProject;


@WebServlet("/mainPage")
public class MainPage extends HttpServlet {
    
    private static HotelsInfoProject hotelsInfoBean = null;

	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {

        handleRequest(req, resp);
    }

    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {

        handleRequest(req, resp);
    }

    /**
     * Handle Request
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void handleRequest(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        Response response = invoke();
        byte[] hotelsInfoString = response.readEntity(String.class).getBytes();
		ObjectMapper mapper = new ObjectMapper();
		hotelsInfoBean = mapper.readValue(hotelsInfoString, HotelsInfoProject.class);
		req.setAttribute("hotelsInfoBean", hotelsInfoBean);
		
        req.getRequestDispatcher("HotelsPage.jsp").forward(req, resp);
    }


    public Response invoke() {
		ClientConfig clientConfig = new ClientConfig();
		Client client = createClient(clientConfig);
		
		WebTarget webTarget = createWebTarget(client);
		Invocation.Builder requestBuilder = createRequestBuilder(webTarget);
		
		Response response = sendRequest(requestBuilder, HttpMethod.GET);
		return response;
	}
    
    /**
     * creates client
     * @param clientConfig
     * @return
     */
    private Client createClient(ClientConfig clientConfig) {
		return ClientBuilder.newClient(clientConfig);
	}
    
    /**
     * createWebTarget
     * @param client
     * @return
     */
    private WebTarget createWebTarget(Client client) {
		return client.target(getUriBuilder());
	}
    
    /**
     * Creates UriBuilder
     * @return
     */
    private UriBuilder getUriBuilder() {
    	
		UriBuilder uriBuilder = UriBuilder.fromPath("https://offersvc.expedia.com/offers/v2/getOffers");
		Map<String, List<String>> queryParameters = new HashMap<>();
		List<String> list = new ArrayList<>();
		list.add("deal-finder");
		queryParameters.put("scenario", list);
		
		list = new ArrayList<>();
		list.add("foo");
		queryParameters.put("page", list);
		
		list = new ArrayList<>();
		list.add("foo");
		queryParameters.put("uid", list);
		
		list = new ArrayList<>();
		list.add("Hotel");
		queryParameters.put("productType", list);
		
		applyQueryParameters(uriBuilder, queryParameters);
		return uriBuilder;
	}
    
    
    private Invocation.Builder createRequestBuilder(WebTarget webTarget) {
		return webTarget.request();
	}
    
    
    private Response sendRequest(Builder requestBuilder, String httpMethod) {
		return requestBuilder.method(httpMethod);
	}
    
    /**
     * Used to add a query parameters to UriBuilder.
     * @param uriBuilder
     * @param queryParameters
     */
    private void applyQueryParameters(UriBuilder uriBuilder, Map<String, List<String>> queryParameters) {
		if (queryParameters.isEmpty()) {
			return;
		}
		for (Entry<String, List<String>> entry : queryParameters.entrySet()) {
			String paramName = entry.getKey();
			List<String> values = entry.getValue();
			if (values == null || values.isEmpty()) {
				continue;
			}
			uriBuilder.queryParam(paramName, values.toArray());
		}
	}
    
    /**
     * getHotelsInfoBean
     * @return
     */
    public static HotelsInfoProject getHotelsInfoBean() {
  		return hotelsInfoBean;
  	}
}
