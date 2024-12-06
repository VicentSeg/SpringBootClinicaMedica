package med.Clinica.api.domain.Medico;

import med.Clinica.api.domain.Direccion.DatosDireccion;

public record DatosRespuestaMedico(
        Long id,
        String nombre,
        String email,
        String telefono,
        String documento,
        String especialidad,
        DatosDireccion direccion) {

    public static DatosRespuestaMedico datosRespuestaMedico(Medico medico) {
        return new DatosRespuestaMedico(
                medico.getId(),
                medico.getNombre(),
                medico.getDocumento(),
                medico.getEmail(),
                medico.getTelefono(),
                medico.getEspecialidad().toString(),
                new DatosDireccion(
                        medico.getDireccion().getCalle(),
                        medico.getDireccion().getNumero(),
                        medico.getDireccion().getCiudad(),
                        medico.getDireccion().getComplemento(),
                        medico.getDireccion().getDistrito()
                ));
    }

}
