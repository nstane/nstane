/**
 * 
 */
package com.readYaml.bdtype;

import org.springframework.stereotype.Component;

/**
 * @author natanwar
 *
 */
public enum BDType {
	CAN("invistago_can"),CIS("invistago_can");
	
	private String type;
	
	BDType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
