package cin.ufpe.br.desktop_benchmarks.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import cin.ufpe.br.desktop_benchmarks.api.IBenchmark;

public class TwfbPlayerBenchmark implements IBenchmark {
	private final String buildXmlPath = "/home/renato/Documents/Mestrado/desktop-bench/twfbplayer-code/build.xml";
	private final String lineArgs = "test";
	private String commandLine;
	private int warmUpIterationsN = 1;
	private int runIterationsN = 1;
	private Runtime rt;
	
	public TwfbPlayerBenchmark(Runtime rt) {
		this.commandLine = String.format("ant -buildfile %s %s", this.buildXmlPath, this.lineArgs);
		this.rt = rt;
	}
	
	@Override
	public void warmup() throws IOException, InterruptedException {
		Process p;
		for(int i = 0 ; i < warmUpIterationsN; i++) {
			p = rt.exec(this.commandLine);
			InputStream os = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(os));
			while(br.readLine() != null) {}
			p.waitFor();
		}
	}

	@Override
	public void run() throws IOException, InterruptedException {
		Process p;
		for(int i = 0 ; i < runIterationsN; i++) {
			p = rt.exec(this.commandLine);
			InputStream os = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(os));
			while(br.readLine() != null) {}
			p.waitFor();
		}
	}

}
