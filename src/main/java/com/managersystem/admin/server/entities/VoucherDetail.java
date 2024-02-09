package com.managersystem.admin.server.entities;

import com.managersystem.admin.server.entities.base.BaseEntity;
import com.managersystem.admin.server.entities.type.VoucherStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "voucher_detail")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VoucherDetail extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "code")
  private String code;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "given_at")
  private Long givenAt;

  @Column(name = "voucher_status")
  @Enumerated(EnumType.STRING)
  private VoucherStatus status;
}