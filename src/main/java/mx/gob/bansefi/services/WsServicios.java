package mx.gob.bansefi.services;

import mx.gob.bansefi.dto.Response.*;
import mx.gob.bansefi.dto.Request.*;
import mx.gob.bansefi.utils.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by AppWhere on 26/06/2017.
 */
@Service
public class WsServicios {

	/*
	 * Definicion de variables urls para servicios
	 */
	@Value("${domain.servicesU}")
	private String urlRootContext;
	@Value("${url.ConsultaNombre}")
	private String urlConsultaNombre;
	/*
	 * Definicion de variables mensajes de servicios
	 */
	@Value("${mensaje.errorServicioCliente}")
	private static String mensajeErrorServicioCliente;
	/*
	 * Definicion de loog4g
	 */

    private static final Logger log = LogManager.getLogger(WsServicios.class);
    private static Util util = Util.getInstance();

    /*CONSULTA DE NOMBRE*/
    public ResConsultaNombreDTO consultaNombre(ReqConsultaCuentaNombreDTO Request)
	{
		ResConsultaNombreDTO Datos=new ResConsultaNombreDTO();
		try
		{
			String jsonRepuesta= util.callRestPost(Request, urlRootContext+ urlConsultaNombre);
			Datos=(ResConsultaNombreDTO)util.jsonToObject(Datos,jsonRepuesta);
		}
		catch(Exception ex)
		{
			log.error("\nError en el metodo consultaNombre(GetConsultaCuentaNombreReqDTO Request)"
					+ "\nException Message: " + ex.getMessage());

		}
		return Datos;
	}
}
