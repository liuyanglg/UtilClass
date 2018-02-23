package com.xml.util;

import com.xml.model.SourceXml;
import com.xml.model.SourceXmlList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

public class XmlUtil {

    public static String beanToXml(Object object, Class<?> clazz) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        StringWriter writer = new StringWriter();
        marshaller.marshal(object, writer);
        return writer.toString();
    }

    public static Object xmlToBean(String xmlPath, Class<?> load) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(load);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(new File(xmlPath));
        return object;
    }

    public static void main(String[] args) {
        List<SourceXml> list = new ArrayList<SourceXml>();

        SourceXml source01 = new SourceXml();
        source01.setId(10);
        source01.setName("开票软件");
        source01.setLevel(1);

        SourceXml source02 = new SourceXml();
        source02.setId(11);
        source02.setName("开票软件-百旺");
        source02.setLevel(1);

        SourceXml source11 = new SourceXml();
        source11.setId(30);
        source11.setName("诺诺网");
        source11.setLevel(2);


        SourceXml source12 = new SourceXml();
        source12.setId(31);
        source12.setName("微信未登录");
        source12.setLevel(2);

        SourceXml source13 = new SourceXml();
        source13.setId(33);
        source13.setName("工商信息");
        source13.setLevel(2);

        SourceXml source16 = new SourceXml();
        source16.setId(34);
        source16.setName("能力开通");
        source16.setLevel(2);

        SourceXml source14 = new SourceXml();
        source14.setId(40);
        source14.setName("用户中心");
        source14.setLevel(2);

        SourceXml source15 = new SourceXml();
        source15.setId(99);
        source15.setName("ADMIN");
        source15.setLevel(2);

        SourceXml source21 = new SourceXml();
        source21.setId(12);
        source21.setName("购方信息");
        source21.setLevel(3);

        SourceXml source31 = new SourceXml();
        source31.setId(32);
        source31.setName("微信已登录");
        source31.setLevel(4);

        SourceXml source32 = new SourceXml();
        source32.setId(50);
        source32.setName("请求开票");
        source32.setLevel(4);

        SourceXml source41 = new SourceXml();
        source41.setId(20);
        source41.setName("CRM");
        source41.setLevel(5);

        list.add(source01);
        list.add(source02);
        list.add(source11);
        list.add(source12);
        list.add(source13);
        list.add(source14);
        list.add(source15);
        list.add(source16);
        list.add(source21);
        list.add(source31);
        list.add(source32);
        list.add(source41);

        SourceXmlList xmlList = new SourceXmlList();
        xmlList.setSourceXmlList(list);

        try {
            String xmlString = XmlUtil.beanToXml(xmlList, SourceXmlList.class);
            String xmlPath = "D:/config.xml";
            BufferedWriter bfw = new BufferedWriter(new FileWriter(new File(xmlPath)));
            bfw.write(xmlString);
            bfw.close();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String xmlPath = "D:/config.xml";
           SourceXmlList list1= (SourceXmlList) XmlUtil.xmlToBean(xmlPath,SourceXmlList.class);
            System.out.println(list1.getSourceXmlList());
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
