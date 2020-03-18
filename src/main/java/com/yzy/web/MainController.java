package com.yzy.web;

import com.yzy.pojo.Hero;
import com.yzy.service.HeroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Api(value="用户mainController",tags={"Hero操作接口"})
@Controller
public class MainController {
    @Autowired
    private HeroService heroService;

    @GetMapping("/main")
    public String main(Model model){
        List<Hero> allHero = heroService.getAllHero();
        allHero.forEach(f -> System.out.println(f.getUsername()));
        model.addAttribute("heroList",allHero);
        return "main";
    }

    @ApiIgnore()
    @GetMapping("/add")
    public String add(){
        return "add";
    }

    @ApiIgnore()
    //添加
    @PostMapping("/addHero")
    public String addHero(Hero hero){
        heroService.addHero(hero);
        return "redirect:/main";
    }

    @ApiIgnore()
    //修改
    @PutMapping("/addHero")
    public String editHero(Hero hero){
        heroService.updateHero(hero);
        return "redirect:/main";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(Date.class,new PropertyEditorSupport(){
            public void setAsText(String value){
                try {
                    setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
                } catch (ParseException e) {
                    setValue(null);
                }
            }

            public String getAsText(){
                return new SimpleDateFormat("yyyy-MM-dd").format((Date)getValue());
            }
        });
    }

    @ApiIgnore()
    //查询
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        Hero hero = heroService.getHeroById(id);
        model.addAttribute("hero",hero);
        System.out.println(hero);
        return "add";
    }

    @ApiIgnore()
    @DeleteMapping("/edit/{id}")
    public String delete(@PathVariable("id") Integer id){
        heroService.deleteHero(id);
        return "redirect:/main";
    }

    @ApiOperation(value="获取id为传入值的hero",notes="根据id获取hero",httpMethod="GET")
    @ApiImplicitParams({@ApiImplicitParam(name="id",value="hero的id",dataType="Long", paramType = "path")})
    @GetMapping("/getHero/{id}")
    @ResponseBody
    public Hero getHero(@PathVariable("id") Integer id,Model model){
        Hero hero = heroService.getHeroById(id);
        return hero;
    }
}
