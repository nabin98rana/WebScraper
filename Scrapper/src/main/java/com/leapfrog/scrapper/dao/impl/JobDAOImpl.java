/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.scrapper.dao.impl;

import com.leapfrog.scrapper.dao.JobDAO;
import com.leapfrog.scrapper.entity.Job;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author Navin
 */
public class JobDAOImpl implements JobDAO{
private List<Job> jobList=new ArrayList<>();
    @Override
    public void insert(Job t) {
        jobList.add(t);
    }

    @Override
    public List<Job> getAll() {
        return jobList;
    }

    @Override
    public void export(String fileName) throws IOException {
        FileWriter writer=new FileWriter(fileName);
        StringBuilder builder=new StringBuilder();
        for(Job j:jobList){
        builder.append(j.toCSV());
        }
        writer.write(builder.toString());
        writer.close();
    }


    @Override
    public List<Job> search(Predicate<Job> p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
