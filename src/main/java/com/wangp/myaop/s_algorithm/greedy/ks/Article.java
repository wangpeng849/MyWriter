package com.wangp.myaop.s_algorithm.greedy.ks;

/**
 * @Author wangp
 * @Date 2020/6/4
 * @Version 1.0
 */
public class Article {
    public int weight;
    public int value;
    public double valueDensity;

    public Article(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.valueDensity = value * 1.0 / weight;
    }

    @Override
    public String toString() {
        return "Article{" +
                "weight=" + weight +
                ", value=" + value +
                ", valueDensity=" + valueDensity +
                '}';
    }
}
