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
			// XML DOCUMENT ȹ��
			xml = documentBuilder.parse("http://web.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108");
			// Root������Ʈ ȹ��
			Element element = xml.getDocumentElement();
			// Root������Ʈ�� channel �ڽ��±״� 1���̹Ƿ� item(0)���� ȹ��
			Node channelNode = element.getElementsByTagName("channel").item(0);
			// channel�±׳��� �����ϴ� �ڽ��±� ȹ��
			NodeList list = channelNode.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				// image,link,title.. ������ �±� �� item �±׸� ȹ��
				if (list.item(i).getNodeName().equals("item")) {
					// item �±��� �ڽĳ�� ȹ��
					NodeList list2 = list.item(i).getChildNodes();
					for (int j = 0; j < list2.getLength(); j++) {
						// �ڽ��±װ� title/description�ϰ�쿡�� �±׸� + ���� ���
						if (list2.item(j).getNodeName().equals("title")
								|| list2.item(j).getNodeName()
										.equals("description")) {
							String content = list2.item(j).getTextContent();
							// �ٹٲ��� �Ǿ������Ƿ� \n replaceall
							content = content.replaceAll("\n", "");

							System.out
									.println("========== ��½��� =================");
							System.out.println("name:"
									+ list2.item(j).getNodeName());
							System.out.println("value:" + content);
							System.out
									.println("========== ������� =================");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}