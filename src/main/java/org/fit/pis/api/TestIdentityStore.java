
package org.fit.pis.api;

import java.util.Arrays;
import java.util.HashSet;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;


@ApplicationScoped
public class TestIdentityStore implements IdentityStore 
{

    public CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {

        if (usernamePasswordCredential.compareTo("user", "secret")) {
            return new CredentialValidationResult("user", new HashSet<>(Arrays.asList("user")));
        } else if (usernamePasswordCredential.compareTo("admin", "secret")) {
            return new CredentialValidationResult("admin", new HashSet<>(Arrays.asList("user", "admin")));
        }

        return CredentialValidationResult.INVALID_RESULT;
    }

}
