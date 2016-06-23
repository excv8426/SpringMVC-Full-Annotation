package javasrc.component;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javasrc.service.WSHandler;
@Component
public class AutoTask {
	
	@Autowired
	private WSHandler wsHandler;
	
	/**
	 * 定时任务。
	 * 每天x秒x分x时执行一次。*/
	@Scheduled(cron="0 0 11 * * ?" )
	private void runtask(){
		
	}
	
	@Scheduled(cron="*/1 * * * * ?" )
	private void push(){
		try {
			wsHandler.pushDate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
