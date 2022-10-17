package com.company;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class StackQueue{

     Queue q1 = new Queue();
     Queue q2 = new Queue();


    public void push(String x){
        q2.enqueue(x);

        while(!q1.isEmpty()){
           q2.enqueue(q1.peekQ());//add the top to become bottom
            q1.dequeue();
        }
        //swap q2's elements to q1
        Queue q = q1;
        q1 = q2;
        q2=q;
    }

    public void pop(String x){
        if(q1.isEmpty()){
            return;
        }
        q1.dequeue();
    }
    public String top(){
       if(q1.isEmpty()){
           return null;
       }
       return q1.peekQ();
       // return q1;
    }

    //get the tag near the tag end-peek to check if they are the same
    //
    //@Override
     public String getm(){
        String tagFront = q1.getItem();
       return tagFront;
    }



    public void printS(){
        q1.printQ();

       }
    }




