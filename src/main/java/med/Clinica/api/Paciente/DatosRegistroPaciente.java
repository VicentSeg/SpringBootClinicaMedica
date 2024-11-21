package med.Clinica.api.Paciente;

import med.Clinica.api.Direccion.DatosDireccion;

public record DatosRegistroPaciente(
        String nombre,
        String email,
        String telefono,
        String documentoIdentidad,
        DatosDireccion direccion
) {
}
