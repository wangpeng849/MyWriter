package com.wangp.myaop.design_pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * classname CoureCalalog
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/23 15:51
 **/
public class CourseCatalog extends CatalogComponent {

    private String name;
    private List<CatalogComponent> items = new ArrayList<>();
    private Integer level;

    public CourseCatalog(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(CatalogComponent catalogComponent) {
        items.add(catalogComponent);
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
        items.remove(catalogComponent);
    }

    @Override
    public void print() {
        System.out.println(this.name);
        for (CatalogComponent item : items) {
            if (this.level != null) {
                for (int i = 0; i < level; i++) {
                    System.out.print("  ");
                }
            }
            item.print();
        }
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }
}
