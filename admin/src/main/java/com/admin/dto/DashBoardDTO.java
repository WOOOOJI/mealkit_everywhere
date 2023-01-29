package com.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DashBoardDTO {
	private int totalPrice;
	private int totalShip;
	private double confirmation;
	
	private double sellIncrease;
	private double shipIncrease;
	private double confirmationIncrease;
}
