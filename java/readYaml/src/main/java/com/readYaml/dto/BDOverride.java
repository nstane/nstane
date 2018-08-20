/**
 * 
 */
package com.readYaml.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author natanwar
 *
 */
public class BDOverride {
	@JsonProperty("CAN")
	private Map<?,?> can;
	@JsonProperty("CIS")
	private Map<?,?> cis;
	public Map<?, ?> getCan() {
		return can;
	}
	public void setCan(Map<?, ?> can) {
		this.can = can;
	}
	public Map<?, ?> getCis() {
		return cis;
	}
	public void setCis(Map<?, ?> cis) {
		this.cis = cis;
	}
}