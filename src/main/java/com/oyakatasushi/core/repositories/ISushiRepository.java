package com.oyakatasushi.core.repositories;

import com.oyakatasushi.core.entities.Sushi;

import java.util.List;

public interface ISushiRepository {
    Sushi getById(Integer id);
    List<Sushi> getSushisListByTerms(String term);
    List<Sushi> getSushisListForPage(Integer pageNumber, Integer pageSize);
    long getNumberTotalOfSushis();
}