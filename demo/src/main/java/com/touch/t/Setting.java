package com.touch.t;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sachag
 *
 */
public class Setting {

	@JsonProperty
	private String id;
	
	@JsonProperty
	private List<String> requires;
	
	public String getId() {
		return this.id;
	}
	
	public List<String> getRequires() {
		return this.requires;
	}
	
}