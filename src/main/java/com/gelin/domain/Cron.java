package com.gelin.domain;

/**
 * Created by 葛林 on 2017/7/19.
 */
public class Cron {


    private Integer id;
    private String cron;

    public Cron() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    @Override
    public String toString() {
        return "Cron{" +
                "id=" + id +
                ", cron='" + cron + '\'' +
                '}';
    }
}
