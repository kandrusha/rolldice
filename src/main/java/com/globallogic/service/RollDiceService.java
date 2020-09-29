package com.globallogic.service;

import com.globallogic.dto.RollDiceDto;
import com.globallogic.dto.RollDiceRequestDto;
import java.util.List;

public interface RollDiceService {

  public List<RollDiceDto> rollDice(RollDiceRequestDto requestDto);


}
