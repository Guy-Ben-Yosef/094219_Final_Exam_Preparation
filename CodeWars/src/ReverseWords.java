public class ReverseWords
{
    public static String reverseWords(final String original)
    {
        String[] words = original.split(" ");
        if ((original.length() == 0) || (words.length == 0)) {
        return original;
        }
        int i = 0;
        for (String word : words) {
            String spacesAtStart = "";
            String spacesAtEnd = "";
            for (int k = 0; k < word.length(); k++) {
                if (word.charAt(k) == ' ') {
                    spacesAtStart += " ";
                } else {
                    break;
                }
            }
            for (int k = word.length() - 1; k >= 0; k--) {
                if (word.charAt(k) == ' ') {
                    spacesAtEnd += " ";
                } else {
                    break;
                }
            }
            word = spacesAtStart + new StringBuilder(word.trim()).reverse().toString() + spacesAtEnd;
            words[i] = word;
            i++;
        }
        return String.join(" ", words);
    }
}