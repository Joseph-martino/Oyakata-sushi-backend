package com.oyakatasushi.core.services;

import com.oyakatasushi.core.entities.Sushi;

import java.util.List;

public interface ISushiService {

    Sushi getSushiById(Integer id);
    List<Sushi> getSushisListByTerms(String term);
    List<Sushi> getSushisListForPage(Integer pageNumber, Integer pageSize);
    long getNumberTotalOfSushis();
}
