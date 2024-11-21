package med.Clinica.api.Controller;

import med.Clinica.api.Medico.DatosRegistroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public void registraMedico(@RequestBody DatosRegistroMedico datosRegistroMedico){
        System.out.println(datosRegistroMedico);

    }
}
