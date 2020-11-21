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
		ApiResponse object = new ApiResponse();
		driverService.addDriver(driver);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(driver);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
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
	public ResponseEntity<ApiResponse> deleteUserById(@PathVariable("id") Integer id) {
		ApiResponse object = new ApiResponse();
		driverService.deleteDriverById(id);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}
	@GetMapping("getDriverByCondition")
	public ResponseEntity<ApiResponse> SearchDriverByCondition(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "idNumber", required = false) String idNumber,
			@RequestParam(value = "licenseType", required = false) String licenseType,
			@RequestParam(value = "address", required = false) String address){
		ApiResponse object = new ApiResponse();
		List<Driver> list = driverService.searchDriverByCondition(name, idNumber, licenseType, address);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(list);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}
}
