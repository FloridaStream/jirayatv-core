package br.com.jirayatv.core.ws.consumer;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class WsProxy {

	
	private String host;
	private Integer port;
	private String username;
	private String password;
	
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEmpty(){
		return ( this.host == null || "".equals(this.host) ) &&
			   this.port == null &&
			   ( this.username == null || "".equals(this.username) ) &&
			   ( this.password == null || "".equals(this.password) );
	}
	
}
