package com.uestc.designpattern.principle.openclose;

/**
 * @author CLthinking
 * @date 2019/7/15 下午 07:12
 */
public class JavaCource implements ICourse {
    private Integer Id;
    private String name;
    private Double price;

    public JavaCource(Integer id, String name, Double price) {
        Id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return this.Id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
