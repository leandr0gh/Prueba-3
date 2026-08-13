package Enum;

public enum EstadoPedido {
    PENDIENTE("Pedido registrado, esperando procesamiento", false, 1),
    PROCESANDO("Pedido siendo preparado", false, 2),
    ENVIADO("Pedido en camino al cliente", false, 3),
    ENTREGADO("Pedido entregado al cliente", true, 0),
    CANCELADO("Pedido cancelado", true, 0);

    private final String desc;
    private final boolean esFInal;
    private final int diasEstimados;

    private EstadoPedido(String desc, boolean esFInal, int diasEstimados) {
        this.desc = desc;
        this.esFInal = esFInal;
        this.diasEstimados = diasEstimados;
    }

    public boolean isEsFInal() {
        return esFInal;
    }

    public String getDesc() {
        return desc;
    }
    
    

    public boolean puedeTransicionarA(EstadoPedido nuevoEstado) {
        if (this.esFInal) {
            return false;
        }
        boolean valido = false;

        switch (this) {
            case PENDIENTE:
                if (nuevoEstado == PROCESANDO || nuevoEstado == CANCELADO) {
                    valido = true;
                }
                break;

            case PROCESANDO:
                if (nuevoEstado == ENVIADO || nuevoEstado == CANCELADO) {
                    valido = true;
                }
                break;

            case ENVIADO:
                if (nuevoEstado == ENTREGADO) {
                    valido = true;
                }
                break;
            default: valido = false;
            break;
        }
        return valido;
    }

}
