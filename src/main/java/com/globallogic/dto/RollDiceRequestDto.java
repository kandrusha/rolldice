package com.globallogic.dto;

import javax.validation.constraints.Min;
import lombok.Data;

@Data
public class RollDiceRequestDto {
  @Min(value = 1, message = "Number of dice must be at least 1")
  private int dicePieces;
  @Min(value = 4, message = "The sides of a dice must be at least 4")
  private int diceSides;
  @Min(value = 1, message = "Total number of rolls must be at least 1")
  int rolls;
}
