/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.upeu.dadsoap.ws;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.upeu.dadsoap.dao.PostDao;
import pe.edu.upeu.dadsoap.daoImpl.PostDaoImpl;
import pe.edu.upeu.dadsoap.model.Post;

/**
 *
 * @author admin
 */
@WebService(serviceName = "PostWebService")
public class PostWebService {
private PostDao dao = new PostDaoImpl();
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
        @WebMethod(operationName = "readAllPost")
    public List<Post> readAllPost() {
        return dao.readAll();
    }
}
