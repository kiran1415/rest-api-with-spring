package com.example.demo.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

import antlr.collections.List;

@RestController
public class Aliencontroller 

{
	@Autowired
	AlienRepo repo;
	
	
   @RequestMapping("home")
   public String  home()
   {
	   return "home.jsp";
   }
   @PostMapping("/alien")
   public Alien addAlien( Alien alien)
   {
	   repo.save(alien);
	   return alien;
   }
   
   @GetMapping(path="/aliens")
   public  java.util.List<Alien> getAliens()
    {
 	     return repo.findAll();
 	}
   
   @RequestMapping("/alien/{aid}")
   public Optional<Alien> getAlien( @PathVariable("aid") int aid)
   {
	     return repo.findById(aid);
	}
    @DeleteMapping("/alien/{aid}")
    public String DeleteAlien(@PathVariable int aid)
    {
    		Alien a=repo.getOne(aid);
    		repo.delete(a);
    				
    	    return "deleted";
    }
   
    @PutMapping("/alien")
    public Alien SaveorUpdate(@RequestBody  Alien alien)
    {
    	repo.save(alien);
    	return alien;
    }
   
}
