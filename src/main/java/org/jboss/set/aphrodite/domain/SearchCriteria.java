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

package org.jboss.set.aphrodite.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * A generic search object that allows for issues to be searched without knowing details of the
 * underlying issue tracking system.
 *
 * @author Ryan Emerson
 */
public class SearchCriteria {
    private final String product;
    private final String component;
    private final Stage stage;
    private final Release release;
    private final List<Stream> streams;
    private final LocalDate lastUpdated;
    private final Integer maxResults;

    private SearchCriteria(String product, String component, Stage stage, Release release,
                           List<Stream> streams, LocalDate lastUpdated, Integer maxResults) {
        this.product = product;
        this.component = component;
        this.stage = stage;
        this.release = release;
        this.streams = streams;
        this.lastUpdated = lastUpdated;
        this.maxResults = maxResults;

        if (lastUpdated != null && lastUpdated.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("lastUpdated cannot be in the future.");
    }

    public Optional<String> getProduct() {
        return Optional.ofNullable(product);
    }

    public Optional<String> getComponent() {
        return Optional.ofNullable(component);
    }

    public Optional<Stage> getStage() {
        return Optional.ofNullable(stage);
    }

    public Optional<Release> getRelease() {
        return Optional.ofNullable(release);
    }

    public Optional<List<Stream>> getStreams() {
        return Optional.ofNullable(streams);
    }

    public Optional<LocalDate> getLastUpdated() {
        return Optional.ofNullable(lastUpdated);
    }

    public Optional<Integer> getMaxResults() {
        return Optional.ofNullable(maxResults);
    }

    public static class Builder {

        private String product;
        private String component;
        private Stage stage;
        private Release release;
        private List<Stream> streams;
        private LocalDate startDate;
        private Integer maxResults;

        public Builder setProduct(String product) {
            this.product = product;
            return this;
        }

        public Builder setComponent(String component) {
            this.component = component;
            return this;
        }

        public Builder setStage(Stage stage) {
            this.stage = stage;
            return this;
        }

        public Builder setRelease(Release release) {
            this.release = release;
            return this;
        }

        public Builder setStreams(List<Stream> streams) {
            this.streams = streams;
            return this;
        }

        public Builder setStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setMaxResults(Integer maxResults) {
            this.maxResults = maxResults;
            return this;
        }

        public SearchCriteria build() {
            return new SearchCriteria(product, component, stage, release, streams, startDate,
                    maxResults);
        }
    }
}