import java.util.*;

public class AhoCorasick {

    static class Node {
        Map<Character, Node> children = new HashMap<>();
        Node failure;
        List<String> output = new ArrayList<>();
    }

    private Node root;

    public AhoCorasick() {
        root = new Node();
        root.failure = root;
    }

    // Add a keyword to the Trie
    public void addPattern(String pattern) {

        pattern = pattern.toLowerCase().trim();

        Node current = root;

        for (char ch : pattern.toCharArray()) {

            if (!current.children.containsKey(ch)) {
                current.children.put(ch, new Node());
            }

            current = current.children.get(ch);
        }

        current.output.add(pattern);
    }

    // Build failure links using BFS
    public void buildFailureLinks() {

        Queue<Node> queue = new LinkedList<>();

        for (Node child : root.children.values()) {
            child.failure = root;
            queue.add(child);
        }

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            for (Map.Entry<Character, Node> entry :
                    current.children.entrySet()) {

                char ch = entry.getKey();
                Node child = entry.getValue();

                Node failureNode = current.failure;

                while (failureNode != root &&
                        !failureNode.children.containsKey(ch)) {

                    failureNode = failureNode.failure;
                }

                if (failureNode.children.containsKey(ch) &&
                        failureNode.children.get(ch) != child) {

                    child.failure = failureNode.children.get(ch);

                } else {

                    child.failure = root;
                }

                child.output.addAll(child.failure.output);

                queue.add(child);
            }
        }
    }

    // Search all keywords in the given text
    public Set<String> search(String text) {

        Set<String> foundPatterns = new LinkedHashSet<>();

        text = text.toLowerCase();

        Node current = root;

        for (char ch : text.toCharArray()) {

            while (current != root &&
                    !current.children.containsKey(ch)) {

                current = current.failure;
            }

            if (current.children.containsKey(ch)) {
                current = current.children.get(ch);
            }

            foundPatterns.addAll(current.output);
        }

        return foundPatterns;
    }
}