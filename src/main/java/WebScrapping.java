import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Stack;

public class WebScrapping {
    Result resultFrame = new Result();
    private String [] webAdress = {"https://www.one.co.il/","https://www.maariv.co.il/","https://www.israelhayom.co.il/","https://www.globes.co.il/" };  // כתובות האתרים
   private String [] classNames= {"one-article","category-five-articles-small-item","post-title","title" };
    private CompliteElement mostNew=new CompliteElement("","","");
    private CompliteElement secondNew=new CompliteElement("","","");
    private CompliteElement lastNew=new CompliteElement("","","");
    private CompliteElement tridNew=new CompliteElement("","","");
    private CompliteElement fourthNew=new CompliteElement("","","");
    private Stack<String> links=new Stack<>();
    private Stack<String> bodyText=new Stack<>();



    public WebScrapping(String searchWord) {
        while (true) {

         for (int j = 0; j < webAdress.length; j++) {
                try {
                    Document webAddress = Jsoup.connect(webAdress[j]).get(); //  מערך כתובות
                    Elements allElements = webAddress.getElementsByClass(classNames[j]); //  מערך מזהים
                    for (Element element : allElements) {
                        String linkToArticle = "";
                       if (j == 0) {
                        linkToArticle = element.attr("href"); //  חילוץ כל הלינקים
                       } else {
                            Element linkElement = element.child(0);
                            linkToArticle = linkElement.attr("href"); //  חילוץ כל הלינקים
                      }

                        if (linkToArticle != null && linkToArticle.length() > 0) { //  מונע את קריסת התוכנית כאשר יש href ללא קישור ממשי
                            try {    // למניעת קריסה של קישור לא תקין
                                Document allArticles = null; //  כניסה לכל הכתבות
                                if (linkToArticle.charAt(0) != 'h') {   //  בדיקה שהלינק אכן מתחיל ב http
                                    allArticles = Jsoup.connect(webAdress[j] + linkToArticle).get();
                                    System.out.println(webAdress[j] + linkToArticle);
                                } else {
                                    allArticles = Jsoup.connect(linkToArticle).get();
                                    System.out.println(linkToArticle);
                                }
                                String[] wordArray = allArticles.text().split(" ");  // חיתוך כל מילות הכתבה למערך
                                for (int i = 0; i < wordArray.length; i++) {
                                    if (searchWord.equals(wordArray[i])) {  //  במידה והמילה נמצאה הכנס לי את הערכים למחסניות ההתאמות המתאימות
                                        bodyText.add(allArticles.text());
                                        if (linkToArticle.charAt(0) != 'h') {   //  בדיקה שהלינק אכן מתחיל ב http
                                            links.add(webAdress[j]+ linkToArticle);
                                        }
                                        else {
                                            links.add(linkToArticle);
                                        }
                                        break;
                                    }
                                }
                            } catch (IOException e) {
                                System.out.println("link Invalid!!");
                            }
                        }

                    }
                } catch (IOException e) {
                    System.out.println("Please contact Technical Support: + 972-58 648 9811");
                }
         }
            if (!links.isEmpty()) {  //  הכנסת הערכים מהמחסנית(ע"י ריקונם מהמחסנית) לאובייקט הסופי- העדכני ביותר
                mostNew.setLink(links.pop());
                mostNew.setElementBody(bodyText.pop());


            }
            if (!links.isEmpty()) {  //  הכנסת הערכים מהמחסנית(ע"י ריקונם מהמחסנית) לאובייקט הסופי- השני הכי עדכני
                secondNew.setLink(links.pop());
                secondNew.setElementBody(bodyText.pop());

            }
            if (!links.isEmpty()) {  //  הכנסת הערכים מהמחסנית(ע"י ריקונם מהמחסנית) לאובייקט השלישי -הכי פחות עדכני
                tridNew.setLink(links.pop());
                tridNew.setElementBody(bodyText.pop());
            }
            if (!links.isEmpty()) {  //  הכנסת הערכים מהמחסנית(ע"י ריקונם מהמחסנית) לאובייקט הרביעי -הכי פחות עדכני
                fourthNew.setLink(links.pop());
                fourthNew.setElementBody(bodyText.pop());
            }
            if (!links.isEmpty()) {  //  הכנסת הערכים מהמחסנית(ע"י ריקונם מהמחסנית) לאובייקט הסופי-הכי פחות עדכני
                lastNew.setLink(links.pop());
                lastNew.setElementBody(bodyText.pop());
            }

        System.out.println(mostNew);
        System.out.println(secondNew);
        System.out.println(tridNew);
        System.out.println(fourthNew);
        System.out.println(lastNew);


            resultFrame.setTextAreaMost(mostNew.getLink()  + "\n" + mostNew.getElementBody());
            resultFrame.setTextAreaSecond(secondNew.getLink()  + "\n" + secondNew.getElementBody());
            resultFrame.setTextAreaTrid(tridNew.getLink() +  "\n" + tridNew.getElementBody());
            resultFrame.setTextAreaFourth(fourthNew.getLink()  +  "\n" + fourthNew.getElementBody());

            while (!links.isEmpty()) {  //  ריקון המחסניות בסיום כל הרצה ע"מ לחסוך משאבים
                links.pop();
                bodyText.pop();
            }
        }
    }
}

