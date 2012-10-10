package br.com.jirayatv.core.impl;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import br.com.jirayatv.core.converter.ModelConverter;
import br.com.jirayatv.core.converter.impl.ModelConverterImpl;
import br.com.jirayatv.core.impl.ModelConverterImplTest;
import br.com.jirayatv.core.model.Guia;
import br.com.jirayatv.core.xml.model.Tv;
import br.com.object2x.O2x;
import br.com.object2x.impl.O2xBuilder;
import br.com.object2x.impl.O2xType;


/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class ModelConverterImplTest {
	private static final Log LOG = LogFactory.getLog(ModelConverterImplTest.class);
	@Test
	public void testConvert() {
		LOG.info("Iniciando o teste");
		O2xBuilder builder = new O2xBuilder(O2xType.XML);
		builder.setEncode("ISO-8859-1");
		O2x o2x = builder.createO2x();
		URL url = ClassLoader.getSystemResource("teste.xml");
		try {
			InputStream inXml = new FileInputStream( new File(url.toURI()));
			LOG.info("XML SIZE = " + inXml.available() / 1024.0 /1024.0 + " MB");
			LOG.info("Deserialisando o xml");
			Tv tv = o2x.deserialize(inXml, Tv.class);
			ModelConverter m = new ModelConverterImpl();
			LOG.info("Convertendo xmlTv para jsonTv");
			Guia g = m.convert(tv);
			assertNotNull(g);
			o2x = new O2xBuilder(O2xType.JSON).createO2x();
			String s = o2x.serializeString(g);
			InputStream inJson = o2x.serializeInputStream(g);
			LOG.info("JSON SIZE = " + inJson.available() / 1024.0 /1024.0 + " MB");
			LOG.info("fim dos testes");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			System.out.println("Periodo de: " + sdf.format(g.getInicio()) + " at�: " + sdf.format(g.getFim()) ) ;
			
		}catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}

}
