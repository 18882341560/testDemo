package com.gelin.domain;

/**
 * Created by 葛林 on 2017/7/21.
 */
public class Markers {

    private Integer id;
    private String x;
    private String y;
    private String icon;

    public Markers() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "markers{" +
                "id=" + id +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
