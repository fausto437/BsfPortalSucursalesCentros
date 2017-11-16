package mx.gob.bansefi.controllers;

import mx.gob.bansefi.dto.BsfOperadorPadreDTO;
import mx.gob.bansefi.dto.BusquedaDTO;
import mx.gob.bansefi.dto.Request.*;
import mx.gob.bansefi.dto.Response.*;
import mx.gob.bansefi.process.SetConsultaDetallesProccess;
import mx.gob.bansefi.process.SetConsultaPrincipalProccess;
import mx.gob.bansefi.services.SecurityWS;
import mx.gob.bansefi.services.WsServicios;
import mx.gob.bansefi.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CentrosController {
    @Value("${domain.servicesU}")
    private String urlServU;
    
    @Autowired
    WsServicios wsServicios;
    private Util util = Util.getInstance();
    @Autowired
    SecurityWS securityWs;
    @Autowired
    private SetConsultaDetallesProccess setDetalles;
    
    @Autowired
    private SetConsultaPrincipalProccess setConsultaPrincipal;
    
    private String packageTemplates = "Centros";
    public String operador;
    
    @RequestMapping("/prueba")
    public ModelAndView pruaba() {
        return new ModelAndView(packageTemplates + "/altaCentro.xhtml");
    }

    //MAPPING PRINCIPAL DEL BSFOPERADOR
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView Index(@RequestParam("BSFOPERADOR") String bsfOperador) // Inicio del flujo
    {
		if (!bsfOperador.equals("")) {
			BusquedaDTO busquedaDatos = new BusquedaDTO();
            operador = bsfOperador;
            busquedaDatos.setBsfoperador(bsfOperador);
            busquedaDatos.setFormato("OFICINA");
            busquedaDatos.setVerificaDigitalizacion("0");
            ResEncryptORDecryptDTO transportDecrypt = securityWs.decrypt(new ReqEncryptORDecryptDTO(bsfOperador));
            try {
            	BsfOperadorPadreDTO bsfOp = (BsfOperadorPadreDTO) util.jsonToObject(new BsfOperadorPadreDTO(), transportDecrypt.getRespuesta());
            	if(bsfOp.getBSFOPERADOR().getTRANSPORT().getIDINTERNOPE()!="") {
            		busquedaDatos.setIdInternoPe(Integer.parseInt(bsfOp.getBSFOPERADOR().getTRANSPORT().getIDINTERNOPE()));
            	}
            	
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }
            return new ModelAndView(packageTemplates + "/Buscador");
        } else {
            return new ModelAndView("error/500").addObject("msgError", "ERROR AL RECIBIR LOS DATOS");

        }
    }
}