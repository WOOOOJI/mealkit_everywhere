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

    private String nowYear;
    private String nowMonth;
    private String nowDay;

    private String totalPrice;
    private String totalShip;
    private double confirmation;

    private String sellIncrease;
    private String totalItemCnt;

    private String itemCntIncrease;
    private String shipIncrease;
    private String confirmationIncrease;
}