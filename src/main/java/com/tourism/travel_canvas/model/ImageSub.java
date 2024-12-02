package com.tourism.travel_canvas.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(schema = "tourism", name = "image_sub")
public class ImageSub {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer imagesubid;
	
	private String imageSubName;

	@Lob
	@Type(type = "org.hibernate.type.BinaryType") // Explicitly map the field to BinaryType
	@Column(name = "image_sub_data", columnDefinition = "bytea")
	private byte[] imageSubData;
	private Integer destinationid;
	private Character activeflag;
	private Integer createby;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdt;

    private Integer modby;  // Changed to Integer instead of Optional<Integer>
    private LocalDateTime moddt;
    
	
	
	public Integer getImagesubid() {
		return imagesubid;
	}
	public void setImagesubid(Integer imagesubid) {
		this.imagesubid = imagesubid;
	}
	public String getImageSubName() {
		return imageSubName;
	}
	public void setImageSubName(String imageSubName) {
		this.imageSubName = imageSubName;
	}
	public byte[] getImageSubData() {
		return imageSubData;
	}
	public void setImageSubData(byte[] imageSubData) {
		this.imageSubData = imageSubData;
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
	
	public ImageSub() {
		super();
	}
	public ImageSub(Integer imagesubid, String imageSubName, byte[] imageSubData, Integer destinationid,
			Character activeflag, Integer createby, LocalDateTime createdt, Integer modby, LocalDateTime moddt) {
		super();
		this.imagesubid = imagesubid;
		this.imageSubName = imageSubName;
		this.imageSubData = imageSubData;
		this.destinationid = destinationid;
		this.activeflag = activeflag;
		this.createby = createby;
		this.createdt = createdt;
		this.modby = modby;
		this.moddt = moddt;
	}
	public ImageSub(Integer imagesubid, String imageSubName, byte[] imageSubData, Integer destinationid,
			Character activeflag, Integer createby, LocalDateTime createdt) {
		super();
		this.imagesubid = imagesubid;
		this.imageSubName = imageSubName;
		this.imageSubData = imageSubData;
		this.destinationid = destinationid;
		this.activeflag = activeflag;
		this.createby = createby;
		this.createdt = createdt;
	}
	
	
	
	
	
	
	

}
