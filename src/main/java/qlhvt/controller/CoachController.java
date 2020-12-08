package qlhvt.controller;

import java.util.Date;
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

import qlhvt.entities.Coach;
import qlhvt.helper.ApiResponse;
import qlhvt.services.CoachService;

@Controller
@RequestMapping("coach")
@CrossOrigin(origins = { "*" })
public class CoachController {

	@Autowired
	private CoachService coachService;

	@GetMapping("getAll")
	public ResponseEntity<ApiResponse> getAllCoach() {
		ApiResponse object = new ApiResponse();
		List<Coach> list = coachService.getAllCoach();
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(list);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse> getCoachById(@PathVariable("id") Integer id) {
		ApiResponse object = new ApiResponse();
		Coach coach = coachService.getCoachById(id);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(coach);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addCoach(@RequestBody Coach coach) {
		if (coachService.isExist(coach) == false) {
			ApiResponse object = new ApiResponse();
			coachService.addCoach(coach);
			object.setCode(200);
			object.setErrors(null);
			object.setStatus(true);
			object.setData(coach);
			return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
		} else {
			ApiResponse object = new ApiResponse();
			object.setCode(409);
			object.setErrors("Coach is exist in database");
			object.setStatus(false);
			return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
		}
	}

	@PutMapping("update")
	public ResponseEntity<ApiResponse> updateCoach(@RequestBody Coach coach) {
		ApiResponse object = new ApiResponse();
		coachService.updateCoach(coach);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(coach);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<ApiResponse> deleteCoachById(@PathVariable("id") Integer id) {
		ApiResponse object = new ApiResponse();
		coachService.deleteCoachById(id);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}

	@GetMapping("getCoachByCondition")
	public ResponseEntity<ApiResponse> SearchDriverByCondition(@RequestParam(value = "page", required = true) int page,
			@RequestParam(value = "pageSize", required = true) int pageSize,
			@RequestParam(value = "columnSortName", required = false) String columnSortName,
			@RequestParam(value = "asc", required = false) Boolean asc,
			@RequestParam(value = "licensePlate", required = false) String licensePlate,
			@RequestParam(value = "color", required = false) String color,
			@RequestParam(value = "manufacturer", required = false) String manufacturer,
			@RequestParam(value = "carType", required = false) String carType,
			@RequestParam(value = "model", required = false) String model,
			@RequestParam(value = "chair", required = false) Integer chair,
			@RequestParam(value = "status", required = false) Integer status) {
		ApiResponse object = new ApiResponse();
		List<Coach> list = coachService.searchCoachByCondition(page, pageSize, columnSortName, asc, licensePlate, color,
				manufacturer, carType, model, chair, status);
		int rowCount = coachService.getRowCount(licensePlate, color, manufacturer, carType, model, chair, status);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(list);
		object.setPage(page);
		object.setPageSize(pageSize);
		object.setTotalRow(rowCount);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}
	
	@GetMapping("/getNextMaintenance/{id}")
	public ResponseEntity<ApiResponse> getNextMaintenance(@PathVariable("id") Integer id) {
		ApiResponse object = new ApiResponse();
		Date nm = coachService.getNextMaintenance(id);
		object.setCode(200);
		object.setErrors(null);
		object.setStatus(true);
		object.setData(nm);
		return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
	}
}
