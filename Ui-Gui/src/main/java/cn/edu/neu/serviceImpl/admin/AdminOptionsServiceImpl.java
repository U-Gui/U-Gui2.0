package cn.edu.neu.serviceImpl.admin;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.neu.entity.Admin;
import cn.edu.neu.mapper.admin.AdminOptionsMapper;
import cn.edu.neu.service.admin.AdminOptionsService;
import cn.edu.neu.util.ShaEncryptUtil;
import cn.edu.neu.vo.backJSON;

@Service
public class AdminOptionsServiceImpl implements AdminOptionsService{

	@Autowired
	private AdminOptionsMapper adminOptionsMapper;
	
	public backJSON findAdmin(String adminId, String adminPassword) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		adminPassword = ShaEncryptUtil.shaEncrypt(adminPassword);
		Admin admin = adminOptionsMapper.findAdmin(adminId,adminPassword);
		if(admin!=null) {
			return new backJSON(200,admin);
		}else {
			return new backJSON(2222,"信息验证失败，请重新登录！");
		}
	}
	
}
