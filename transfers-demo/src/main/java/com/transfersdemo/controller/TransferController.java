package com.transfersdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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

import com.transfersdemo.model.Transfer;
import com.transfersdemo.model.TransferRepository;

@RestController
@RequestMapping("/api/v1")
public class TransferController {
	@Autowired
	private TransferRepository transferRepository;

	@Autowired
	private EntityManager em;

	@GetMapping("/transfers")
	public List<Transfer> getTransfers() {
		return transferRepository.findAll();
	}

	@GetMapping("/transfer/{id}")
	public ResponseEntity<Transfer> getTransferById(@PathVariable(value = "id") Long transferId) throws Exception {
		Transfer transfer = transferRepository.findById(transferId)
				.orElseThrow(() -> new Exception("Transfer " + transferId + " not found"));
		return ResponseEntity.ok().body(transfer);
	}

	@PostMapping("/transfers")
	public Transfer createTransfer(@Valid @RequestBody Transfer transfer) {
		return transferRepository.save(transfer);
	}

	@PutMapping("/transfers/{id}")
	public ResponseEntity<Transfer> updateTransfer(@PathVariable(value = "id") Long transferId,
			@Valid @RequestBody Transfer transferDetails) throws Exception {
		Transfer transfer = transferRepository.findById(transferId)
				.orElseThrow(() -> new Exception("Transfer " + transferId + " not found"));

		transfer.setAmount(transferDetails.getAmount());
		transfer.setComment(transferDetails.getComment());
		transfer.setFromAccount(transferDetails.getFromAccount());
		transfer.setToAccount(transferDetails.getToAccount());
		transfer.setPan(transferDetails.getPan());
		transfer.setPan2(transferDetails.getPan2());

		final Transfer updatedTransfer = transferRepository.save(transfer);
		return ResponseEntity.ok(updatedTransfer);
	}

	@DeleteMapping("/transfer/{id}")
	public Map<String, Boolean> deleteTransfer(@PathVariable(value = "id") Long transferId) throws Exception {
		Transfer transfer = transferRepository.findById(transferId)
				.orElseThrow(() -> new Exception("Transfer " + transferId + " not found"));
		transferRepository.delete(transfer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@GetMapping("/transfersNameQuery")
	public List<Object> getTransfersNamedQuery() {
		Query q = em.createNativeQuery("select t.key, t.value from transfer.simple_table t");
		List<Object> keyAndValues = q.getResultList();
		return keyAndValues;
	}
}