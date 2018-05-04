package cloud.frizio.demo.web.training.converter;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import cloud.frizio.demo.web.training.dao.UserData;
import cloud.frizio.demo.web.training.model.Book;

@RequestScoped
@Named
public class BookConverter implements Converter {

	private Logger LOGGER = Logger.getLogger(BookConverter.class.getName()); 
	
	@Inject
	private UserData userData;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		LOGGER.info("Chiamato metodo getAsObject ");
		return userData.getBooks().get(Integer.valueOf(arg2));
		//return 
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		LOGGER.info("Chiamato metodo getAsString");
		Book book = (Book) arg2;
		if (book == null) {
			return null;
		}
		return String.valueOf(book.getId());
		//return book.toString();
	}

}
