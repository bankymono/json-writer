package jsonwriter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InspectArray {
    public static void main(String[] args) {
        int [] oneDimensionalArray = {1,2};
        double [][] twoDimensionalArray = {{1.2,2.3,3.4},{4.5,5.6,6.7}};


//        inspectArrayObject(oneDimensionalArray);
        inspectArrayObject(twoDimensionalArray);
        inspectArrayValues(twoDimensionalArray);
    }

    public static void inspectArrayValues(Object arrayObject) {
        int arrayLength = Array.getLength(arrayObject);
        System.out.print("[");
        for(int i = 0; i < arrayLength; ++i) {
            Object element = Array.get(arrayObject,i);

            if(element.getClass().isArray()){
                inspectArrayValues(element);
            } else {
                System.out.print(element);
            }

            if(i != arrayLength -1){
                System.out.print(" , ");
            }
        }

        System.out.print("]");
    }


    public static void inspectArrayObject(Object arrayObject){
        Class<?> clazz = arrayObject.getClass();
        System.out.println(String.format("Is array : %s", clazz.isArray()));

        Class<?> arrayComponentType = clazz.getComponentType();
        System.out.println(String.format("This is an array of type : %s", arrayComponentType.getTypeName()));

    }
}
