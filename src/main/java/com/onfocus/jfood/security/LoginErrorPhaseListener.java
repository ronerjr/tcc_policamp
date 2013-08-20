/**
 * 
 */
package com.onfocus.jfood.security;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;

import com.onfocus.jfood.util.FacesUtil;

/**
 * @author Roner
 * 
 */
public class LoginErrorPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent arg0) {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void beforePhase(PhaseEvent arg0) {
		Exception dadosIncorretosException = (Exception) FacesUtil
				.getSessionMap().get(WebAttributes.AUTHENTICATION_EXCEPTION);
		if (dadosIncorretosException instanceof BadCredentialsException) {
			FacesUtil.getSessionMap().put(
					WebAttributes.AUTHENTICATION_EXCEPTION, null);
			FacesUtil.exibirMensagemErro("Dados incorretos!");
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
