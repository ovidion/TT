package com.touch.t;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sachag
 *
 */
@Service
public class JukeboxService {
	
	@Autowired
	private JukeboxDao jukeboxDao;
	
	@Autowired
	private SettingsDao settingsDao;
	

	/**
	 * @param settingId
	 * @param model
	 * @param offset
	 * @param limit
	 * @return
	 */
	public Collection<Jukebox> getValidJukeboxes(String settingId, String model, Integer offset, Integer limit) {
		List<Jukebox> listJukeboxes = jukeboxDao.getJukeboxes();
		Settings listSettings = settingsDao.getSettings();
		
		Optional<Setting> setting = listSettings.getListSettings().stream().filter(s -> s.getId().equals(settingId)).findFirst();
		
		if (!setting.isPresent()) {
			return Collections.emptyList();
		}
		Collection<String> requirements = setting.get().getRequires();
		
		List<Jukebox> result = listJukeboxes.stream()
			.filter(j -> model == null || j.getModel().equals(model))
			.filter(j -> j.getComponentNames().containsAll(requirements))
			.skip(offset)
			.limit(limit == 0 ? listJukeboxes.size() : limit)
			.collect(Collectors.toList());
		
		return result;
	}
	
}