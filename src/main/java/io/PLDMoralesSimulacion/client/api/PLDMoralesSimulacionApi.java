package io.PLDMoralesSimulacion.client.api;

import io.PLDMoralesSimulacion.client.ApiClient;
import io.PLDMoralesSimulacion.client.ApiException;
import io.PLDMoralesSimulacion.client.ApiResponse;
import io.PLDMoralesSimulacion.client.Configuration;
import io.PLDMoralesSimulacion.client.Pair;
import io.PLDMoralesSimulacion.client.ProgressRequestBody;
import io.PLDMoralesSimulacion.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import io.PLDMoralesSimulacion.client.model.Peticion;
import io.PLDMoralesSimulacion.client.model.Respuesta;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PLDMoralesSimulacionApi {
    private ApiClient apiClient;
    public PLDMoralesSimulacionApi() {
        this(Configuration.getDefaultApiClient());
    }
    public PLDMoralesSimulacionApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public ApiClient getApiClient() {
        return apiClient;
    }
    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    public okhttp3.Call getPLDPmCall(String xApiKey, Peticion body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        String localVarPath = "";
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "*/*"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    private okhttp3.Call getPLDPmValidateBeforeCall(String xApiKey, Peticion body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling getPLDPm(Async)");
        }
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling getPLDPm(Async)");
        }
        
        okhttp3.Call call = getPLDPmCall(xApiKey, body, progressListener, progressRequestListener);
        return call;
    }
    
    public Respuesta getPLDPm(String xApiKey, Peticion body) throws ApiException {
        ApiResponse<Respuesta> resp = getPLDPmWithHttpInfo(xApiKey, body);
        return resp.getData();
    }
    
    public ApiResponse<Respuesta> getPLDPmWithHttpInfo(String xApiKey, Peticion body) throws ApiException {
        okhttp3.Call call = getPLDPmValidateBeforeCall(xApiKey, body, null, null);
        Type localVarReturnType = new TypeToken<Respuesta>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

}
