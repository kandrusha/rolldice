package com.globallogic.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dice_roll_request")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiceRollRequest {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  @EqualsAndHashCode.Exclude
  private Long id;
  @Column(name = "rolls")
  private Integer rolls;
  @Column(name = "dice_pieces")
  private Integer dicePieces;
  @Column(name = "dice_sides")
  private Integer diceSides;
  @OneToMany(mappedBy = "diceRollRequest", fetch = FetchType.LAZY, orphanRemoval=true, cascade = CascadeType.ALL)
  @Default
  @EqualsAndHashCode.Exclude
  private List<DiceRoll> diceRolls = new ArrayList<>();
}
