package br.com.jirayatv.core.model;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class Programa extends BaseModel{

	
	private Date inicio;
	private Date fim;
	private String idCanal;
	private List<Titulo> titulos;
	private String descricao;
	private List<Categoria> categorias;
	private String pais;
	private Classificacao classificacao;
	private Titulo subTitulo;
	private String epsodio;
	private List<String> atores;
	private List<String> diretores;
	private String ano;
	private String starClassificacao;
	
	
	
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
	public String getIdCanal() {
		return idCanal;
	}
	public void setIdCanal(String idCanal) {
		this.idCanal = idCanal;
	}
	public List<Titulo> getTitulos() {
		return titulos;
	}
	public void setTitulos(List<Titulo> titulos) {
		this.titulos = titulos;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Classificacao getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}
	public Titulo getSubTitulo() {
		return subTitulo;
	}
	public void setSubTitulo(Titulo subTitulo) {
		this.subTitulo = subTitulo;
	}
	public String getEpsodio() {
		return epsodio;
	}
	public void setEpsodio(String epsodio) {
		this.epsodio = epsodio;
	}
	public List<String> getAtores() {
		return atores;
	}
	public void setAtores(List<String> atores) {
		this.atores = atores;
	}
	public List<String> getDiretores() {
		return diretores;
	}
	public void setDiretores(List<String> diretores) {
		this.diretores = diretores;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getStarClassificacao() {
		return starClassificacao;
	}
	public void setStarClassificacao(String starClassificacao) {
		this.starClassificacao = starClassificacao;
	}
	
}
