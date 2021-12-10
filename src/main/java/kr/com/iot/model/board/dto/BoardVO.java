package kr.com.iot.model.board.dto;

import lombok.Data;

@Data
public class BoardVO {

	private int newNum;
	private int num;          
	private String writer;    
	private String subject;   
	private String content;   
	private String reg_date;    
	private int readcount;    
	private int no;
	private int lev;          
	private int step;         
	private int ref;          
	private String ip;        
	private String passwd;    
	private String email;
	private int startRow;
	private int endRow;
}
