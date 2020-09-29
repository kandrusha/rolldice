package com.globallogic.service.impl;

import com.globallogic.dto.RollDiceDto;
import com.globallogic.dto.RollDiceRequestDto;
import com.globallogic.entity.DiceRollRequest;
import com.globallogic.entity.DiceRoll;
import com.globallogic.repository.DiceRollRequestRepository;
import com.globallogic.service.RollDiceService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DefaultRollDiceService implements RollDiceService {

  @Autowired
  private Random random;
  @Autowired
  private DiceRollRequestRepository diceRollRepository;

  public List<RollDiceDto> rollDice(RollDiceRequestDto requestDto) {
    Map<Integer, Integer> rollResult = new HashMap<>();
    for (int i = 0; i < requestDto.getRolls(); i++) {
      Integer rollSum = getRollSum(requestDto.getDicePieces(), requestDto.getDiceSides());
      Integer rollSumCount = rollResult.getOrDefault(rollSum, 0);
      rollResult.put(rollSum, ++rollSumCount);
    }

    saveDiceRolls(requestDto, rollResult);

    return rollResult.entrySet().stream()
      .map(entry -> RollDiceDto.builder()
        .rollSum(entry.getKey())
        .rollSumAmount(entry.getValue())
        .build())
      .collect(Collectors.toList());
  }

  @Transactional
  private void saveDiceRolls(RollDiceRequestDto requestDto, Map<Integer, Integer> rollResult) {
    DiceRollRequest diceRollRequest = DiceRollRequest.builder()
      .dicePieces(requestDto.getDicePieces())
      .diceSides(requestDto.getDiceSides())
      .rolls(requestDto.getRolls())
      .build();

    List<DiceRoll> diceRolls = rollResult.entrySet().stream()
      .map(entry -> DiceRoll.builder()
        .diceRollRequest(diceRollRequest)
        .rollSum(entry.getKey())
        .rollSumAmount(entry.getValue())
        .build())
      .collect(Collectors.toList());
    diceRollRequest.setDiceRolls(diceRolls);
    diceRollRepository.save(diceRollRequest);
  }

  private int getRollSum(int diceNumber, int diceSides) {
    int rollSum = 0;
    for (int i = 0; i < diceNumber; i++) {
      rollSum += random.nextInt(diceSides) + 1;
    }
    return rollSum;
  }
}
