/**
 * 
 */
package com.ns.yamlreader;

/**
 * @author natanwar
 *
 */
public class YamlObject {

	private int port;
	private String userName;
	private String password;
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "YamlObject [port=" + port + ", userName=" + userName + ", password=????]";
	}
}
