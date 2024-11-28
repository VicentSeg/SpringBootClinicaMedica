package med.Clinica.api.Controller;

import jakarta.validation.Valid;
import med.Clinica.api.Medico.DatosRegistroMedico;
import med.Clinica.api.Medico.DatoslistadoMedico;
import med.Clinica.api.Medico.Medico;
import med.Clinica.api.Medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registraMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico){
        medicoRepository.save(new Medico(datosRegistroMedico));
    }
    @GetMapping
    public List<DatoslistadoMedico> listadoMedicos() {
        return medicoRepository.findAll().stream()
                .map(DatoslistadoMedico::new).toList();
    }
}
