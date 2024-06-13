package com.oyakatasushi.core.services;

import com.oyakatasushi.core.entities.Sushi;
import com.oyakatasushi.core.repositories.ISushiRepository;

import java.util.List;

public class SushiServiceImpl implements ISushiService{

    private ISushiRepository sushiRepository;

    public SushiServiceImpl(ISushiRepository sushiRepository){
        this.sushiRepository = sushiRepository;
    }
    @Override
    public Sushi getSushiById(Integer id) {
        return this.sushiRepository.getById(id);
    }
    @Override
    public List<Sushi> getSushisListByTerms(String term) {
        return this.sushiRepository.getSushisListByTerms(term);
    }
    @Override
    public List<Sushi> getSushisListForPage(Integer pageNumber, Integer pageSize) {
        return this.sushiRepository.getSushisListForPage(pageNumber, pageSize);
    }
    @Override
    public long getNumberTotalOfSushis() {
        return this.sushiRepository.getNumberTotalOfSushis();
    }
}
