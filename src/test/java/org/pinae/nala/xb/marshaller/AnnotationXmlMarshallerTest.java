package org.pinae.nala.xb.marshaller;

import java.io.IOException;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.pinae.nala.xb.NalaTestConstant;
import org.pinae.nala.xb.data.annotation.People;
import org.pinae.nala.xb.data.annotation.PersonOne;
import org.pinae.nala.xb.exception.MarshalException;
import org.pinae.nala.xb.exception.NoSuchPathException;
import org.pinae.nala.xb.marshal.Marshaller;
import org.pinae.nala.xb.marshal.XmlMarshaller;
import org.pinae.nala.xb.util.ResourceWriter;

/**
 * AnnotationMarshaller单元测试
 * 
 * @author Huiyugeng
 */
public class AnnotationXmlMarshallerTest extends TestCase {
	private static final Logger log = Logger.getLogger(AnnotationXmlMarshallerTest.class);
	
	private People people = new People();
	
	public void setUp(){
		people.setPerson(PersonOne.getObject());
	}
	
	/**
	 * 测试从带注释的对象生成XML文件(编组)
	 */
	public void testMarshal() {

		Marshaller marshaller = new XmlMarshaller(people);

		marshaller.setDocumentStart("<?xml version='1.0' encoding='gb2312'?>");
		try {
			new ResourceWriter().writeToFile(marshaller.marshal(), NalaTestConstant.OUTPUT_XMLFILE);
			log.debug(marshaller.marshal());
		} catch (NoSuchPathException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		} catch (MarshalException e) {
			fail(e.getMessage());
		}
		
	}
}
