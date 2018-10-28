package cin.ufpe.br.desktop_benchmarks.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import cin.ufpe.br.desktop_benchmarks.api.IBenchmark;

public class XstreamJMHBenchmark implements IBenchmark {
	private final String shellScriptPath = 
			"/home/renato/Documents/Mestrado/Hasan-apps/xstream-jmh-1.5.0-SNAPSHOT-dell-rec-50k/bin/xstream-jmh.sh";
	private final String lineArgs = "";
	private String commandLine;
	private Runtime rt;
	
	public XstreamJMHBenchmark(Runtime rt) {
		this.rt = rt;
		this.commandLine = String.format("%s %s", this.shellScriptPath, this.lineArgs);
	}
	
	@Override
	public void warmup() throws IOException, InterruptedException {
		//intentionally empty
	}

	@Override
	public void run() throws IOException, InterruptedException {
		Process p;
		p = rt.exec(this.commandLine);
		InputStream os = p.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(os));
		String out = br.readLine();
		while(out != null) {
			out = br.readLine();
			System.out.println(out);
		}
		p.waitFor();
	}

}
