package org.fit.pis.api;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


/**
 *
 * @author burgetr
 */
@ApplicationScoped
@ApplicationPath("/rest")
@DeclareRoles({ "user", "admin" })
@BasicAuthenticationMechanismDefinition(realmName = "rest-api")
public class ApplicationConfig extends Application {

}
