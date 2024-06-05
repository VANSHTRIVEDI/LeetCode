package Medium.Miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class Find_Common_Characters {
    public List<String> commonChars(String[] words) {
        String t = words[0];
        int main[] = new int[26];
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            main[ch - 97]++;
        }

        for (int j = 1; j < words.length; j++) {
            String s = words[j];
            int temp[] = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                temp[ch - 97]++;
            }

            for (int i = 0; i < 26; i++) {
                if (main[i] == 0)
                    continue;

                else if (temp[i] == 0)
                    main[i] = 0;

                else {
                    main[i] = Math.min(main[i], temp[i]);
                }
            }

        }

        List<String> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {

            if (main[i] > 0) {
                char ch = (char) (i + 'a');
                String pp = String.valueOf(ch);
                for (int j = 0; j < main[i]; j++) {
                    arr.add(pp);
                }
            }
        }
        return arr;

    }
}
