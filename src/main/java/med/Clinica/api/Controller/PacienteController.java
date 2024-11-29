package med.Clinica.api.Controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.Clinica.api.Paciente.*;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;
    @PostMapping
    public void registrar (@RequestBody @Valid DatosRegistroPaciente datosRegistroPaciente){
        pacienteRepository.save(new Paciente(datosRegistroPaciente));
    }
    @GetMapping
    public Page<DatosListaPaciente> listar(@PageableDefault(page = 0, size = 10, sort = {"nombre"}) Pageable paginacion) {
        //return pacienteRepository.findAll(paginacion).map(DatosListaPaciente::new);
        return pacienteRepository.findByActivoTrue(paginacion).map(DatosListaPaciente::new);

    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DatosActualizacionPaciente datos) {
        Paciente paciente = pacienteRepository.getReferenceById(datos.id());
        paciente.atualizarInformacion(datos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@PathVariable Long id) {
        Paciente paciente = pacienteRepository.getReferenceById(id);
        paciente.inactivar();
    }

}
