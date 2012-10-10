package br.com.jirayatv.core.model;

import java.util.Date;
import java.util.List;


/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class Guia {

	private Date inicio;
	private Date fim;
	private List<Canal> canais;
	private List<Programa> programas;
	
	
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	public List<Canal> getCanais() {
		return canais;
	}
	public void setCanais(List<Canal> canais) {
		this.canais = canais;
	}
	public List<Programa> getProgramas() {
		return programas;
	}
	public void setProgramas(List<Programa> programas) {
		this.programas = programas;
	}
	
	
}
