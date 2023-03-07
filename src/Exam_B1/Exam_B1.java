package Exam_B1;

import java.util.Scanner;

public class Exam_B1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[100];
        int[] sizeArray = new int[1];
        sizeArray[0] = 100;
        int option;
        boolean inputStatus = false;
        do {
            System.out.print("\n****************HACKATHON-JAVA-BASIC-1-MENU***************\n" +
                    "1. Nhập số phần tử và giá trị cho các phần tử của mảng từ bàn phím\n" +
                    "2. In ra giá trị các phần tử trong mảng\n" +
                    "3. Tính tổng và in ra các phần tử có giá trị lẻ trong mảng\n" +
                    "4. In ra giá trị lớn nhất và nhỏ nhất trong mảng\n" +
                    "5. Thống kê số lượng phần tử chia hết cho 2 và 3 trong mảng\n" +
                    "6. In ra mảng đảo ngược\n" +
                    "7. In ra các phần tử và tổng số các phần tử là số nguyên tố trong mảng\n" +
                    "8. Sắp xếp mảng tăng dần\n" +
                    "9. Thoát\n");
            System.out.print("Nhập chức năng muốn thực thi: ");
            option = input.nextInt();
            if (option != 9) {
                switch (option) {
                    case 1:
                        inputArray(array, sizeArray);
                        break;
                    case 2:
                        printArray(array, sizeArray);
                        break;
                    case 3:
                        oddArray(array, sizeArray);
                        break;
                    case 4:
                        mixMaxArray(array, sizeArray);
                        break;
                    case 5:
                        chiaHaiBa(array, sizeArray);
                        break;
                    case 6:
                        reverseArray(array,sizeArray);
                        break;
                    case 7:
                        primeNumber(array,sizeArray);
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại");
                        break;
                }
            } else {
                System.out.println("Ứng dụng sẽ được kết thúc!!!");
            }
        } while (option != 9);
    }

    //B1. Nhập số phần tử và giá trị cho các phần tử của mảng từ bàn phím
    public static void inputArray(int[] array, int[] sizeArray) {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.print("Nhập độ dài của mảng : ");
            size = input.nextInt();
            if (size > 100) {
                System.out.print("Dộ dài mảng không quá 100 phần tử ");
            }
        }
        while (size > 100);
        sizeArray[0] = size;
        for (int i = 0; i < size; i++) {
            System.out.print("Nhập vào phần tử thứ  " + (i + 1) + " : ");
            array[i] = input.nextInt();
        }
        System.out.println("Đã nhập thành công ");
    }

    //B2. In ra giá trị các phần tử trong mảng
    public static void printArray(int[] array, int[] sizeArray) {
        Scanner input = new Scanner(System.in);
        int size = sizeArray[0];
        System.out.println("Các phần tử trong mảng : ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " \t ");
        }
    }

    //B3. Tính tổng và in ra các phần tử có giá trị lẻ trong mảng
    public static void oddArray(int[] array, int[] sizeArray) {
        int sum = 0;
        int size = sizeArray[0];
        System.out.print("Số lẻ là : ");
        for (int i = 0; i < size; i++) {
            if (array[i] % 2 != 0) {
                System.out.print(array[i] + "\t");
                sum += array[i];
            }
        }
        System.out.print(" \nTổng của các số lẻ là : " + sum);
    }

    //B4. In ra giá trị lớn nhất và nhỏ nhất trong mảng
    public static void mixMaxArray(int[] array, int[] sizeArray) {
        int min = array[0];
        int max = array[0];
        int size = sizeArray[0];
        for (int i = 0; i < size; i++) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Giá trị lớn nhất là : " + max);
        System.out.println("Giá trị nhỏ nhất là : " + min);
    }

    //B5. Thống kê số lượng phần tử chia hết cho 2 và 3 trong mảng
    public static void chiaHaiBa(int[] array, int[] sizeArray) {
        int size = sizeArray[0];
        System.out.println("Các phần tử chia hết cho 2 và 3 là : ");
        for (int i = 0; i < size; i++) {
            if (array[i] % 6 == 0)
                System.out.println(array[i] + " \t ");
        }
    }

    //B6. In ra mảng đảo ngược
    public static void reverseArray( int[] array, int[] sizeArray) {
        int size = sizeArray[0];
        for (int i = 0; i < size/2; i++) {
            int temp = array[i];
            array[i] = array[size-1-i];
            array[size-1-i] = temp;
        }
        System.out.print("\nDãy số đảo ngược là : ");
        for (int j = 0; j < size; j++) {
            System.out.print(array[j] + "\t");
        }
    }

    //B7. In ra các phần tử và tổng số các phần tử là số nguyên tố trong mảng
    public static void primeNumber(int[] intArray, int[] sizeArray) {
        int size = sizeArray[0];
        int sum = 0;
        System.out.print(" số nguyên tố trong mảng là: ");
        for (int i = 0; i < size; i++) {
            boolean primeCheck = isPrime(intArray[i]);
            if (primeCheck) {
                System.out.print(intArray[i] + "\t");
                sum += intArray[i];
            }
        }
        System.out.printf("\nTổng của các số nguyên tố trong mảng là:", sum);
    }
    public static boolean isPrime(int number) {
        boolean flag = true;
        if (number < 2) {
            flag = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}

