package com.yzy.service;

import com.yzy.pojo.Hero;

import java.util.List;

public interface HeroService {
    public List<Hero> getAllHero();
    public void addHero(Hero hero);
    public Hero getHeroById(Integer id);
    public void updateHero(Hero hero);
    public void deleteHero(Integer id);
}
