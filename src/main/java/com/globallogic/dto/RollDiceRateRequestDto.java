package com.globallogic.dto;

import javax.validation.constraints.Min;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class RollDiceRateRequestDto {
  @Min(value = 1, message = "Number of dice must be at least 1")
  @Nullable
  private int dicePieces;
  @Min(value = 4, message = "The sides of a dice must be at least 4")
  @Nullable
  private int diceSides;
}
