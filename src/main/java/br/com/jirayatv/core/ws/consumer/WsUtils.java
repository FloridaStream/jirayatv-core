package br.com.jirayatv.core.ws.consumer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;

import br.com.jirayatv.core.ws.consumer.exception.WsException;
import br.com.object2x.O2x;
import br.com.object2x.exception.O2xTransformException;
import br.com.object2x.impl.O2xBuilder;
import br.com.object2x.impl.O2xType;



/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class WsUtils {

	private static final Log LOG = LogFactory.getLog(WsUtils.class);
	private static final DefaultHttpClient client = new DefaultHttpClient();
	
	static{
		try {
			O2xBuilder o2xBuilder = new O2xBuilder(O2xType.JSON);
			O2x o2x = o2xBuilder.createO2x();
			InputStream json = ClassLoader.getSystemResourceAsStream("proxy.json");
			
			if (json != null && json.available() > 0){
				WsProxy wsProxy = o2x.deserialize(json, WsProxy.class);
				if (wsProxy != null && !wsProxy.isEmpty()){
					HttpHost proxy = new HttpHost(wsProxy.getHost(), wsProxy.getPort());
					client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
					client.getCredentialsProvider().setCredentials(AuthScope.ANY,new UsernamePasswordCredentials(wsProxy.getUsername(),wsProxy.getPassword()));
				}
			}
			
		} catch (O2xTransformException e) {
			LOG.error("Erro ao ler a properties do proxy", e);
		} catch (IOException e) {
			LOG.error("Erro ao ler a properties do proxy", e);
		}
	}
	
	
	/**
	 * 
	 * @param url
	 * @return
	 * @throws WsException
	 */
	public static InputStream makePostRequest(String url) throws WsException{
		return makePostRequest(url, "");
	}
	
	
	/**
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws WsException
	 */
	public static InputStream makePostRequest(String url, Map<String, Object> params) throws WsException{
			HttpPost request = new HttpPost(url);
			try {
				if (params != null){
					for (String key : params.keySet()){
						request.getParams().setParameter(key, params.get(key));
					}
				}
				HttpResponse response = client.execute(request);
				
				hasError(response);
				
				hasBusinessError(response);
				
				return response.getEntity().getContent();
			} catch (ClientProtocolException e) {
				throw new WsException(HttpStatus.SC_NOT_FOUND, e.getMessage());
			} catch (IOException e) {
				throw new WsException(HttpStatus.SC_NOT_FOUND, e.getMessage());
			} finally{
				request.releaseConnection();
			}
	}
	
	
	private static void hasError(HttpResponse response) throws WsException, IOException {
		String statusCode = String.valueOf(response.getStatusLine().getStatusCode());
		
		if (isError(statusCode) || isRedirection(statusCode)){
			throw new WsException(Integer.valueOf(statusCode),"Pagina não encontrada.");
		}
	}
	
	private static void hasBusinessError(HttpResponse response) throws WsException, IOException {
		String statusCode = String.valueOf(response.getStatusLine().getStatusCode());
		
		if (isServerError(statusCode)){
			throw new WsException(Integer.valueOf(statusCode),"Business Error", response.getEntity().getContent());
		}
	}


	private static boolean isServerError(String statusCode) {
		return checkCode(statusCode, 5);
	}
	private static boolean isError(String statusCode) {
		return checkCode(statusCode, 4);
	}
	private static boolean isRedirection(String statusCode) {
		return checkCode(statusCode, 3);
	}

	private static boolean checkCode(String statusCode, int start){
		Pattern p = Pattern.compile("^"+ start + "[0-9]+");
		Matcher  m = p.matcher(statusCode);
		return m.find();
	}

	/**
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws WsException
	 */
	public static InputStream makePostRequest(String url, String ... params) throws WsException{
			HttpPost request = new HttpPost(url + parseParam(params));
			try {
				HttpResponse response = client.execute(request);
				
				hasError(response);
				
				hasBusinessError(response);
				
				return response.getEntity().getContent();
			} catch (ClientProtocolException e) {
				throw new WsException(HttpStatus.SC_NOT_FOUND, e.getMessage());
			} catch (IOException e) {
				throw new WsException(HttpStatus.SC_NOT_FOUND, e.getMessage());
			} finally{
				request.releaseConnection();
			}
	}
	
	
	
	/**
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static InputStream makeGetRequest(String url, Map<String,String> params) throws WsException{
		return makeGetRequest(url + parseParam(params));
	}
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	public static InputStream makeGetRequest(String url) throws WsException{
		return makeGetRequest(url,"");
	}
	
	/**
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static InputStream makeGetRequest(String url, String... params) throws WsException{
		HttpGet request = new HttpGet(url + parseParam(params));
		try {
			HttpResponse response = client.execute(request);
			
			hasError(response);
			
			hasBusinessError(response);
			
			return response.getEntity().getContent();
		} catch (ClientProtocolException e) {
			throw new WsException(HttpStatus.SC_NOT_FOUND, e.getMessage());
		} catch (IOException e) {
			throw new WsException(HttpStatus.SC_NOT_FOUND, e.getMessage());
		} finally{
			request.releaseConnection();
		}
	}
	
	
	private static String parseParam(String[] params) {
		String urlParam = "";
		if (containsParam(params)){
			urlParam = "/";
			for (int i = 0; i < params.length; i++) {
				if (!"".equals(params[i])){
					urlParam += params[i] + "/";
				}
			}
		}
		return urlParam;
	}


	private static boolean containsParam(String[] params) {
		return params != null && params.length > 0 && !"".equals(params[0]) ;
	}
	
	
	private static String parseParam(Map<String,String> params) {
		String urlParam = "/?";
		if (params != null){
			int c = 0;
			for (String key : params.keySet()){
				c++;
				urlParam += key + "=" + scapeSpace(params.get(key)) +  ( c < params.size() ? "&" : "" );
			}
		}
		return urlParam;
	}


	private static String scapeSpace(String param) {
		return param.replaceAll(" ", "%20");
	}

	
	
}
