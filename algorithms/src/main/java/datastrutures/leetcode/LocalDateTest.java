package datastrutures.leetcode;

import java.time.LocalDateTime;

/**
 * Created by archith.rapaka on 5/11/17.
 */
public class LocalDateTest {

	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.parse("2017-03-04T12:30:30");
		//System.out.println(date);
		LocalDateTime date1 = LocalDateTime.parse("2017-05-03T12:30:30");
		LocalDateTime now = LocalDateTime.now();
		//System.out.println(date1);
		//System.out.println(now);
		System.out.println(now.compareTo(date1));
	}

}
