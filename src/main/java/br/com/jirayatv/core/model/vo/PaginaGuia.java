package br.com.jirayatv.core.model.vo;

import java.util.List;

import br.com.jirayatv.core.model.Programa;


/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class PaginaGuia {

	private int totalPaginas;
	private int pagina;
	private List<Programa> programas;
	
	
	public int getTotalPaginas() {
		return totalPaginas;
	}
	public void setTotalPaginas(int totalPaginas) {
		this.totalPaginas = totalPaginas;
	}
	public int getPagina() {
		return pagina;
	}
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	public List<Programa> getProgramas() {
		return programas;
	}
	public void setProgramas(List<Programa> programas) {
		this.programas = programas;
	}
	
}
