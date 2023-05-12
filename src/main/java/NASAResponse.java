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
    public String mediaType;
    @JsonProperty("service_version")
    public String serviceVersion;
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
                "\n media_type: " + mediaType +
                "\n service_version: " + serviceVersion +
                "\n title: " + title +
                "\n url: " + url;
    }
}
