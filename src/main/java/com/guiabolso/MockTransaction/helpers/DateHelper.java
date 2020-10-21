package com.guiabolso.MockTransaction.helpers;

import com.guiabolso.MockTransaction.dtos.client.transaction.out.TransactionOutputDTO;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.Instant;
import java.util.TimeZone;

@Service
public class DateHelper {

	public static LocalDateTime longToLocalDateTime(TransactionOutputDTO transaction) {
		LocalDateTime date = null;
			date =
					LocalDateTime.ofInstant(Instant.ofEpochMilli(transaction.getData() ), TimeZone
							.getDefault().toZoneId());

		return date;
	}

}
