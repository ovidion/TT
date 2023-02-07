package com.touch.t;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sachag
 *
 */
public class Component {
	
    @JsonProperty
	private String name;
    
    public String getName() {
    	return this.name;
    }
    
    public boolean equals(Component otherComponent) {
    	return this.name.equals(otherComponent.getName());
    }
    
}