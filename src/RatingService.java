import java.util.HashMap;
import java.util.Map;

public class RatingService {

    private final Map<String, Document> allDocuments = new HashMap<>();

    public void like(final String docId) {
        allDocuments.computeIfAbsent(docId, Document::new).like();
    }

    public void dislike(final String docId) {
        allDocuments.computeIfAbsent(docId, Document::new).dislike();
    }

    public Map<String, Document> getAllDocuments() {
        return allDocuments;
    }

    public static void main(String[] args) {

        RatingService r = new RatingService();

        r.like("doc123");
        r.like("doc123");

        r.dislike("doc123");
        r.dislike("doc123");

        final double rating = r.getAllDocuments().get("doc123").getDocumentRating();
        if (rating == 0.5d) {
            System.out.println("CORRECT");
        } else {
            System.out.println("ERROR");
        }

    }
}
