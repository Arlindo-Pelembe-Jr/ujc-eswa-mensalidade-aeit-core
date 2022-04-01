package com.ujc.eswa.mensalidade.aeit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ujc.eswa.mensalidade.aeit.model.Estudante;
import com.ujc.eswa.mensalidade.aeit.notification.Notification;

@Component
public class Service {
	@Autowired(required=false)
	private Notification notify;
	
	public Service(Notification notify) {
		super();
		this.notify = notify;
	}

	public void ative(Estudante estudante) {
		System.out.println("Ative");
		notify.notify(estudante,"You have been ativated");
	}
}
