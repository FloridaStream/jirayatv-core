package br.com.jirayatv.core.converter;

import br.com.jirayatv.core.model.Guia;
import br.com.jirayatv.core.xml.model.Tv;


/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public interface ModelConverter {

	/**
	 * 
	 * @param tv
	 * @return
	 */
	public Guia convert(Tv tv);
	
	
}
