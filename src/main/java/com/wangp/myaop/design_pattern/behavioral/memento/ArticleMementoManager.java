package com.wangp.myaop.design_pattern.behavioral.memento;

import java.util.Stack;

/**
 * <pre>
 * classname ArticleMementoManage
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/28 22:37
 **/
public class ArticleMementoManager {

    private final Stack<ArticleMemento> ARTICLE_MEMENTO_STACK = new Stack<>();

    public ArticleMemento getMemento() {
        ArticleMemento articleMemento = ARTICLE_MEMENTO_STACK.pop();
        if (articleMemento == null) {
            throw new RuntimeException();
        }
        return articleMemento;
    }

    public void addMemento(ArticleMemento articleMemento) {
        ARTICLE_MEMENTO_STACK.push(articleMemento);
    }
}
