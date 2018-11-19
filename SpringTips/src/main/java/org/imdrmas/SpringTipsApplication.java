package org.imdrmas;

import java.io.File;
import java.nio.file.Files;

import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.transformer.GenericTransformer;

@SpringBootApplication
public class SpringTipsApplication {
	
	@Bean
	<DefaultFtpSession> DefaultFtpSession ftpFileSessionFactory(
			@Value("${ftp.port:2121}") int port,
			@Value("${ftp.username:drmas}") String username,
			@Value("${ftp.password:spring}") String pw
			) {
		DefaultFtpSession.setP
	}
	
	@Bean
	IntegrationFlow files(@Value("${input-directory:${HOME}/Desktop/in}") File in) {
		return IntegrationFlows.from(Files.inboundAdapter(in).autoCreateDirectory(true).preventDuplicates())
				.transform(File.class, (GenericTransformer<File, String>) (File Source) ->{
					
				})
				.handleWithAdapter(adaoters -> adapters.ftp())
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringTipsApplication.class, args);
	}
}
