package com.ReadProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class ReadController 
{
	@Autowired
	private Environment env;
	
	@GetMapping("/property")
	public String getPropertyValue (@RequestParam("key") String key)
	{
		String retrunValue="No Value";
		String keyValue=env.getProperty(key);
		
		if(keyValue!=null&&!keyValue.isEmpty())
		{
			retrunValue=keyValue;
		}
		return retrunValue;
	}

}
