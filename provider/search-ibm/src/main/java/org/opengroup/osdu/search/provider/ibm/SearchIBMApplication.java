/* Licensed Materials - Property of IBM              */
/* (c) Copyright IBM Corp. 2020. All Rights Reserved.*/

package org.opengroup.osdu.search.provider.ibm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = {"org.opengroup.osdu"})
@SpringBootApplication(
		exclude = {
		org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration.class,
		org.springframework.boot.security.autoconfigure.UserDetailsServiceAutoConfiguration.class,
		org.springframework.boot.security.autoconfigure.actuate.web.servlet.ManagementWebSecurityAutoConfiguration.class})
@PropertySource("classpath:swagger.properties")
public class SearchIBMApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchIBMApplication.class, args);
	}
}
