package med.Clinica.api.domain.Paciente;

import med.Clinica.api.domain.Direccion.DatosDireccion;

public record DatosRespuestaPaciente(
        Long id,
        String nombre,
        String email,
        String telefono,
        String documento,
        DatosDireccion direccion) {
    public static DatosRespuestaPaciente datosRespuestaPaciente(Paciente paciente) {
        return new DatosRespuestaPaciente(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getDocumento(),
                paciente.getEmail(),
                paciente.getTelefono(),
                new DatosDireccion(
                        paciente.getDireccion().getCalle(),
                        paciente.getDireccion().getNumero(),
                        paciente.getDireccion().getCiudad(),
                        paciente.getDireccion().getComplemento(),
                        paciente.getDireccion().getDistrito()
                ));

    }
}
