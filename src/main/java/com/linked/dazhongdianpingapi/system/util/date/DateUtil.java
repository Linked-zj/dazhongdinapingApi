package com.linked.dazhongdianpingapi.system.util.date;



import com.linked.dazhongdianpingapi.system.enums.DateStyle;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Linked
 * @date 2020/5/4 17:00
 */
public class DateUtil {

	/**
	 * 获取SimpleDateFormat
	 * @param parttern 日期格式
	 * @return SimpleDateFormat对象
	 * @throws RuntimeException 异常：非法日期格式
	 */
	private static SimpleDateFormat getDateFormat(String parttern) throws RuntimeException {
		return new SimpleDateFormat(parttern);
	}

	/**
	 * 获取日期中的某数值。如获取月份
	 * @param date 日期
	 * @param dateType 日期格式
	 * @return 数值
	 */
	private static int getInteger(Date date, int dateType) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(dateType);
	}
	
	/**
	 * 增加日期中某类型的某数值。如增加日期
	 * @param date 日期字符串
	 * @param dateType 类型
	 * @param amount 数值
	 * @return 计算后日期字符串
	 */
	private static String addInteger(String date, int dateType, int amount) {
		String dateString = null;
		DateStyle dateStyle = getDateStyle(date);
		if (dateStyle != null) {
			Date myDate = StringToDate(date, dateStyle);
			myDate = addInteger(myDate, dateType, amount);
			dateString = DateToString(myDate, dateStyle);
		}
		return dateString;
	}
	
	/**
	 * 增加日期中某类型的某数值。如增加日期
	 * @param date 日期
	 * @param dateType 类型
	 * @param amount 数值
	 * @return 计算后日期
	 */
	private static Date addInteger(Date date, int dateType, int amount) {
		Date myDate = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(dateType, amount);
			myDate = calendar.getTime();
		}
		return myDate;
	}

	/**
	 * 获取精确的日期
	 * @param timestamps 时间long集合
	 * @return 日期
	 */
	private static Date getAccurateDate(List<Long> timestamps) {
		Date date = null;
		long timestamp = 0;
		Map<Long, long[]> map = new HashMap<Long, long[]>();
		List<Long> absoluteValues = new ArrayList<Long>();

		if (timestamps != null && timestamps.size() > 0) {
			if (timestamps.size() > 1) {
				for (int i = 0; i < timestamps.size(); i++) {
					for (int j = i + 1; j < timestamps.size(); j++) {
						long absoluteValue = Math.abs(timestamps.get(i) - timestamps.get(j));
						absoluteValues.add(absoluteValue);
						long[] timestampTmp = { timestamps.get(i), timestamps.get(j) };
						map.put(absoluteValue, timestampTmp);
					}
				}

				// 有可能有相等的情况。如2012-11和2012-11-01。时间戳是相等的
				long minAbsoluteValue = -1;
				if (!absoluteValues.isEmpty()) {
					// 如果timestamps的size为2，这是差值只有一个，因此要给默认值
					minAbsoluteValue = absoluteValues.get(0);
				}
				for (int i = 0; i < absoluteValues.size(); i++) {
					for (int j = i + 1; j < absoluteValues.size(); j++) {
						if (absoluteValues.get(i) > absoluteValues.get(j)) {
							minAbsoluteValue = absoluteValues.get(j);
						} else {
							minAbsoluteValue = absoluteValues.get(i);
						}
					}
				}

				if (minAbsoluteValue != -1) {
					long[] timestampsLastTmp = map.get(minAbsoluteValue);
					if (absoluteValues.size() > 1) {
						timestamp = Math.max(timestampsLastTmp[0], timestampsLastTmp[1]);
					} else if (absoluteValues.size() == 1) {
						// 当timestamps的size为2，需要与当前时间作为参照
						long dateOne = timestampsLastTmp[0];
						long dateTwo = timestampsLastTmp[1];
						if ((Math.abs(dateOne - dateTwo)) < 100000000000L) {
							timestamp = Math.max(timestampsLastTmp[0], timestampsLastTmp[1]);
						} else {
							long now = new Date().getTime();
							if (Math.abs(dateOne - now) <= Math.abs(dateTwo - now)) {
								timestamp = dateOne;
							} else {
								timestamp = dateTwo;
							}
						}
					}
				}
			} else {
				timestamp = timestamps.get(0);
			}
		}

		if (timestamp != 0) {
			date = new Date(timestamp);
		}
		return date;
	}

	/**
	 * 判断字符串是否为日期字符串
	 * @param date 日期字符串
	 * @return true or false
	 */
	public static boolean isDate(String date) {
		boolean isDate = false;
		if (date != null) {
			if (StringToDate(date) != null) {
				isDate = true;
			}
		}
		return isDate;
	}

	/**
	 * 获取日期字符串的日期风格。失敗返回null。
	 * @param date 日期字符串
	 * @return 日期风格
	 */
	public static DateStyle getDateStyle(String date) {
		DateStyle dateStyle = null;
		Map<Long, DateStyle> map = new HashMap<Long, DateStyle>();
		List<Long> timestamps = new ArrayList<Long>();
		for (DateStyle style : DateStyle.values()) {
			Date dateTmp = StringToDate(date, style.getValue());
			if (dateTmp != null) {
				timestamps.add(dateTmp.getTime());
				map.put(dateTmp.getTime(), style);
			}
		}
		dateStyle = map.get(getAccurateDate(timestamps).getTime());
		return dateStyle;
	}

	/**
	 * 将日期字符串转化为日期。失败返回null。
	 * @param date 日期字符串
	 * @return 日期
	 */
	public static Date StringToDate(String date) {
		DateStyle dateStyle = null;
		return StringToDate(date, dateStyle);
	}

	/**
	 * 将日期字符串转化为日期。失败返回null。
	 * @param date 日期字符串
	 * @param parttern 日期格式
	 * @return 日期
	 */
	public static Date StringToDate(String date, String parttern) {
		Date myDate = null;
		if (date != null) {
			try {
				myDate = getDateFormat(parttern).parse(date);
			} catch (Exception e) {
			}
		}
		return myDate;
	}

	/**
	 * 将日期字符串转化为日期。失败返回null。
	 * @param date 日期字符串
	 * @param dateStyle 日期风格
	 * @return 日期
	 */
	public static Date StringToDate(String date, DateStyle dateStyle) {
		Date myDate = null;
		if (dateStyle == null) {
			List<Long> timestamps = new ArrayList<Long>();
			for (DateStyle style : DateStyle.values()) {
				Date dateTmp = StringToDate(date, style.getValue());
				if (dateTmp != null) {
					timestamps.add(dateTmp.getTime());
				}
			}
			myDate = getAccurateDate(timestamps);
		} else {
			myDate = StringToDate(date, dateStyle.getValue());
		}
		return myDate;
	}

	/**
	 * 将日期转化为日期字符串。失败返回null。
	 * @param date 日期
	 * @param parttern 日期格式
	 * @return 日期字符串
	 */
	public static String DateToString(Date date, String parttern) {
		String dateString = null;
		if (date != null) {
			try {
				dateString = getDateFormat(parttern).format(date);
			} catch (Exception e) {
			}
		}
		return dateString;
	}

	/**
	 * 将日期转化为日期字符串。失败返回null。
	 * @param date 日期
	 * @param dateStyle 日期风格
	 * @return 日期字符串
	 */
	public static String DateToString(Date date, DateStyle dateStyle) {
		String dateString = null;
		if (dateStyle != null) {
			dateString = DateToString(date, dateStyle.getValue());
		}
		return dateString;
	}

	/**
	 * 将日期字符串转化为另一日期字符串。失败返回null。
	 * @param date 旧日期字符串
	 * @param parttern 新日期格式
	 * @return 新日期字符串
	 */
	public static String StringToString(String date, String parttern) {
		return StringToString(date, null, parttern);
	}

	/**
	 * 将日期字符串转化为另一日期字符串。失败返回null。
	 * @param date 旧日期字符串
	 * @param dateStyle 新日期风格
	 * @return 新日期字符串
	 */
	public static String StringToString(String date, DateStyle dateStyle) {
		return StringToString(date, null, dateStyle);
	}

	/**
	 * 将日期字符串转化为另一日期字符串。失败返回null。
	 * @param date 旧日期字符串
	 * @param olddParttern 旧日期格式
	 * @param newParttern 新日期格式
	 * @return 新日期字符串
	 */
	public static String StringToString(String date, String olddParttern, String newParttern) {
		String dateString = null;
		if (olddParttern == null) {
			DateStyle style = getDateStyle(date);
			if (style != null) {
				Date myDate = StringToDate(date, style.getValue());
				dateString = DateToString(myDate, newParttern);
			}
		} else {
			Date myDate = StringToDate(date, olddParttern);
			dateString = DateToString(myDate, newParttern);
		}
		return dateString;
	}

	/**
	 * 将日期字符串转化为另一日期字符串。失败返回null。
	 * @param date 旧日期字符串
	 * @param olddDteStyle 旧日期风格
	 * @param newDateStyle 新日期风格
	 * @return 新日期字符串
	 */
	public static String StringToString(String date, DateStyle olddDteStyle, DateStyle newDateStyle) {
		String dateString = null;
		if (olddDteStyle == null) {
			DateStyle style = getDateStyle(date);
			dateString = StringToString(date, style.getValue(), newDateStyle.getValue());
		} else {
			dateString = StringToString(date, olddDteStyle.getValue(), newDateStyle.getValue());
		}
		return dateString;
	}

}