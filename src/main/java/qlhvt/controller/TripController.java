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
import org.springframework.web.util.UriComponentsBuilder;

import qlhvt.entities.Trip;
import qlhvt.helper.ApiResponse;
import qlhvt.services.TripService;

@Controller
@RequestMapping("trip")
@CrossOrigin(origins = { "*" })
public class TripController {
	@Autowired
	private TripService tripService;

	@GetMapping("getAll")
	public ResponseEntity<ApiResponse> getAllTrip() {
		ApiResponse object = new ApiResponse();
		List<Trip> list = tripService.getAllTrip();
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(list);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse> getTripById(@PathVariable("id") Integer id) {
		ApiResponse object = new ApiResponse();
		Trip trip = tripService.getTripById(id);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(trip);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addTrip(@RequestBody Trip trip, UriComponentsBuilder builder) {		
		if (tripService.isExist(trip) == false) {
			ApiResponse object = new ApiResponse();
			tripService.addTrip(trip);
			object.setCode(200);
			object.setErrors(null);
			object.setStatus(true);
			object.setData(trip);
			return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
		} else {
			ApiResponse object = new ApiResponse();
			object.setCode(409);
			object.setErrors("trip is exist in database");
			object.setStatus(false);
			return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
		}
	}

	@PutMapping("update")
	public ResponseEntity<ApiResponse> updateTrip(@RequestBody Trip trip) {
		ApiResponse object = new ApiResponse();
		tripService.updateTrip(trip);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(trip);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<ApiResponse> deleteTripById(@PathVariable("id") Integer id) {
		ApiResponse object = new ApiResponse();
		tripService.deleteTripById(id);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@GetMapping("getByCondition")
	public ResponseEntity<ApiResponse> SearchTripByCondition(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "pageSize", required = true) int pageSize,
			@RequestParam(value = "columnSortName", required = false) String columnSortName,
			@RequestParam(value = "asc", required = false) Boolean asc,
			@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "status", required = false) Integer status) {
		ApiResponse object = new ApiResponse();
		List<Trip> list = tripService.searchTripByCondition(page, pageSize, columnSortName, asc, code, status);
		int rowCount = tripService.getRowCount(code, status);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(list);
		object.setPage(page);
		object.setPageSize(pageSize);
		object.setTotalRow(rowCount);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@GetMapping("/getByCoachId/{id}")
	public ResponseEntity<ApiResponse> getTripByCoachId(@PathVariable("id") Integer id) {
		ApiResponse object = new ApiResponse();
		List<Trip> list = tripService.getTripByCoachId(id);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(list);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@GetMapping("/getTotalIncome/{id}")
	public ResponseEntity<ApiResponse> getTotalIncome(@PathVariable("id") Integer id) {
		ApiResponse object = new ApiResponse();
		int ti = tripService.getTotalIncome(id);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(ti);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}
}
