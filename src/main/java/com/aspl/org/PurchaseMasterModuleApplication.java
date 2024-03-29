package com.aspl.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.aspl.org.utils.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class PurchaseMasterModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseMasterModuleApplication.class, args);
	}

}
