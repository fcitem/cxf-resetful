package com.message.ws.client;

import javax.xml.namespace.QName;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.message.ws.service.SendResult;

public class TestClient {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf
                .createClient("http://localhost:8080/message-ws/tw_wsserver/ResultServicesServerImpl?wsdl");
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
	
	@Test 
	public void testStaticInvoke(){
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        // 判断是否抛出异常
        factory.getOutInterceptors().add(new LoggingInInterceptor());
        // 注册webservice接口
        factory.setServiceClass(SendResult.class);
        // 配置webservice地址
        factory.setAddress("http://localhost:8081/tw_wsserver/ResultServicesServerImpl?wsdl");
        // 获得接口对象
        SendResult service = (SendResult) factory.create();
        // 调用接口方法
        String result = service.ReplyResult("<?xml version=\"1.0\" encoding=\"UTF-8\"?> <REQUEST><CalledId>343434</CalledId> <EXTCode>07</EXTCode> <Result>1</Result> </REQUEST>");
        System.out.println("调用结果:" + result);
        System.exit(0);
	}
	@Test
	public void we(){
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf
                .createClient("http://192.168.1.105:8787/tw_wsserver/ExternalServicesServerImpl?wsdl");
        QName name = new QName("http://services", "SendShortMsg");
        StringBuilder str=new StringBuilder();
        str.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        str.append("<REQUEST>");
		// 接收方号码
		str.append("<CalledId>").append("1378047962").append("</CalledId>");
		str.append("<Content>").append("好好睡觉的").append("</Content>"); // 短信内容
		str.append("<EXTCode>").append("07").append("</EXTCode>");
//		str.append("<Result>").append("1").append("</Result>");
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
