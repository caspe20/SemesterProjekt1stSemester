package com.zuul.application;

public class ScreenWriter {
    private static final int screenWidth = 65;
    private static final int textWidth = 50;
    private static final int textIndentSize = (screenWidth - textWidth)/2;
    private static String indentText = "";

    public static void print(String screenText){
        System.out.println(write(screenText));
    }

    private static String write(String screenText){
        // Make text indent
        if(textIndentSize > 0 && indentText.isEmpty()) {
            for (int i = 0; i < textIndentSize; i++) {
                indentText += " ";
            }
        }

        // Variable for whats left of text input, and output
        String temp = screenText;
        String outputString ="";

        do{
            // If input text has a skip line in current line
            String testString = temp.substring(0,(Math.min(textWidth,temp.length())));
            // If string contains a \n and an \n\n
            if(testString.contains("\n")) {
                outputString += indentText + temp.substring(0, temp.indexOf("\n") + 1);
                temp = temp.substring(temp.indexOf("\n") + 1);
                continue;
            }

            // Search for nearest space in ScreenText within screen width.
            for(int i = textWidth; i > 0 ;i--){
                if(temp.length() <= textWidth){
                    outputString += indentText + temp;
                    temp = "";
                    break;
                }else if(temp.charAt(i) == ' '){
                    outputString += indentText + temp.substring(0,i) + "\n";
                    temp = temp.substring(i+1);
                    break;
                }
            }

        }while(temp.length() > 0);

        return outputString;
    }

    private static String writeIndentFree(String screenText){
        // Make text indent
        if(textIndentSize > 0 && indentText.isEmpty()) {
            for (int i = 0; i < textIndentSize; i++) {
                indentText += " ";
            }
        }

        String temp = screenText;
        String outputString ="";

        do{
            // If input text has a skip line in current line
            String testString = temp.substring(0,(Math.min(textWidth,temp.length())));
            // If string contains a \n and an \n\n
            if(testString.contains("\n") && testString.indexOf("\n") > testString.length() && temp.substring(testString.indexOf("\n"),testString.indexOf("\n") + 2).contains("\n\n")){
                outputString += indentText + temp.substring(0,temp.indexOf("\n")+2);
                temp = temp.substring(temp.indexOf("\n")+2);
                continue;
            }else if(testString.contains("\n")){
                outputString+= "\n";
                temp = temp.substring(temp.indexOf("\n") + 1);
            }

            // Search for nearest space in ScreenText within screen width.
            for(int i = textWidth; i > 0 ;i--){
                if(temp.length() <= textWidth){
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
        String[] tempArr = writeIndentFree(screenText).split("\n");
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
            outputString += temp + (tempArr[i].length() > 1 ? "\n" : "");
        }

        System.out.println(outputString);
    }

    public static void printCenterSpecial(String screenText, char centerer){
        String[] tempArr = writeIndentFree(screenText).split("\n");
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
            for (int j = 0; j < (((double) textWidth - tempArr[i].length()) / 2.0) - 1; j++) {
                temp = centerer + temp + centerer;
            }
            outputString += indentText + temp + indentText + (tempArr.length > 1 ? "\n" : "");
        }

        System.out.println(outputString);
    }

    public static String getLeftRight(String left, String right){
        String combined = left + right;
        String tempLeft = left;
        String output = "";
        if(combined.length() > textWidth){
            if(left.length() > textWidth){
                output += indentText + left.substring(0,(Math.min(left.length(), textWidth))) + "\n";
                while(left.length() != 0){
                    output += indentText + left.substring(0,(Math.min(left.length(), textWidth))) + "\n";
                    left = left.substring((Math.min(left.length(), textWidth))) + "\n";
                }
                output += indentText;
                for (int i = 0; i < textWidth - right.length(); i++) {
                    output+= " ";
                }
                output += right;
            }else{
                output += left + "\n" + indentText;
                for (int i = 0; i < textWidth - right.length(); i++) {
                    output += " ";
                }
                output += right;
            }
        }else{
            output += left;
            for (int i = 0; i < textWidth - right.length() - left.length(); i++) {
                output += " ";
            }
            output += right;
        }

        return output;
    }

    public static String getCenter(String text){
        String output = "";
        String temp = text;
        while(!temp.isEmpty()){
            String currentLine = temp.substring(0,Math.min(temp.length(), textWidth));
            temp = temp.substring(Math.min(temp.length(), textWidth));
            for (int i = 0; i < screenWidth/2 - currentLine.length(); i++) {
                currentLine = " " + currentLine;
            }
            output += indentText + currentLine;
        }
        return output;
    }
}
