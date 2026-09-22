import java.util.*;

public class TFIDFCosine {

    // Calculate Term Frequency
    private static double termFrequency(String term, String document) {

        String[] words = document.toLowerCase().split("\\W+");

        int count = 0;

        for (String word : words) {

            if (word.equals(term)) {
                count++;
            }
        }

        if (words.length == 0) {
            return 0;
        }

        return (double) count / words.length;
    }

    // Calculate Inverse Document Frequency
    private static double inverseDocumentFrequency(
            String term,
            List<String> documents) {

        int documentCount = 0;

        for (String document : documents) {

            String[] words =
                    document.toLowerCase().split("\\W+");

            for (String word : words) {

                if (word.equals(term)) {

                    documentCount++;
                    break;
                }
            }
        }

        if (documentCount == 0) {
            return 0;
        }

        return Math.log(
                (double) documents.size()
                        / documentCount);
    }

    // Create TF-IDF vector
    private static Map<String, Double> createVector(
            String document,
            List<String> allDocuments) {

        Map<String, Double> vector =
                new HashMap<>();

        String[] words =
                document.toLowerCase().split("\\W+");

        Set<String> uniqueWords =
                new HashSet<>();

        for (String word : words) {

            if (!word.isEmpty()) {
                uniqueWords.add(word);
            }
        }

        for (String word : uniqueWords) {

            double tf =
                    termFrequency(word, document);

            double idf =
                    inverseDocumentFrequency(
                            word,
                            allDocuments);

            double tfidf = tf * idf;

            vector.put(word, tfidf);
        }

        return vector;
    }

    // Calculate Cosine Similarity
    public static double cosineSimilarity(
            String document1,
            String document2,
            List<String> allDocuments) {

        Map<String, Double> vector1 =
                createVector(
                        document1,
                        allDocuments);

        Map<String, Double> vector2 =
                createVector(
                        document2,
                        allDocuments);

        Set<String> allTerms =
                new HashSet<>();

        allTerms.addAll(vector1.keySet());
        allTerms.addAll(vector2.keySet());

        double dotProduct = 0;
        double magnitude1 = 0;
        double magnitude2 = 0;

        for (String term : allTerms) {

            double value1 =
                    vector1.getOrDefault(term, 0.0);

            double value2 =
                    vector2.getOrDefault(term, 0.0);

            dotProduct += value1 * value2;

            magnitude1 += value1 * value1;

            magnitude2 += value2 * value2;
        }

        if (magnitude1 == 0 || magnitude2 == 0) {
            return 0;
        }

        return dotProduct /
                (Math.sqrt(magnitude1)
                        * Math.sqrt(magnitude2));
    }
}