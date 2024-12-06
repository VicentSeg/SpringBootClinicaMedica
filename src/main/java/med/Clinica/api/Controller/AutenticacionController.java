package med.Clinica.api.Controller;

import jakarta.validation.Valid;
import med.Clinica.api.domain.Usuarios.DatosAutenticacion;
import med.Clinica.api.infra.security.TokenService;
import med.Clinica.api.domain.Usuarios.Usuario;
import med.Clinica.api.infra.security.DatosTokenJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity  realizarLogin (@RequestBody @Valid DatosAutenticacion datosAutenticacion) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(datosAutenticacion.login(),
                datosAutenticacion.contrasena());
        var authentication = authenticationManager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
    }
}

