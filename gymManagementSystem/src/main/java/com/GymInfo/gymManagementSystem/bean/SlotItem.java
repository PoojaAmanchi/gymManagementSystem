package com.GymInfo.gymManagementSystem.bean;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class SlotItem {
  @EmbeddedId
  private SlotItemEmbed embeddedId;
  private Integer seatAvailable;
  public SlotItem() {
    super();
    seatAvailable=0;
    // TODO Auto-generated constructor stub
  }
  public SlotItem(SlotItemEmbed embeddedId, Integer seatAvailable) {
    super();
    this.embeddedId = embeddedId;
    this.seatAvailable = seatAvailable;
  }
  public SlotItemEmbed getEmbeddedId() {
    return embeddedId;
  }
  public void setEmbeddedId(SlotItemEmbed embeddedId) {
    this.embeddedId = embeddedId;
  }
  public Integer getSeatAvailable() {
    return seatAvailable;
    }
    public void setSeatAvailable(Integer seatAvailable) {
    this.seatAvailable = seatAvailable;
    } 
}