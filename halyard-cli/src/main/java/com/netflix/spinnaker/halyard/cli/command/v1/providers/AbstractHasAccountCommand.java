/*
 * Copyright 2017 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.halyard.cli.command.v1.providers;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.NestableCommand;
import com.netflix.spinnaker.halyard.cli.services.v1.Daemon;
import com.netflix.spinnaker.halyard.cli.ui.v1.AnsiUi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * An abstract definition for commands that accept ACCOUNT as a main parameter
 */
@Parameters()
public abstract class AbstractHasAccountCommand extends AbstractProviderCommand {
  @Parameter(description = "The name of the account to operate on.", arity = 1)
  List<String> accounts = new ArrayList<>();

  @Override
  public String getMainParameter() {
    return "account";
  }

  public String getAccountName() {
    switch (accounts.size()) {
      case 0:
        throw new IllegalArgumentException("No account name supplied");
      case 1:
        return accounts.get(0);
      default:
        throw new IllegalArgumentException("More than one account supplied");
    }
  }
}
