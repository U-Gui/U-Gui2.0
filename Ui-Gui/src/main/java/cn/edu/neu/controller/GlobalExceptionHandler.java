package cn.edu.neu.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * 接收全局异常，记录进日志
 * @author bc
 * @date 2018年11月27日
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		logger.error(e, e.fillInStackTrace());
		return "redirect:/index.jsp";
	}
	
}
