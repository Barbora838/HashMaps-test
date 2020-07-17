import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Document {

    // jaky je rozdil mezi final/non final variable?
    // https://stackoverflow.com/questions/4399837/what-is-the-benefit-of-purely-functional-data-structure
    private final String documentId;
    private final AtomicInteger likes = new AtomicInteger(0);
    private final AtomicInteger dislikes = new AtomicInteger(0);
    // jaky je rozdil mezi HashMap a ConcurrentHashMap ?
    private final Map<String, AtomicInteger> tags = new ConcurrentHashMap<>();

    public Document(String docId) {
        this.documentId = docId;
    }

    //metoda pocitajici rating dokumentu
    public double getDocumentRating() {
        // returns 0 when both rating(likes & dislikes) are zero
        if (this.likes.get() == 0 && this.dislikes.get() == 0) {
            return 0.0;
        }
        //returns 100 when at least one of the rating(likes & dislikes) is zero
        if (this.likes.get() == 0 && this.dislikes.get() == 0) {
            return 100.0;
        }

        double numLikes = this.likes.get();
        double numDislikes = this.dislikes.get();
        double total = numLikes + numDislikes;

        double percentage = (numLikes / total);
        double result = percentage * 100;
        return result;
    }

    public void like() {
        likes.incrementAndGet();
    }

    public void dislike() {
        dislikes.incrementAndGet();
    }

    public void addTag(final String tag) {
        tags.computeIfAbsent(tag.strip().toLowerCase(), t -> new AtomicInteger(0)).incrementAndGet();
    }

    public Map<String, Integer> getTags() {
        final Map<String, Integer> result = new HashMap<>();
        this.tags.entrySet().forEach(e -> {
            result.put(e.getKey(), e.getValue().get());
        });
        return result;
    }

    public String getDocumentId() {
        return documentId;
    }
}

