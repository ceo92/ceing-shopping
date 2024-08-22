package ceing.ceing.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ColorEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "color_id")
  private Long id;

  private Color color;



}
