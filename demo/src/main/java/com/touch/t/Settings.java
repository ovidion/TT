package com.touch.t;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sachag
 *
 */
public class Settings {

	@JsonProperty
	private List<Setting> settings;

	public List<Setting> getListSettings() {
		return this.settings;
	}

}