package med.Clinica.api.Medico;

import med.Clinica.api.Direccion.DatosDireccion;

public record DatosRegistroMedico(
        String nombre,
        String email,
        String telefono,
        String documento,
        Especialidad especialidad,
        DatosDireccion direccion
) {
}
