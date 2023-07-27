package sandipchitale.scg.proxyexchange;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.mvc.ProxyExchange;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@SpringBootApplication
public class ProxyexchangeApplication {

	@RestController
	public static class ProxyExchangeController {

		@GetMapping("/")
		public String get(ProxyExchange<String> proxyExchange,
						  @RequestParam MultiValueMap<String, String> allRequestParams) {

			UriComponentsBuilder uriComponentsBuilder = ServletUriComponentsBuilder.fromHttpUrl("https://postman-echo.com/get");
			if (allRequestParams != null) {
				uriComponentsBuilder.replaceQueryParams(allRequestParams);

			}
			URI uri = uriComponentsBuilder.build().toUri();
			return proxyExchange.uri(uri).get().getBody();
		}

		@PostMapping("/")
		public String post(ProxyExchange<String> proxyExchange,
						  @RequestParam  MultiValueMap<String, String>  allRequestParams) {
			UriComponentsBuilder uriComponentsBuilder = ServletUriComponentsBuilder.fromHttpUrl("https://postman-echo.com/post");
			if (allRequestParams != null) {
				uriComponentsBuilder.replaceQueryParams(allRequestParams);

			}
			URI uri = uriComponentsBuilder.build().toUri();
			return proxyExchange.uri(uri).post().getBody();
		}

		@PutMapping("/")
		public String put(ProxyExchange<String> proxyExchange,
						   @RequestParam  MultiValueMap<String, String>  allRequestParams) {
			UriComponentsBuilder uriComponentsBuilder = ServletUriComponentsBuilder.fromHttpUrl("https://postman-echo.com/put");
			if (allRequestParams != null) {
				uriComponentsBuilder.replaceQueryParams(allRequestParams);

			}
			URI uri = uriComponentsBuilder.build().toUri();
			return proxyExchange.uri(uri).put().getBody();
		}

		@DeleteMapping("/")
		public String delete(ProxyExchange<String> proxyExchange,
						  @RequestParam  MultiValueMap<String, String>  allRequestParams) {
			UriComponentsBuilder uriComponentsBuilder = ServletUriComponentsBuilder.fromHttpUrl("https://postman-echo.com/delete");
			if (allRequestParams != null) {
				uriComponentsBuilder.replaceQueryParams(allRequestParams);

			}
			URI uri = uriComponentsBuilder.build().toUri();
			return proxyExchange.uri(uri).delete().getBody();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(ProxyexchangeApplication.class, args);
	}

}
