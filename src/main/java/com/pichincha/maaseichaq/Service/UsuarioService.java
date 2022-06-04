package com.pichincha.maaseichaq.Service;

import com.pichincha.maaseichaq.Entity.Usuario;
import com.pichincha.maaseichaq.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService implements UsuarioServicio {
    @Autowired
    UsuarioRepository usuarioRepository;
    public ArrayList<Usuario> obtenerUsuarios(){
        return  (ArrayList<Usuario>) usuarioRepository.findAll();
    }
    public String guardarUsuario(Usuario usuario){
        String cedula = usuario.getCedula();
        String email = usuario.getEmail();
        if (validarCedula(cedula)) {
            Usuario userEmail = usuarioRepository.findByEmail(email);
            Usuario userCedula = usuarioRepository.findByCedula(cedula);
            if (userCedula == null && userEmail == null) {
                usuarioRepository.save(usuario);
                return "Usuario registrado exitosamente";
            }
            if (userCedula != null) {
                return "Ya existe un usuario con la cédula " + cedula;
            }
            if (userEmail != null) {
                return "Ya existe un usuario con el email " + email;
            }
            return "Usuario no registrado contactese con el admin";
        }else {
            return "La cédula es incorrecta";
        }
    }
    public Optional<Usuario> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }
    public Usuario obtenerPorCedula(String cedula){
        return usuarioRepository.findByCedula(cedula);
    }
    public Usuario obtenerPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }
    public Boolean eliminarUsuario(Long id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private Boolean validarCedula(String cedula){
        boolean cedulaCorrecta;
        if (cedula.length() == 10) // ConstantesApp.LongitudCedula
        {
            int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
            if (tercerDigito < 6) {
            // Coeficientes de validación cédula
            // El decimo digito se lo considera dígito verificador
                int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
                int verificador = Integer.parseInt(cedula.substring(9,10));
                int suma = 0;
                int digito = 0;
                for (int i = 0; i < (cedula.length() - 1); i++) {
                    digito = Integer.parseInt(cedula.substring(i, i + 1))* coefValCedula[i];
                    suma += ((digito % 10) + (digito / 10));
                }

                if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                    cedulaCorrecta = true;
                }
                else if ((10 - (suma % 10)) == verificador) {
                    cedulaCorrecta = true;
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } else {
            cedulaCorrecta = false;
        }
        return cedulaCorrecta;
    }
}
