package mx.gob.bansefi.process;

import mx.gob.bansefi.dto.RetencionesDTO;
import mx.gob.bansefi.services.WsServicios;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
public class SetConsultaPrincipalProccess {
    @Value("${url.LocalHost}")
    private String urlLocalHost;

    private DecimalFormat df = new DecimalFormat("0.00");

    //Funcion para llenar la tabla de retenciones con los datos de la consulta
//	public List<GralRetencionDTO> setConsultaRetenciones(List<GralRetencionDTO> lstRetenciones) {
//		List<GralRetencionDTO> nuevaLista = new ArrayList<GralRetencionDTO>();
//    	for (GralRetencionDTO datoRetencion : lstRetenciones) {
//    		GralRetencionDTO nuevoObj = new GralRetencionDTO();
//    		nuevoObj.setTipo(datoRetencion.getTipo()==null?"":datoRetencion.getTipo());
//    		nuevoObj.setEstado("ACTIVO");
//    		try {
//				String nueva_fecha=datoRetencion.getFechaAlta().substring(6, 8)+"/"+datoRetencion.getFechaAlta().substring(4, 6)+"/"+datoRetencion.getFechaAlta().substring(0, 4);
//				nuevoObj.setFechaAlta(nueva_fecha);
//			} catch (Exception e) {
//				nuevoObj.setFechaAlta("");
//				e.printStackTrace();
//			}
//    		try {
//				String nueva_fecha=datoRetencion.getFechaVTO().substring(6, 8)+"/"+datoRetencion.getFechaVTO().substring(4, 6)+"/"+datoRetencion.getFechaVTO().substring(0, 4);
//				nuevoObj.setFechaVTO(nueva_fecha);
//			} catch (Exception e) {
//				nuevoObj.setFechaVTO("");
//				e.printStackTrace();
//			}
//    		nuevoObj.setConcepto(datoRetencion.getConcepto()==null?"":datoRetencion.getConcepto());
//    		nuevoObj.setEmpleado(datoRetencion.getEmpleado()==null?"":datoRetencion.getEmpleado());
//    		nuevoObj.setOrigen(datoRetencion.getOrigen()==null?"":datoRetencion.getOrigen());
//    		try {
//    			nuevoObj.setImporte(datoRetencion.getImporte()==null?"":""+df.format(Double.parseDouble(datoRetencion.getImporte())));    			
//    		}
//    		catch(Exception e) {
//    			nuevoObj.setImporte("");
//				e.printStackTrace();
//    		}
//    		nuevaLista.add(nuevoObj);
//    	}
//    	return nuevaLista;
//	}
}
