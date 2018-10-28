package cin.ufpe.br.desktop_benchmarks.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import cin.ufpe.br.desktop_benchmarks.api.IBenchmark;

public class TemplateItBenchmark implements IBenchmark {
	private final String pomPath = "/home/renato/Documents/Mestrado/desktop-bench/templateit-code/pom.xml";
	private final String lineArgs = "surefire:test -DdisableXmlReport=true";
	private String commandLine;
	private int warmUpIterationsN = 1;
	private int runIterationsN = 1;
	private Runtime rt;
	
	public TemplateItBenchmark(Runtime rt) {
		this.commandLine = String.format("mvn -f %s %s", this.pomPath, this.lineArgs);
		this.rt = rt;
	}
	
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
