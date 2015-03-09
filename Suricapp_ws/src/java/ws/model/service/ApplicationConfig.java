/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.model.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Morgan
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ws.model.service.DCategoryFacadeREST.class);
        resources.add(ws.model.service.DCommentFacadeREST.class);
        resources.add(ws.model.service.DFollowerFacadeREST.class);
        resources.add(ws.model.service.DMessageFacadeREST.class);
        resources.add(ws.model.service.DPointFacadeREST.class);
        resources.add(ws.model.service.DUserFacadeREST.class);
    }
    
}
