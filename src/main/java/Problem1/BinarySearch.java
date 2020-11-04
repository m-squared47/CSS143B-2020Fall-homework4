package Problem1;

public class BinarySearch {
    // This is to be done recursively
    // Do not change signature (return type, function name, parameter types)
    // Add a helper function for recursion calls
    public static int binarySearch(int[] data, int target) {
        // homework
        int size = data.length;                 //size of data[]
        int[] newData = null;

        if(size > 0) {                          //if the array has more than 1 element
            newData = new int[size - 1];        //data[] with size - 1

            for (int i = 0; i < newData.length; i++) {    //fill in newData[] array
                newData[i] = data[i];
            }

            if (data[size - 1] != target) {    //if last element doesn't match
                return binarySearch(newData, target);      //recursive call
            }else{
                return size - 1;                            //return index
            }
        }

        return -1;  // if the target was not found or array is null
    }
}
