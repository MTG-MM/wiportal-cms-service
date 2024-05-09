package com.wiinvent.gami.domain.entities;

import com.wiinvent.gami.domain.entities.type.Status;
import com.wiinvent.gami.domain.pojo.UserRewardItems;
import com.wiinvent.gami.domain.utils.Converter.UserRewardItemConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "quest")
public class Quest extends BaseEntity{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Size(max = 50)
  @NotNull
  @Column(name = "code", nullable = false, length = 50)
  private String code;

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "image_url", nullable = false)
  private String imageUrl;

  @Column(name = "game_id")
  private Integer gameId;

  @Column(name = "status")
  private Status status;

  @Column(name = "reward_items")
  @Convert(converter = UserRewardItemConverter.class)
  private List<UserRewardItems> rewardItems;
}