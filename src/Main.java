import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter the maximum value: ");
        if (userInput.hasNextInt()) {

            int max = userInput.nextInt();
            int[] primes = getPrimes(max);

            System.out.println("Primes smaller than " + max + " are: " + Arrays.toString(primes));

        }
    }

    protected static int[] getPrimes(int max) {

        boolean[] isComplex = new boolean[max + 1];

        for (int i = 2; (i * i) <= max; i++) {

            if (!isComplex[i]) {

                for (int j = i; (i * j) <= max; j++) {

                    isComplex[i*j] = true;

                }
            }
        }

        int numPrimes = 0;

        for (int i = 2; i <= max; i++) {

            if (!isComplex[i]) numPrimes++;

        }

        int [] primes = new int [numPrimes];
        int index = 0;

        for (int i = 2; i <= max; i++) {

            if (!isComplex[i]) {

                primes[index++] = i;

            }
        }

        return primes;

    }
}
