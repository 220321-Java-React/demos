package com.revature;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Launcher {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
    	
    	
    	//Create an empty array to be filled with the number of birds sightings
        int[] types = new int[5];
        
        //we want to loop through the given values....
        for(int i=0; i<arr.size(); i++){
        	
        	//and record which type of bird is sighted in each loop
        	//we know we're only getting 1, 2, 3, 4, or 5 in this List<Integer>
            switch(arr.get(i)){
                case 1:
                    types[0]++;
                    break;
                case 2:
                    types[1]++;
                    break;
                case 3:
                    types[2]++;
                    break;
                case 4:
                    types[3]++;
                    break;
                case 5:
                    types[4]++;
                    break;
            }
        }
        
        //That was the first movement... we now have an Array full of the number of sightings of each bird
        //We were given a list of birds
        //and now we have a list of the sightings, which is what we ACTUALLY want to use to find the most common bird
        
        //So let's say we had [1, 1, 2, 2, 3]
        //After this, we have a types Array of {2, 2, 1, 0, 0}
        
        //for now, we'll have a placeholder for the bird that was sighted the most.
        //so for now, we're saying index 0 of types is the most sighted bird (bird 1)
        int max = types[0];
        
        //we have this int, which we'll use to compare the amount of bird sightings
        int index = 1;
        
        //loop through our types array
        for(int j = 1; j<types.length;j++){
        	
        	//IF the value of our placeholder max int is less than the value in the current index of the types array...
        	//This also checks for the lowest id, lets say id 1 and 2 both have 2 sightings
        	//bird 1 will ONLY get overrwritten if bird 2 has more sightings
        	//otherwise it's checking if 2 < 2, which it's not. So bird type 1 remains
            if(max < types[j]){
            	//then our new max value is that value in the current index of the types array
            	//if the previous max was 1, and the value of types[j] 2, then max is now 2. the second bird type.
                max = types[j];
                //since the types array is zero-index, and we only have birds 1-5, we just need to add 1
                index = j+1;
            }
        }
        
        //at the end of all this, we have our most commonly sighted bird.
        return index;
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr.add(arrItem);
        }

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}