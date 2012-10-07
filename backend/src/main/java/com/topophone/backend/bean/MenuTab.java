package com.topophone.backend.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class MenuTab {
	
	@Id
	@Column(name="Id")
	@Getter
	private Long id;

	@Getter @Setter
	@OneToMany(targetEntity=TabEntry.class)
	private List<TabEntry> entries;

}
