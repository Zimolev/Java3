import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayMetods {

    public static void main(String[] args) {
        /**
         * Написать метод, которому в качестве аргумента передается не пустой одномерный
         * целочисленный массив. Метод должен вернуть новый массив,
         * который получен путем вытаскивания из исходного массива элементов,
         * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
         * иначе в методе необходимо выбросить RuntimeException.
         * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
         * Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
         */
        int[] massiveWithFour = {1,2,3,4,5,4,6,7,8,9,0};
        int[] massiveWithOutFour = {1,2,3,5,5,6,6,7,8,9,0};
        //checkIsFourOrNot(massiveWithOutFour);
        int[] printMassive;
        printMassive = checkIsFourOrNot(massiveWithFour);
        for (int i = 0; i < printMassive.length; i++) {
            System.out.println(printMassive[i]);
        }
    }
    public static int[] checkIsFourOrNot(int[] massive){

        int lastIndexOfFour = -1;
        if (massive == null || massive.length == 0)
        {
            throw new RuntimeException("Массив пустой");
        }
        for (int i = 0; i < massive.length; i++) {
           if (massive[i] == 4) {
                lastIndexOfFour = i+1;
           }
        }
        if (lastIndexOfFour < 0) {
            throw new RuntimeException();
        }
        else return Arrays.copyOfRange(massive, lastIndexOfFour, massive.length);
    }

}
