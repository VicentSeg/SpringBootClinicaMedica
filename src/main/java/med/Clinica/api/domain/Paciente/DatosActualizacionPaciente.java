package med.Clinica.api.domain.Paciente;

import jakarta.validation.Valid;
import med.Clinica.api.domain.Direccion.DatosDireccion;

public record DatosActualizacionPaciente(
        Long id,
        String nombre,
        String telefono,
        @Valid
        DatosDireccion direccion
) {
    }
