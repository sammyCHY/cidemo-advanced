package dev.fykio.cidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author fykio
 */

@SpringBootApplication
@RestController
@RequestMapping(path = "v1")
public class CidemoApplication {

	private static Logger log = Logger.getLogger(CidemoApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(CidemoApplication.class, args);
	}

	@GetMapping("/ping")
	public ResponseEntity<String> ping() {
		log.info("Service pinged!");
		return ResponseEntity.ok().body("CI Demo Service is up...");
	}
}
