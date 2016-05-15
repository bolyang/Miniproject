package datebase;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ConnectXml {
	public static void main(String ar[]) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory
					.newDocumentBuilder();
			Document xml = null;
			// XML DOCUMENT 획득
			xml = documentBuilder.parse("http://web.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108");
			// Root엘리먼트 획득
			Element element = xml.getDocumentElement();
			// Root엘리먼트의 channel 자식태그는 1개이므로 item(0)으로 획득
			Node channelNode = element.getElementsByTagName("channel").item(0);
			// channel태그내에 존재하는 자식태그 획득
			NodeList list = channelNode.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				// image,link,title.. 여러개 태그 중 item 태그만 획득
				if (list.item(i).getNodeName().equals("item")) {
					// item 태그의 자식노드 획득
					NodeList list2 = list.item(i).getChildNodes();
					for (int j = 0; j < list2.getLength(); j++) {
						// 자식태그가 title/description일경우에만 태그명 + 값을 출력
						if (list2.item(j).getNodeName().equals("title")
								|| list2.item(j).getNodeName()
										.equals("description")) {
							String content = list2.item(j).getTextContent();
							// 줄바꿈이 되어있으므로 \n replaceall
							content = content.replaceAll("\n", "");

							System.out
									.println("========== 출력시작 =================");
							System.out.println("name:"
									+ list2.item(j).getNodeName());
							System.out.println("value:" + content);
							System.out
									.println("========== 출력종료 =================");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}