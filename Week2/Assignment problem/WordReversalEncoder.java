public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        if (sentence == null) {
            return "";
        }

        String[] words = sentence.split(" ");
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder wordBuilder = new StringBuilder();
            
            // Build the reversed word character by character using a loop
            for (int j = words[i].length() - 1; j >= 0; j--) {
                wordBuilder.append(words[i].charAt(j));
            }

            resultBuilder.append(wordBuilder);

            // Add space between words (except after the last word)
            if (i < words.length - 1) {
                resultBuilder.append(" ");
            }
        }

        String result = resultBuilder.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        // Sample Test Case
        reverseEachWord("hello club");
    }
}