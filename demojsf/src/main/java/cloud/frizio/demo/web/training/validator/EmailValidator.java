package cloud.frizio.demo.web.training.validator;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("cloud.frizio.demo.web.training.validator.EmailValidator")
public class EmailValidator implements Validator {
	
	private Logger LOGGER = Logger.getLogger(EmailValidator.class.getName());

	public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." +
												"[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +
												"(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	private Matcher matcher;

	
	public EmailValidator(){
		  pattern = Pattern.compile(EMAIL_PATTERN);
	}
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		LOGGER.info("Chiamato metodo validate");
		matcher = pattern.matcher(arg2.toString());
		if (!matcher.matches()){
			LOGGER.info("Validation failed!!!" + arg2.toString());
			FacesMessage msg = new FacesMessage("Summary: E-mail validation failed.", "Detail: Invalid E-mail format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		} else {
			LOGGER.info("SUCCESSFULL validation!!!" + arg2.toString());
			
		}
	}

}
