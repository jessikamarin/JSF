package br.dextra.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  
 * A anotação @WebServlet registra o filtro no Web Container. O atributo servletNames é utilizado
 * para definir quais servlets serão interceptadas pelo filtro. 
 * O método doFilter() é chamado toda vez que uma requisição HTTP à servlet Faces Servlet é realizada. 
 * Esse método verifica se existe um usuário registrado na sessão HTTP ou se a página requisitada é a do 
 * formulário de autenticação. Se uma dessas condições for satisfeita, o filtro permite que o fluxo prossiga para a Faces Servlet. Caso
 * contrário, ele redireciona o usuário para a página do formulário de autenticação.
 *
 */

@WebFilter(servletNames={"Faces Servlet"})
public class ControleDeAcesso implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request ;
		HttpSession session = req.getSession();
		
		if (session.getAttribute("usuario") != null
			|| req.getRequestURI().endsWith("login.xhtml")) {
			
			chain.doFilter(request, response);
		} else {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("login.xhtml");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}