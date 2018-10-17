package cin.ufpe.br.desktop_benchmarks.impl;

import java.io.IOException;

import cin.ufpe.br.desktop_benchmarks.api.IBenchmark;

public class BattlecryBenchmark implements IBenchmark {
	private final String jarPath = "/home/renato/Documents/Mestrado/desktop-bench/battlecry/battlecry/battlecry.jar";
	private final String lineArgs = 
			//"--demo test";
			"-m data/modules/battlecry.bcm";
	private String commandLine;
	private int warmUpIterationsN = 10;
	private int runIterationsN = 100;
	private Runtime rt;
	
	public BattlecryBenchmark(Runtime rt) {
		this.commandLine = String.format("java -jar %s %s", this.jarPath, this.lineArgs);
		this.rt = rt;
	}
	
	public void warmup() throws IOException, InterruptedException {
		Process p;
		for(int i = 0 ; i < warmUpIterationsN; i++) {
			p = rt.exec(this.commandLine);
			p.waitFor();
		}
	}

	public void run() throws IOException, InterruptedException {
		Process p;
		for(int i = 0 ; i < runIterationsN; i++) {
			p = rt.exec(this.commandLine);
			p.waitFor();
		}
	}

}
