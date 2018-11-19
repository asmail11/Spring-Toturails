package org.imdrmas;

import org.imdrmas.service.MessageServiceProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SpringBootCommandLineRunnerApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext cAc =	SpringApplication.run(SpringBootCommandLineRunnerApplication.class, args);
	MessageServiceProvider mSp = cAc.getBean(MessageServiceProvider.class);
	
	String message = mSp.message();
	System.out.println(message);
	}
}
