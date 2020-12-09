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

import qlhvt.entities.Buses;
import qlhvt.helper.ApiResponse;
import qlhvt.services.BusesService;

@Controller
@RequestMapping("buses")
@CrossOrigin(origins = { "*" })
public class BusesController {
	@Autowired
	private BusesService busesService;

	@GetMapping("getAll")
	public ResponseEntity<ApiResponse> getAllBuses() {
		ApiResponse object = new ApiResponse();
		List<Buses> list = busesService.getAllBuses();
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(list);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse> getBusesById(@PathVariable("id") Integer id) {
		ApiResponse object = new ApiResponse();
		Buses buses = busesService.getBusesById(id);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(buses);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addBuses(@RequestBody Buses buses) {
		if (busesService.isExist(buses) == false) {
			ApiResponse object = new ApiResponse();
			busesService.addBuses(buses);
			object.setCode(200);
			object.setErrors(null);
			object.setStatus(true);
			object.setData(buses);
			return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
		} else {
			ApiResponse object = new ApiResponse();
			object.setCode(409);
			object.setErrors("Buses is exist in database");
			object.setStatus(true);
			object.setData(buses);
			return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
		}
	}

	@PutMapping("update")
	public ResponseEntity<ApiResponse> updateBuses(@RequestBody Buses buses) {
		ApiResponse object = new ApiResponse();
		busesService.updateBuses(buses);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(buses);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<ApiResponse> deleteBusesById(@PathVariable("id") Integer id) {
		ApiResponse object = new ApiResponse();
		busesService.deleteBusesById(id);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@GetMapping("getBusesByCondition")
	public ResponseEntity<ApiResponse> SearchBusesByCondition(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "pageSize", required = true) int pageSize,
			@RequestParam(value = "columnSortName", required = false) String columnSortName,
			@RequestParam(value = "asc", required = false) Boolean asc,
			@RequestParam(value = "first", required = false) String first,
			@RequestParam(value = "last", required = false) String last,
			@RequestParam(value = "length", required = false) Integer length,
			@RequestParam(value = "complexity", required = false) Integer complexity,
			@RequestParam(value = "status", required = false) Integer status) {
		ApiResponse object = new ApiResponse();
		List<Buses> list = busesService.searchBusesByCondition(page, pageSize, columnSortName, asc, first, last, length,
				complexity, status);
		int rowCount = busesService.getRowCount(first, last, length, complexity, status);
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
