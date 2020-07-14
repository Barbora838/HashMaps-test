import java.util.ArrayList;
import java.util.List;

public class Document {
    private String name;
    private List<String> rates = new ArrayList<>();
    private List<String> tags = new ArrayList<>();
    public int counter;

    public Document(String n) {
        this.name = n;
    }

    public void incrementCount() {
        counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(String n) {
        return n.toString();
    }

    public void setRating(String rate) {
        if (rate == "like") {
            this.rates.add(rate);
        } else if (rate == "dislike") {
            this.rates.add(rate);
        } else {
            return;
        }
        counter++;
    }

    public void setTags(String tag) {
        if (tag == "užitečné" || tag == "aktuální" || tag == "jasné" || tag == "stručné" || tag == "objevné" ||
                tag == "nepřehledné" || tag == "moc dlouhé" || tag == "příliš stručné" || tag == "nesrozumitelné" ||
                tag == "irelevantní" || tag == "zastaralé") {
            this.tags.add(tag);
        }
    }

    public List<String> getRates() {
        return rates;
    }

    public List<String> getTags() {
        return tags;
    }
}
