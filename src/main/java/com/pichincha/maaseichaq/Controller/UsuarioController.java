package com.pichincha.maaseichaq.Controller;

import com.pichincha.maaseichaq.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pichincha.maaseichaq.Entity.Usuario;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listar")
    public ArrayList<Usuario> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping(path = "/buscar/{id}")
    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return usuarioService.obtenerPorId(id);
    }
    @GetMapping("/cedula")
    public Usuario obtenerUsuarioPorCedula(@RequestParam("cedula")String cedula){
        return usuarioService.obtenerPorCedula(cedula);
    }
    @DeleteMapping(path = "/del/{id}")
    public String eliminarPorId(@PathVariable("id")Long id){
        boolean ok = usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con el id ("+id+")";
        }else{
            return "No se pudo eliminar el usuario con el id ("+id+")";
        }
    }
    @PostMapping("/save")
    public String guardarUsuario(@RequestBody Usuario usuario){
        return usuarioService.guardarUsuario(usuario);
    }
}
