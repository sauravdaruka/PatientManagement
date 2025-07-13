package com.daruka.saurav.patientservice.service;

import com.daruka.saurav.patientservice.dto.PatientRequestDTO;
import com.daruka.saurav.patientservice.dto.PatientResponseDTO;
import com.daruka.saurav.patientservice.exception.EmailAlreadyExistsException;
import com.daruka.saurav.patientservice.exception.PatientNotFoundException;
import com.daruka.saurav.patientservice.mapper.PatientMapper;
import com.daruka.saurav.patientservice.model.Patient;
import com.daruka.saurav.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getAllPatients() {
       List<Patient> patients = patientRepository.findAll();
       return patients.stream().map(PatientMapper::toDTO).toList();
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {

        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("A patient with this email " + "already exists" + patientRequestDTO.getEmail());
        }

        Patient newPatient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));

//        billingServiceGrpcClient.createBillingAccount(newPatient.getId().toString(), newPatient.getName(), newPatient.getEmail());
//        kafkaProducer.sendEvent(newPatient);

        return PatientMapper.toDTO(newPatient);
    }
    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO) {

        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + id));

        if (patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(), id)) {
            throw new EmailAlreadyExistsException("A patient with this email " + "already exists" + patientRequestDTO.getEmail());
        }

        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));

        Patient updatedPatient = patientRepository.save(patient);
        return PatientMapper.toDTO(updatedPatient);
    }


    public void deletePatient(UUID id) {
        patientRepository.deleteById(id);
    }
}
