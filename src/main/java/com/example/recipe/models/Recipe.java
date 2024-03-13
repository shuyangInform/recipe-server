package com.example.recipe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties (value = {"hibernateLazyInitializer", "handler"})
public class Recipe {

  @Id
  @GeneratedValue
  private long   id;

  @Column (name = "name")
  private String name;

  @Column (name = "description", length = Integer.MAX_VALUE)
  private String description;

  public long getId () {
    return id;
  }

  public void setId (long id) {
    this.id = id;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public String getDescription () {
    return description;
  }

  public void setDescription (String description) {
    this.description = description;
  }
}
