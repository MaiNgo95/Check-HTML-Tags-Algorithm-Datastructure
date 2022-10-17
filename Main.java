package com.company;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //read the file from text
        Scanner read = new Scanner(new File("C:\\Users\\maian\\Stack_Queue\\src\\text1.txt"));
        StackQueue addTag = new StackQueue();
        int countLine = 0;
        //create the character will be remove in the String
        // String charClose = ">";
        String specialChar_end = "/";
        while (read.hasNext()) {
            String data = read.nextLine();
            //******using Matcher and pattern to extract the string contain < > in the  HTML file.
            Pattern pattern = Pattern.compile("<[^>]*>");
            Matcher matcher = pattern.matcher(data);
            //print out the special chars
            //*******loop through the line in file text
            while (matcher.find()) {
                // System.out.println(matcher.group());
                addTag.push(matcher.group());
                addTag.top();
                System.out.println(addTag.top());
                System.out.println(addTag.top().getClass().getSimpleName());

                //***** check and pass the first base if have in HTML
                if (addTag.top().equals("<!DOCTYPE html>")) {
                    System.out.println("yes");
                     continue;

                 //**** check if the next tag contain the character "/" or not. if not it will continue to loop
                }
                if (specialChar_end.indexOf(addTag.top().charAt(1)) < 0) {
                    System.out.println(specialChar_end.indexOf(addTag.top().charAt(1)));
                    //if(addTag.top())
                    continue;
                }



                // *** check if the next tag contain the character "/" or not. if yes
                // *** it will check the condition

                //*** remove the char "/" to check if two strings are the same, then we will pop out
               if (specialChar_end.indexOf(addTag.top().charAt(1)) >= 0) {
                   String a = addTag.top().replace("/", "");
                   System.out.println("get end " + a);
                   String bottomTag = addTag.getm();
                    System.out.println(bottomTag);
                    if (a.equals(bottomTag)) {
                        System.out.println("get the match");
                        System.out.println(bottomTag);
                        addTag.pop(a);
                        addTag.pop(bottomTag);
                    }
                    else{
                        System.out.println("Opps ... There is a problem . ." +
                                "The " + bottomTag + " tag at line " + countLine + " does not meet the tag rules . . ");
                    }
                }

               if(addTag.top().equals("<br>") || addTag.top().equals("<hr>")) {
                   continue;


               }


//                    //addTag.pop(addTag.top());
//                    //addTag.pop(matcher.group());
//                    //addTag.push(matcher.group());
//
            


        }
        countLine++;


    }
        //addTag.printS();

        System.out.println(countLine);


    }
}
 


