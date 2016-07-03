package javasrc.service;

import org.springframework.stereotype.Service;

@Service
public class TestAOP {
	
	public int runAop(int i,int j){
		int k=i+j;
		System.out.println("i+j="+k);
		return k;
	}
}
