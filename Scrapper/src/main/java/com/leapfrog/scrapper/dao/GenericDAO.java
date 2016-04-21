/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.scrapper.dao;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author Navin
 */
public interface GenericDAO<T> {
    void insert(T t);
    List<T>getAll();
    void export(String fileName)throws IOException;
    List<T> search(Predicate<T> p);
    
}
