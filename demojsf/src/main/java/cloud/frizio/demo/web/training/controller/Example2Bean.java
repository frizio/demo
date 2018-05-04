package cloud.frizio.demo.web.training.controller;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cloud.frizio.demo.web.training.dao.UserData;
import cloud.frizio.demo.web.training.model.Book;

@SessionScoped
@Named
public class Example2Bean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, String> availableItems;
	private String data;
	private String item;
	
	@Inject
	private UserData userData;
	private Book book;
	

	@PostConstruct
	public void init() {
		availableItems = new LinkedHashMap<>();
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
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	public Map<String, String> getAvailableItems() {
		return availableItems;
	}
	public void setAvailableItems(Map<String, String> availableItems) {
		this.availableItems = availableItems;
	}

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	
	public List<Book> getAvailableBooks() {
		return userData.getBooks();
	}
	
	public void submit() {
		
	}

}
