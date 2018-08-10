package cn.edu.neu.mapper.admin;

import cn.edu.neu.entity.Admin;

public interface AdminOptionsMapper {

	public Admin findAdmin(String adminId, String adminPassword);
	
}
