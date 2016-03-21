package org.sourceit;

import java.util.Arrays;
import java.util.Random;
import static java.util.Arrays.deepToString;

public class HomeTask2 {

    /**
     * Конвертирует десятичное число в бинарную форму
     *
     * @param number может быть только позитивным
     * @return бинарная форма числа
     */
    public static long decimalToBinary(int number) {
        int value;
        String str = "";
        while(number > 0){
            value = number % 2;
            number /= 2;
            str = value + str;
        }
        long bin = new Long (str);
        return bin;
    }

    /**
     * Конвертирует десятичное число в октальную форму
     *
     * @param number может быть только позитивным
     * @return октальная форма числа
     */
    public static long decimalToOctal(int number) {
        int value;
        String string = "";
        while(number > 0){
            value = number % 8;
            number /= 8;
            string = value + string;
        }
        long octal = new Long (string);
        return octal;
    }

    /**
     * Конвертирует десятичное число в хексовою форму
     *
     * @param number может быть только позитивным
     * @return хексовая форма числа
     */
    public static long decimalToHex(int number) {
        int value;
        String string = "";
        while(number > 0){
            value = number % 16;
            number /= 16;
            string = value + string;
        }
        long hex = new Long (string);
        return hex;
    }

    /**
     * Конвертирует бинарную форму в десятичное число
     *
     * @param binary бинарная форма, может быть только позитивным
     * @return десятичное число
     */
    public static int binaryToDecimal(long binary) {
        long value;
        int decimal = 0;
        int exponent = 0;
        while(binary > 0){
            value = binary % 10;
            binary /= 10;
            value *= Math.pow(2, exponent);
            decimal += value;
            ++exponent;
        }
        return decimal;
    }

    /**
     * Конвертирует октальную форму в десятичное число
     *
     * @param octal октальная форма, может быть только позитивным
     * @return десятичное число
     */
    public static int octalToDecimal(long octal) {
        long value;
        int decimal = 0;
        int exponent = 0;
        while(octal > 0){
            value = octal % 10;
            octal /= 10;
            value *= Math.pow(8, exponent);
            decimal += value;
            ++exponent;
        }
        return decimal;
    }

    /**
     * Конвертирует хексовую форму в десятичное число
     *
     * @param hex хексовая форма, может быть только позитивным
     * @return десятичное число
     */
    public static int hexToDecimal(long hex) {
        long value;
        int decimal = 0;
        int exponent = 0;
        while(hex > 0){
            value = hex % 10;
            hex /= 10;
            value *= Math.pow(16, exponent);
            decimal += value;
            ++exponent;
        }
        return decimal;
    }

    /**
     * Генерируют двумерный массив, со случайными числами.
     *
     * @param rows
     * @param columns
     * @return двумерный массив
     */
    public static int[][] generateTwoDimensionArray(int rows, int columns) {
        int [][] array = new int [rows][columns];
        Random random = new Random();
        for(int a = 0; a < rows; ++a){
            for(int b = 0; b < columns; ++b ){
                array[a][b] = (int)(Math.random()* 10);
            }
        }
        return array;
    }

    /**
     * Определить и вывести на экран индекс строки с
     * наибольшим по модулю произведением элементов.
     * Если таких строк несколько, то вывести индекс
     * первой встретившейся из них.
     *
     * @param input двумерный массив
     * @return индекс строки
     */
    public static int findMaxProduct(int[][] input) {
        int rowMas[] = new int[input.length];
        int maxRow = 0;
        int index = 0;
        for(int a = 0; a < input.length; ++a ) {
            rowMas[a] = 1;
            for(int b = 0; b < input[a].length; ++b){
                rowMas[a] *= input[a][b];
            }
        }
        for(int a = 0; a < rowMas.length; ++a){
            if(rowMas[a] < 0){
                rowMas[a] *= -1;
            }
            if(rowMas[a] > maxRow){
                maxRow = rowMas[a];
                index = a;
            }
        }
        return index;

    }

    /**
     * Выводит все простые числа из интервала от 2 до n.
     *
     * @param n
     * @return массив простых чисел.
     */
    public static int[] getSimple(int n) {
        return null;
    }

    // Рекурсивные методы. Реализовать их нужно с помощью рекурсии.

    /**
     * Вычисляет сумму чисел от 1 до n включительно.
     *
     * @param n предел
     * @return сумма
     */
    public static long sum(int n) {
        if (n >= 1) {
            return sum(n - 1) + n;
        }
        return 0;
    }

    /**
     * Метод вычисляет, результат умножения.
     *
     * @param first
     * @param second
     * @return
     */
    public static int product(int first, int second) {
        if(second > 0) {
            return first + product(first, --second);
        }
        else if(second < 0){
            return (first * -1) + product(first, ++second);
        }
        return 0;
    }

    public static void main(String[] args) {

        int[][] input = {
                {5, 4, 2, 0},
                {-8, 2, 7, 1},
                {6, 2, 7, 1},
                {3, 9, 10, 0}
        };
        System.out.println("decimalToBinary = " + decimalToBinary(8));
        System.out.println("decimalToOctal = " + decimalToOctal(100));
        System.out.println("decimalToHex = " + decimalToHex(255));
        System.out.println("binaryTodecimal = " + binaryToDecimal(10011));
        System.out.println("octalTodecimal = " + octalToDecimal(144));
        System.out.println("hexToDecimal = " + hexToDecimal(100));
        System.out.println("array with random value = " + deepToString(generateTwoDimensionArray(4, 4)));
        System.out.println("row with max product = " + findMaxProduct(input));

        System.out.println("sum 1 to n = " + sum(10));
        System.out.println("product = " + product(3, -5));
    }
}
