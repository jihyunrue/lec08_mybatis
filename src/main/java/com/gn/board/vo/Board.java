package com.gn.board.vo;

import java.util.Date;

import com.gn.common.Paging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Board extends Paging {
	private int board_no;
	private String board_title;
	private String board_content;
	private Date reg_date;
	private String order_type = "1";
}
