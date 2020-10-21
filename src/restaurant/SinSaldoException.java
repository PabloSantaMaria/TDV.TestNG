package restaurant;

public class SinSaldoException extends Exception {

	@Override
	public String toString() { return "No tiene suficiente saldo";}
}