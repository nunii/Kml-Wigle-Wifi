package main.java.filters;

import main.java.data_classes.Sample;

public interface Filter {

	public boolean criterion(Sample samp);
}
