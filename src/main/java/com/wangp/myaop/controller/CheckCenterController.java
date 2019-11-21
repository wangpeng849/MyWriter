package com.wangp.myaop.controller;

import com.wangp.myaop.entity.ApiReturnObject;
import com.wangp.myaop.entity.JsonResult;
import com.wangp.myaop.entity.RusultObject;
import com.wangp.myaop.entity.User;
import com.wangp.myaop.util.ApiReturnUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Api("客服接口")
@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {

	// 创建线程安全的Map
	static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

	@ApiOperation(value="获取客服", notes="根据cid获取客服")
    @ApiImplicitParam(name = "cid", value = "客户id", required = true, dataType = "String")
	@ResponseBody
	@GetMapping("/getCenter")
	public ApiReturnObject getCenter(String cid) {
		Map<String,String> map=new LinkedHashMap<String,String>();
		map.put("cid",cid);
		map.put("name","客服");
		return ApiReturnUtil.success(map);
	}

	@ApiOperation(value="获取客服", notes="根据cid获取客服")
    @ApiImplicitParam(name = "cid", value = "客户id", required = true, dataType = "String")
	@ResponseBody
	@PostMapping("/getCenter/{cid}")
	public ApiReturnObject getCenter2(@PathVariable String cid) {
		Map<String,String> map=new LinkedHashMap<String,String>();
		map.put("cid",cid);
		map.put("name","客服");
		return ApiReturnUtil.success(map);
	}


//	@ApiOperation(value="测试接口api", notes="根据cid获取客服信息，this is test api")
//    @ApiImplicitParam(name = "cid", value = "客户id", required = true, dataType = "String")
//	@ResponseBody
//	@PostMapping("/getCenter/{cid}")
//	public ResponseEntity<RusultObject> getCinterCall(@PathVariable String cid) {
//		RusultObject ret=new RusultObject();
//		Map<String,String> map=new LinkedHashMap<String,String>();
//		map.put("cid",cid);
//		map.put("name","客服");
//		ret.setResult(map);
//		ret.setStatus("ok");
//		return new ResponseEntity<RusultObject>(ret, HttpStatus.OK);
//	}

	/**
	 * 查询用户列表
	 * @return
	 */
	@ApiOperation(value="获取用户列表", notes="获取用户列表")
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getUserList (){
		JsonResult r = new JsonResult();
		try {
			//List<User> userList = new ArrayList<User>(users.values());
			Map<String,String> map=new LinkedHashMap<String,String>();
			map.put("aa", "小红");
			map.put("bb", "小明");
			r.setResult(map);
			r.setStatus("ok");
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}

}