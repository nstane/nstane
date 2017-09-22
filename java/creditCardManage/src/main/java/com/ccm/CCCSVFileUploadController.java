/**
 * 
 */
package com.ccm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ntanwa
 *
 */

@RestController
public class CCCSVFileUploadController {

	private static final Logger LOG = Logger.getLogger(CCCSVFileUploadController.class);

	/**
	 * Upload Credit Card Detail CSV File
	 * 
	 * @param file
	 * @param request
	 * @return {message}
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String upload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
		if(file.getOriginalFilename().endsWith(".csv"))
			try {
				file.transferTo(new File(System.getProperty("java.io.tmpdir") + file.getOriginalFilename()));
				readCSVFile(file);
			} catch (IllegalStateException | IOException e) {
				System.out.println("Error : " + e.getMessage());
				return "Error while upload " + file.getName() + " error message : " + e.getMessage();
			}
		return file.getName() + " uploaded successfully.";
	}

	/**
	 * Read Credit Card CSV File.
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void readCSVFile(MultipartFile file) throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(
				new FileReader(new File(System.getProperty("java.io.tmpdir") + file.getOriginalFilename())));
		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;

		while ((line = reader.readLine()) != null) {
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				LOG.info("Data" + data);
				/*
				 * if (index == 0) //emp.setId(Integer.parseInt(data)); else if
				 * (index == 1) //emp.setName(data); else if (index == 2)
				 * //emp.setRole(data); else if (index == 3)
				 * //emp.setSalary(data); else
				 * System.out.println("invalid data::" + data);
				 */
				index++;
			}
			index = 0;
			// empList.add(emp);
		}

		// close reader
		reader.close();
	}

	@RequestMapping("/resource")
	public Map<String, Object> home() {
		LOG.info("Resource callled ----------------------------");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}

}
