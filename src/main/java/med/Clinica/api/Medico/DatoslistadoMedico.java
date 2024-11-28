package med.Clinica.api.Medico;

public record DatoslistadoMedico(
        String nombre,
        String especialidad,
        String documento,
        String email
){
    public DatoslistadoMedico(Medico medico){
        this(medico.getNombre(),medico.getEspecialidad().toString(), medico.getDocumento(), medico.getEmail());
    }
}
