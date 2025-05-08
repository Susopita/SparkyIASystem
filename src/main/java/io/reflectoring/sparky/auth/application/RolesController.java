package io.reflectoring.sparky.auth.application;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/roles")
public class RolesController {
    @PreAuthorize("hasRole('SPARKY_ADMIN')")
    @GetMapping("/both")
    public ResponseEntity<String> both(Principal principal) {
        return ResponseEntity.ok("Soy un sparky admin: " + principal.getName());
    }

    @PreAuthorize("hasRole('EMPRESA_ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> admin(Principal principal) {
        return ResponseEntity.ok("Soy un admin: " + principal.getName());
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public ResponseEntity<String> user(Principal principal) {
        return ResponseEntity.ok("Soy un user: " + principal.getName());
    }
}
