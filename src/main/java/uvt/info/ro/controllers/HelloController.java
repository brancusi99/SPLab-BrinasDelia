package uvt.info.ro.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uvt.info.ro.components.ClientComponent;

@RestController
public record HelloController(ClientComponent clientComponent) {

    /**
     * This constructor is automatically provided by 'record'.
     * Spring sees it needs a ClientComponent and injects
     * the singleton bean from its context.
     */

    @GetMapping("/")
    public String hello() {
        // This fulfills task 9
        // return "Hello from Spring Boot";

        // This fulfills task 10
        return "Hello from ClientComponent = " + clientComponent.toString();
    }
}