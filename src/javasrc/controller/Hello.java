package javasrc.controller;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javasrc.component.ServiceParam;
import javasrc.service.PrototypeService;
import javasrc.service.TestAOP;

@Controller
public class Hello {
	public Hello(){
		System.out.println("Hello construct");
	}
	
	@Autowired
	private PrototypeService service;
	@Autowired
	private ServiceParam param;
	@Autowired
	private TestAOP testAOP;
	
	@ModelAttribute
	public void getsession(HttpServletRequest request){
		HttpSession session=request.getSession(true);
		System.out.println("session id:::::::::::::::::::"+session.getId());
	}
	
	@RequestMapping("/hello")
	public @ResponseBody String hello(@RequestParam("myname") String name) {
		return "hello"+name;
	}
	
	@RequestMapping("/testBeanScope")
	public @ResponseBody String beanScope(@RequestParam("x") String x,@RequestParam("y") String y) throws InterruptedException{
		param.setX(x);
		param.setY(y);
		TimeUnit.SECONDS.sleep(5L);
		System.out.println("Controller hashcode:"+this.hashCode());
		System.out.println("Controller thread:"+Thread.currentThread());
		System.out.println(service.getX());
		return service.getX();
	}
	
	@RequestMapping("/testAOP")
	public @ResponseBody String testAOP() throws InterruptedException{
		return String.valueOf(testAOP.runAop(1, 2));
	}
}
