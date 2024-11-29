package med.Clinica.api.Paciente;

import jakarta.validation.Valid;
import med.Clinica.api.Direccion.DatosDireccion;

public record DatosActualizacionPaciente(
        Long id,
        String nombre,
        String telefono,
        @Valid
        DatosDireccion direccion
) {
    }
