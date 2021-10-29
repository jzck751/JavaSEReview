package cn.jackse.homework;

import java.util.ArrayList;

/**
 * @author Jack
 * @version 1.0
 * @description: homework1
 * @date 2021/10/29 8:49
 */

@SuppressWarnings({"all"})
public class Exercise1 {
    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();

        News news = new News("新冠确诊病例超过千万例，日常出行需谨之又甚");
        News news1 = new News("胶皮管覅你发给窘境瓶盖南方各地i舰炮i更孬ing");

        arrayList.add(news);
        arrayList.add(news1);

        int size = arrayList.size();

        for (int i = size - 1; i >= 0; i--) {
            System.out.println(subTitle(((News) arrayList.get(i)).getTitle()));
        }

    }

    //定义截取字符串的方法
    public static String subTitle(String title) {
        if (title == null) {
            return "";
        } else if (title.length() > 15) {
            return title.substring(0, 15) + "...";
        } else {
            return title;
        }
    }


}

class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }
}
