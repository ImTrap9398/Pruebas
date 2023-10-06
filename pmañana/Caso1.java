import java.util.Arrays;

public class Caso1 {

    public static void main(String[] args) {
        int[] num = {60,6,5,4,3,2,7,7,29,1};
        int eliminar = 6;

        // Crear un nuevo arreglo sin los números que contienen el número a eliminar
        int[] nuevo = eliminarNumeros(num, eliminar);

        // Ordenar el nuevo arreglo en orden descendente
        Arrays.sort(nuevo);
        descendente(nuevo);

        // El nuevo arreglo ahora contiene los números restantes en orden descendente
        System.out.println("Arreglo original: " + Arrays.toString(num));
        System.out.println("Nuevo arreglo en orden descendente: " + Arrays.toString(nuevo));
    }

    public static int[] eliminarNumeros(int[] num, int dig) {
        int count = 0; // Contador para contar cuántos números no deben eliminarse

        // Contar cuántos números no deben eliminarse
        for (int numero : num) {
            if (!contieneDigito(numero, dig)) {
                count++;
            }
        }

        // Crear un nuevo arreglo con el tamaño adecuado
        int[] nuevo = new int[count];
        int index = 0;

        // Copiar los números que no deben eliminarse al nuevo arreglo
        for (int numero : num) {
            if (!contieneDigito(numero, dig)) {
                nuevo[index] = numero;
                index++;
            }
        }

        return nuevo;
    }

    public static boolean contieneDigito(int num, int dig) {
        while (num != 0) {
            int d = num % 10;
            if (d == dig) {
                return true;
            }
            num /= 10;
        }
        return false;
    }

    public static void descendente(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}