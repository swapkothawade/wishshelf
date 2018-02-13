package com.wishshelf.category;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class WishCategoryController {


	@Autowired
	private WishCategoryRepository wishcategoryRepo;
	
	@Autowired
	private MessageSource resource;
	
	@RequestMapping(value="/wishcategories", method=RequestMethod.GET)
	public List<WishCategory> wishcategories(){
		return wishcategoryRepo.findAll();
	}
	
	@RequestMapping(value="/wishcategories/{id}", method=RequestMethod.GET)
	public WishCategory wishcategoriesbyid(@PathVariable String id)throws Exception{
		WishCategory  cat = wishcategoryRepo.findOne(id);
		if(cat == null){
				throw new Exception("User { " + id + " }Not found ");
			
		}
		return cat; 
	}
	
	@RequestMapping(value="/wishcategories", method=RequestMethod.POST)
	public ResponseEntity wishcategories(@Valid @RequestBody WishCategory category){
		 WishCategory cat = wishcategoryRepo.save(category);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{d}").buildAndExpand(cat.get_id()).toUri();
		ResponseEntity t =ResponseEntity.created(location).build();
		 return t;
	}

	
	@RequestMapping(value="/wishcategories/{id}", method=RequestMethod.DELETE)
	public WishCategory deleteWishCategory(@PathVariable String id)throws Exception{
		WishCategory  cat = wishcategoryRepo.findOne(id);
		if(cat == null){
				throw new Exception("User { " + id + " }Not found ");
			
		}else{
			wishcategoryRepo.delete(id);
		}
		return cat; 
	}
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String sayHello(@RequestHeader(name="Accept-Language",required=false) Locale locale){
		
		return resource.getMessage("message.good.morning", null, locale);
	}
	
	
	
}
