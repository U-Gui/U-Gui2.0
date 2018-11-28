package cn.edu.neu.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;

import cn.edu.neu.util.Value;

/**
 * 定时任务
 * @author bc
 * @date 2018年11月27日
 */
//@Component
public class TimingComponent {
	
	/*
	 * 定时备份数据库
	 * 周一和周五，凌晨2点
	 */
	private static int ugdbNum = 0;
	@Scheduled(cron = "0 0 2 ? * 1,5")
	private void backupUGDB() {
		String dbPath = Value.getBackupugdbpath();
		ugdbNum = (ugdbNum)%4;
		dbPath += ("ugdb"+ugdbNum+".sql");
		File dbFile = new File(dbPath);
		if(dbFile.exists())
			dbFile.delete();
		String com = "mysqldump -uuser -ppassword ugdb > "+dbPath;   	 //！！！此处要改数据库用户名和密码
		String[] command = new String[] {"/bin/sh", "-c", com};  		//！！！要改成mysql路径
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
