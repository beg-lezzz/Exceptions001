public class Worker {

    /*
1. Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив.
Метод должен пройтись по каждому элементу и проверить что он не равен null.
А теперь реализуйте следующую логику:
Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя
Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”
 */

    public static void checkArray(Integer[] arr){
        StringBuilder forException= new StringBuilder();
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null){
                if (forException.isEmpty()){
                    forException.append(i);
                    counter++;
                } else {
                    forException.append(", ").append(i);
                    counter++;
                }
            }
        }

        if (!forException.isEmpty()){
            if (counter > 1){
                throw new RuntimeException("Null elements was occured in array more one time on indexes: " + forException);
            } else {
                throw new RuntimeException("Null elements was occured in array only one time on index " + forException);
            }
        } else {
            System.out.println("Null elements was not occured in array");
        }
    }

/*
2. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
 каждый элемент которого равен сумме элементов двух входящих массивов в той же ячейке.
 Если длины массивов не равны, необходимо как-то оповестить пользователя.
 */

    public static int[] sumEqualsArrays(int[] firstArr, int[] secondArr) {
        int[] resultArr;
        if (firstArr.length != secondArr.length) {
            throw new RuntimeException("Length of arrays is not equals");
        } else {
            resultArr = new int[firstArr.length];
            for (int i = 0; i < resultArr.length; i++) {
                resultArr[i] = firstArr[i] + secondArr[i];
            }
        }
        return resultArr;
    }

/*
3*. Реализуйте метод, принимающий в качестве аргументов двумерный массив.
Метод должен проверить что длина строк и столбцов с одинаковым индексом одинакова,
детализировать какие строки со столбцами не требуется.
 */

    public static void checkEqualsArrays(int[][] arr){

//        printTwoDimArray(arr);

        int max = arr[0].length;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length > max){
                max = arr[i].length;
            }
        }

        StringBuilder errorIndexes = new StringBuilder();
        int counter=0;
        for (int i = 0; i < max; i++) {
            counter = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].length > i){
                    counter++;
                }
            }

            if (arr.length <= i){
                errorIndexes.append(", ").append(i + 1);
            } else {
                if (counter != arr[i].length){
                    if (errorIndexes.isEmpty()){
                        errorIndexes.append(i + 1);
                    } else {
                        errorIndexes.append(", ").append(i + 1);
                    }
                }
            }
        }
        if (!errorIndexes.isEmpty()){
            throw new RuntimeException("Dimensions do not match in columns: " + errorIndexes);
        } else {
            System.out.println("All dimensions is match");
        }
    }


/*
Вспомогательные методы вне ДЗ
 */
    // метод печати одномерного массива
    public static void printArr(int[] arr){
        StringBuilder resultString = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (resultString.isEmpty()){
                resultString.append(arr[i]);
            } else {
                resultString.append(", ").append(arr[i]);
            }
        }
        System.out.println(resultString);
    }

    // метод печати двумерного массива
    public static void printTwoDimArray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(" " + arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

