package com.wiinvent.gami.domain.entities.Transaction;

import com.wiinvent.gami.domain.entities.BaseEntity;
import com.wiinvent.gami.domain.entities.type.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "turn_transaction")
public class TurnTransaction extends BaseEntity {
  @Id
  @Column(columnDefinition = "BINARY(16)")
  private UUID id;

  @Column(name = "user_id", columnDefinition = "BINARY(16)")
  private UUID userId;

  @Column(name = "amount")
  private Long amount;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private TransactionType type;

  @Column(name = "note")
  private String note;

  @Column(name = "resource_type")
  private String resourceType;

  @Column(name = "balance")
  private Long balance;
}
