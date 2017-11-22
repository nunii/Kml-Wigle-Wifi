

public class positionFilter implements Filter {
	private Position pos;
	public positionFilter(Position pos){
		this.pos = pos;
	}

	public boolean criterion(Sample samp) {
		return samp.getPosition().equals(pos);
	}

}
