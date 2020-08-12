package com.bancobogota.web;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Gabriel Arias
 */
@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext acrc_requestContext, ContainerResponseContext acrc_responseContext) throws IOException {
        
        MultivaluedMap<String, Object> headers;
        
        headers = acrc_responseContext.getHeaders();
        
        headers.add("Acces-Control-Allow-Origin", "*");
        headers.add("Acces-Control-Allow-Credentials", "true");
        headers.add("Acces-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,  Authorization");
        headers.add("Acces-Control-Allow-Methdos", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }

}
