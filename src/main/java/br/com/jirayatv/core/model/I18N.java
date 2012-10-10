package br.com.jirayatv.core.model;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public enum I18N {

	
	PT, EN, ES, UNKNOWN;
	
	public	static I18N getLinguagemByName(String name){
		if (PT.name().equalsIgnoreCase(name)){
			return PT;
		}else if (EN.name().equalsIgnoreCase(name)){
			return EN;
		}else if (ES.name().equalsIgnoreCase(name)){
			return ES;
		}
		
		return UNKNOWN;
	}
	
}


