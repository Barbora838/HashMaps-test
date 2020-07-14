import java.util.ArrayList;
import java.util.List;

public class Document {
    private String name;
    private List<String> rate = new ArrayList<>();
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

    public Document setName(String name) {
        this.name = name;
        return this;
    }

    public String toString(String n) {
        return n.toString();
    }

    /*
    public void setRating(String rate){
        if (rate == "like"){
            this.rating = rate;
        }
        else if (rate == "dislike"){
            this.rating = rate;
        }
        else{
            this.rating = null;
        }
    }
    */
}
