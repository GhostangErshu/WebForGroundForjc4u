package club.jc4u.xzkt.serviceImpl;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.entity.Suggestion;
import club.jc4u.xzkt.mapper.SuggestionMapper;
import club.jc4u.xzkt.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class SuggestServiceImpl implements SuggestionService {

	@Autowired
	private SuggestionMapper suggestionMapper;

	private ResponseForm res;

	@Override
	public ResponseForm addNewSuggestion(Suggestion suggestion) {
		res = new ResponseForm();
		int result = 0;
		try {
			String time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
			suggestion.setTime(time);
			result = suggestionMapper.insNewSuggestion(suggestion);
		} catch (Exception e){
			res.setError(e.getMessage());
			return res;
		}
		res.setStatus(true);
		res.setContent(result);
		return res;
	}

}
