package br.com.jirayatv.core.model;


/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class Canal extends BaseModel{

	private I18N linguagem;
	private String nome;
	private Integer numero;
	private String srcIcon;
	
	
	public I18N getLinguagem() {
		return linguagem;
	}
	public void setLinguagem(I18N linguagem) {
		this.linguagem = linguagem;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getSrcIcon() {
		return srcIcon;
	}
	public void setSrcIcon(String srcIcon) {
		this.srcIcon = srcIcon;
	}
}
