package anchit.bhushan.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import anchit.bhushan.Model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

	List<Medicine> findBycnameContainingIgnoreCase(String name);

	
	@Modifying
	@Query("UPDATE medicine c SET c.n_balance_qty = c.n_balance_qty - :quant WHERE c.c_unique_code = :code")
	void UpdateQuantity(@Param("quant") Integer qty, @Param("code") Integer code);
}
