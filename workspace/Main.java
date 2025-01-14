//Name: Emilie Spindler
//Date: 1.2.25
//Description: Creates a game where users can guess which country is being shown on an 
//            image and says if they are correct or not if the choose the "Quiz" button. 
//            This game can also state the countires info

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main 
{

  // array of 10 Country objects
  private Country[] countryArray = new Country[10];  
  // index of current shown country
  private int index = 0;

  // GUI elements
  private JFrame jFrame = new JFrame("Countries");
  private ImageIcon img;
  private JLabel imageLabel;
  private JLabel outputLabel;
  private JTextField input;
  
  public static void main(String[] args) {
    // Create the GUI
    Main gui = new Main();
    gui.loadCountries();
    gui.showCountry();
  }

  /* loadCountries() reads in the data from the countries-data.csv file and fills in the countryArray with data. You need to add the loop that reads in the country data into the array. */
  //Precondition: a csv file of 10 country objects must exist and only country objects.
  //Postcondition: the objects in the csv file become the objects in countryArray
  public void loadCountries() 
  {
    // Open the data file - do not change
    File file = new File("/workspaces/Countries/workspace/countries-data.csv");
    Scanner scan = null;
    try {
      scan = new Scanner(file);
    } catch(FileNotFoundException e) { 
        System.out.println("File not found");     
    }
    
    // Write a for loop that goes through the countryArray.
    for(int i=0; i<countryArray.length; i++) {
    // Do the following inside the loop
      String input = scan.nextLine();
      String[] data = input.split(",");
      System.out.println("Read in " + data[2]);
     //
      // inside the loop, create a new Country using your constructor with 4 arguments and pass in data[0], data[1], data[2], data[3] as arguments.
     // inside the loop, set countryArray[i] to the created Country object
      Country countryObject = new Country(data[0], data[1], data[2], data[3]);
      countryArray[i] = countryObject;
    }
  }

  /* showCountry() will show the image associated with the current country. It should get the country at index from the countryArray. It should use its get method to get its image file name and use the code below to put the image in the GUI.
  */
  //Precondition: countryArray must be filled with country objects
  //Postcondition: displays the image associated with the current country
  public void showCountry() {
    // Get the country at index from countryArray
    Country c = countryArray[index];
  
    // Use its get method to get the its image file name and save it into imagefile variable below instead of worldmap.jpg.
    String imagefile = "worldmap.jpg";
    imagefile = c.getPhoto();
    // Use the following code to create an new Image Icon and put it into the GUI
    img = new ImageIcon("/workspaces/Countries/workspace/"+imagefile);
    imageLabel.setIcon(img);
  }
  
  /* nextButton should increment index. If the index is greater than 9, reset it back to 0. Clear the outputLabel to empty string using setText, and call showCountry();*/
  //Precondition: None
  //Postcondition: moves onto the next Country after the "next" button is clicked
  public void nextButtonClick()
  {
    index++;
    if(index > 9){
      index = 0;
    }
    outputLabel.setText("Name this country");
    showCountry();
   
  }
  
  /* reviewButton should get the country at index from the countryArray, call its toString() method and save the result, print it out with System.out.println and as an argument to outputLabel.setText( text to print out ); */
  //Precondition: countryArray needs to have countries in it
  //Postcondition: displays the info of the current country(name, captital, and language) when the "review" button is clicked
  public void reviewButtonClick()
  {
     String review = countryArray[index].toString();
     System.out.println(review);
     outputLabel.setText("correct answer: "+review);

  }

  /* quizButton should clear the outputLabel (outputLabel.setText to empty string), get the country at index from countryArray, print out a question about it like What country is this? and/or What's this country's capital?. Get the user's answer using scan.nextLine() and check if it is equal to the country's data using its get methods and print out correct or incorrect.
  */
  //Precondition: countryArray needs to have countries in it
  //Postcondition: checks if the answer submitted by the user is correct or not.
  public void quizButtonClick()
  {
    
    if(input.getText().contentEquals(countryArray[index].getName())){
      outputLabel.setText("correct");
    }
    else {
      outputLabel.setText("wrong");
    }
  }


  /* Do NOT change anything below here */
  /* The Main() constructor is finished and will construct the GUI */
public Main() {
    jFrame.setLayout(new FlowLayout());
    jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // buttons at the top
        JButton reviewButton = new JButton("Review");
        JButton quizButton = new JButton("Quiz");
        JButton newButton = new JButton("Next");
        jFrame.add(reviewButton);
        jFrame.add(quizButton);
        jFrame.add(newButton);
        
        // create a new image icon
        img = new ImageIcon("worldmap.jpg");
        // create a label to display image
        imageLabel = new JLabel(img);
        // and one for output
        outputLabel = new JLabel();
        jFrame.add(imageLabel);
        jFrame.add(outputLabel);

        input = new JTextField(20);
        jFrame.add(input);

        jFrame.setVisible(true);
        // add event listener for button click
        reviewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      reviewButtonClick();
    }
        });
    quizButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      quizButtonClick();
    }
    });
   
   newButton.addActionListener(new ActionListener()  {
    public void actionPerformed(ActionEvent e) 
    {
      nextButtonClick();
    }
   });
}
  

}
