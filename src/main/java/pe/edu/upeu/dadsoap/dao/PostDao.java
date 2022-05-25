/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.dadsoap.dao;

import java.util.List;
import pe.edu.upeu.dadsoap.model.Post;

/**
 *
 * @author admin
 */
public interface PostDao {
    int create (Post post);
    int update (Post post);
    int delete (int id);
    Post read (int id);
    List<Post> readAll();
}
