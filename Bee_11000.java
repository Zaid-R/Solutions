
import java.io.*;
import java.util.ArrayList;

public class UVa_11000 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Long> arr = new ArrayList<>();
        arr.add((long) 1);
        arr.add((long) 1);
        ArrayList<Long> comu = new ArrayList<>();
        comu.add((long) 1);
        comu.add((long) 2);
        int n = 1;
        while ((n = Integer.parseInt(reader.readLine())) != -1) {
            if (n == 0) {
                writer.write(0 + " " + 1);
            } else if (arr.size() > n) {
                writer.write(comu.get(n - 1) + " " + comu.get(n));
            } else {
                int i = arr.size();
                while (arr.size() <= n) {
                    arr.add(arr.get(i - 1) + arr.get(i - 2));
                    comu.add(arr.get(i) + comu.get(i - 1));
                    i++;
                }
                writer.write(comu.get(n - 1) + " " + comu.get(n));
            }
            writer.newLine();
        }
        writer.flush();
    }
}
