package com.wangp.myaop.util;

import com.wangp.myaop.entity.ApiReturnObject;

import java.util.Map;

public class ApiReturnUtil {

	public static ApiReturnObject success(Map<String, String> map) {
		return (ApiReturnObject) map;
	}

}