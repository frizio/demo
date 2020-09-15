package cloud.frizio.web.demo.mvc.model;

import java.util.LinkedHashMap;

public class Student {
  
  private String firstName;
  private String lastName;
  private String country;
  private String favoriteLanguage;
  private String[] operatingSystems;

  private LinkedHashMap<String, String> countryOptions;
  private LinkedHashMap<String, String> favoriteLanguageOptions;
	
	public Student() {
		
		// populate country options: used ISO country code
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
    countryOptions.put("US", "United States of America");		
    
    favoriteLanguageOptions = new LinkedHashMap<>();

    favoriteLanguageOptions.put("Java", "Java");
    favoriteLanguageOptions.put("C#", "C#");
    favoriteLanguageOptions.put("PHP", "PHP");
    favoriteLanguageOptions.put("Ruby", "Ruby");    

	}

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  };

  public String getFavoriteLanguage() {
    return this.favoriteLanguage;
  }

  public void setFavoriteLanguage(String favoriteLanguage) {
    this.favoriteLanguage = favoriteLanguage;
  };

  public LinkedHashMap<String, String> getCountryOptions() {
    return this.countryOptions;
  }

  public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
    return this.favoriteLanguageOptions;
  }

  public String[] getOperatingSystems() {
    return this.operatingSystems;
  }

  public void setOperatingSystems(String[] operatingSystems) {
    this.operatingSystems = operatingSystems;
  };

}
