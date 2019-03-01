package it.difesa.configuration.DLL_app2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DLL_app2Application {
	public static void main(String[] args) {
		SpringApplication.run(DLL_app2Application.class, args);
	}

}

@RefreshScope
@RestController
class MessageResource {

	@Value("${message}")
	private String msg;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home() {
		return msg;
	}

	@RequestMapping("/pingMessage")
	String getMsg() {return this.msg.toString();}
}

