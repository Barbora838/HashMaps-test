import java.util.HashMap;
import java.util.function.Function;
import java.util.Map;
import java.util.Iterator;

public class RatingService {

    private final Map<String, Document> allDocuments = new HashMap<>();

    public void onNewHashTag(String name) {

        Document document = allDocuments.computeIfAbsent(name, s -> new Document(s));
        document.incrementCount();
    }

    public Map<String, Document> getAllDocuments() {
        return allDocuments;
    }

    public static void main(String[] args) {

        RatingService r = new RatingService();

        r.onNewHashTag("doc1");
        r.onNewHashTag("doc2");
        r.onNewHashTag("doc2");
        r.onNewHashTag("doc3");
        r.onNewHashTag("doc4");

        System.out.println(r.getAllDocuments());
    }
}
