package javasrc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javasrc.component.ServiceParam;

@Service
@Scope(value=WebApplicationContext.SCOPE_REQUEST,proxyMode=ScopedProxyMode.TARGET_CLASS)
public class PrototypeService {
	private String x;
	private String y;
	
	@Autowired
	public PrototypeService(ServiceParam param){
		System.out.println("PrototypeService construct");
		this.x=param.getX();
		this.y=param.getY();
	}
	
	public String getX() {
		return x;
	}
	
	public void setX(String x) {
		this.x = x;
	}
	
	public String getY() {
		System.out.println("Service thread:"+Thread.currentThread());
		System.out.println("Service hashcode:"+this.hashCode());
		return y;
	}
	
	public void setY(String y) {
		this.y = y;
	}
}
