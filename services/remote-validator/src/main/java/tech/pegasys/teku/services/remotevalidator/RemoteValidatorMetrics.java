/*
 * Copyright 2020 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package tech.pegasys.teku.services.remotevalidator;

import org.hyperledger.besu.plugin.services.MetricsSystem;
import tech.pegasys.teku.infrastructure.metrics.SettableGauge;
import tech.pegasys.teku.infrastructure.metrics.TekuMetricCategory;

class RemoteValidatorMetrics {

  private final SettableGauge connectedValidatorsGauge;

  RemoteValidatorMetrics(final MetricsSystem metricsSystem) {
    connectedValidatorsGauge =
        SettableGauge.create(
            metricsSystem,
            TekuMetricCategory.REMOTE_VALIDATOR,
            "connected_validator_nodes",
            "Number of validator nodes connected to the Remote Validator Service");
  }

  void updateConnectedValidators(final int value) {
    connectedValidatorsGauge.set(value);
  }
}
