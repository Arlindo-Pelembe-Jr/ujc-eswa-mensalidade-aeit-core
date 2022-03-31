package com.ujc.eswa.mensalidade.aeit.notification;

import com.ujc.eswa.mensalidade.aeit.model.Estudante;

public interface Notification {
public void notify(Estudante estudante,String message);
}
