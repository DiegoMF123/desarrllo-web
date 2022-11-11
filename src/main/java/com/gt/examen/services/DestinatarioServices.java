/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.examen.services;

import com.gt.examen.models.DestinatarioModel;
import com.gt.examen.dtos.ActualizarDto;
import com.gt.examen.dtos.CreacionDto;
import com.gt.examen.dtos.EmailParameters;
import com.gt.examen.dtos.RespuestaDto;
import com.gt.examen.repositories.DestinatarioRepository;
import com.gt.examen.utils.CorreoElectronico;
import java.io.IOException;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego_MF
 */
@Service
@Slf4j
@Transactional

public class DestinatarioServices {
    
private static final Logger LOGGER = LoggerFactory.getLogger(DestinatarioServices.class);

    @Autowired
    DestinatarioRepository destinatarioRepository;
    
    @Autowired
    private JavaMailSender mailSender;
    
    CorreoElectronico correoElectronico = new CorreoElectronico();

    public RespuestaDto crearDestinatario(CreacionDto creacion) {
     log.debug("Creando Destinatario...");

        DestinatarioModel destinatario = destinatarioRepository.save(
                DestinatarioModel.builder()
                        .nombreDestinatario(creacion.getNombreDestinatario())
                        .apellidoDestinatario(creacion.getApellidoDestinatario())
                        .direccionDestinatario(creacion.getDireccionDestinatario())
                        .numeroDestinatario(creacion.getNumeroDestinatario())
                        .correoDestinatario(creacion.getCorreoDestinatario())
                        .build()
        );
        return new RespuestaDto(destinatario.getIdDestinatario());
    }
    
    public void actualizarDestinatario(Integer idSolicitud, ActualizarDto actualizar) {
        log.debug("Consultando una Destinatario");
        final DestinatarioModel destinatarioModel = this.destinatarioRepository.findById(idSolicitud).orElse(null);
        if (destinatarioModel != null) {
            destinatarioModel.setNombreDestinatario(actualizar.getNombreDestinatario());
            destinatarioModel.setApellidoDestinatario(actualizar.getApellidoDestinatario());
            destinatarioModel.setDireccionDestinatario(actualizar.getDireccionDestinatario());
            destinatarioModel.setNumeroDestinatario(actualizar.getNumeroDestinatario());
            destinatarioModel.setCorreoDestinatario(actualizar.getCorreoDestinatario()); 
        } else {
            return;
        }
    }
    
    public boolean sendEmeilAdminUsuarios(EmailParameters emailAdminUsuarios) throws MessagingException, IOException {
        boolean send = false;
        //LOGGER.info("EmailBody: {}", emailAdminUsuarios.toString());
        String[] strArray = null;
        String from = "pruebacorreocita123@gmail.com";
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        try {
            strArray = emailAdminUsuarios.getEmail().split(",");
            helper.setSubject(emailAdminUsuarios.getSubject());
            helper.setFrom(from);
            helper.setTo(strArray);

            String content = correoElectronico.correoData(emailAdminUsuarios);

            helper.setText(content, true);
            mailSender.send(message);
            send = true;
            LOGGER.info("Mail enviado!");
        } catch (MessagingException e) {
            LOGGER.error("Hubo un error al enviar el mail: {}", e);
        }
        return send;

    }
    
    
   
    public void deleteDestinatario(int id){
        destinatarioRepository.deleteById(id);
    }
    
    public boolean existById(int id){
        return destinatarioRepository.existsById(id);
    }
    
    public DestinatarioModel obtenerDestinatario(int id){
        return destinatarioRepository.findById(id).orElse(null);
    }
     
    public List<DestinatarioModel> findAll() {
        return (List<DestinatarioModel>) destinatarioRepository.findAll();
    }

    private void ValidacionesEnvioCorreo(String[] strArray) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
}
