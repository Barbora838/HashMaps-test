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

        //testing document
        Document document = new Document("doc123" );
        document.setRating("like");
        document.setRating("dislike");
        document.setRating("like");
        document.setRating("dislike");
        System.out.println(document.getRates());

        document.setTags("užitečné");
        document.setTags("nepřehledné");
        document.setTags("aktuální");
        document.setTags("irelevantní");
        System.out.println(document.getTags());



        r.onNewHashTag("doc1");
        r.onNewHashTag("doc2");
        r.onNewHashTag("doc2");
        r.onNewHashTag("doc3");
        r.onNewHashTag("doc4");

        System.out.println(r.getAllDocuments());
    }
}
