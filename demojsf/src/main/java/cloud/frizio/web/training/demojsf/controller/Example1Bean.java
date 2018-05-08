package cloud.frizio.web.training.demojsf.controller;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cloud.frizio.web.training.demojsf.dao.UserData;
import cloud.frizio.web.training.demojsf.model.Book;

@RequestScoped
@Named
public class Example1Bean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Logger LOGGER = Logger.getLogger(Example1Bean.class.getName());

	@Inject
	private UserData userData;
	
	private String title;
	private int pages;
	

	public String getTitle() {
		LOGGER.info("Chiamato metodo getTitle");
		return title;
	}
	public void setTitle(String title) {
		LOGGER.info("Chiamato metodo setTitle");
		this.title = title;
	}
	
	public int getPages() {
		LOGGER.info("Chiamato metodo getPages");
		return pages;
	}
	public void setPages(int pages) {
		LOGGER.info("Chiamato metodo setPages");
		this.pages = pages;
	}
	
	
	public void insertBook() {
		Book book = new Book();
		book.setTitle(this.title);
		book.setPages(this.pages);
		userData.getBooks().add(book);
	}
	
	
	public String goToPage() {
		return "/pages/index.xhtml?faces-redirect=true";
	}
	
	

}
