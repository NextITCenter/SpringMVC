package kr.or.nextit.springmvc.member;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

// 우리나라 웹 개발에서는 DTO보다는 VO(Value Object)를 많이 사용
@Data
public class MemberDTO {
	private String memId;
	private String memPass;
	private String memName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate memBir;
	private String memZip;
	private String memAdd1;
	private String memAdd2;
	private String memHp;
	private String memMail;
}
