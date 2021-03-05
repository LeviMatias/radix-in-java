package com.company;
import model.*;

public class Main {

    public static void main(String[] args) {
	    int [] arr = {4, 1, 666, 123123, 3, 98, 102, 77, 2, 10000, 55};

	    Radix.sort(arr);

	    for (int i:arr){
	        System.out.println(i);
        }
    }
}
