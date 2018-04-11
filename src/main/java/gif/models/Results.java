package gif.models;

public class Results {

    String url;
    Media[] media;
    int shares;
    String title;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Media[] getMedia() {
        return media;
    }

    public void setMedia(Media[] media) {
        this.media = media;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
