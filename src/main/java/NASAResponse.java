import com.fasterxml.jackson.annotation.JsonProperty;

public class NASAResponse {
    @JsonProperty("copyright")
    public String copyright;
    @JsonProperty("date")
    public String date;
    @JsonProperty("explanation")
    public String explanation;
    @JsonProperty("hdurl")
    public String hdurl;
    @JsonProperty("media_type")
    public String media_type;
    @JsonProperty("service_version")
    public String service_version;
    @JsonProperty("title")
    public String title;
    @JsonProperty("url")
    public String url;

    public NASAResponse() {
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "NASA response:" +
                "\n copyright: " + copyright +
                "\n date: " + date +
                "\n explanation: " + explanation +
                "\n hdurl: " + hdurl +
                "\n media_type: " + media_type +
                "\n service_version: " + service_version +
                "\n title: " + title +
                "\n url: " + url;
    }
}
