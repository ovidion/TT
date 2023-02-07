package com.touch.t;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sachag
 *
 */
public class Jukebox {

	@JsonProperty
	private String id;

	@JsonProperty
	private String model;

	@JsonProperty
	private List<Component> components;

	public String getModel() {
		return this.model;
	}

	public List<String> getComponentNames() {
		List<String> components = new ArrayList<String>();
		for (Component component : this.components) {
			components.add(component.getName());
		}
		
		return components;
	}

}