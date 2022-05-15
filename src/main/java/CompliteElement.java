import org.jsoup.nodes.Element;

public class CompliteElement {
    private String link;
    private String title;
    private String elementBody;

    public CompliteElement(String link, String title, String elementBody) {
        this.link = link;
        this.title = title;
        this.elementBody = elementBody;
    }
    public String toString(){
        String ans="link: " + link+"\ntitle: " + title +"\n"+ elementBody;
        return ans;
    }



    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getElementBody() {
        return elementBody;
    }

    public void setElementBody(String elementBody) {
        this.elementBody = elementBody;
    }
}
