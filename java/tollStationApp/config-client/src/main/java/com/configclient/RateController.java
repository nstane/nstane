/**
 *
 */
package com.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author natanwar
 *
 */
@Controller
//@RefreshScope
public class RateController {

	@Value("${rate}")
	private String rate;
	@Value("${lanecount}")
	private String laneCount;
	@Value("${tollstart}")
	private String tollStart;

	@RequestMapping("/rate")
	public String getRate(Model model) {
		 model.addAttribute("rate", rate);
		 model.addAttribute("lanecount", laneCount);
		 model.addAttribute("tollstart", tollStart);
		 return "rateview";
	}

}
