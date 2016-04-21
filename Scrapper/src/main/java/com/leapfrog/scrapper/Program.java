/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.scrapper;

import com.leapfrog.scrapper.dao.JobDAO;
import com.leapfrog.scrapper.dao.impl.JobDAOImpl;
import com.leapfrog.scrapper.entity.Job;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Navin
 */
public class Program {

    public static void main(String[] args) {
        try {
            JobDAO jobDAO = new JobDAOImpl();
            URL url = new URL("http://jobsnepal.com");
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder builder = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            reader.close();
            String regEx = "<a class=\"job-item\"(.*?)href=\"(.*?)\"(.*?)>(.*?)</a>";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(builder.toString());

            while (matcher.find()) {
                //System.out.println("Job Title:"+matcher.group(4).trim());
                //System.out.println("Link:"+matcher.group(2));
                Job job = new Job(matcher.group(4).trim(), matcher.group(2));
                jobDAO.insert(job);
            }
           
            long time = Calendar.getInstance().getTimeInMillis();
            jobDAO.export("jobs-" + time + ".csv");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());

        }
    }

}
