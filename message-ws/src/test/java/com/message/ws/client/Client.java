package com.message.ws.client;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class Client {

	public static void main(String[] args) {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf
                .createClient("http://localhost:8081/tw_wsserver/ResultServicesServerImpl?wsdl");
        // url为调用webService的wsdl地址
        QName name = new QName("http://services.sms.com", "ReplyResult");
        // namespace是命名空间，methodName是方法名
        StringBuilder str=new StringBuilder();
        str.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        str.append("<REQUEST>");
		// 接收方号码
		str.append("<CalledId>").append("1378047962").append("</CalledId>");
//		str.append("<Content>").append("好好睡觉的").append("</Content>"); // 短信内容
		str.append("<EXTCode>").append("07").append("</EXTCode>");
		str.append("<Result>").append("1").append("</Result>");
		str.append("</REQUEST>");
        // paramvalue为参数值
        Object[] objects;
        try {
            objects = client.invoke(name, str.toString());
            System.out.println(objects[0].toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
