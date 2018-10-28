package cin.ufpe.br.desktop_benchmarks;

import java.io.IOException;

import cin.ufpe.br.desktop_benchmarks.api.IBenchmark;
import cin.ufpe.br.desktop_benchmarks.impl.BarbecueBenchmark;
import cin.ufpe.br.desktop_benchmarks.impl.BattlecryBenchmark;
import cin.ufpe.br.desktop_benchmarks.impl.JodaTimeBenchmark;
import cin.ufpe.br.desktop_benchmarks.impl.TemplateItBenchmark;
import cin.ufpe.br.desktop_benchmarks.impl.TwfbPlayerBenchmark;
import cin.ufpe.br.desktop_benchmarks.impl.XisemeleBenchmark;
import cin.ufpe.br.desktop_benchmarks.impl.XstreamJMHBenchmark;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException
    {
    	EnergyCheckUtils.ProfileInit();
        IBenchmark bench = new TemplateItBenchmark(Runtime.getRuntime());
        bench.warmup();
        int repeatExp = 600;
        while((repeatExp--) > 0) {
	        double packageBefore = EnergyCheckUtils.getEnergyStats()[2];
	        bench.run();
	        double packageAfter = EnergyCheckUtils.getEnergyStats()[2];
	        System.out.println(packageAfter-packageBefore);
        }
    	EnergyCheckUtils.ProfileDealloc();
    }
}
