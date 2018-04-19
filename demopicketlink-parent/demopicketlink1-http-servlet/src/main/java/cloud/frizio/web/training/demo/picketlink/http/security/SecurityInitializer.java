/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package cloud.frizio.web.training.demo.picketlink.http.security;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.credential.Password;
import org.picketlink.idm.model.basic.Role;
import org.picketlink.idm.model.basic.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import static org.picketlink.idm.model.basic.BasicModel.grantRole;

/**
 * This startup bean creates a number of default users, groups and roles when the application is started.
 * 
 * @author Pedro Igor, modified by Maurizio La Rocca;
 */

@Singleton
@Startup
public class SecurityInitializer {

    @Inject
    private PartitionManager partitionManager;
    
    private static final Logger LOG4JLOGGER = LogManager.getLogger(SecurityInitializer.class.getName());
    

    @PostConstruct
    public void create() {
    	LOG4JLOGGER.info("\nChiamato metodo create on PostCostruct");
    	LOG4JLOGGER.info("Creazione di utenti gruppi e ruoli dell'applicazione");
    	
    	IdentityManager identityManager = this.partitionManager.createIdentityManager();
    	
        // Create user john
        User john = new User("john");
        identityManager.add(john);
        identityManager.updateCredential(john, new Password("john"));

        // Create user admmin
        User admin = new User("admin");
        identityManager.add(admin);
        identityManager.updateCredential(admin, new Password("aaaa"));
        
        // Create application role "adminRole"
        Role userRole = new Role("User");
        identityManager.add(userRole);

        // Create application role "adminRole"
        Role adminRole = new Role("Administrator");
        identityManager.add(adminRole);

        RelationshipManager relationshipManager = this.partitionManager.createRelationshipManager();
        
        // Grant the "userRole" application role to john
        grantRole(relationshipManager, john, userRole);
        
        // Grant the "adminRole" application role to admin
        grantRole(relationshipManager, admin, adminRole);
    }
}
