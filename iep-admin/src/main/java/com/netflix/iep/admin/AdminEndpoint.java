/*
 * Copyright 2014-2022 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.netflix.iep.admin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * Qualifier for all admin endpoints.
 *
 * Admin resources are meant to be very lightweight with no dependencies. Resources
 * can either implement {@link HttpEndpoint} or implement the methods specified in that
 * interface and the admin will use reflection to invoke them. The second approach allows
 * for having an endpoint resource without an explicit dependency on the admin.
 *
 * <pre>
 * // Resource {name} derived from multi-binding string
 * class MyEndpoint {
 *   // {name}/
 *   public get() {
 *   }
 *
 *   // {name}/{id}
 *   public get(String id) {
 *   }
 * }
 * </pre>
 *
 * The {@code name} is configured using a Map binding.
 */
@Qualifier
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AdminEndpoint {
}
