package anchit.bhushan.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import anchit.bhushan.Model.Medicine;
import anchit.bhushan.service.MedicineService;
import anchit.bhushan.utility.CsvUtils;

@RestController
public class MedicineController {

	@Autowired
	private MedicineService medicineService;

	@Autowired
	private CsvUtils csvutils;



	@RequestMapping(method = RequestMethod.GET, value = "/medicine")
	public ResponseEntity<List<Medicine>> getAll() {
		List<Medicine> result = medicineService.getAllMedicines();
		if (result.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(result));
	}

	@RequestMapping(method = RequestMethod.POST, value = "/medicine")
	public ResponseEntity<Void> addMedicine(@RequestBody Medicine medicine) {

		try {
			medicineService.addMedicine(medicine);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/medicine/uploadCSV")
	public ResponseEntity<Void> upload(@RequestParam("file") MultipartFile File)
			throws NumberFormatException, ParseException, IOException {

		try {
			List<Medicine> medicines = csvutils.csvToMedicines(File.getInputStream());
			medicineService.AddRecords(medicines);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/medicine/searchMedicine/{name}")
	public ResponseEntity<List<Medicine>> search(@PathVariable String name) {

		List<Medicine> result = medicineService.getMedicineByName(name);
		if (result.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(result));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/medicine/getMedicineDetails/{id}")
	public ResponseEntity<Medicine> getMedicine(@PathVariable String id) {

		Medicine result = medicineService.getMedicineByid(Integer.parseInt(id));
		if (result == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(result));
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/medicine/deleteAll")
	public ResponseEntity<Void> deleteAll() {
		try {
			medicineService.deleteAll();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return null;
	}

}
