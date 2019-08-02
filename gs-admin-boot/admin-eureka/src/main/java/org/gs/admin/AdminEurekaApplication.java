package org.gs.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zpp
 * @date 2019/8/1 16:50
 */
@SpringBootApplication
@EnableEurekaServer
public class AdminEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminEurekaApplication.class, args);
    }


}
