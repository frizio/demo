package cloud.frizio.demo.web.training.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import cloud.frizio.demo.web.training.model.Book;

@SessionScoped
@Named
public class UserData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Book> books;

	@PostConstruct
	public void init() {
		this.setBooks(new ArrayList<>());
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
