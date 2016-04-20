/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.scrapper.entity;

/**
 *
 * @author Navin
 */
public class Job {
    private String title,link;

    public Job() {
    }

    public Job(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Job{" + "title=" + title + ", link=" + link + '}';
    }
    public String toCSV() {
        return  title + ", " + link +"\r\n";
    }
    
}
