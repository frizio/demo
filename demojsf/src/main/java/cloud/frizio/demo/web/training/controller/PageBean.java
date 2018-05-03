package cloud.frizio.demo.web.training.controller;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class PageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String data;
	
	private Map<String, String> availableItems;
	
	@PostConstruct
	public void init() {
		availableItems = new LinkedHashMap<String, String>();
        availableItems.put("value1", "label1");
        availableItems.put("value2", "label2");
        availableItems.put("value3", "label3");
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public Map<String, String> getAvailableItems() {
		return availableItems;
	}
	
	
}
