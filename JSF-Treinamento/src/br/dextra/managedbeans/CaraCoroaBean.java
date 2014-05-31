package br.dextra.managedbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CaraCoroaBean {

	public String lancar() {
		if (Math.random() < 0.5) {
			System.out.println("cara");
			return "cara";

		}
		System.out.println("coroa");
		return "coroa";

	}

}
