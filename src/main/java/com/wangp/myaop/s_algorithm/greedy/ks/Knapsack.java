package com.wangp.myaop.s_algorithm.greedy.ks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author wangp
 * @Date 2020/6/4
 * @Version 1.0
 */
public class Knapsack {
    public static void main(String[] args) {
        select("价值主导",(a1, a2) -> a2.value - a1.value);
        select("重量主导",(a1, a2) -> a1.weight - a2.weight);
        select("价值密度主导",(a1, a2) -> Double.compare(a2.valueDensity,a1.valueDensity));
    }

    static void select(String title,Comparator<Article> comparator) {
        Article[] articles = new Article[]{
                new Article(35, 10), new Article(30, 40),
                new Article(60, 30), new Article(50, 50),
                new Article(40, 35), new Article(10, 40),
                new Article(25, 30)
        };
        Arrays.sort(articles, comparator);

        int capacity = 150, weight = 0, value = 0;
        List<Article> articleList = new LinkedList<>();
        for (Article article : articles) {
            int newWeight = weight + article.weight;
            if (newWeight <= capacity) {
                weight = newWeight;
                value += article.value;
                articleList.add(article);
            }
        }

        System.out.println("【"+title+"】");
        System.out.println("总价值为:"+value);
        for (Article article : articleList) {
            System.out.println(article);
        }
        System.out.println("------------------------------");
    }
}
