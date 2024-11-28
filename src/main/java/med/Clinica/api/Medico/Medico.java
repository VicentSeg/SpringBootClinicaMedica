package med.Clinica.api.Medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.Clinica.api.Direccion.Direccion;

@Table (name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    @Enumerated (EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public Medico(DatosRegistroMedico datosRegistroMedico) {
        this.nombre = datosRegistroMedico.nombre();
        this.direccion = new Direccion(datosRegistroMedico.direccion());
        this.documento = datosRegistroMedico.documento();
        this.email = datosRegistroMedico.email();
        this.telefono = datosRegistroMedico.telefono();
        this.especialidad = datosRegistroMedico.especialidad();
    }
}
