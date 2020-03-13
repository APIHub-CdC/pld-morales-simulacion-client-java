package io.PLDMoralesSimulacion.client.api;

import io.PLDMoralesSimulacion.client.ApiClient;
import io.PLDMoralesSimulacion.client.api.ApiTest;
import io.PLDMoralesSimulacion.client.ApiException;
import io.PLDMoralesSimulacion.client.model.Peticion;
import io.PLDMoralesSimulacion.client.model.Respuesta;
import okhttp3.OkHttpClient;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

public class ApiTest {
	
    private final PLDMoralesSimulacionApi api = new PLDMoralesSimulacionApi();
	private Logger logger = LoggerFactory.getLogger(ApiTest.class.getName());
	private ApiClient apiClient = null;
    
	@Before()
	public void setUp() {
		this.apiClient = api.getApiClient();
		this.apiClient.setBasePath("the_url");
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
		apiClient.setHttpClient(okHttpClient);
	}
    
    @Test
    public void getPLDPmTest() throws ApiException {
    	
    	String xApiKey = "your_api_key";
        
        Peticion peticion = new Peticion();
        peticion.setRazonSocial("EMPRESA SA DE CV");
        
		try {
			Respuesta response = api.getPLDPm(xApiKey, peticion);
	        Assert.assertTrue(response != null);
	        if(response != null) {
	        	logger.info(response.toString());
	        }
		} catch (ApiException e) {
			logger.info(e.getResponseBody());
		}
    }
    
}