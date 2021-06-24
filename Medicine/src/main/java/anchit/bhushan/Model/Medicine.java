package anchit.bhushan.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="medicine")
@Table(name="medicine")
public class Medicine {

	@Column(name = "c_name")
	private String cname;
	private String c_batch_no;
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date d_expiry_date;
	private Integer n_balance_qty;
	private String c_packaging;
	@Id
	private Integer c_unique_code;
	private String c_schemes;
	private Double n_mrp;
	private String c_manufacturer;
	private Integer hsn_code;

	public Medicine() {

	}

	public Medicine(String cname, String c_batch_no, Date d_expiry_date, Integer n_balance_qty, String c_packaging,
			Integer c_unique_code, String c_schemes, Double n_mrp, String c_manufacturer, Integer hsn_code) {
		this.cname = cname;
		this.c_batch_no = c_batch_no;
		this.d_expiry_date = d_expiry_date;
		this.n_balance_qty = n_balance_qty;
		this.c_packaging = c_packaging;
		this.c_unique_code = c_unique_code;
		this.c_schemes = c_schemes;
		this.n_mrp = n_mrp;
		this.c_manufacturer = c_manufacturer;
		this.hsn_code = hsn_code;
	}

	public String getCname() {
		return cname;
	}

	public void setC_name(String cname) {
		this.cname = cname;
	}

	public String getC_batch_no() {
		return c_batch_no;
	}

	public void setC_batch_no(String c_batch_no) {
		this.c_batch_no = c_batch_no;
	}

	public Date getD_expiry_date() {
		return d_expiry_date;
	}

	public void setD_expiry_date(Date d_expiry_date) {
		this.d_expiry_date = d_expiry_date;
	}

	public Integer getN_balance_qty() {
		return n_balance_qty;
	}

	public void setN_balance_qty(Integer n_balance_qty) {
		this.n_balance_qty = n_balance_qty;
	}

	public String getC_packaging() {
		return c_packaging;
	}

	public void setC_packaging(String c_packaging) {
		this.c_packaging = c_packaging;
	}

	public Integer getC_unique_code() {
		return c_unique_code;
	}

	public void setC_unique_code(Integer c_unique_code) {
		this.c_unique_code = c_unique_code;
	}

	public String getC_schemes() {
		return c_schemes;
	}

	public void setC_schemes(String c_schemes) {
		this.c_schemes = c_schemes;
	}

	public Double getN_mrp() {
		return n_mrp;
	}

	public void setN_mrp(Double n_mrp) {
		this.n_mrp = n_mrp;
	}

	public String getC_manufacturer() {
		return c_manufacturer;
	}

	public void setC_manufacturer(String c_manufacturer) {
		this.c_manufacturer = c_manufacturer;
	}

	public Integer getHsn_code() {
		return hsn_code;
	}

	public void setHsn_code(Integer hsn_code) {
		this.hsn_code = hsn_code;
	}

	@Override
	public String toString() {
		return "Medicine [c_name=" + cname + ", c_batch_no=" + c_batch_no + ", d_expiry_date=" + d_expiry_date
				+ ", n_balance_qty=" + n_balance_qty + ", c_packaging=" + c_packaging + ", c_unique_code="
				+ c_unique_code + ", c_schemes=" + c_schemes + ", n_mrp=" + n_mrp + ", c_manufacturer=" + c_manufacturer
				+ ", hsn_code=" + hsn_code + "]";
	}

}
