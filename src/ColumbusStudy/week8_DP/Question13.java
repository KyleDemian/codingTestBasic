package ColumbusStudy.week8_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Question13 {
    // https://www.acmicpc.net/problem/2309

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                for (int k = j + 1; k < 9; k++) {
                    for (int l = k + 1; l < 9; l++) {
                        for (int m = l + 1; m < 9; m++) {
                            for (int n = m + 1; n < 9; n++) {
                                for (int o = n + 1; o < 9; o++) {
                                    if ((arr[i] + arr[j] + arr[k] + arr[l] + arr[m] + arr[n] + arr[o]) == 100) {
                                        set.add(arr[i]);
                                        set.add(arr[j]);
                                        set.add(arr[k]);
                                        set.add(arr[l]);
                                        set.add(arr[m]);
                                        set.add(arr[n]);
                                        set.add(arr[o]);

                                        ArrayList<Integer> list = new ArrayList<>(set);
                                        Collections.sort(list);

                                        list.stream().forEach(System.out::println);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
