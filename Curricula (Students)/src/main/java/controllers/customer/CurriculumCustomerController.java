/* CurriculumCustomerController.java
 *
 * Copyright (C) 2016 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package controllers.customer;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.CurriculumService;
import controllers.AbstractController;
import domain.Curriculum;


@Controller
@RequestMapping("curriculum/customer")
public class CurriculumCustomerController extends AbstractController {

	// Services ---------------------------------------------------
	
	@Autowired
	private CurriculumService curriculumService;
	
	// Constructors -----------------------------------------------
	
	public CurriculumCustomerController() {
		super();
	}
	
	// Listing ----------------------------------------------------
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView res;
		Collection<Curriculum> curricula;
		
		curricula = curriculumService.findByPrincipal();
		
		res = new ModelAndView("curriculum/list");
		res.addObject("curricula", curricula);

		return res;
	}
	
	// Creating --------------------------------------------------
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView res;
		Curriculum curriculum;
		
		curriculum = curriculumService.create();
		res = createEditModelAndView(curriculum);
		
		return res;
	}
	
	// Editing ---------------------------------------------------
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int curriculumId) {
		ModelAndView res;
		Curriculum curriculum;
		
		curriculum = curriculumService.findOneToEdit(curriculumId);
		Assert.notNull(curriculum);
		res = createEditModelAndView(curriculum);
		
		return res;
	}
	
	// Saving ---------------------------------------------------
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid Curriculum curriculum, BindingResult binding) {
		ModelAndView res;
		
		if(binding.hasErrors()) {
			res = createEditModelAndView(curriculum);
		} else {
			try {
				curriculumService.save(curriculum);
				res = new ModelAndView("redirect:list.do");
			} catch (Throwable th) {
				res = createEditModelAndView(curriculum, "curriculum.commit.error");
			}
		}
		
		return res;
	}
	
	// Deleting ------------------------------------------------
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(Curriculum curriculum, BindingResult binding) {
		ModelAndView res;
		
		try {
			curriculumService.delete(curriculum);
			res = new ModelAndView("redirect:list.do");
		} catch (Error th) {
			res = createEditModelAndView(curriculum, "curriculum.commit.error");
		}
		
		return res;
	}
	
	// Ancillary methods ---------------------------------------
	
	protected ModelAndView createEditModelAndView(Curriculum curriculum) {
		ModelAndView res;
		
		res = createEditModelAndView(curriculum, null);
		
		return res;
	}
	
	protected ModelAndView createEditModelAndView(Curriculum curriculum, String message) {
		ModelAndView res;
		
		res = new ModelAndView("curriculum/edit");
		res.addObject("curriculum", curriculum);
		res.addObject("message", message);
		
		return res;
	}
		
}