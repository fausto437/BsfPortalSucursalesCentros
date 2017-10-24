package mx.gob.bansefi.process;

import mx.gob.bansefi.dto.SituacionApunteDTO;
import mx.gob.bansefi.services.WsServicios;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by AppWhere on 19/10/2017.
 */
@Service
public class SetConsultaDetallesProccess {
    @Value("${url.LocalHost}")
    private String urlLocalHost;

    private DecimalFormat df = new DecimalFormat("0.00");

	/*public DetalleConsultaDTO SetConsultaAuditoriaDetalles(ResConsultaAuditoriaDetalleDTO res) {
		DetalleConsultaDTO detalles = new DetalleConsultaDTO();
		detalles.setTitulo("de Auditoría");
		detalles.setTipoDetalle("dAu");
		detalles.setNombreEmpleado(res.getNombreEmpleado());
		detalles.setNombreAutorizador(res.getNombreAutorizador());
		detalles.setCodCentro(res.getCodigoCentro());
		detalles.setNombEnt(res.getNombEnt());
		
		return detalles;
	}*/
}
