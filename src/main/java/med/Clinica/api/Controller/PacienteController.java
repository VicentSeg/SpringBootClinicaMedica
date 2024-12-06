package med.Clinica.api.Controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.Clinica.api.domain.Paciente.*;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;
    @PostMapping
    public ResponseEntity<DatosRespuestaPaciente> registrar (@RequestBody @Valid DatosRegistroPaciente datosRegistroPaciente,
                                                             UriComponentsBuilder uriComponentsBuilder){
        Paciente paciente =  pacienteRepository.save(new Paciente(datosRegistroPaciente));
        DatosRespuestaPaciente respuestaPaciente = DatosRespuestaPaciente.datosRespuestaPaciente(paciente);
        URI url= uriComponentsBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(url).body(respuestaPaciente);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaPaciente>>  listar(@PageableDefault(page = 0, size = 10, sort = {"nombre"}) Pageable paginacion) {
        //return pacienteRepository.findAll(paginacion).map(DatosListaPaciente::new);
        return ResponseEntity.ok(pacienteRepository.findByActivoTrue(paginacion).map(DatosListaPaciente::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaPaciente> atualizar(@RequestBody @Valid DatosActualizacionPaciente datos) {
        Paciente paciente = pacienteRepository.getReferenceById(datos.id());
        paciente.atualizarInformacion(datos);
        return ResponseEntity.ok(DatosRespuestaPaciente.datosRespuestaPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity  remover(@PathVariable Long id) {
        Paciente paciente = pacienteRepository.getReferenceById(id);
        paciente.inactivar();
        return ResponseEntity.noContent().build();
    }

}
