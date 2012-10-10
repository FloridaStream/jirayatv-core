package br.com.jirayatv.core.service;

import java.util.Date;

import br.com.jirayatv.core.model.vo.PaginaGuia;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public interface MytvSearchableService {

	
	/**
	 * Procura dentro de programas o argumento informado.<br>
	 * Podendo conter em nome do canal, descricao, autor, titulo, subtitulo e outros.
	 * @param args
	 * @return Lista de programas encontrados
	 */
	public PaginaGuia findPrograma(String args);
	
	/**
	 * Busca programas em um determinado periodo de acordo com o argumento informado.
	 * @param inicio periodo inicial
	 * @param fim periodo final
	 * @param args Argumento da pesquisa.
	 * @return Lista de programas encontrados.
	 */
	public PaginaGuia findPrograma(Date inicio, Date fim, String args);
	
	
	/**
	 * Busca programas de um determinado canal de acordo com o argumento informado.
	 * @param idCanal id do canal
	 * @param args Argumento da pesquisa
	 * @return Lista de programas encontrados.
	 */
	public PaginaGuia findPrograma(String idCanal, String args);
	
	
	/**
	 * Busca programas de um canal em um determinado periodo
	 * @param idCanal id do canal
	 * @param inicio data inicio
	 * @param fim data final
	 * @return
	 */
	public PaginaGuia findPrograma(String idCanal, Date inicio, Date fim);
	
	
	/**
	 * Busca programas em um determinado periodo.
	 * @param inicio data inicio
	 * @param fim data final
	 * @return PaginaGuia
	 */
	public PaginaGuia findPrograma(Date inicio, Date fim);
	
	
}
