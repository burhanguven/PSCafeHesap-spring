package com.Hesap.PSHesap.service.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import com.Hesap.PSHesap.model.TableStatus;
import com.Hesap.PSHesap.repository.PStableStatusRepository;
import com.Hesap.PSHesap.service.PStableStatusService;

@Service
public class PStableStatusServiceImpl implements PStableStatusService {
	
	static final int MINUTES_PER_HOUR = 60;
	static final int SECONDS_PER_MINUTE = 60;
	static final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;
	//virgülden sonra 2 bakasak almak için
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	@Autowired
	PStableStatusRepository psTableStatusRepository;

	@Override
	public TableStatus saveTableStatus(TableStatus tableStatus) {
		
		return psTableStatusRepository.save(tableStatus);
	}

	@Override
	public List<TableStatus> getTableStatus() {
		return psTableStatusRepository.findAll();
	}

	@Override
	public TableStatus getSaatHesap(Integer id, TableStatus tableStatus) throws ParseException {
		
		double hesapSaat=0;
		double hesap=0;
		double hesapDakika=0;
		int kolSayısı=0;
		
		TableStatus data=psTableStatusRepository.findFirstById(id);
		
		//status ü sıfır olan kayıt için hesapma yapmamak için kontrol ekliyorum
		if (data.getStatus()!=0) 
		{
			Date date=new Date();
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strDate=formatter.format(date);
			
			Date endDate=formatter.parse(strDate);
			 //db ye endDate i set ediyorum
			data.setEndDate(endDate);
			data.setStatus(0);
			
			System.out.println("StartDate: "+data.getStartDate());
			System.out.println("EndData: "+strDate);
			
			LocalDateTime toDateTime = LocalDateTime.of(endDate.getYear(),endDate.getMonth(),endDate.getDay(),endDate.getHours(),endDate.getMinutes(),endDate.getSeconds());
	        LocalDateTime fromDateTime = LocalDateTime.of(data.getStartDate().getYear(), data.getStartDate().getMonth() , data.getStartDate().getDay(), data.getStartDate().getHours(), data.getStartDate().getMinutes(), data.getStartDate().getSeconds());
	        
	        Period period = getPeriod(fromDateTime, toDateTime);
	        long time[] = getTime(fromDateTime, toDateTime);
	
	        /*System.out.println(period.getYears() + " years " + 
	                period.getMonths() + " months " + 
	                period.getDays() + " days " +
	                time[0] + " hours " +
	                time[1] + " minutes " +
	                time[2] + " seconds.");*/
	        //fiyat olarak hesaplamak için işleme başlıyorum
	        hesapDakika=(time[0]*60)+(time[1]);
	        System.out.println(hesapDakika);
	      
	        hesapSaat=hesapDakika/60;
			hesap=hesapSaat*data.getPrice();
			System.out.println("Hesap: "+df2.format(hesap));		
		}
		else
		{
			System.out.println("Masa Status=0 olduğundan hesaplama yapılamaz.");
		}
		
		return psTableStatusRepository.save(data);
	}
	
	//saat farkı hesaplamak için
	private static Period getPeriod(LocalDateTime dob, LocalDateTime now) {
	      return Period.between(dob.toLocalDate(), now.toLocalDate());
	}
	 //saat farkı hesaplamak için 
	private static long[] getTime(LocalDateTime dob, LocalDateTime now) {
	      LocalDateTime today = LocalDateTime.of(now.getYear(),
	            now.getMonthValue(), now.getDayOfMonth(), dob.getHour(), dob.getMinute(), dob.getSecond());
	      Duration duration = Duration.between(today, now);

	      long seconds = duration.getSeconds();

	      long hours = seconds / SECONDS_PER_HOUR;
	      long minutes = ((seconds % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE);
	      long secs = (seconds % SECONDS_PER_MINUTE);

	      return new long[]{hours, minutes, secs};
	  }	

}
