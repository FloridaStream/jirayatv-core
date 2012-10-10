package br.com.jirayatv.core.ws.consumer;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import br.com.jirayatv.core.ws.consumer.WsUtils;
import br.com.jirayatv.core.ws.consumer.exception.WsException;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class WsUtilsTest {

	@Test
	public void testMakePostRequest() {
		try {
			InputStream in = WsUtils.makePostRequest("http://www.deanclatworthy.com");
			assertNotNull(in);
		} catch (WsException e) {
			fail("Erro: " + e.getMessage());
		}
	}
	
	@Test
	public void testMakePostRequestWithUrlParam() {
		try {
			InputStream in = WsUtils.makePostRequest("https://accounts.google.com/ServiceLoginAuth", "");
			assertNotNull(in);
		} catch (WsException e) {
			fail("Erro: " + e.getMessage());
		}
	}
	
	
	@Test
	public void testMakePostRequestWithParam() {
		try {
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("q", "teste");
			InputStream in = WsUtils.makePostRequest("https://accounts.google.com/ServiceLoginAuth", params);
			assertNotNull(in);
		} catch (WsException e) {
			fail("Erro: " + e.getMessage());
		}
	}
	


	@Test
	public void testMakeGetRequest() {
		try {
			InputStream in = WsUtils.makeGetRequest("http://www.deanclatworthy.com");
			assertNotNull(in);
		} catch (WsException e) {
			fail("Erro: " + e.getMessage());
		}
	}

	
	@Test
	public void testMakeGetRequestWithUrlParam() {
		try {
			InputStream in = WsUtils.makeGetRequest("http://www.deanclatworthy.com","imdb");
			assertNotNull(in);
		} catch (WsException e) {
			fail("Erro: " + e.getMessage());
		}
	}
	
	@Test
	public void testMakeGetRequestWithParam() {
		try {
			Map<String,String> params = new HashMap<String,String>();
			params.put("q", "The + Spider");
			InputStream in = WsUtils.makeGetRequest("http://www.deanclatworthy.com/imdb",params);
			assertNotNull(in);
		} catch (WsException e) {
			fail("Erro: " + e.getMessage());
		}
	}
	
	
	@Test
	public void testMakeGetRequestError() {
		try {
			WsUtils.makeGetRequest("http://www.fdahuifdshuifsdahuifas.com");
			fail("Erro: Não era pra retornar 200");
		} catch (WsException e) {
			assertNotNull(e);
		}
	}

	
	
}
