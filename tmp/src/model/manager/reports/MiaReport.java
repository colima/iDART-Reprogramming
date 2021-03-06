package model.manager.reports;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import model.manager.excel.conversion.exceptions.ReportException;




import org.celllife.idart.commonobjects.LocalObjects;
import org.celllife.idart.database.hibernate.StockCenter;
import org.eclipse.swt.widgets.Shell;

public class MiaReport extends AbstractJasperReport {
	
	private final StockCenter stockCenter;
	private final Date theDate;
	private final Date startDate;
	private final Date endDate;


	public MiaReport(Shell parent, StockCenter stockCenter,
			Date theDate, Date startDate, Date endDate) {
		super(parent);
		this.stockCenter = stockCenter;
		this.theDate = theDate;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Override
	protected void generateData() throws ReportException {
	}

	@Override
	protected Map<String, Object> getParameterMap() throws ReportException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(theDate);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		// Set the parameters for the report
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
		"yyyy-MM-dd HH:mm:ss.SSS");

		map.put("stockCenterId", new Integer(stockCenter.getId()));
		map.put("date", cal.getTime());
		map.put("dateFormat", dateFormat.format(cal.getTime()));
		map.put("monthStart", dateFormat.format(cal.getTime()));
		cal.add(Calendar.MONTH, 1);
		map.put("monthEnd", dateFormat.format(cal.getTime()));
		map.put("stockCenterName", stockCenter.getStockCenterName());
		map.put("path", getReportPath());

		map.put("facilityName", LocalObjects.currentClinic.getClinicName());
		map.put("pharmacist1", LocalObjects.pharmacy.getPharmacist());
		map.put("pharmacist2", LocalObjects.pharmacy.getAssistantPharmacist());
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		return map;
	}


	@Override
	protected String getReportFileName() {
		return "MmiaReport";
	}

}
