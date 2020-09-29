package com.globallogic.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RollDiceDto {
  private int rollSum;
  private int rollSumAmount;
}
