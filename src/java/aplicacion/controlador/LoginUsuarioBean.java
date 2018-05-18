/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador;

import aplicacion.entidades.Usuarios;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Hogar
 */
@Named(value = "loginUsuarioBean")
@SessionScoped
public class LoginUsuarioBean implements Serializable {

   @EJB
   private UsuariosFacade usuFacade;
   private Usuarios usuarioAutenticado;

    public Usuarios getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Usuarios usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }
   private List<Object> listado; 

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
   private String usuario;
   private String contraseña;

    public List<Object> getListado() {
        return listado;
    }

    public void setListado(List<Object> listado) {
        this.listado = listado;
    }
   
    public LoginUsuarioBean() {
    }
    public String autentcar(){
        usuarioAutenticado= usuFacade.encontrarUsuario(usuario);
        if(usuarioAutenticado!=null){
            if(usuarioAutenticado.getUsuaPass().equals(contraseña)){
                return "ingresar";
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Contraseña incorrecta", "Contraseña incorrecta"));
            return null;
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "El usuario no existe", "el usuario no existe"));
        return null;
    }
}
