package anchit.bhushan.utility;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import anchit.bhushan.Model.Medicine;

@Service
public class CsvUtils {
	public String TYPE = "text/csv";
	static String[] HEADERs = { "c_name", "c_batch_no", "d_expiry_date", "n_balance_qty", "c_packaging",
			"c_unique_code", "c_schemes", "n_mrp", "c_manufacturer", "hsn_code" };

	public boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public List<Medicine> csvToMedicines(InputStream is) throws NumberFormatException, ParseException {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Medicine> medicines = new ArrayList<>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				Medicine medicine = new Medicine(csvRecord.get(HEADERs[0]), csvRecord.get(HEADERs[1]),
						new SimpleDateFormat("dd/MM/yyyy").parse(csvRecord.get(HEADERs[2])),
						Integer.parseInt(csvRecord.get(HEADERs[3])), csvRecord.get(HEADERs[4]),
						Integer.parseInt(csvRecord.get(HEADERs[5])), csvRecord.get(HEADERs[6]),
						Double.parseDouble(csvRecord.get(HEADERs[7])), csvRecord.get(HEADERs[8]),
						Integer.parseInt(csvRecord.get(HEADERs[9])));

				medicines.add(medicine);
			}

			return medicines;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

}