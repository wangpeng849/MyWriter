package com.wangp.myaop.design_pattern.behavioral.memento;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/28 22:44
 **/
public class Test {

    public static void main(String[] args) {
        ArticleMementoManager articleMementoManager = new ArticleMementoManager();
        Article article = new Article("A", "哈哈哈哈哈哈", "图片1");
        ArticleMemento articleMemento = article.saveToMemento();
        articleMementoManager.addMemento(articleMemento);
        System.out.println(articleMemento + "存入成功！");
        System.out.println("修改手记start");
        article.setTitle("B");
        article.setContent("呵呵呵呵呵呵");
        article.setImgs("图片2");
        System.out.println("修改手记end");
        articleMemento = article.saveToMemento();
        articleMementoManager.addMemento(articleMemento);
        System.out.println(articleMemento + "  存入成功！");
        article.setTitle("C");
        article.setContent("嘿嘿嘿嘿嘿");
        article.setImgs("图片3");
        System.out.println(article);
        System.out.println("暂存回退start");
        System.out.println("退一次");
        article.undoFromMemento(articleMementoManager.getMemento());
        System.out.println(article);
        System.out.println("退两次");
        article.undoFromMemento(articleMementoManager.getMemento());
        System.out.println(article);
        System.out.println("暂存回退end");
        System.out.println(article);
    }
}
