package com.ujc.eswa.mensalidade.aeit.notification;

import org.springframework.stereotype.Component;

import com.ujc.eswa.mensalidade.aeit.model.Estudante;
@Component
public class NotificationEmail implements Notification{

	@Override
	public void notify(Estudante estudante, String message) {
		// TODO Auto-generated method stub
		System.out.printf("Estudante notificado nome: %s por email",estudante.getNome());
	}

}
