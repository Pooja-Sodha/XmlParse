package com.parsexml.cd;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Service
public class CdServicesImpl implements CdServices {

	@Override
	public List<CdDto> getCdList() {
		List<CdDto> cdlist=new ArrayList<CdDto>();
		try {
			String fileName = "cd.xml";
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();

			File fXmlFile = new File(classLoader.getResource(fileName).getFile());// File fXmlFile = new
																					// File("C:\\Users\\PoojaSagar\\Downloads\\Spring-Boot-REST\\Spring-Boot-REST\\src\\main\\resources\\static");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
					
			NodeList nList = doc.getElementsByTagName("cd");
					
			System.out.println("----------------------------");
			CdDto cdDto=new CdDto();
			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
						
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
						
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					cdDto.setArtist(eElement.getElementsByTagName("name").item(0).getTextContent());
					cdDto.setArtist(eElement.getElementsByTagName("artist").item(0).getTextContent());
					cdDto.setArtist(eElement.getElementsByTagName("title").item(0).getTextContent());
					cdDto.setArtist(eElement.getElementsByTagName("price").item(0).getTextContent());
					cdDto.setArtist(eElement.getElementsByTagName("publish_date").item(0).getTextContent());
					cdlist.add(cdDto);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cdlist;
	}
	

}