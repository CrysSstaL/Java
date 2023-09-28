import java.util.Arrays;


public class lab_2 {
    public static void main(String[] args) {
//        point_1();
//        point_2();
//        point_3();
//        point_4();
//        point_5();
//        point_6();
//        point_7();
//        point_8();
    }
    public static void point_1(){  // №1 Наибольшая идентичная строка
        String str = "ffqzxqwfmwgmqlbw";
        int len;
        len = str.length();
        StringBuilder string_symbols = new StringBuilder();
        char[] array_symbols = new char[len];
        int i = 0, first = 0;
        int j = 0, second = 0;
        int result = 0;
        for (int k = 0; k < len; k++)
        {
            array_symbols[k] = str.charAt(k);
        }
        while (j < len && i < len)
        {
            if (string_symbols.toString().indexOf(array_symbols[j]) == -1) // если не повторяется
            {
                string_symbols.append(array_symbols[j]);
                j++;
                if (j - i > result)
                {
                    first = i;
                    second = j;
                    result = j - i;
                }
            }
            else       // если повторяется
            {
                if (i == j)
                {
                    j++;
                }
                string_symbols = new StringBuilder(string_symbols.toString().replace(array_symbols[i], ' '));
                i++;
            }
        }
        System.out.println(str.substring(first, second));
    }
    public static void point_2() // №2 Обьеинение массивов
    {
        int[] array_1 = new int[] {3, 6, 3000, 4670};
        int[] array_2 = new int[] {-10,-9, 2000, 4000, 10000};
        int size1 = array_1.length, size2 = array_2.length;
        int[] result_array = new int[size1 + size2];
        System.arraycopy(array_1, 0, result_array, 0, size1);
        int iter = 0;
        for (int i = size1; i < size1 + size2; i++)
        {
            result_array[i] = array_2[iter];
            iter++;
        }
        Arrays.sort(result_array);
        for (int i = 0; i < size1 + size2; i++)
        {
            System.out.println(result_array[i]);
        }

    }
    public static void point_3() // №3 Максимальная сумма подмассива
    {
        int[] arr = new int[] {-15, 9, -7, 10, 37, 45, -42, 43, 1};
        int result = 0;
        int iter_max = 0;
        int max;
        for (int elem : arr)
        {
            iter_max = iter_max + elem;
            iter_max = Math.max(iter_max, 0);
            result = Math.max(result, iter_max);
        }
        max = Arrays.stream(arr).max().getAsInt();
        if (max < 0)
        {
            result = max;
        }
        System.out.println(result);
    }
    public static void point_4() // №4 Поворот массива на 90 градусов по часовой
    {
        int[][] array = new int[][]{
                {1, 4, 9, 16},
                {25, 36, 49, 64},
                {81, 100, 121, 144}
        };
        int[][] Transform_array = new int[array[0].length][array.length];
        for (int line = 0; line < array.length; line++)
        {
            for (int col = 0; col < array[0].length; col++)
            {
                Transform_array[col][array.length - line - 1] = array[line][col];
            }
        }
        for (int[] line : Transform_array)
        {
            for (int number : line)
            {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
    public static void point_5() // №5 Поиск пары элементов с заданной суммой
    {
        int[] array = new int[] {-23, 45, 55, -56, 95, 4, 71};
        int target = 150;
        int first = -1 , second = -1;
        for (int first_iter = 0; first_iter < array.length; first_iter++)
        {
            for (int second_iter = 0; second_iter < array.length; second_iter++)
            {
                if (array[first_iter] + array[second_iter] == target)
                {
                    first = first_iter;
                    second = second_iter;
                }
            }
        }
        if (first != -1)
        {
            System.out.println(array[first] + " " + array[second]);
        }
        else
        {
            System.out.println("null");
        }
    }
    public static void point_6() // №6 Сумма всех элементов в двумерном массиве
    {
        int[][] array = new int[][]{
                {1, 4, 9, 16},
                {25, 36, 49, 64},
                {81, 100, 121, 144}
        };
        int result = 0;
        for (int[] line : array)
        {
            for (int number : line)
            {
                result += number;
            }
        }
        System.out.println(result);
    }
    public static void point_7() // №7 Максимальный элемент каждой строки двумерного массива
    {
        int[][] array = new int[][]{
                {1, 4, 9, 16},
                {25, 36, 49, 64},
                {81, 100, 121, 144}
        };
        int[] result = new int[array.length];
        Arrays.fill(result, Integer.MIN_VALUE);
        for (int line = 0; line < array.length; line++)
        {
            for (int number = 0; number < array[line].length; number++)
            {
                if (array[line][number] > result[line])
                {
                    result[line] = array[line][number];
                }
            }
            System.out.print(result[line] + " ");
        }
    }
    public static void point_8() // №8 Поворот двумерного массива на 90 градусов против часовой
    {
        int[][] array = new int[][]{
                {1, 4, 9, 16},
                {25, 36, 49, 64},
                {81, 100, 121, 144}
        };
        int[][] Transform_array = new int[array[0].length][array.length];
        for (int line = 0; line < array.length; line++)
        {
            for (int col = 0; col < array[0].length; col++)
            {
                Transform_array[col][line] = array[line][array[0].length - col - 1];
            }
        }
        for (int[] line : Transform_array)
        {
            for (int number : line)
            {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

}