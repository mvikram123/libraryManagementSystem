import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        solve();
    }

    public static void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of elements
        int arr[] = new int[n];
        // Initializing array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt(); // No. of times to rotate
        rotateArray(arr, n, k);
    }

    public static void rotateArray(int arr[], int n, int k) {
        // Write code here
        int temp[]=new int[n];
        int j=0;
        for(int i=k; i<n; i++)
        {
            temp[j]=arr[i];
            j++;
        }
        for(int i=0; i<k; i++)
        {

            temp[j]=arr[i];
            j++;
        }
        for(int i=0; i<n; i++)
        {
            arr[i]=temp[i];
            System.out.print(arr[i]+" ");
        }

    }

}
//input =8
//7 5 2 11 2 43 1 1
//2
// output=2 11 2 43 1 1 7 5