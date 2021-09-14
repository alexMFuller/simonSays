package simon;
import java.util.Random;

public class randomColorGenerator {
    Random randNum = new Random();
    private String finalColorOne = "";
    private String finalColorTwo = "";
    private String finalColorThree = "";
    private String finalColorFour = "";
    private String finalColor = "";
    public void formatGen(String colorOne,String colorTwo,String colorThree,String colorFour){
        //allows for user selected colors
        finalColorOne=colorOne;
        finalColorTwo=colorTwo;
        finalColorThree=colorThree;
        finalColorFour=colorFour;

    }
    public void formatGen(){
        //allows for default colors
        finalColorOne="blue";
        finalColorTwo="red";
        finalColorThree="green";
        finalColorFour="yellow";

    }

    public String randColor(){
        //runs a randomizer and selects one of the user selected "colors"
        int randColor = randNum.nextInt(4);
        if (randColor==0){
            finalColor=finalColorOne;
        }
        else if (randColor==1){
            finalColor=finalColorTwo;
        }
        else if (randColor==2){
            finalColor=finalColorThree;
        }
        else if (randColor==3){
            finalColor=finalColorFour;
        }
        return finalColor;
    }
}


