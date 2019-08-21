package br.unitins.bike.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.bike.application.Util;
import br.unitins.bike.model.Usuario;

@Named
@RequestScoped
public class LoginController {
	
	private Usuario usuario;
	

	
	public String logar() {
		
		if (getUsuario().getLogin().equals("Matheus")
				&& getUsuario().getSenha().equals("123")) {
			System.out.println(getUsuario().getLogin());
			System.out.println(getUsuario().getSenha());
			return "cadastro.xhtml?faces-redirect=true";
		}
		
		Util.addMessageError("Usuário ou senha inválido.");
		return null;
	}
	
	public void cadastrar() {
			System.out.println("Usuário novo: "+getUsuario().getLogin());
			System.out.println("Senha nova: "+getUsuario().getSenha());
			System.out.println("Idade: "+getUsuario().getId());
			System.out.println("Ativo: "+ getUsuario().getAtivo());
		}
	
	public void limpar() {
		setUsuario(new Usuario());
//		usuario = new Usuario();
	}
	
	public String retornar(){
		return "login.xhtml?faces-redirect=true";
	}
	
	public String redirect(){
		return "cadastrar.xhtml?faces-redirect=true";
	}

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
