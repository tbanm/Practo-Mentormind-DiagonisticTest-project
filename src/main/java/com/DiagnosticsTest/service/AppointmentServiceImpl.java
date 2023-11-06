package com.DiagnosticsTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DiagnosticsTest.entity.Appointment;
import com.DiagnosticsTest.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl {
	
	private AppointmentRepository appointmentRepository;

	//inject employee dao
	@Autowired   //Adding bean id @Qualifier
	public AppointmentServiceImpl( AppointmentRepository obj)
	{
		appointmentRepository=obj;
	}
	
	
	public void save(Appointment app)
	{
		
		appointmentRepository.save(app);
	}
	
	
	public List<Appointment> findAll() {
		return appointmentRepository.findAll();
	}



}
