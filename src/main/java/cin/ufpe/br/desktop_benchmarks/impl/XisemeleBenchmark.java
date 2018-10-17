package cin.ufpe.br.desktop_benchmarks.impl;

import java.io.IOException;

import cin.ufpe.br.desktop_benchmarks.api.IBenchmark;

public class XisemeleBenchmark implements IBenchmark {
	private final String pomPath = "/home/renato/Documents/Mestrado/desktop-bench/xisemele-code/xisemele/pom.xml";
	private final String lineArgs = "test";
	private String commandLine;
	private int warmUpIterationsN = 1;
	private int runIterationsN = 1;
	private Runtime rt;
	
	public XisemeleBenchmark(Runtime rt) {
		this.commandLine = String.format("mvn -f %s %s", this.pomPath, this.lineArgs);
		this.rt = rt;
	}
	
	@Override
	public void warmup() throws IOException, InterruptedException {
		Process p;
		for(int i = 0 ; i < warmUpIterationsN; i++) {
			p = rt.exec(this.commandLine);
			p.waitFor();
		}
	}

	@Override
	public void run() throws IOException, InterruptedException {
		Process p;
		for(int i = 0 ; i < runIterationsN; i++) {
			p = rt.exec(this.commandLine);
			p.waitFor();
		}
	}

}
