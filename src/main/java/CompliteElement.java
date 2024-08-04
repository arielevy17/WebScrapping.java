

public class CompliteElement {
    private String link;
    private String title;
    private String elementBody;

    public CompliteElement(String link, String title, String elementBody) {
        this.link = link;
        this.elementBody = elementBody;
    }
    public String toString(){
        String ans="link: " + link + "\n"+ elementBody;
        return ans;
    }

    public void catTheBody(){ //הוספת ירידת שורות לטקסט הכתבה
        int wordCounter = 0;
        char[] charArray = this.elementBody.toCharArray(); // המרת המחרוזת למערך תווים
        for (int i=0; i<charArray.length; i++){ // ריצה על כל מילות הכתבה
            if (charArray[i] == ' '){ // בדיקה האם זה רווח בין מילים
                wordCounter ++;
                if (wordCounter %5 == 0){ // כל 6 מילים תתבצע ירידת שורה
                    charArray[i] = '\n';
                }
            }
        }
        this.elementBody = new String(charArray);
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
        this.catTheBody();
    }
}
