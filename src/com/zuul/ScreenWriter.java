package com.zuul;

public class ScreenWriter {
    private static final int screenWidth = 35;
    private static final int textWidth = 25;

    public static void print(String screenText){
        System.out.println(write(screenText));
    }

    public static String write(String screenText){
        String temp = screenText;
        String outputString ="";

        do{
            if(temp.substring(0,(textWidth > temp.length() ? temp.length() : textWidth)).contains("\n")){
                outputString += temp.substring(0,temp.indexOf("\n")+1) + "\n";
                temp = temp.substring(temp.indexOf("\n")+1);
                continue;
            }

            // Search for nearest space in ScreenText within screen width.
            for(int i = textWidth; i > 0 ;i--){
                if(temp.length() < textWidth){
                    outputString += temp;
                    temp = "";
                    break;
                }else if(temp.charAt(i) == ' '){
                    outputString += temp.substring(0,i) + "\n";
                    temp = temp.substring(i+1);
                    break;
                }
            }

        }while(temp.length() > 0);

        return outputString;
    }

    public static void printCenter(String screenText){
        String[] tempArr = write(screenText).split("\n");
        String temp = "";
        String outputString = "";
        int currSpaces = 0;

        for (int i = 0; i < tempArr.length; i++) {
            if(tempArr[i].length() == 0){
                outputString+= "\n";
                continue;
            }

            temp = tempArr[i];
            for (int j = 0; j < (((double) screenWidth - tempArr[i].length()) / 2.0); j++) {
                temp = " " + temp + " ";
            }
            outputString += temp + (tempArr.length > 1 ? "\n" : "");
        }

        System.out.println(outputString);
    }

    public static void printCenterSpecial(String screenText, char centerer){
        String[] tempArr = write(screenText).split("\n");
        String temp = "";
        String outputString = "";
        int currSpaces = 0;

        for (int i = 0; i < tempArr.length; i++) {
            if(tempArr[i].length() == 0){
                outputString+= "\n";
                continue;
            }

            temp = tempArr[i];
            temp = " " + temp + " ";
            for (int j = 0; j < (((double) screenWidth - tempArr[i].length()) / 2.0) - 1; j++) {
                temp = centerer + temp + centerer;
            }
            outputString += temp + (tempArr.length > 1 ? "\n" : "");
        }

        System.out.println(outputString);
    }
}
