package med.Clinica.api.domain.Medico;

import jakarta.validation.constraints.NotNull;
import med.Clinica.api.domain.Direccion.DatosDireccion;

public record DatosActualizarMedico(
        @NotNull
        Long id,
        String nombre,
        String documento,
        DatosDireccion direccion) {
}
