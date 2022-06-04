package com.pichincha.maaseichaq.Service;

import java.util.ArrayList;
import java.util.Optional;

import com.pichincha.maaseichaq.Entity.Usuario;

public interface UsuarioServicio {
    public ArrayList<Usuario> obtenerUsuarios();
    public String guardarUsuario(Usuario usuario);
    public Optional<Usuario> obtenerPorId(Long id);
    public Usuario obtenerPorCedula(String cedula);
    public Usuario obtenerPorEmail(String email);
    public Boolean eliminarUsuario(Long id);
}
