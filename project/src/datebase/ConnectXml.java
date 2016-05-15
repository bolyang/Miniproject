package datebase;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
class KmaData
{
    int data;
    String city;
    String mode;
    String numEf; // n�� �� ����
    String tmEf; // �����**
    String wf; // ��������**
    String tmn; // �����µ�***
    String tmx; // �ְ�µ�***
    String reliability; // �ŷڵ�***

}

public class ConnectXml
{
    
    public static void main(String[] args)
    {
	int allCount = 0;
	
	
	// 1. DocumentBuilderFactory ��ü����
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	// ArrayList<KmaData> kmaData;
	ArrayList<KmaData> kmaList = new ArrayList<KmaData>();

	try
	{
	    // 2. DocumentBuilder ��ü ����
	    DocumentBuilder builder = factory.newDocumentBuilder();

	    // DocumentBuilder ��ü�� ���� ���ϴ� XML������ Document��ü�� ����.
	    // 3. Document ��ü ����
	    // Document doc = builder.parse("./addressbook.xml");
	    Document doc = builder
		    .parse("http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=146");

	    NodeList cityList = doc.getElementsByTagName("city");

	    System.out.println("City Elements ���� : " + cityList.getLength());
	    for (int i = 0; i < cityList.getLength(); i++)
	    {
		Node cityNode = cityList.item(i);
		//System.out.println(cityNode.getChildNodes().item(0)
		//	.getNodeValue()); // �λ�, ���, �泲

		Node Temp = cityNode.getNextSibling();

		while (true)
		{
		    Temp = Temp.getNextSibling();

		    if (Temp == null)
			break;

		    if (Temp.getNodeType() == Node.ELEMENT_NODE)
		    {
			NodeList dataList = Temp.getChildNodes();
			
			KmaData kmaTemp = new KmaData();
			
			kmaTemp.city = cityNode.getChildNodes().item(0).getNodeValue();
			
			for (int j = 0; j < dataList.getLength(); j++)
			{
			    Node data = dataList.item(j);

			    if (data.getNodeType() == Node.ELEMENT_NODE)
			    {
				
				switch(data.getNodeName())
				{
				    case "mode":
					kmaTemp.mode = data.getChildNodes().item(0).getNodeValue();
					break;
					
				    case "tmEf":
					kmaTemp.tmEf = data.getChildNodes().item(0).getNodeValue();
					break;
					
				    case "wf":
					kmaTemp.wf = data.getChildNodes().item(0).getNodeValue();
					break;
					
				    case "tmn":
					kmaTemp.tmn = data.getChildNodes().item(0).getNodeValue();
					break;
					
				    case "tmx":
					kmaTemp.tmx = data.getChildNodes().item(0).getNodeValue();
					break;
					
				    case "reliability":
					kmaTemp.reliability = data.getChildNodes().item(0).getNodeValue();
					break;
					
				}
				
				
				
				
				//kmaTemp.city = "test";
				//System.out.print(data.getNodeName() + " ");
				//System.out.print(data.getChildNodes().item(0).getNodeValue()+ " "); // �λ�, ���, �泲
			    }

			}
			
			kmaList.add(kmaTemp);
			kmaTemp = null;
			//System.out.println("----" + allCount++);
			// System.out.println(Temp.getNodeName());
		    }

		}

	    }

	    for (int i = 0; i < kmaList.size(); i++)
	    {
		System.out.print( kmaList.get(i).city + " / ");
		System.out.print( kmaList.get(i).mode + " / ");
		//System.out.print( kmaList.get(i).numEf + " / ");
		
		System.out.print("��¥:");
		System.out.print( kmaList.get(i).tmEf + " / ");
		System.out.print("�ŷڵ�:");
		System.out.print( kmaList.get(i).reliability + " / ");
		
		
		System.out.print("����:");
		System.out.printf("%2d / ", Integer.parseInt(kmaList.get(i).tmn));
		
		System.out.print("�ְ�:");
		System.out.printf("%2d / ", Integer.parseInt(kmaList.get(i).tmx));
		//System.out.print( kmaList.get(i).tmn + " / ");
		//System.out.print( kmaList.get(i).tmx + " / ");
		
		System.out.print( kmaList.get(i).wf + " ");
		
		
		
		System.out.println();
	    }

	    /*
	     * // 4. root Element ������ Element root = doc.getDocumentElement();
	     * 
	     * System.out.println( "root : " + root.getNodeName() );
	     * 
	     * // 5. NodeList ������ // ���⿡�� ���������� �ִ�. // XML�������� ���� �ٸ���Ʈ�� Ȯ���ϱ�
	     * ���ؼ� �����Ҷ��� Text��ü�� ���Եȴ�. // ���� ����� 2���� �ٸ���Ʈ�� ������ Text��ü�� 3���� ���ԵǾ�
	     * 5���� �ȴ�. NodeList list = root.getChildNodes();
	     * //System.out.println( "list count : " + list.getLength() );
	     * 
	     * 
	     * //Node node = list.item(1);
	     * 
	     * //System.out.println(node.getNodeName());
	     * //node.getNextSibling();
	     * 
	     * 
	     * 
	     * for( int i = 0; i < list.getLength(); i ++ ) { Node node =
	     * list.item(i);
	     * 
	     * //System.out.println(i); System.out.println( "node[" + (i+1) +
	     * "]:" + node.getNodeName() ); }
	     * 
	     * // root�� �ڽ� �ٸ���Ʈ�� �̸��� "member"�� �ٸ���Ʈ���� ������ �´�. list =
	     * root.getElementsByTagName( "name" ); System.out.println(
	     * "tag name list count : " + list.getLength() );
	     * 
	     * for( int i = 0; i < list.getLength(); i ++ ) { Node node =
	     * list.item(i); System.out.println( "node[" + (i+1) + "]:" +
	     * node.getNodeName() );
	     * 
	     * NodeList child = node.getChildNodes(); for(int j = 0 ; j <
	     * child.getLength() ; j++) { Node childNode = child.item(j);
	     * System.out.println("---------" + childNode.getNodeValue()); }
	     * 
	     * }
	     */

	} catch (Exception e)
	{
	    e.printStackTrace();
	}
    }
}

