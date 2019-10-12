package club.jc4u.xzkt.controller;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.entity.Suggestion;
import club.jc4u.xzkt.serviceImpl.SuggestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/suggestion")
@RestController
public class SuggestionController {
	
	@Autowired
	private SuggestServiceImpl suggestService;
	
	@RequestMapping("/add")
	ResponseForm addSuggestionById(Suggestion suggestion){
		return suggestService.addNewSuggestion(suggestion);
	}
}
