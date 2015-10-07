/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2015, Red Hat, Inc., and individual contributors
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

package org.jboss.set.aphrodite.config;

import java.util.Objects;

/**
 * @author Ryan Emerson
 */
public class RepositoryConfig extends AbstractServiceConfig {

    private final String type;

    public RepositoryConfig(String url, String username, String password, String type) {
        super(url, username, password);

        Objects.requireNonNull(type, "A 'type' must be specified for each repository.");
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "RepositoryConfig{" +
                "url='" + getUrl() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
