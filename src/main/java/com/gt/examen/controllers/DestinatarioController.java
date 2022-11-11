/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.examen.controllers;

import com.gt.examen.models.DestinatarioModel;
import com.gt.examen.dtos.ActualizarDto;
import com.gt.examen.dtos.CreacionDto;
import com.gt.examen.dtos.EmailParameters;
import com.gt.examen.dtos.RespuestaDto;
import com.gt.examen.services.DestinatarioServices;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping; 
import javax.mail.MessagingException;
import lombok.Value;

/**
 *
 * @author Diego_MF
 */
@RestController
@Slf4j
public class DestinatarioController {

    @Autowired
    DestinatarioServices destinatarioServices;

    @PostMapping(value = "/destinatario/crear")
//   @ApiOperation(value = "Crear una solicitud")
    public RespuestaDto crearFirma(@Valid @RequestBody CreacionDto creacion) {
        //   log.info("Crea un registro de firma...");

        return destinatarioServices.crearDestinatario(creacion);
    }

    @PutMapping(value = "/destinatario/actualizar/{idSolicitud}")
    public void actualizarFirma(@Valid @PathVariable Integer idSolicitud, @Valid @RequestBody ActualizarDto actu) {
        log.info("Acutalizando Destinatario...");

        destinatarioServices.actualizarDestinatario(idSolicitud, actu);
    }

    @DeleteMapping(value = "/eliminar/destinatario/{id}")
    public void deleteDestinatario(@PathVariable("id") int id) {
        destinatarioServices.deleteDestinatario(id);
        ResponseEntity.ok(!destinatarioServices.existById(id));
    }
    
    
    @GetMapping(value = "/obtener/destinatario/{idSolicitud}")
    public DestinatarioModel obtenerDestinatario(@PathVariable("idSolicitud") int idSolicitud){
        return destinatarioServices.obtenerDestinatario(idSolicitud);
    }
    
     @GetMapping(value = "/obtener/destinatarios")
     private ResponseEntity<List<DestinatarioModel>> getAllDestinatarios() {
        return ResponseEntity.ok(destinatarioServices.findAll());
    }
     
     @PostMapping("util/enviarEmail/AdminUsuarios")
    //@ApiOperation(value = "Enviar Correos Administracion de Usuarios")
    public Boolean enviarEmailAdminUsuarios(@RequestBody EmailParameters emailParameters) throws MessagingException, IOException {
        return destinatarioServices.sendEmeilAdminUsuarios(emailParameters);
    }
     
  

}
