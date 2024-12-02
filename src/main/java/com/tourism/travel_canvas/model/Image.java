package com.tourism.travel_canvas.model;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.*;

@Entity
@Table(schema = "tourism", name = "image")
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer imageid;
	private String name;

	@Lob
	@Type(type = "org.hibernate.type.BinaryType") // Explicitly map the field to BinaryType
	@Column(name = "image_data", columnDefinition = "bytea")
	private byte[] imageData;
	private Integer destinationid;
	private Character activeflag;
	private Integer createby;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdt;

    private Integer modby;  // Changed to Integer instead of Optional<Integer>
    private LocalDateTime moddt;

	public Integer getImageid() {
		return imageid;
	}

	public void setImageid(Integer imageid) {
		this.imageid = imageid;
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

	public Integer getDestinationid() {
		return destinationid;
	}

	public void setDestinationid(Integer destinationid) {
		this.destinationid = destinationid;
	}

	
	public Character getActiveflag() {
		return activeflag;
	}

	public void setActiveflag(Character activeflag) {
		this.activeflag = activeflag;
	}

	@Override
	public String toString() {
		return "Image [imageid=" + imageid + ", name=" + name + ", imageData=" + Arrays.toString(imageData)
				+ ", destinationid=" + destinationid + ", activeflag=" + activeflag + ", createby=" + createby
				+ ", createdt=" + createdt + ", modby=" + modby + ", moddt=" + moddt + "]";
	}

	public Image(Integer imageid, String name, byte[] imageData, Integer destinationid, Character activeflag,
			Integer createby, LocalDateTime createdt) {
		super();
		this.imageid = imageid;
		this.name = name;
		this.imageData = imageData;
		this.destinationid = destinationid;
		this.activeflag = activeflag;
		this.createby = createby;
		this.createdt = createdt;
	}

	public Image(Integer imageid, String name, byte[] imageData, Integer destinationid, Character activeflag,
			Integer createby, LocalDateTime createdt, Integer modby, LocalDateTime moddt) {
		super();
		this.imageid = imageid;
		this.name = name;
		this.imageData = imageData;
		this.destinationid = destinationid;
		this.activeflag = activeflag;
		this.createby = createby;
		this.createdt = createdt;
		this.modby = modby;
		this.moddt = moddt;
	}

	public Integer getCreateby() {
		return createby;
	}

	public void setCreateby(Integer createby) {
		this.createby = createby;
	}

	public LocalDateTime getCreatedt() {
		return createdt;
	}

	public void setCreatedt(LocalDateTime createdt) {
		this.createdt = createdt;
	}

	public Integer getModby() {
		return modby;
	}

	public void setModby(Integer modby) {
		this.modby = modby;
	}

	public LocalDateTime getModdt() {
		return moddt;
	}

	public void setModdt(LocalDateTime moddt) {
		this.moddt = moddt;
	}

	public Image() {
		super();
	}

	
	
}
