import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class WebScrapping {
    Result resultFrame=new Result();
    private String [] webAdress = {"https://www.one.co.il/","https://www.vox.com/","https://www.maariv.co.il/","https://www.israelhayom.co.il/","https://www.globes.co.il/" };  // ע"מ לעשות זאת על 5 אתרים יכול לשים את כל כתובות האתרים הראשיות במערך ולפני שהwhile רץ עוד פעם להתקדם בכתובות המערך לכתובת הבאה
   private String [] classNames= {"one-article","c-entry-box--compact","category-five-articles-small-item","post-title","title" };
    private CompliteElement mostNew=new CompliteElement("","","");
    private CompliteElement secondNew=new CompliteElement("","","");
    private CompliteElement lastNew=new CompliteElement("","","");
    private CompliteElement tridNew=new CompliteElement("","","");
    private CompliteElement fourthNew=new CompliteElement("","","");
    private Stack<String> links=new Stack<>();
    private Stack<String> titels=new Stack<>();
    private Stack<String> bodyText=new Stack<>();



    public WebScrapping(String serchWord) {
        while (true) {

         for (int j = 0; j < webAdress.length; j++) {
                try {
                    Document mainDocument1 = Jsoup.connect(webAdress[j]).get(); // ***** פה יהיה מערך כתובות במיקום הi
                    Elements allElements1 = mainDocument1.getElementsByClass(classNames[j]); // ********חילוץ כל הכתבות***** פה יהיה מערך מזהים במיקום הi
                    for (Element element : allElements1) {
                        String linkToArticle = "";
                       if (j == 0) {
                        linkToArticle = element.attr("href"); //  חילוץ כל הלינקים
                       } else {
                            Element linkElement = element.child(0);
                            linkToArticle = linkElement.attr("href"); //  חילוץ כל הלינקים
                      }

                        if (linkToArticle != null && linkToArticle.length() > 0) { //  מונע את קריסת התוכנית כאשר יש href ללא קישור ממשי
                            try {    // למניעת קריסה של קישור לא תקין
                                Document secondDocument1 = null; //  כניסה לכל הכתבות
                                if (linkToArticle.charAt(0) != 'h') {   //  בדיקה שהלינק אכן מתחיל ב http
                                    secondDocument1 = Jsoup.connect(webAdress[j] + linkToArticle).get();
                                    System.out.println(webAdress[j] + linkToArticle);
                                } else {
                                    secondDocument1 = Jsoup.connect(linkToArticle).get();
                                    System.out.println(linkToArticle);
                                }
                                String[] wordArray = secondDocument1.text().split(" ");  // חיתוך כל מילות הכתבה למערך
                                for (int i = 0; i < wordArray.length; i++) {
                                    if (serchWord.equals(wordArray[i])) {  //  במידה והמילה נמצאה הכנס לי את הערכים למחסניות ההתאמות המתאימות
                                        bodyText.add(secondDocument1.text());
                                        titels.add(secondDocument1.title());
                                        if (linkToArticle.charAt(0) != 'h') {   //  בדיקה שהלינק אכן מתחיל ב http
                                            links.add(webAdress[j]+ linkToArticle);
                                        }
                                        else {
                                            links.add(linkToArticle);
                                        }
                                        System.out.println(titels.size());
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
            if (!titels.isEmpty()) {  //  הכנסת הערכים מהמחסנית(ע"י ריקונם מהמחסנית) לאובייקט הסופי- העדכני ביותר
                mostNew.setLink(links.pop());
                mostNew.setTitle(titels.pop());
                mostNew.setElementBody(bodyText.pop());

            }
            if (!titels.isEmpty()) {  //  הכנסת הערכים מהמחסנית(ע"י ריקונם מהמחסנית) לאובייקט הסופי- השני הכי עדכני
                secondNew.setLink(links.pop());
                secondNew.setTitle(titels.pop());
                secondNew.setElementBody(bodyText.pop());

            }
            if (!titels.isEmpty()) {  //  הכנסת הערכים מהמחסנית(ע"י ריקונם מהמחסנית) לאובייקט השלישי -הכי פחות עדכני
                tridNew.setLink(links.pop());
                tridNew.setTitle(titels.pop());
                tridNew.setElementBody(bodyText.pop());
            }
            if (!titels.isEmpty()) {  //  הכנסת הערכים מהמחסנית(ע"י ריקונם מהמחסנית) לאובייקט הרביעי -הכי פחות עדכני
                fourthNew.setLink(links.pop());
                fourthNew.setTitle(titels.pop());
                fourthNew.setElementBody(bodyText.pop());
            }
            if (!titels.isEmpty()) {  //  הכנסת הערכים מהמחסנית(ע"י ריקונם מהמחסנית) לאובייקט הסופי-הכי פחות עדכני
                lastNew.setLink(links.pop());
                lastNew.setTitle(titels.pop());
                lastNew.setElementBody(bodyText.pop());
            }
            System.out.println(titels.size());

            // למחוק  TODO
        System.out.println(mostNew);
        System.out.println(secondNew);
        System.out.println(tridNew);
        System.out.println(fourthNew);
        System.out.println(lastNew);


            resultFrame.setTextAreaMost(mostNew.getLink() + "\n" + mostNew.getTitle() + "\n" + mostNew.getElementBody());
            resultFrame.setTextAreaSecond(secondNew.getLink() + "\n" + secondNew.getTitle() + "\n" + secondNew.getElementBody());
            resultFrame.setTextAreaTrid(tridNew.getLink() + "\n" + tridNew.getTitle() + "\n" + tridNew.getElementBody());
            resultFrame.setTextAreaFourth(fourthNew.getLink() + "\n" + fourthNew.getTitle() + "\n" + fourthNew.getElementBody());
            resultFrame.setTextAreaLast(lastNew.getLink() + "\n" + lastNew.getTitle() + "\n" + lastNew.getElementBody());

            while (!titels.isEmpty()) {  //  ריקון המחסניות בסיום כל הרצה ע"מ לחסוך משאבים
                links.pop();
                titels.pop();
                bodyText.pop();
            }
        }
    }
}

