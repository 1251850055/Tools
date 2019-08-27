package com.wzh.tools.utils.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

public class StringUtil {
	public final static String SOAP_RETURN_STARTSTR = "<return>";
	public final static String SOAP_RETURN_ENDSTR = "</return>";
	public final static String SOAP_RETURN_CMTS_STARTSTR = "<ns:return>";
	public final static String SOAP_RETURN_CMTS_ENDSTR = "</ns:return>";
	public final static String SOAP_RETURN_HUOFENGHUANGSTR1 = "<?xml version=\"1.0\" encoding=\"GBK\"?>";
	public final static String SOAP_RETURN_HUOFENGHUANGSTR2 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";


	public static String subStringSoapStr(String soapStr) {
		int start = soapStr.indexOf(SOAP_RETURN_STARTSTR);
		int end = soapStr.indexOf(SOAP_RETURN_ENDSTR);
		if (start > -1 && end > -1) {
			return soapStr.substring(
					start + SOAP_RETURN_STARTSTR.length(), end);
		} else {
			int cmtsStart = soapStr.indexOf(SOAP_RETURN_CMTS_STARTSTR);
			int cmtsEnd = soapStr.indexOf(SOAP_RETURN_CMTS_ENDSTR);
			if (cmtsStart > -1 && cmtsEnd > -1) {
				soapStr = soapStr.substring(cmtsStart + SOAP_RETURN_CMTS_STARTSTR.length(), cmtsEnd);
				StringBuffer sb = new StringBuffer();
				if (soapStr.indexOf("<?xml") < 0) {
					sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
					sb.append(soapStr);
				}
				return sb.toString();
			}
			
			int huoFengHuangStr1 = soapStr.indexOf(SOAP_RETURN_HUOFENGHUANGSTR1);
			if (huoFengHuangStr1 > -1) {
				soapStr = soapStr.replace(SOAP_RETURN_HUOFENGHUANGSTR1, "");
			}
			
			int huoFengHuangStr2 = soapStr.indexOf(SOAP_RETURN_HUOFENGHUANGSTR2);
			if (huoFengHuangStr2 > -1) {
				soapStr = soapStr.replace(SOAP_RETURN_HUOFENGHUANGSTR2, "");
			}
			return soapStr;
		}
	}

	public static String subStringSoapJson(String soapStr) {
		int start = soapStr.indexOf(SOAP_RETURN_STARTSTR);
		int end = soapStr.indexOf(SOAP_RETURN_ENDSTR);
		if (start > -1 && end > -1) {
			return soapStr.substring(
					start + SOAP_RETURN_STARTSTR.length(), end);
		} else {
			int cmtsStart = soapStr.indexOf(SOAP_RETURN_CMTS_STARTSTR);
			int cmtsEnd = soapStr.indexOf(SOAP_RETURN_CMTS_ENDSTR);
			if (cmtsStart > -1 && cmtsEnd > -1) {
				soapStr = soapStr.substring(cmtsStart + SOAP_RETURN_CMTS_STARTSTR.length(), cmtsEnd);
				StringBuffer sb = new StringBuffer();
				sb.append(soapStr);
				return sb.toString();
			}

			int huoFengHuangStr1 = soapStr.indexOf(SOAP_RETURN_HUOFENGHUANGSTR1);
			if (huoFengHuangStr1 > -1) {
				soapStr = soapStr.replace(SOAP_RETURN_HUOFENGHUANGSTR1, "");
			}

			int huoFengHuangStr2 = soapStr.indexOf(SOAP_RETURN_HUOFENGHUANGSTR2);
			if (huoFengHuangStr2 > -1) {
				soapStr = soapStr.replace(SOAP_RETURN_HUOFENGHUANGSTR2, "");
			}
			return soapStr;
		}
	}

	/**
	 * 维信系统xml截取
	 * @param soupXml
	 * @return
	 */
	public static String subStringSoapStr4WeiXin(String soupXml) {
		int start = soupXml.indexOf("<OnlineTicketingServiceReply");
		int end = soupXml.indexOf("</OnlineTicketingServiceReply>");
		soupXml = soupXml.substring(start, end);
		soupXml = soupXml.substring(soupXml.indexOf(">") + 1);
		return soupXml;
	}

	private static GregorianCalendar[] getBetweenDate(String startDate,
			String endDate) throws Exception {
		Vector<GregorianCalendar> dateVector = new Vector<GregorianCalendar>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar startGC = new GregorianCalendar();
		GregorianCalendar endGC = new GregorianCalendar();

		startGC.setTime(sdf.parse(startDate));
		endGC.setTime(sdf.parse(endDate));
		do {
			GregorianCalendar tempGC = (GregorianCalendar) startGC.clone();
			dateVector.add(tempGC);
			startGC.add(Calendar.DAY_OF_MONTH, 1);
		} while (!startGC.after(endGC));

		return dateVector.toArray(new GregorianCalendar[dateVector.size()]);
	}

	/**
	 * 
	 * @param startDate
	 *            ("2013-11-29");
	 * @param endDate
	 *            ( "2013-12-5");
	 * @return
	 * @throws Exception
	 */
	public static String[] getBetweenDateStr(String startDate, String endDate)
			throws Exception {

		GregorianCalendar[] resultGC = getBetweenDate(startDate, endDate);
		String[] gcStr = new String[resultGC.length];
		int i = 0;
		for (GregorianCalendar gc : resultGC) {
			Date date = gc.getTime();
			gcStr[i] = formatDate2Str(date);
			i++;
		}
		return gcStr;
	}
	
	/**
	 * 得到几天前的时间
	 * 
	 * @param
	 * @param day
	 * @return
	 */
	public static String getDateBefore(String date, int day) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return dateFormat.format(now.getTime());
	}

	public static String getCurrentDate() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(new Date());
	}

	public static String formatDate2Str(Date date) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	public static String formatDate2Str(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(new Date());
	}

	public static String formatStr(String date) {
		if (date.length() > 19) {
			date = date.substring(0, 19);
		}
		return date;
	}

	public static String dateAddMinute(String dateFormat, int addMinute)
			throws Exception {
		// String s = "2014-02-28 23:59:50";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date sdate = sdf.parse(dateFormat.replace("T", " "));
		long ld = sdate.getTime() + 1000 * 60 * addMinute;
		sdate.setTime(ld);
		return sdf.format(sdate);
	}

	public static boolean isNotEmpty(String str) {
		return str != null && !str.equals("");
	}
	
	public static boolean isEmpty(String str) {
		return isNotEmpty(str);
	}
}
