package cn.edu.neu.util;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import cn.edu.neu.entity.Admin;

public class UserInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null ;
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin==null) {
			JSONObject res = new JSONObject();
			res.put("code", 1100);
		    res.put("data", "权限认证失败，请重新登录！");
		    out = response.getWriter();
		    out.append(res.toString());
			return false;
		}else{	
			return true;
		}
	}

}
