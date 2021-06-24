package anchit.bhushan.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anchit.bhushan.DAO.MedicineRepository;
import anchit.bhushan.Model.Medicine;

@Service
public class MedicineService {

	@Autowired
	private MedicineRepository medicineRepository;

	public List<Medicine> getAllMedicines() {

		List<Medicine> list = new ArrayList<>();
		for (Medicine m : medicineRepository.findAll())
			list.add(m);
		return list;
	}

	public void AddRecords(List<Medicine> medicines) {
		medicineRepository.saveAll(medicines);
	}

	public void addMedicine(Medicine m) {
		medicineRepository.save(m);
	}

	public Medicine getMedicineByid(Integer id) {
		return medicineRepository.findById(id).orElse(null);
	}

	public void deleteMedicine(Integer id) {
		medicineRepository.deleteById(id);
	}

	public void updateMedicine(Medicine medicine) {
		medicineRepository.save(medicine);
	}

	public List<Medicine> getMedicineByName(String name) {
		return medicineRepository.findBycnameContainingIgnoreCase(name);
	}

	public void deleteAll() {
		medicineRepository.deleteAll();
	}

}
