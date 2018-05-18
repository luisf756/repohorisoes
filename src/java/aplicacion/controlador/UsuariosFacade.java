/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador;

import aplicacion.entidades.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Hogar
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "proyectoLoginPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    public List obtenerLogin(){
        Query q= em.createNativeQuery("SELECT usua_id, usua_correo, usua_pass, fk_usua_rol FROM usuarios;");
        List<Object[]> listado =q.getResultList();
        return listado;
    }
    public Usuarios encontrarUsuario(String nombre){
        Query q=em.createNamedQuery("Usuarios.findByUsuaCorreo", Usuarios.class).setParameter("usuaCorreo", nombre);
        List<Usuarios> listado= q.getResultList();
        
        if(!listado.isEmpty()){
            return listado.get(0);
        }
        return null;
    }
    
}
