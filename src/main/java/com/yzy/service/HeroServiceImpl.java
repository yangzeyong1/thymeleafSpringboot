package com.yzy.service;

import com.yzy.mapper.HeroMapper;
import com.yzy.pojo.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroMapper heroMapper;
    @Override
    public List<Hero> getAllHero() {
        List<Hero> heroes = heroMapper.selectAll();
        return heroes;
    }

    @Override
    public void addHero(Hero hero) {
        int insert = heroMapper.insert(hero);
        System.out.println("是否成功添加="+insert);
    }

    @Cacheable(value = "hero", key = "#root.args[0]", unless = "#result eq null ")
    @Override
    public Hero getHeroById(Integer id) {
        Hero hero = heroMapper.selectByPrimaryKey(id);
        return hero;
    }

    @Override
    public void updateHero(Hero hero) {
        heroMapper.updateByPrimaryKey(hero);
    }

    @Override
    public void deleteHero(Integer id) {
        heroMapper.deleteByPrimaryKey(id);
    }
}
