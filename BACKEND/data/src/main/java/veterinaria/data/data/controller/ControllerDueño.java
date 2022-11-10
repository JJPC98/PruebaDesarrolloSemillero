package veterinaria.data.data.controller;

import org.springframework.web.bind.annotation.*;
import veterinaria.data.data.dto.Dueño;
import veterinaria.data.data.dto.Respuesta;
import veterinaria.data.data.exceptions.ExceptionManager;
import veterinaria.data.data.manager.ImgrDueño;

import java.util.List;

@RestController
@RequestMapping(path = "/veterinaria")
@CrossOrigin("*")
public class ControllerDueño {

    ImgrDueño manager;

    public ControllerDueño(ImgrDueño manager) {
        this.manager = manager;
    }

    @PostMapping(path = "dueño/save")
    public @ResponseBody void Save (@RequestBody Dueño dueño){
        try {
            manager.Save(dueño);
        } catch (ExceptionManager e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "dueño/delete")
    public @ResponseBody void Delete (@RequestParam int id){
        Dueño dueño = new Dueño();
        dueño.setIdpropietario(id);
        try {
            manager.Delete(dueño);
        } catch (ExceptionManager e) {
            e.printStackTrace();
        }

    }

    @PutMapping(path = "dueño/update")
    public @ResponseBody void Update (@RequestBody Dueño dueño){
        try {
            manager.Update(dueño);
        } catch (ExceptionManager e) {
            e.printStackTrace();
        }

    }

    @GetMapping(path = "/dueño/lista")
    public Respuesta lista(){
        Respuesta respuesta = new Respuesta();
        try {
            List lista = manager.lista();
            respuesta.setData(lista);
            respuesta.setCodigo(0);
        } catch (ExceptionManager e) {
            respuesta.setCodigo(1);
            respuesta.setMensaje(e.getMessage());
        }
        return respuesta;
    }
}
