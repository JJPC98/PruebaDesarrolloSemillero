package veterinaria.data.data.controller;

import org.springframework.web.bind.annotation.*;
import veterinaria.data.data.dto.Dueño;
import veterinaria.data.data.dto.Mascota;
import veterinaria.data.data.dto.Respuesta;
import veterinaria.data.data.exceptions.ExceptionManager;
import veterinaria.data.data.manager.ImgrMascota;

import java.util.List;

@RestController
@RequestMapping(path = "/veterinaria")
@CrossOrigin("*")
public class ControllerMascota {
    ImgrMascota manager;

    public ControllerMascota(ImgrMascota manager) {
        this.manager = manager;
    }

    @PostMapping(path = "mascota/save")
    public @ResponseBody void Save (@RequestBody Mascota mascota){
        try {
            manager.Save(mascota);
        } catch (ExceptionManager e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(path = "mascota/delete")
    public @ResponseBody void Delete (@RequestParam int id){
        Mascota mascota = new Mascota();
        mascota.setIdmascota(id);
        try {
            manager.Delete(mascota);
        } catch (ExceptionManager e) {
            e.printStackTrace();
        }

    }

    @PutMapping(path = "mascota/update")
    public @ResponseBody void Update (@RequestBody Mascota mascota){
        try {
            manager.Update(mascota);
        } catch (ExceptionManager e) {
            e.printStackTrace();
        }

    }

    @GetMapping(path = "/mascota/lista")
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

