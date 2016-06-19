package javasrc.component;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_REQUEST,proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ServiceParam {
	
	public ServiceParam(){
		System.out.println("ServiceParam construct");
	}
	
	private String x;
	private String y;
	
	public String getX() {
		return x;
	}
	public void setX(String x) {
		System.out.println("ServiceParam set Param ");
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		System.out.println("ServiceParam set Param ");
		this.y = y;
	}
	
}
