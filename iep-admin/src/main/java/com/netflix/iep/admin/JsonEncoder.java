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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Keeps a cached copy of the mapper to reuse.
 */
class JsonEncoder {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  static byte[] encode(Object obj) throws JsonProcessingException {
    return MAPPER.writeValueAsBytes(obj);
  }

  static byte[] encodeUnsafe(Object obj) {
    try {
      return MAPPER.writeValueAsBytes(obj);
    } catch (JsonProcessingException e) {
      return new byte[0];
    }
  }
}
