package hackerrank.algo.java;

import java.lang.reflect.Method;

class Printer<T> {
    void printArray(T[] t) {
        if (t instanceof Integer[]) {
            for (T value : t) {
                System.out.println(value);
            }
        } else if (t instanceof String[]) {
            for (T value : t) {
                System.out.println(value);
            }
        }
    }
}

public class GenericClasses {

    public static void main(String args[]) {
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if (name.equals("printArray"))
                count++;
        }

        if (count > 1) System.out.println("Method overloading is not allowed!");

    }
}
