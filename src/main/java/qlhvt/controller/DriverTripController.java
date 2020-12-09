package qlhvt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import qlhvt.entities.DriverTrip;
import qlhvt.helper.ApiResponse;
import qlhvt.services.DriverTripService;

@Controller
@RequestMapping("driverTrip")
@CrossOrigin(origins = { "*" })
public class DriverTripController {
	@Autowired
	private DriverTripService driverTripService;

	@GetMapping("getAll")
	public ResponseEntity<ApiResponse> getAllDriverTrip() {
		ApiResponse object = new ApiResponse();
		List<DriverTrip> list = driverTripService.getAllDriverTrip();
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(list);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse> getDriverTripById(@PathVariable("id") Integer id) {
		ApiResponse object = new ApiResponse();
		DriverTrip driverTrip = driverTripService.getDriverTripById(id);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(driverTrip);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addDriverTrip(@RequestBody DriverTrip driverTrip) {
		if (driverTripService.isExist(driverTrip) == false) {
			ApiResponse object = new ApiResponse();
			driverTripService.addDriverTrip(driverTrip);
			object.setCode(200);
			object.setErrors(null);
			object.setStatus(true);
			object.setData(driverTrip);
			return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
		} else {
			ApiResponse object = new ApiResponse();
			object.setCode(409);
			object.setErrors("exist driverTrip in database");
			object.setStatus(true);
			return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
		}
	}

	@PutMapping("update")
	public ResponseEntity<ApiResponse> updateDriverTrip(@RequestBody DriverTrip driverTrip) {
		ApiResponse object = new ApiResponse();
		driverTripService.updateDriverTrip(driverTrip);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(driverTrip);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<ApiResponse> deleteDriverTripById(@PathVariable("id") Integer id) {
		ApiResponse object = new ApiResponse();
		driverTripService.deleteDriverTripById(id);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@GetMapping("getByCondition")
	public ResponseEntity<ApiResponse> SearchDriverByCondition(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "pageSize", required = true) int pageSize,
			@RequestParam(value = "columnSortName", required = false) String columnSortName,
			@RequestParam(value = "asc", required = false) Boolean asc,
			@RequestParam(value = "driverType", required = false) Integer driverType) {
		ApiResponse object = new ApiResponse();
		List<DriverTrip> list = driverTripService.searchDriverTripByCondition(page, pageSize, columnSortName, asc,
				driverType);
		int rowCount = driverTripService.getRowCount(driverType);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(list);
		object.setPage(page);
		object.setPageSize(pageSize);
		object.setTotalRow(rowCount);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@GetMapping("getByDriverId/{id}")
	public ResponseEntity<ApiResponse> getDriverTripByDriverId(@PathVariable("id") Integer id) {
		ApiResponse object = new ApiResponse();
		List<DriverTrip> list = driverTripService.getDriverTripByDriverId(id);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(list);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@GetMapping("getSalaryMonth")
	public ResponseEntity<ApiResponse> getDriverTripByDriverId(@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "month", required = true) int month,
			@RequestParam(value = "year", required = true) int year) {
		ApiResponse object = new ApiResponse();
		int sm = driverTripService.salaryMonth(id, month, year);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(sm);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

}
