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

import qlhvt.entities.Driver;
import qlhvt.helper.ApiResponse;
import qlhvt.services.DriverService;

@Controller
@RequestMapping("driver")
@CrossOrigin(origins = { "*" })
public class DriverController {
	@Autowired
	private DriverService driverService;

	@GetMapping("getAll")
	public ResponseEntity<ApiResponse> getAllDriver() {
		ApiResponse object = new ApiResponse();
		List<Driver> list = driverService.getAllDriver();
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(list);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse> getDriverById(@PathVariable("id") Integer id) {
		ApiResponse object = new ApiResponse();
		Driver driver = driverService.getDriverById(id);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(driver);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addDriver(@RequestBody Driver driver) {
		if (driverService.isExist(driver) == false) {
			ApiResponse object = new ApiResponse();
			driverService.addDriver(driver);
			object.setCode(200);
			object.setErrors(null);
			object.setStatus(true);
			object.setData(driver);
			return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
		} else {
			ApiResponse object = new ApiResponse();
			object.setCode(409);
			object.setErrors("driver is exist in database");
			object.setStatus(false);
			return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
		}
	}

	@PutMapping("update")
	public ResponseEntity<ApiResponse> updateDriver(@RequestBody Driver driver) {
		ApiResponse object = new ApiResponse();
		driverService.updateDriver(driver);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(driver);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<ApiResponse> deleteDriverById(@PathVariable("id") Integer id) {
		ApiResponse object = new ApiResponse();
		driverService.deleteDriverById(id);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@GetMapping("getDriverByCondition")
	public ResponseEntity<ApiResponse> SearchDriverByCondition(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "pageSize", required = true) int pageSize,
			@RequestParam(value = "columnSortName", required = false) String columnSortName,
			@RequestParam(value = "asc", required = false) Boolean asc,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "idNumber", required = false) String idNumber,
			@RequestParam(value = "licenseType", required = false) String licenseType,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "status", required = false) Integer status) {
		ApiResponse object = new ApiResponse();
		List<Driver> list = driverService.searchDriverByCondition(page, pageSize, columnSortName, asc, name, idNumber,
				licenseType, address, status);
		int rowCount = driverService.getRowCount(name, idNumber, licenseType, address, status);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(list);
		object.setPage(page);
		object.setPageSize(pageSize);
		object.setTotalRow(rowCount);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}
}
