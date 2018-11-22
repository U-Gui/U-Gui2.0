package cn.edu.neu.util;

import java.io.IOException;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

/**
 * 打开柜子工具类
 * 连接硬件端服务器，执行shell
 * @author bc
 * @date 2018年11月19日
 */
public class OpenBox {

	//根据柜子id打开柜子
	public static boolean openBox(int boxid) {
		boolean flag = false;
		Connection conn = null;
		Session session = null;
		String cmd = "cd /home/open; ./ch "+boxid;	//开柜子命令
		try {
			conn = new Connection(Value.getBoxopenurl());  
			conn.connect();
			if(conn.authenticateWithPassword(Value.getBoxopenuser(), Value.getBoxopenpassword())) {
				session = conn.openSession();
				session.execCommand(cmd);
				flag = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
			if(conn!=null)
				conn.close();
		}
		return flag;
	}
	
}
