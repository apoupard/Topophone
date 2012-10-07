package com.topophone.backend.bean;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@EqualsAndHashCode
@ToString
public class TabEntry {

	@Id
	@Getter
	private Long id;

	@Basic
	@Getter
	@Setter
	private String name;

	@Basic
	@Getter
	@Setter
	private Integer position;

}
