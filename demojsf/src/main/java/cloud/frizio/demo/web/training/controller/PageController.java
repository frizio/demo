package cloud.frizio.demo.web.training.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cloud.frizio.demo.web.training.dao.UserData;
import cloud.frizio.demo.web.training.model.Book;

@RequestScoped
@Named
public class PageController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private UserData userData;
	
	private String title;
	private int pages;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
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
