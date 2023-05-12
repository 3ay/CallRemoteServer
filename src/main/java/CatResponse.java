import com.fasterxml.jackson.annotation.JsonProperty;

public class CatResponse {
    @JsonProperty("id")
    String id;
    @JsonProperty("text")
    String text;
    @JsonProperty("type")
    String type;
    @JsonProperty("user")
    String user;
    @JsonProperty("upvotes")
    Integer upvotes;

    public CatResponse() {
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return "id: " + id +
                "\n text: " + text +
                "\n type: " + type +
                "\n user: " + user +
                "\n upvotes: " + upvotes;
    }
}
