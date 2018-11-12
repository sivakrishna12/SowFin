package com.app.model;

import org.hibernate.annotations.GenericGenerator;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "snapshots")
public class Snapshot {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    private int id;

    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String fileName;

    private String fileType;

    @Lob
    private byte[] snapshot;
    private Date saved_at;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public byte[] getSnapshot() {
		return snapshot;
	}
	public void setSnapshot(byte[] snapshot) {
		this.snapshot = snapshot;
	}
	public Date getSaved_at() {
		return saved_at;
	}
	public void setSaved_at(Date saved_at) {
		this.saved_at = saved_at;
	}
	public Snapshot(int id, String fileName, String fileType, byte[] snapshot, Date saved_at) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.snapshot = snapshot;
		this.saved_at = saved_at;
	}
	public Snapshot() {
		super();
	}
	public Snapshot(int id) {
		super();
		this.id = id;
	}
	public Snapshot(String fileName, String fileType, byte[] snapshot, Date saved_at) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.snapshot = snapshot;
		this.saved_at = saved_at;
	}
	@Override
	public String toString() {
		return "Snapshot [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", snapshot="
				+ Arrays.toString(snapshot) + ", saved_at=" + saved_at + "]";
	}
	
   
}
