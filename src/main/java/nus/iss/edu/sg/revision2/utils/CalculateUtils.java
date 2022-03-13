package nus.iss.edu.sg.revision2.utils;

public class CalculateUtils {

    public boolean isWithinRange(Integer number){
        if(number>=0 && number<=30){return true;}
        else return false;
    }
    
    public boolean isInt(String s){
        Integer parser = 0;
        try {
            parser = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public int arithmeticFunc(String firstNum, String secondNum, String ari){
        Integer parserOne = Integer.parseInt(firstNum);
        Integer parserTwo = Integer.parseInt(secondNum);

        if(ari.equals("plus")){
            return(parserOne+parserTwo);
        }
        else if(ari.equals("minus")){
            return (parserOne-parserTwo);
        }
        else if(ari.equals("mod")){
            return(parserOne%parserTwo);
        }
        else{
           return(parserOne/parserTwo);
        }
    }

}
