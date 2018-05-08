package cloud.frizio.web.training.demojsf.model;


public class Book {

	private int id;
	
	private String title;
	private int pages;

	
	public Book() {
		super();
	}
	
	public Book(int id, String title, int pages) {
		super();
		this.id = id;
		this.title = title;
		this.pages = pages;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

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

}

