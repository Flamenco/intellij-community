/*
 * Copyright 2000-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.openapi.vcs.configurable;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurableProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vcs.ProjectLevelVcsManager;
import org.jetbrains.annotations.NotNull;

public final class VcsManagerConfigurableProvider extends ConfigurableProvider {
  private final Project myProject;

  public VcsManagerConfigurableProvider(Project project) {
    myProject = project;
  }

  @NotNull
  @Override
  public Configurable createConfigurable() {
    return new VcsManagerConfigurable(myProject);
  }

  @Override
  public boolean isConfigurableProvided() {
    return ProjectLevelVcsManager.getInstance(myProject).getAllVcss().length > 0;
  }
}
