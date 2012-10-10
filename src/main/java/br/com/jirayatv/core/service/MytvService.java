package br.com.jirayatv.core.service;

import br.com.jirayatv.core.model.Canal;
import br.com.jirayatv.core.model.Programa;



/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public interface MytvService<T> {

	/**
	 * Pega um programa pelo seu id.
	 * @param idPrograma id do programa.
	 * @return Programa
	 */
	public Programa getProgramaById(String idPrograma);
	
	
	/**
	 * Pega um canal pelo seu id.
	 * @param id do canal.
	 * @return Canal.
	 */
	public Canal getCanalById(String idCanal);
	
	
	
	public void save(T obj);
	
	
}
