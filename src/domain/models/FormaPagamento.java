package domain.models;

public enum FormaPagamento {
	CARTAO_CREDITO("Cartão de Crédito"),
    CARTAO_DEBITO("Cartão de Débito"),
    BOLETO("Dinheiro"),
    PIX("Pix");
	private String descricao;

	FormaPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static FormaPagamento fromString(String descricao) {
        for (FormaPagamento fp : FormaPagamento.values()) {
            if (fp.descricao.equalsIgnoreCase(descricao)) {
                return fp;
            }
        }
        return null;
    }
}
