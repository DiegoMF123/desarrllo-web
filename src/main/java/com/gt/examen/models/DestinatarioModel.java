package com.gt.examen.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;

/**
 *
 * @author Diego_MF
 */
@Entity
@Builder
@Table(name = "destinatario", schema = "public")
public class DestinatarioModel implements java.io.Serializable {

    private int idDestinatario;
    private String nombreDestinatario;
    private String apellidoDestinatario;
    private String direccionDestinatario;
    private String numeroDestinatario;
    private String correoDestinatario;

    public DestinatarioModel() {
    }

    public DestinatarioModel(int idDestinatario, String nombreDestinatario, String apellidoDestinatario, String direccionDestinatario, String numeroDestinatario, String correoDestinatario) {
        this.idDestinatario = idDestinatario;
        this.nombreDestinatario = nombreDestinatario;
        this.apellidoDestinatario = apellidoDestinatario;
        this.direccionDestinatario = direccionDestinatario;
        this.numeroDestinatario = numeroDestinatario;
        this.correoDestinatario = correoDestinatario;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(int idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    @Column(name = "nombre_destinatario")
    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public void setNombreDestinatario(String nombreDestinatario) {
        this.nombreDestinatario = nombreDestinatario;
    }

    @Column(name = "apellido_destinatario")
    public String getApellidoDestinatario() {
        return apellidoDestinatario;
    }

    public void setApellidoDestinatario(String apellidoDestinatario) {
        this.apellidoDestinatario = apellidoDestinatario;
    }

    @Column(name = "direccion")
    public String getDireccionDestinatario() {
        return direccionDestinatario;
    }

    public void setDireccionDestinatario(String direccionDestinatario) {
        this.direccionDestinatario = direccionDestinatario;
    }

    @Column(name = "telefono")
    public String getNumeroDestinatario() {
        return numeroDestinatario;
    }

    public void setNumeroDestinatario(String numeroDestinatario) {
        this.numeroDestinatario = numeroDestinatario;
    }

    @Column(name = "correo")
    public String getCorreoDestinatario() {
        return correoDestinatario;
    }

    public void setCorreoDestinatario(String correoDestinatario) {
        this.correoDestinatario = correoDestinatario;
    }

    @Override
    public String toString() {
        return "DestinatarioModel{" + "idDestinatario=" + idDestinatario + ", nombreDestinatario=" + nombreDestinatario + ", apellidoDestinatario=" + apellidoDestinatario + ", direccionDestinatario=" + direccionDestinatario + ", numeroDestinatario=" + numeroDestinatario + ", correoDestinatario=" + correoDestinatario + '}';
    }

}
