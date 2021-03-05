package model;

import java.util.ArrayList;

public class Radix {

    public static void sort(int [] arr){
        String[] str_arr = new String[arr.length];
        for (int i= 0; i< arr.length; i++){
            str_arr[i] = String.valueOf(arr[i]);
        }

        normalizeStrings(str_arr);
        Radix.calculate(str_arr, 0);

        for (int i= 0; i< arr.length; i++){
            arr[i] = Integer.parseInt(str_arr[i]);
        }
    }

    private static void calculate(String[] arr, int position){
        ArrayList<String>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {  buckets[i] = new ArrayList<String>(); }

        for (String str: arr){
            String c = Character.toString(str.charAt( str.length() - 1 - position));
            buckets[Integer.parseInt(c)].add(str);
        }

        int index = 0;
        for (ArrayList<String> bucket: buckets){
            for (String s : bucket) {
                arr[index] = s;
                index++;
            }
        }

        position++;
        if (position < arr[0].length()){
            calculate(arr, position);
        }
    }

    private static void normalizeStrings(String[] arr){
        int max = 0;
        for (String str: arr){
            if (str.length() > max){
                max = str.length();
            }
        }
        for (int i= 0; i< arr.length; i++){
            arr[i] = String.format("%0"+max+"d", Integer.parseInt(arr[i]) );
        }
    }
}
