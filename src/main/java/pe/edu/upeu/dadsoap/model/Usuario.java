/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.dadsoap.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author admin
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Usuario {
    public int idusuario;
    public String username;
    public String password;
    public int idpersona;
    public int idrol;
    public String fechacreacion;
    public boolean estado;
}
