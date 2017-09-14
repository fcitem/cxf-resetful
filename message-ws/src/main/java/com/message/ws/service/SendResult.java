package com.message.ws.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
@Produces({"application/json","application/xml"})  
public interface SendResult {

	/**
	 * @author fengchao
	 * @data 2017年5月28日
	 * @注释 接收短信发送结果的接口
	 * @param request 请求参数 
	 * 示例  <?xml version="1.0" encoding="UTF-8"?>
	 * <REQUEST>
	 * <CalledId></CalledId><EXTCode></EXTCode><Result></Result>
	 * </REQUEST>
	 */
	@GET
	@Path("/cxf/test/{id}")
	@Consumes({"application/json","application/xml"})
	public String UpdateResult(@PathParam("name") String username,@PathParam("name") String password);
	
	/**
	 * @author fengchao
	 * @data 2017年5月28日
	 * @注释 接收短信回复接口
	 */
	public String ReplyResult(String request);
}
