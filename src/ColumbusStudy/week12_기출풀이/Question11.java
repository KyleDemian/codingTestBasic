package ColumbusStudy.week12_기출풀이;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Question11 {

    // https://www.acmicpc.net/problem/22859

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        Pattern dTag = Pattern.compile("<div title=\"(.*?)\">(.*?)</div>");
        Matcher dMat = dTag.matcher(str);

        while (dMat.find()) {
            String title = dMat.group(1);
            sb.append("title : ").append(title).append("\n");

            String contents = dMat.group(2);
            Pattern pTag = Pattern.compile("<p>(.*?)</p>");
            Matcher pMat = pTag.matcher(contents);

            while (pMat.find()) {
                String text = pMat.group(1);
                text = text.replaceAll("<.*?>", " ");
                text = text.replaceAll("\\s{2,}", " ");
                text = text.trim();

                sb.append(text).append("\n");
            }
        }
        System.out.print(sb);
    }
}
