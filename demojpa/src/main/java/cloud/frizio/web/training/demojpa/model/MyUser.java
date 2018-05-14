package cloud.frizio.web.training.demojpa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="myuser")
public class MyUser implements Serializable {


	private static final long serialVersionUID = 1L;

	private int id;

	private static final String CIPHER_KEY = "pippo";
	
	private String name;
	
	private String email;
	
	//private List<Book> books;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	/*
	@ColumnTransformer(
            read = "CAST(AES_DECRYPT(name, '" + CIPHER_KEY  + "') as CHAR(128))",
            write = "AES_ENCRYPT(?, '" + CIPHER_KEY + "')"
    )
    */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	/*	
	@OneToMany
	@JoinTable(name="books_for_user")
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	*/

	@Override
	public String toString() {
		return "[name=" + name + ", email=" + email + "]";
	}
	
}
