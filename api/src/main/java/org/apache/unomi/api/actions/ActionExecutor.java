/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.unomi.api.actions;

import org.apache.unomi.api.Event;
import org.apache.unomi.api.services.EventService;

/**
 * A piece of code that performs a specified {@link Action}, given a triggering {@link Event}
 */
public interface ActionExecutor {

    /**
     * Executes a specified {@link Action}, given a triggering {@link Event}.
     *
     * @param action the {@link Action} to execute
     * @param event  the {@link Event} that triggered the action
     * @return an integer status corresponding to what happened as defined by public constants of {@link EventService}
     */
    int execute(Action action, Event event);

}
