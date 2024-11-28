package med.Clinica.api.Controller;

import jakarta.validation.Valid;
import med.Clinica.api.Paciente.DatosRegistroPaciente;
import med.Clinica.api.Paciente.Paciente;
import med.Clinica.api.Paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;
    @PostMapping
    public void registrar (@RequestBody @Valid DatosRegistroPaciente datosRegistroPaciente){
        pacienteRepository.save(new Paciente(datosRegistroPaciente));
    }
}
