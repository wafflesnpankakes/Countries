//Name: Emilie Spindler
//Date: 1.2.25
//Description: this class created countries with a name, captital, language, and photo of where it is in the world. 

public class Country
{
  // add private instance variables for the name, capital, language, and image file.
  private String name;
  private String capital;
  private String language;
  private String photo;

  // add constructors
  public Country(String name, String capital, String language, String photo){
    this.name = name;
    this.capital = capital;
    this.language = language;
    this.photo = photo;
  }

  public Country(){
    name = "United States";
    capital = "Washington D.C.";
    language = "English";
    photo = "US.jpg";
  }

  // Write accessor/get methods for each instance variable that returns it.
  public String getName(){
    return name;
  }
  public String getCapital(){
    return capital;
  }
  public String getLanguage(){
    return language;
  }
  public String getPhoto(){
    return photo;
  }

  // Write a toString() method that returns a concatenated String of 3 of the instance variables in a sentence like "..'s capital is .. and its primary language is ..."
 public String toString(){
    return name+"'s captital is " +capital+" and its primary language is "+language;
  }
}