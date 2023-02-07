package com.touch.t;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author sachag
 *
 */
@RestController
public class JukeboxController {

	@Autowired
	private JukeboxService jukeboxService;
	
	/**
	 * @param settingId
	 * @param model
	 * @param offset
	 * @param limit
	 * @return
	 */
	@GetMapping("/jukebox/get-by-setting-id")
	public Collection<Jukebox> getBySettingId(
			@RequestParam String settingId,
			@RequestParam(required = false) String model,
			@RequestParam(required = false, defaultValue = "0") Integer offset,
			@RequestParam(required = false, defaultValue = "0") Integer limit) {
		
		validateGetBySettingId(settingId, offset, limit);
		return jukeboxService.getValidJukeboxes(settingId, model, offset, limit);		
	}
	
	private void validateGetBySettingId(String settingId, Integer offset, Integer limit) {
		if (offset < 0 || limit < 0 || settingId.isBlank()) {
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid parameters", null);
		}
	}
	
}