package com.message.ws.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.message.ws.service.SendResult;

/**开放短信回复接口与短信发送结果接口
 * @author fengchao
 * @data 2017年6月9日
 */
public class SendResusltImpl implements SendResult {

	@Override
	@GET
	@Path("/cxf/test/username@{name}&password||{pwd}")
	@Consumes({"application/json","application/xml"})       //说明接收的数据类型
	@Produces({"application/json"})              //说明返回类型的数据类型
	public String UpdateResult(@PathParam("name") String username,@PathParam("name") String password) {
		
		return username+" "+password;
	}

	@Override
	public String ReplyResult(String request) {
		// TODO Auto-generated method stub
		return null;
	}

}
