package uk.ac.york.sepr4.objects.entity;

import lombok.Data;

@Data
public class Attribute {

    private Double health;
    private Double maxHealth;

    private Float angle;
    private Float speed;

    private Double damage;

    public Attribute(){
        this(10.0, 10.0, 15f, 1.2f, 1.0);
    }

    public Attribute(Double health, Double maxHealth, Float speed, Float angularSpeed, Double damage){
        this.health = health;
        this.maxHealth = maxHealth;
        this.speed = speed;
        this.angle = angularSpeed;
        this.damage = damage;
    }

}
