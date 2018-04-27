package cloud.frizio.demo.web.training.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value="demo")
@RequestScoped
public class Demo {

	private Logger LOGGER = Logger.getLogger(Demo.class.getName()); 
	
	private int counter;
	private List<String> list;
	
	
	public int getCounter() {
		LOGGER.info("Chiamato metodo getCounter");
		return counter * 2;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
		
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	
	@PostConstruct
	public void init() {
		this.counter = 10;
//		this.list = new ArrayList<>();
//		list.add("Qui");
//		list.add("Quo");
//		list.add("Qua");

		this.list = Arrays.asList("Qui", "Quo", "Qua");
	}
	
	public void increment() {
		this.counter++;
	}
	
}
