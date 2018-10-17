package cin.ufpe.br.desktop_benchmarks.api;

import java.io.IOException;

public interface IBenchmark {
	public void warmup() throws IOException, InterruptedException;
	public void run() throws IOException, InterruptedException;
}
