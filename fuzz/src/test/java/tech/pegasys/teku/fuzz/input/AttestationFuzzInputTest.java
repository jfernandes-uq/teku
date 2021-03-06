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

package tech.pegasys.teku.fuzz.input;

import tech.pegasys.teku.datastructures.operations.Attestation;
import tech.pegasys.teku.datastructures.state.BeaconStateImpl;

public class AttestationFuzzInputTest extends AbstractFuzzInputTest<AttestationFuzzInput> {

  @Override
  protected Class<AttestationFuzzInput> getInputType() {
    return AttestationFuzzInput.class;
  }

  @Override
  protected AttestationFuzzInput createInput() {
    final BeaconStateImpl state = (BeaconStateImpl) dataStructureUtil.randomBeaconState();
    final Attestation attestation = dataStructureUtil.randomAttestation();
    return new AttestationFuzzInput(state, attestation);
  }
}
