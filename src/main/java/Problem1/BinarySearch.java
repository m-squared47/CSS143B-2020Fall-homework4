package Problem1;

public class BinarySearch {
    // This is to be done recursively
    // Do not change signature (return type, function name, parameter types)
    // Add a helper function for recursion calls
    public static int binarySearch(int[] data, int target) {
        // homework
        int size = data.length;
        int middle = size / 2;  //split the array in two, a low and a high
        int middleOE = middle;
        int[] low = null;              //low and high value arrays (assuming inputs are sorted)
        int[] high = null;

        if(size > 0){   //if the array has an element

            if(size % 2 == 0) {                 //if array has an even number of elements
                low = new int[middle];    //initialize
                high = new int[middle];
            }else{                              //if the array has an odd number of elements
                middleOE = middle - 1;
                low = new int[middle];
                high = new int[middleOE];
            }

            for(int i = 0; i < middle; i++){            //fill in low array
                low[i] = data[i];
            }

            for(int i = 0; i + middle < size; i++){    //fill in high array
                high[i] = data[i + middle];
            }

            if(data[middle] == target){ //if by chance the middle value is the target, return the index
                return middle - 1;
            }

            if(target < data[middle]){  //if the target is low, use recursion using the low array
                return binarySearch(low, target);
            }

            return binarySearch(high, target);
        }

        return -1;  // if the target was not found or array is null
    }
}
