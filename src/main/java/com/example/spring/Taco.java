package com.example.spring;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Taco {

  private Long id;
  private LocalDateTime createdAt = LocalDateTime.now();

  @NotNull
  @Size(min = 5, message = "Name must be at least 5 characters long")
  private String name;

  @Size(min=1, message="You must choose at least 1 ingredient")
  private List<IngredientRef> ingredients = new ArrayList<>();

  public void addIngredient(Ingredient ingredient) {
    ingredients.add(new IngredientRef(ingredient.getId()));
  }
}
