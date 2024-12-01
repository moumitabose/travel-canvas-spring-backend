package com.tourism.travel_canvas.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(schema = "tourism", name = "image")
public class Image
{
    @Id


    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

private String name;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType") // Explicitly map the field to BinaryType
    @Column(name = "image_data", columnDefinition = "bytea")
private byte[] imageData;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
