package com.praksa.ivan.web.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.praksa.ivan.domain.UserCreateForm;
import com.praksa.ivan.model.Igrac;
import com.praksa.ivan.service.IgracService;
import com.praksa.ivan.support.IgracDTOToIgrac;
import com.praksa.ivan.support.IgracToIgracDTO;
import com.praksa.ivan.web.dto.IgracDTO;


@RestController
@RequestMapping("api/igraci")
public class ApiIgracController {

	@Autowired
	private IgracService igracService;
	
	@Autowired
	private IgracToIgracDTO toDTO;
	@Autowired
	private IgracDTOToIgrac toIgrac;
	
	//find all
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<IgracDTO>> getAll(
												@RequestParam(required = false) Long klubid,
												@RequestParam(required = false) String ime,
												@RequestParam(required = false) String prezime,
												@RequestParam(required = false) String pozicija,
												@RequestParam(defaultValue = "4") int pPoStrani,
												@RequestParam(defaultValue = "0") int pageNum) {

		Page<Igrac> igraci;
		
		if (klubid != null || ime != null || prezime != null || pozicija != null) {
			igraci = igracService.pretraga(klubid, ime,prezime,pozicija,pPoStrani, pageNum);
		} else {
			igraci = igracService.findAll(pageNum, pPoStrani);
		}
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(igraci.getTotalPages()));
		return new ResponseEntity<>(toDTO.convert(igraci.getContent()), headers, HttpStatus.OK);
	}
	//find one
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<IgracDTO> get(@PathVariable Long id) {
		Igrac igrac = igracService.findOne(id);

		if (igrac == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(igrac), HttpStatus.OK);
	}
	
//	 @RequestMapping(value = "/igrac/create", method = RequestMethod.GET)
//	    public ModelAndView getUserCreatePage() {
////	        LOGGER.debug("Getting igrac create form");
//	        return new ModelAndView("igrac", "noviIgrac", new IgracDTO());
//	    }
//	
	
	
	
//	//dodaj novog
//	@PreAuthorize("hasAuthority('ADMIN')")
//	@RequestMapping(value = "/igrac/create", method = RequestMethod.POST)
//    public String handleUserCreateForm(@Valid @ModelAttribute("noviIgrac") IgracDTO noviIgrac, BindingResult bindingResult) {
////        LOGGER.debug("Processing user create form={}, bindingResult={}", noviIgrac, bindingResult);
//        if (bindingResult.hasErrors()) {
//            // failed validation
//            return "igrac";
//        }
//        try {
//        	Igrac igrac = toIgrac.convert(noviIgrac); 
//            igracService.save(igrac);
//        } catch (DataIntegrityViolationException e) {
////            LOGGER.warn("Exail", e);
////            bindingResult.reject("email.exists", "Email already exists");
//            return "igrac";
//        }
//        // ok, redirect
//        return "redirect:/#!/";
//    }
//	
//	
//	
	
		@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<IgracDTO> add(@Valid @ModelAttribute("noviIgrac") IgracDTO noviIgrac, BindingResult bindingResult){
		
		Igrac igrac = toIgrac.convert(noviIgrac); 
		
		igracService.save(igrac);
		
		return new ResponseEntity<>(toDTO.convert(igrac), HttpStatus.CREATED);
	}
	//izmeni
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(method=RequestMethod.PUT,value="/{id}")
	public ResponseEntity<IgracDTO> edit(
			@PathVariable Long id,
			@RequestBody IgracDTO izmenjen){
		
		if(!id.equals(izmenjen.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Igrac igrac = toIgrac.convert(izmenjen); 
		igracService.save(igrac);
		
		return new ResponseEntity<>(toDTO.convert(igrac),
				HttpStatus.OK);
	}
	// brisanje
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public ResponseEntity<IgracDTO> delete(@PathVariable Long id){
		igracService.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<Void> validationHandler(DataIntegrityViolationException e){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
