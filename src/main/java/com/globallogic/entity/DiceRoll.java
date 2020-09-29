package com.globallogic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dice_roll")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiceRoll {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @EqualsAndHashCode.Exclude
  private Long id;
  @Column(name = "roll_sum")
  private Integer rollSum;
  @Column(name = "roll_sum_amount")
  private Integer rollSumAmount;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "dice_roll_id", referencedColumnName = "id", nullable = false)
  private DiceRollRequest diceRollRequest;
}
