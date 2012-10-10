package br.com.jirayatv.core;

import java.io.File;
import java.net.URL;

import junit.framework.Assert;

import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import br.com.jirayatv.core.xml.model.Tv;
import br.com.object2x.O2x;
import br.com.object2x.impl.O2xBuilder;
import br.com.object2x.impl.O2xType;

/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class TestTransf {

	private static final org.apache.commons.logging.Log LOG = LogFactory.getLog(TestTransf.class);
	@Test
	public void testTransform(){
		LOG.debug("Iniciando testes..........");
		O2xBuilder builder = new O2xBuilder(O2xType.XML);
		builder.setEncode("ISO-8859-1");
		O2x o2x = builder.createO2x();
		URL url = ClassLoader.getSystemResource("teste.xml");
		try {
			File fileXml = new File(url.toURI());
			Tv tv = o2x.deserialize(fileXml, Tv.class);
			
			String serialize = o2x.serializeString(tv);
			Tv tv2 = o2x.deserialize(serialize, Tv.class);
			Assert.assertEquals(tv, tv2);
			LOG.debug("Fim dos testes..........");
			LOG.debug("transformando pra json..........");
			O2xBuilder builderjson = new O2xBuilder(O2xType.JSON);
			o2x =builderjson.createO2x();
			//String in = o2x.serializeString(tv);
			/*FileOutputStream file = new FileOutputStream(new File("c:\\tmp\\jsontv.json"));
			IOUtils.write(in, file);*/
			LOG.debug("fim do transform..........");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
}
