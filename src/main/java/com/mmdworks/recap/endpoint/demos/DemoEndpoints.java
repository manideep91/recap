package com.mmdworks.recap.endpoint.demos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmdworks.recap.domain.Property;
import com.mmdworks.recap.domain.User;
import com.mmdworks.recap.jsonhelper.UserDocumentJsonHelper;

@RestController
@RequestMapping("/demo-services")
public class DemoEndpoints {

	@GetMapping("/get-demo-user")
	public User getUserDocDemoJson() {
		return UserDocumentJsonHelper.getUserDocumentJson();
	}
	
	@GetMapping("/get-demo-property")
	public Property getPropertyDemoJson() {
		return UserDocumentJsonHelper.getPropertyJson();
	}
	
	
}
