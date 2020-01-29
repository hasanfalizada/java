package com.hibernatedemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernatedemo.model.Phone;
import com.hibernatedemo.model.PhoneRepository;

@RestController
@RequestMapping("/api/v1")
public class PhoneController {
	@Autowired
	private PhoneRepository phoneRepository;

	// GET method to fetch all phones
	@GetMapping("/phones")
	public List<Phone> getAllPhones() {
		return phoneRepository.findAll();
	}

	// GET method to fetch phone by Id
	@GetMapping("/phones/{id}")
	public ResponseEntity<Phone> getPhoneById(@PathVariable(value = "id") Long phoneId) throws Exception {
		Phone phone = phoneRepository.findById(phoneId)
				.orElseThrow(() -> new Exception("Phone " + phoneId + " not found"));
		return ResponseEntity.ok().body(phone);
	}

	// POST method to create a phone
	@PostMapping("/phones")
	public Phone createPhone(@Valid @RequestBody Phone phone) {
		return phoneRepository.save(phone);
	}

	// PUT method to update a phone's details
	@PutMapping("/phones/{id}")
	public ResponseEntity<Phone> updatePhone(@PathVariable(value = "id") Long phoneId,
			@Valid @RequestBody Phone phoneDetails) throws Exception {
		Phone phone = phoneRepository.findById(phoneId)
				.orElseThrow(() -> new Exception("Phone " + phoneId + " not found"));

		phone.setPhoneName(phoneDetails.getPhoneName());
		phone.setOs(phoneDetails.getOs());

		final Phone updatedPhone = phoneRepository.save(phone);
		return ResponseEntity.ok(updatedPhone);
	}

	// DELETE method to delete a phone
	@DeleteMapping("/phone/{id}")
	public Map<String, Boolean> deletePhone(@PathVariable(value = "id") Long phoneId) throws Exception {
		Phone phone = phoneRepository.findById(phoneId)
				.orElseThrow(() -> new Exception("Phone " + phoneId + " not found"));

		phoneRepository.delete(phone);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}