package anchit.bhushan.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "order_specs")
public class OrderSpec {

	@Id
	@JoinColumn(name = "Order", referencedColumnName = "order_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer order_id;

	@JoinColumn(name = "Medicine", referencedColumnName = "c_unique_code")
	private Integer c_unique_id;

	private Integer quantity;

	@JoinColumn(name = "Medicine", referencedColumnName = "c_name")
	String c_name;

	public OrderSpec(Integer c_unique_id, Integer quantity, String c_name, Integer order_id) {
		this.c_unique_id = c_unique_id;
		this.quantity = quantity;
		this.c_name = c_name;
		this.order_id = order_id;
	}

	public OrderSpec() {
	}

	public Integer getC_unique_id() {
		return c_unique_id;
	}

	public void setC_unique_id(Integer c_unique_id) {
		this.c_unique_id = c_unique_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	@Override
	public String toString() {
		return "OrderSpec [c_name=" + c_name + ", c_unique_id=" + c_unique_id + ", order_id=" + order_id + ", quantity="
				+ quantity + "]";
	}

}
