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
    String numEf; // n일 후 예보
    String tmEf; // 년월일**
    String wf; // 날씨예보**
    String tmn; // 최저온도***
    String tmx; // 최고온도***
    String reliability; // 신뢰도***

}

public class ConnectXml
{
    
    public static void main(String[] args)
    {
	int allCount = 0;
	
	
	// 1. DocumentBuilderFactory 객체생성
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	// ArrayList<KmaData> kmaData;
	ArrayList<KmaData> kmaList = new ArrayList<KmaData>();

	try
	{
	    // 2. DocumentBuilder 객체 생성
	    DocumentBuilder builder = factory.newDocumentBuilder();

	    // DocumentBuilder 객체를 통해 원하는 XML문서의 Document객체를 얻어낸다.
	    // 3. Document 객체 생성
	    // Document doc = builder.parse("./addressbook.xml");
	    Document doc = builder
		    .parse("http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=146");

	    NodeList cityList = doc.getElementsByTagName("city");

	    System.out.println("City Elements 갯수 : " + cityList.getLength());
	    for (int i = 0; i < cityList.getLength(); i++)
	    {
		Node cityNode = cityList.item(i);
		//System.out.println(cityNode.getChildNodes().item(0)
		//	.getNodeValue()); // 부산, 울산, 경남

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
				//System.out.print(data.getChildNodes().item(0).getNodeValue()+ " "); // 부산, 울산, 경남
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
		
		System.out.print("날짜:");
		System.out.print( kmaList.get(i).tmEf + " / ");
		System.out.print("신뢰도:");
		System.out.print( kmaList.get(i).reliability + " / ");
		
		
		System.out.print("최저:");
		System.out.printf("%2d / ", Integer.parseInt(kmaList.get(i).tmn));
		
		System.out.print("최고:");
		System.out.printf("%2d / ", Integer.parseInt(kmaList.get(i).tmx));
		//System.out.print( kmaList.get(i).tmn + " / ");
		//System.out.print( kmaList.get(i).tmx + " / ");
		
		System.out.print( kmaList.get(i).wf + " ");
		
		
		
		System.out.println();
	    }

	    /*
	     * // 4. root Element 얻어오기 Element root = doc.getDocumentElement();
	     * 
	     * System.out.println( "root : " + root.getNodeName() );
	     * 
	     * // 5. NodeList 얻어오기 // 여기에서 주의할점이 있다. // XML문서에서 하위 앨리먼트를 확인하기
	     * 위해서 개행할때에 Text객체가 포함된다. // 따라서 현재는 2개의 앨리먼트만 있지만 Text객체가 3개가 포함되어
	     * 5개가 된다. NodeList list = root.getChildNodes();
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
	     * // root의 자식 앨리먼트중 이름이 "member"인 앨리먼트만을 가지고 온다. list =
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

