package com.myblog;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ControllerSupport {

	public Map<String, Object> newModel(HttpServletRequest re) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("contextPath", re.getContextPath());
		return map;
	}
}
