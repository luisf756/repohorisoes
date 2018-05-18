/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hogar
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByUsuaId", query = "SELECT u FROM Usuarios u WHERE u.usuaId = :usuaId")
    , @NamedQuery(name = "Usuarios.findByUsuaCorreo", query = "SELECT u FROM Usuarios u WHERE u.usuaCorreo = :usuaCorreo")
    , @NamedQuery(name = "Usuarios.findByUsuaPass", query = "SELECT u FROM Usuarios u WHERE u.usuaPass = :usuaPass")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usua_id")
    private Integer usuaId;
    @Size(max = 50)
    @Column(name = "usua_correo")
    private String usuaCorreo;
    @Size(max = 50)
    @Column(name = "usua_pass")
    private String usuaPass;
    @JoinColumn(name = "fk_usua_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Roles fkUsuaRol;

    public Usuarios() {
    }

    public Usuarios(Integer usuaId) {
        this.usuaId = usuaId;
    }

    public Integer getUsuaId() {
        return usuaId;
    }

    public void setUsuaId(Integer usuaId) {
        this.usuaId = usuaId;
    }

    public String getUsuaCorreo() {
        return usuaCorreo;
    }

    public void setUsuaCorreo(String usuaCorreo) {
        this.usuaCorreo = usuaCorreo;
    }

    public String getUsuaPass() {
        return usuaPass;
    }

    public void setUsuaPass(String usuaPass) {
        this.usuaPass = usuaPass;
    }

    public Roles getFkUsuaRol() {
        return fkUsuaRol;
    }

    public void setFkUsuaRol(Roles fkUsuaRol) {
        this.fkUsuaRol = fkUsuaRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuaId != null ? usuaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuaId == null && other.usuaId != null) || (this.usuaId != null && !this.usuaId.equals(other.usuaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplicacion.entidades.Usuarios[ usuaId=" + usuaId + " ]";
    }
    
}
