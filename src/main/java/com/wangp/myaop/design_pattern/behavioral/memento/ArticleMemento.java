package com.wangp.myaop.design_pattern.behavioral.memento;

/**
 * <pre>
 * classname ArticleMemento
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/28 22:36
 **/
public class ArticleMemento {

    private String title;
    private String content;
    private String imgs;

    public String getTitle() {
        return title;
    }
    
    public String getContent() {
        return content;
    }

    public String getImgs() {
        return imgs;
    }


    public ArticleMemento(String title, String content, String imgs) {
        this.title = title;
        this.content = content;
        this.imgs = imgs;
    }

    @Override
    public String toString() {
        return "ArticleMemento{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imgs='" + imgs + '\'' +
                '}';
    }
}
