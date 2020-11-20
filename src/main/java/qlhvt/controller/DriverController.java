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
import org.springframework.web.util.UriComponentsBuilder;

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
	public ResponseEntity<Driver> getDriverById(@PathVariable("id") Integer id) {
		Driver driver = driverService.getDriverById(id);
		return new ResponseEntity<Driver>(driver, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Driver> addDriver(@RequestBody Driver driver) {
		driverService.addDriver(driver);
		return new ResponseEntity<Driver>(driver, HttpStatus.OK);
	}

	@PutMapping("update")
	public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver) {
		driverService.updateDriver(driver);
		return new ResponseEntity<Driver>(driver, HttpStatus.OK);
	}

	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable("id") Integer id) {
		driverService.deleteDriverById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
