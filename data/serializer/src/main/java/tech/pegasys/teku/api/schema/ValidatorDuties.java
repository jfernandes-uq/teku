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

package tech.pegasys.teku.api.schema;

import static tech.pegasys.teku.api.schema.SchemaConstants.DESCRIPTION_BYTES48;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import tech.pegasys.teku.infrastructure.unsigned.UInt64;

public class ValidatorDuties {
  @Schema(type = "string", format = "byte", description = DESCRIPTION_BYTES48)
  public final BLSPubKey validator_pubkey;

  public final Integer aggregator_modulo;
  public final Integer validator_index;
  public final Integer attestation_committee_index;
  public final Integer attestation_committee_position;

  @ArraySchema(schema = @Schema(type = "string", format = "uint64"))
  public final List<UInt64> block_proposal_slots;

  @Schema(type = "string", format = "uint64")
  public final UInt64 attestation_slot;

  @JsonCreator
  public ValidatorDuties(
      @JsonProperty("validator_pubkey") BLSPubKey validator_pubkey,
      @JsonProperty("validator_index") Integer validator_index,
      @JsonProperty("attestation_committee_index") Integer attestation_committee_index,
      @JsonProperty("attestation_committee_position") Integer attestation_committee_position,
      @JsonProperty("aggregator_modulo") Integer aggregator_modulo,
      @JsonProperty("block_proposal_slots") List<UInt64> block_proposal_slots,
      @JsonProperty("attestation_slot") UInt64 attestation_slot) {
    this.validator_pubkey = validator_pubkey;
    this.validator_index = validator_index;
    this.attestation_committee_index = attestation_committee_index;
    this.attestation_committee_position = attestation_committee_position;
    this.aggregator_modulo = aggregator_modulo;
    this.block_proposal_slots = block_proposal_slots;
    this.attestation_slot = attestation_slot;
  }
}