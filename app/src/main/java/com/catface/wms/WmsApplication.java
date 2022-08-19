package com.catface.wms;

import com.catface.common.util.EnvUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * @author by catface
 * @since 2020/12/13
 */
@Slf4j
@SpringBootApplication(
				scanBasePackages = {"com.catface"}
)
public class WmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WmsApplication.class, args);
		log.info("wmsApplication start success!");
		System.out.println("wmsApplication start success!");
		System.out.println(EnvUtil.getSwaggerUrl());
		System.out.println(EnvUtil.getDocUrl());
	}
}
