/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.examen.dtos;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Diego_MF
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActualizarDto implements Serializable {

    private String nombreDestinatario;
    private String apellidoDestinatario;
    private String direccionDestinatario;
    private String numeroDestinatario;
    private String correoDestinatario;
}
