

public class positionFilter implements Filter {
	private Position pos;
	public positionFilter(Position pos){
		this.pos = pos;
	}

	public boolean criterion(Line samp) {
		return samp.getPosition().equals(pos);
	}

}
