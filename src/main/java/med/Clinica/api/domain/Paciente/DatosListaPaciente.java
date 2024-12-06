package med.Clinica.api.domain.Paciente;

public record DatosListaPaciente(
        Long id,
        String nombre,
        String email,
        String documentoIdentidad) {
    public DatosListaPaciente(Paciente paciente) {
        this(paciente.getId(),paciente.getNombre(), paciente.getEmail(), paciente.getDocumento());
    }

}